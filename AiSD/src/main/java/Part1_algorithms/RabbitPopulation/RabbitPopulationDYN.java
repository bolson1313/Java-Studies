package Part1_algorithms.RabbitPopulation;

import java.util.Scanner;

public class RabbitPopulationDYN {
    public static int rabbits_population (int months){
        int[] rabbits = new int[months+1];
        rabbits[1] = 1;
        rabbits[2] = 1;
        for (int i = 3; i < rabbits.length; i++){
            rabbits[i] = rabbits[i - 1] + rabbits[i - 2];
        }
        return rabbits[rabbits.length - 1];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert months: ");
        int months = input.nextInt();
        System.out.println("Rabbits: " +rabbits_population(months)*2);

    }
}
