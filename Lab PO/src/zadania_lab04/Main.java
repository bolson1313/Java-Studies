package lab04;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Jan", "Kowalski", 12);
        person.imie = "Jan";
        person.setImie("Jakub");
        person.wiek = 12;
        System.out.println(person.toString());
    }
}
