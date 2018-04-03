package ua.kpi.tef.controller;

import ua.kpi.tef.LoginCollisionException;
import ua.kpi.tef.model.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {

    private static String index = "index.jsp";
    private static String congrats = "congrats.jsp";
    private static String NAME = "name";
    private static String EMAIL = "email";
    private static String LOGIN = "login";
    private static String OLD_EMAIL = "oldemail";
    private static String OLD_NAME = "oldname";
    private static String OLD_LOGIN = "login";
    private static String ERROR_MESSAGE = "errorMsg";
    private final static int MINIMUM_ERR_MSG_LENGTH = 2;

    private String errorMessage = "";
    private boolean modelInitialised = false;

    private InputNote inputNote;
    private Model model;

    @Override
    public void init() {
       this.model = new Model();
       this.inputNote = new InputNote();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        if (modelInitialised) {
            req.setAttribute(NAME, model.getNote().getName());
            req.setAttribute(EMAIL, model.getNote().getEmail());
            req.setAttribute(LOGIN, model.getNote().getLogin());
            req.getRequestDispatcher(congrats).forward(req, resp);
        } else {
            if (errorMessage.length() > MINIMUM_ERR_MSG_LENGTH) {
                req.setAttribute(ERROR_MESSAGE, errorMessage);
                errorMessage = "";
            }
            req.setAttribute(OLD_NAME, inputNote.getInputNote().getName());
            req.setAttribute(OLD_EMAIL, inputNote.getInputNote().getEmail());
            req.setAttribute(OLD_LOGIN, inputNote.getInputNote().getLogin());
            req.getRequestDispatcher(index).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");

        String name = req.getParameter(NAME);
        String email = req.getParameter(EMAIL);
        String login = req.getParameter(LOGIN);

        inputNote.setInputNoteData(name, email, login);
        inputNote.processInput();
        processData(inputNote, req, resp);
        doGet(req, resp);
    }

   private void processData(InputNote inputNote, HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
       if (!inputNote.isCorrect()) {
           errorMessage = inputNote.getErrorMessage();
           doGet(req, resp);
       } else {
           try {
               model.initNote(inputNote.getInputNote());
           } catch (LoginCollisionException err) {
               errorMessage = StringBundleProcessor.concatenateStrings(
                       StringBundleProcessor.getBundleString(BundleKeys.INPUT_LOGIN_EXIST_ERROR_FIRST_CLAUSE),
                       err.getWrongData().getLogin(),
                       StringBundleProcessor.getBundleString(BundleKeys.INPUT_LOGIN_EXIST_ERROR_SECOND_CLAUSE
                       ));
               doGet(req, resp);
           }
           modelInitialised = true;
       }
   }
}
