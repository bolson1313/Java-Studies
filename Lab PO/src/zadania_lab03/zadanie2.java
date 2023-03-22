package zadania_lab03;

import java.util.Scanner;

public class zadanie2 {
    public static void main(String[] args) {
        int[] results = countNumbers();
        System.out.println("Liczb dodatnich jest " +results[0]+ " a liczb ujemnych "+results[1]+ " łącznie takich liczb jest " +(results[0]+results[1]));
    }

    public static int[] newArray(){
        int[] numbers = new int[10];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < numbers.length; i++){
            System.out.print("Podaj [" +i+ "] element tablicy: ");
            numbers[i] = input.nextInt();
        }
        return numbers;
    }

    public static int[] countNumbers(){
        int negativeN = 0;
        int positiveN = 0;
        int[] counter = new int[2];
        int[] arrayN = newArray();
        for (int j : arrayN) {
            if (j < 0) {
                ++negativeN;
            } else if (j > 0) {
                ++positiveN;
            }
        }
        counter[0] = positiveN;
        counter[1] = negativeN;
        return counter;
    }
}
