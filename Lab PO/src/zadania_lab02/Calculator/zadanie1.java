package zadania_lab02.Calculator;
import java.util.Scanner;

public class zadanie1 {
    public static void main(String[] args) {
//        Zadanie 1
        Trojmian();

    }

    //    Zadanie 1
    public static double InputDouble(){
        Scanner input = new Scanner(System.in);
        double liczba = input.nextDouble();
        return liczba;
    }
    public static double Delta(double a, double b, double c){
        return Math.pow(b, 2) - 4 * a * c;
    }
    public static void Trojmian(){
        System.out.println("Podaj a: ");
        double a = InputDouble();

        System.out.println("Podaj b: ");
        double b = InputDouble();

        System.out.println("Podaj c: ");
        double c = InputDouble();

        if (a != 0){
            double delta = Delta(a, b, c);

            if (delta < 0){
                System.out.println("Brak rozwiązań");
            }else if (delta == 0) {
                System.out.format("Jedno rozwiązanie: %f", ((-b)/(2*a)));
            }else System.out.format("Dwa rozwiązania: %f i %f", (-b-Math.sqrt(delta))/(2*a), (-b+Math.sqrt(delta))/(2*a));

        }else System.out.println("To nie jest równanie kwadratowe");
    }
}
