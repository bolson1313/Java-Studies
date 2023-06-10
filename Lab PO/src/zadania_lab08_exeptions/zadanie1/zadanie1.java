package zadania_lab08_exeptions.zadanie1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class zadanie1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float number;
        while(true) {
            try {
                System.out.println("Podaj liczbe: ");
                number = input.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Podana wartość nie jest liczbą");
                input.next();
            }
        }
        if(number < 0) throw new IllegalArgumentException("Liczba jest ujemna");


        System.out.println("Pierwiastek z liczby "+number+ " to: "+Math.sqrt(number));
    }
}
