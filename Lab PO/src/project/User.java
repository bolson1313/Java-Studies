package project;

public class User {
    String name, surname;
    int id, acces_code;
    boolean authorized;
    private String time;
    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public User(int id, String name, String surname, int acces_code, boolean authorized) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.acces_code = acces_code;
        this.authorized = authorized;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public boolean isAuthorized() {
        return authorized;
    }
}
