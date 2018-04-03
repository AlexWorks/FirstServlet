package ua.kpi.tef;

import ua.kpi.tef.model.entities.Note;

public class LoginCollisionException extends Exception {
    private Note wrongData;

    public LoginCollisionException(Note wrongData) {
        this.wrongData = wrongData;
    }

    public Note getWrongData() {
        return wrongData;
    }
}
