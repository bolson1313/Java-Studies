package kalkulator;

import java.util.Scanner;

public class kalkulator {
    public static void main(String[] args) {
        Run();
    }

    //run method
    public static void Run(){
        int i=10;
        int pick;
        double a = ReadVar();
        double b = ReadVar();

        while(i==0){
            Menu();
                switch(pick=Pick()){
                    case 1:
                        a = ReadVar();
                        b = ReadVar();
                        break;
                    case 2:
                        System.out.printf("Suma wybranych liczb to: "+sum(a,b));
                        break;
                    case 3:

                }

        }
    }
    //pick method
    public static int Pick(){
        System.out.printf("Wybierz opcje: ");
        Scanner input = new Scanner(System.in);
        int var;
        var = input.nextInt();
        return var;
    }

    //read var
    public static double ReadVar(){
        System.out.printf("Podaj liczbę: ");
        Scanner input = new Scanner(System.in);
        double var;
        var = input.nextDouble();
        return var;
    }
    //read string
    public static String ReadString(){
        Scanner inputStr = new Scanner(System.in);
        String confirm;
        confirm = inputStr.next();
        return confirm;
    }


    //sum
    public static double sum(double a, double b){
        return 0;
    }

    //menu
    public static void Menu(){
        System.out.println("Witaj w narzędziu kalkulatora! \n\n1. Podaj zmienne\n2. Suma liczb\n3. Różnica liczb\n4. Iloczyn liczb\n5. Iloraz liczb\n6. Potęga liczby a do liczby b\n7. Pierwiastek kwadratowy\n8. Funkcje trygonometryczne\n9. Wyjdź\n10.Zresetuj program");
    }
}
