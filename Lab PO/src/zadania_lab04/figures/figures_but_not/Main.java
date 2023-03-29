package zadania_lab04.figures.figures_but_not;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            System.out.print("Podaj figure: ");
            String name = readString();
                switch (name){
                    case "koło":
                        System.out.println("Podaj promień koła");
                        Figures.Circle circle = new Figures.Circle();
                        circle.setRadius(5);
                        System.out.println(circle.Field(circle.getRadius()));
                        break;
                }
        }
    }


    //read string
    public static String readString(){
        Scanner input = new Scanner(System.in);
        String name;
        name = input.nextLine();
        return name;
    }
    //read double input
    public static double readDouble(){
        Scanner input = new Scanner(System.in);
        double dinput;
        dinput = input.nextDouble();
        return dinput;
    }
}
