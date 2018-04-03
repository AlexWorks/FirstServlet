package ua.kpi.tef;

public enum MockDatabase {
    FIRST ("Taras1814", "Тарас", "taras@gmail.com"),
    SECOND ("PetroTractor", "Петро", "petro@gmail.com"),
    THIRD ("VasjaPupkin", "Василь", "vasil@gmail.com");

    private final String login;
    private final String name;
    private final String email;

    MockDatabase(String login, String name, String email) {
        this.login = login;
        this.name = name;
        this.email = email;
    }

    static public boolean checkLogin(String value) {
        for (MockDatabase item : MockDatabase.values()) {
            if (item.login.equals(value)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "MockDatabase{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
