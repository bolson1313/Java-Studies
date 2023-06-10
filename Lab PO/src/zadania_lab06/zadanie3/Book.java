package zadania_lab06.zadanie3;

public class Book extends Client{

    String title, author;
    double price;
    boolean isBorrowed;

    public Book(String name, String surname, String title, double price) {
        super(name, surname);
        this.title = title;
        this.author = this.name +" "+ this.surname;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", isBorrowed=" + isBorrowed +
                '}';
    }

    public boolean isBorrowed(){
        boolean borrowed;
        borrowed = true;
        return borrowed;
    }
}
