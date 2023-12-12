package Part1_algorithms.NumberGuessing;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingDC {
    static Random random = new Random();
    static int RandomNumber = random.nextInt(0,101);
    public static void GuessingNumber(int left, int right, int number) {
        int guess = (left+right) / 2;
        System.out.println("Is your number " +guess+ " ?");
        if(number == guess) {
            System.out.println("Your number is " + guess + " !");
        } else if (number > guess) {
            System.out.println("ABOVE!");
            System.out.println("LEFT=" + guess+1 + "    RIGHT="+ right);
            GuessingNumber(guess+1,right, number);
        } else {
            System.out.println("LESS!");
            System.out.println("LEFT="+left+ "  RIGHT="+(guess-1));
            GuessingNumber(left, guess-1, number);
        }
    }
    public static void main(String[] args) {
        GuessingNumber(0,100,15);
    }
}
