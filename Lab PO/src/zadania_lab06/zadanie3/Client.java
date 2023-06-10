package zadania_lab06.zadanie3;

public class Client {
    String name, surname;
    boolean books;

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Client(String name, String surname, boolean books) {
        this.name = name;
        this.surname = surname;
        this.books = books;
    }
}
