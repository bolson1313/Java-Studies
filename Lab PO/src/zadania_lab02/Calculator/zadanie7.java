package zadania_lab02.Calculator;

import java.util.Scanner;

public class zadanie7 {
    public static void main(String[] args) {
        int i;
        i = read();
        numbers(5);
    }

    public static int read(){
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj ile liczb chcesz wprowadzic: ");
        int result;
        result = input.nextInt();
        return result;
    }

    public static void numbers(int a){
        Scanner input2 = new Scanner(System.in);
        int num, i;
        i=0;
        while(a!=i){
            i++;
            System.out.println("Podaj "+i+" liczbe ciagu: ");
            num = input2.nextInt();
        }
    }
}
