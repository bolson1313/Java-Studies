package Part1_algorithms.NumberGuessing;

import java.util.Random;

public class NumberGuessing {
    static Random random = new Random();
    static int RandomNumber = random.nextInt(0,101);

    public static int Guessing(int left, int right, int number){
        int guess = (left+right)/2;
        System.out.println("is your number "+ guess + "?");
        if(number == guess){
            System.out.println("your number is "+ guess);
            return 1;
        } else if (number > guess) {
            System.out.println("above");
            System.out.println(guess+1 + " " + right);
            return Guessing(guess+1, right, number);
        } else {
            System.out.println("less");
            guess=guess-1;
            System.out.println(left+ " " + guess);
            return Guessing(left, guess, number);
        }
    }
    public static void main(String[] args) {
        Guessing(0, 100, RandomNumber);
    }
}