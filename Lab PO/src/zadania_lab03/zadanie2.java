package zadania_lab03;

import java.util.Scanner;

public class zadanie2 {
    public static void main(String[] args) {
        int[] results = countNumbers();
        System.out.println("Liczb dodatnich jest: " +results[0]+ ", suma dodatnich elementów to: " +results[3]+ ", a liczb ujemnych: " +results[1]+ " suma umjemnych elementów " +results[2] );
    }

    //creating new Array and input numbers
    public static int[] newArray(){
        int[] numbers = new int[10];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < numbers.length; i++){
            System.out.print("Podaj [" +i+ "] element tablicy: ");
            numbers[i] = input.nextInt();
        }
        return numbers;
    }

    //counting if elements are negative or positive, returning array with results
    public static int[] countNumbers(){
        int negativeN = 0, positiveN = 0;
        int countPositiveN = 0 , countNegativeN = 0;
        int[] counter = new int[4];
        int[] arrayN = newArray();
        for (int i =0; i < arrayN.length; i++) {
            if (arrayN[i] < 0) {
                ++negativeN;
                countNegativeN = arrayN[i] + countNegativeN;
            } else if (arrayN[i] > 0) {
                ++positiveN;
                countPositiveN = arrayN[i] + countPositiveN;
            }
        }
        counter[0] = positiveN;
        counter[1] = negativeN;
        counter[2] = countNegativeN;
        counter[3] = countPositiveN;
        return counter;
    }
}
