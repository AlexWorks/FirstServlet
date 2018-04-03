package ua.kpi.tef.model.entities;

public class Note {
    private String name;
    private String email;
    private String login;

    public Note() {

    }

    public Note(Note note) {
        this(note.name, note.email, note.login);
    }

    public Note(String name, String email, String login) {
        this.name = name;
        this.email = email;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
