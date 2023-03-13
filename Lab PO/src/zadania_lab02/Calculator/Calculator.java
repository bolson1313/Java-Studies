package zadania_lab02.Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Run();
    }

    //run method
    public static void Run(){
        int i;
        i = 10;
        double a = ReadVar();
        double b = ReadVar();

        while(i!=0){
            Menu();
            String conf;
            switch(Pick()){
                case 1:
                    a = ReadVar();
                    b = ReadVar();
                    break;
                case 2:
                    System.out.println("Suma wybranych liczb to: " +sum(a,b));
                    break;
                case 3:
                    System.out.println("Różnica liczb to: " +sub(a,b));
                    break;
                case 4:
                    System.out.println("Iloczyn liczb to: " +mult(a,b));
                    break;
                case 5:
                    System.out.println("Iloraz liczb to: " +div(a,b));
                    break;
                case 6:
                    System.out.println("Potega liczby a do liczby b to: " +pow(a,b));
                    break;
                case 7:
                    System.out.println("Pierwiastek kwadratowy z liczby " +a+ " to: " +elem(a));
                    break;
                case 8:
                    tryg(a);
                    tryg(b);
                    break;
                case 9:
                    conf = ReadString();
                    System.exit(1);
                    break;
                case 10:
                    Run();
                    break;
                default:
                    break;
            }

        }
    }
    //pick method
    public static int Pick(){
        System.out.println("Wybierz opcje: ");
        Scanner input = new Scanner(System.in);
        int var;
        var = input.nextInt();
        return var;
    }

    //read var
    public static double ReadVar(){
        System.out.println("Podaj liczbę: ");
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
        return a+b;
    }
    //sub
    public static double sub(double a, double b){
        return a-b;
    }
    //mult
    public static double mult(double a, double b){
        return a*b;
    }
    //div
    public static double div(double a, double b){
        return a/b;
    }
    //pow
    public static double pow(double a, double b){
        return Math.pow(a,b);
    }
    //element
    public static double elem(double a){
        return Math.sqrt(a);
    }
    //trygonometry
    public static void tryg(double a){
        double sin = Math.sin(Math.toRadians(a));
        double cos = Math.cos(Math.toRadians(a));
        double tan = Math.tan(Math.toRadians(a));
        double ctg = cos/sin;
        System.out.println("Trygonometria dla kąta " +a+ ": sinus = " +sin+ "; cosinus = " +cos+ "; tangens = " +tan+ "; cotangens = " +ctg);
    }


    //menu
    public static void Menu(){
        System.out.println("Witaj w narzędziu kalkulatora! \n\n1. Podaj zmienne\n2. Suma liczb\n3. Różnica liczb\n4. Iloczyn liczb\n5. Iloraz liczb\n6. Potęga liczby a do liczby b\n7. Pierwiastek kwadratowy\n8. Funkcje trygonometryczne\n9. Wyjdź\n10.Zresetuj program");
    }
}
