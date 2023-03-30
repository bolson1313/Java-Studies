package zadania_lab04.zadanie3;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Species no1 = new Species("Wilk", "Szary", 46, 5, "Wilk mieszkajacy w lesie iglastym");
        Species no2 = new Species("Wilk", "Biały", 44, 3, "Wilk mieszkajacy w lesie lisciastym");
        no1.output();
        no2.output();

        Species copy = (Species)no1.clone();
        copy.output();
    }
}
