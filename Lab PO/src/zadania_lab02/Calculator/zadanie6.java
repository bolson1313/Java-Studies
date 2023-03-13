package zadania_lab02.Calculator;

import java.util.Scanner;

public class zadanie6 {
    public static void main(String[] args) {

        while(true){
            int i = scan();
            if(i<0){
                break;
            }
        }
    }

    public static int scan(){
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj liczbe: ");
        int result = input.nextInt();
        return result;
    }
}
