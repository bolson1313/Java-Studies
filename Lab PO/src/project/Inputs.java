package project;

import java.util.Scanner;

public class Inputs {
    public static int InputInt(String message){
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextInt();
    }
    public static String InputString(String message){
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextLine();
    }
}
