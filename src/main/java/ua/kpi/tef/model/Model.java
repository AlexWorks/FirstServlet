package ua.kpi.tef.model;

import ua.kpi.tef.LoginCollisionException;
import ua.kpi.tef.MockDatabase;
import ua.kpi.tef.model.entities.Note;

public class Model {
    Note note;

    public void initNote(Note note) throws LoginCollisionException {
        if (!MockDatabase.checkLogin(note.getLogin()))
            throw new LoginCollisionException(note);

        this.note = note;
    }

    public Note getNote() {
        return note;
    }
}
