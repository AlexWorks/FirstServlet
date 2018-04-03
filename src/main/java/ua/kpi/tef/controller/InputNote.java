package ua.kpi.tef.controller;

import ua.kpi.tef.model.entities.Note;

import java.util.ArrayList;

public class InputNote {
    private Note inputNote;
    private ArrayList<String> errorKeys;
    private Utils utils;
    private boolean correct;

    InputNote() {
        errorKeys = new ArrayList<>();
        utils = new Utils();
        inputNote = new Note();
    }

    public void processInput() {
        getErrorKeys();
        checkInput();
    }

    private void checkInput() {
       correct =  utils.checkStringValueWithRegexp(inputNote.getName(), RegularExpressions.UA_NAME_REGEXP)
                && utils.checkStringValueWithRegexp(inputNote.getEmail(), RegularExpressions.EMAIL_REGEXP)
                && utils.checkStringValueWithRegexp(inputNote.getLogin(), RegularExpressions.LOGIN_REGEXP);
    }

    private void checkErrorMessage(String field, String regexp, String errKey) {
        if (!utils.checkStringValueWithRegexp(field, regexp)) {
            addErrorKey(errKey);
        }
    }

    private void getErrorKeys() {
        checkErrorMessage(inputNote.getName(), RegularExpressions.UA_NAME_REGEXP, BundleKeys.INPUT_NAME_ERROR);
        checkErrorMessage(inputNote.getEmail(), RegularExpressions.EMAIL_REGEXP, BundleKeys.INPUT_EMAIL_ERROR);
        checkErrorMessage(inputNote.getLogin(), RegularExpressions.LOGIN_REGEXP, BundleKeys.INPUT_LOGIN_ERROR);
    }

    private void addErrorKey(String errKey) {
       errorKeys.add(errKey);
    }

    public boolean isCorrect() {
        return correct;
    }

    public String getErrorMessage() {
        return StringBundleProcessor.concatenateStringsUsingBundle(errorKeys);
    }

    public Note getInputNote() {
        return new Note(inputNote);
    }

    public void setInputNoteData(String name, String email, String login) {
        inputNote.setName(name);
        inputNote.setEmail(email);
        inputNote.setLogin(login);

        errorKeys = new ArrayList<>();
    }

}
