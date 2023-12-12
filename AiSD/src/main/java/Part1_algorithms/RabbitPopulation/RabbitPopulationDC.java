package Part1_algorithms.RabbitPopulation;

import java.util.Scanner;

public class RabbitPopulationDC {
    public static int rabbit_population(int month){
        if (month == 1 || month == 2) {
            return 1;
        } else {
            return rabbit_population(month - 1) + rabbit_population(month - 2);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert months: ");
        int n = input.nextInt();
        System.out.println("Months passed: " + rabbit_population(n)*2);
    }
}
