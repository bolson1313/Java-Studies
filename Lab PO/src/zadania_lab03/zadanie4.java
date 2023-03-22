package zadania_lab03;

import java.util.Random;
import java.util.Scanner;

public class zadanie4 {
    public static void main(String[] args) {
        System.out.println("Suma wylosowanych liczb parzystych z danego ciągu wynosi: " +arrayNumbersRandomizer());
    }
    public static int setRange(){
       Scanner input = new Scanner(System.in);
       System.out.print("Podaj ile liczb chcesz losowac z zakresu od -10 do 45: ");
       int range;
       range = input.nextInt();

       return range;
    }

    public static int arrayNumbersRandomizer(){
        Random randomNumber = new Random();
        int[] numbers = new int[setRange()];
        int count = 0;
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = randomNumber.nextInt(56) -10;
            if(numbers[i]%2 == 0){
                count = count + numbers[i];
            }
        }

        return count;
    }
}
