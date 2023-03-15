import java.util.Random;
import java.util.Scanner;

public class lab01{
    public static void main(String[] args) {
        //zczytywanie liczb
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj X: ");
        float x;
        x = input.nextFloat();
        System.out.println("Podaj Y: ");
        float y;
        y = input.nextFloat();

        //Zadanie 1
        System.out.println(Name());
        System.out.println(Age());

        //zadanie 2
        actions(x,y);

        //zadanie 3
        System.out.println(ifEven(y));

        //zadanie 4
        System.out.println(ifDiv35(x));

        //zadanie 5
        System.out.format("liczba %.0f do potegi 3 jest rowna: %s \n",x,power3(x));

        //zadnie 6
        System.out.println("pierwiastek kwadratowy z liczby " +x+ " to " +element(x));

        //zadanie 7 i losowanie
        int a, b;
        Random losowanie = new Random();
        System.out.println("podaj pierwsza liczbe przedzialu: ");
        a = input.nextInt();
        b = input.nextInt();
        int przedzial;
        przedzial = Math.abs(b-a);
        int randomA, randomB, randomC;
        randomA = losowanie.nextInt(przedzial) +a;
        randomB = losowanie.nextInt(przedzial) +a;
        randomC = losowanie.nextInt(przedzial) +a;
        System.out.println(randomA+" "+randomB+" "+randomC);
        System.out.println(triangle(randomA, randomB, randomC));

    }

    //zadanie 1
    public static String Name(){
        return "Kacper";
    }
    public static int Age(){
        return 20;
    }


    //zadanie 2
    public static void actions(float a, float b){
        System.out.println("Suma " +a+ " + " +b+ " = "+(a+b));
        System.out.println("Różnica " +a+ " - " +b+ " = " +(a-b));
        System.out.format("Iloczyn %.0f + %.0f = %.0f \n", a,b,(a*b));
    }

    //zadanie 3
    public static boolean ifEven(float a){
        return a % 2 == 0;
    }

    //zadanie 4
    public static boolean ifDiv35(float a){
        return a % 3 == 0 && a % 5 ==0;
    }

    //zadanie 5
    public static double power3(float a){
        return Math.pow(a, 3);
    }

    //zadanie 6
    public static double element(float a){
        double b;
        b = Math.sqrt(a);
        return b;
    }

    //zadanie 7
    public static boolean triangle(int a, int b, int c){
        if(a + b > c && a + c > b && c + b > a){
            return true;
        }else {
            return false;
        }
    }
}
