package zadania_lab04.zadanie2;

public class Building {
    String name;
    int year, floors;

    public Building(String name, int year, int floors) {
        this.name = name;
        this.year = year;
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "Nazwa: "+name+"\nRok wybudowania: "+year+"\nIlość pięter: "+floors;
    }
}
