package zadania_lab04.zadanie2;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Building building1 = new Building("Szkoła", 1998, 2);
        Building building2 = new Building("Szpital", 2006, 5);
        Building building3 = new Building("Urząd wojewódzki", 2015, 6);
        Building building4 = new Building("Blok mieszkalny", 1990, 8);
        System.out.println("Dane budynku nr1: \n"+building1);
        howOld(building1.year);
        System.out.println("Dane budynku nr2: \n"+building2);
        howOld(building2.year);
        System.out.println("Dane budynku nr3: \n"+building3);
        howOld(building3.year);
        System.out.println("Dane budynku nr4: \n"+building4);
        howOld(building4.year);
    }

    public static void howOld(int year){
        LocalDate currentYear = LocalDate.now();
        int howold;
        howold = currentYear.getYear() - year;
        System.out.println("Budynek ma: "+howold+" lat\n");
    }
}
