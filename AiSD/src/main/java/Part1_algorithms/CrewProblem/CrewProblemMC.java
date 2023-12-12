package Part1_algorithms.CrewProblem;

import java.util.Arrays;
import java.util.Random;

public class CrewProblemMC {
    static String[] crew_members = {"AD", "BD", "BC", "AB", "CD"};

    public static void main(String[] args) {
        Random random = new Random();
        int random_crew1 = random.nextInt(0,5);
        int random_crew2 = random.nextInt(0,5);
        String answer;
        while(true) {
            if(random_crew1 != random_crew2) {
                answer = crew_members[random_crew1] + crew_members[random_crew2];

                char[] chars = answer.toCharArray();
                Arrays.sort(chars);
                answer = new String(chars);
                if(answer.equals("ABCD")) {
                    System.out.println("Crew members k" + (random_crew1+1) + " and k" + (random_crew2+1));
                    break;
                }
            }
            random_crew1 = random.nextInt(0,5);
            random_crew2 = random.nextInt(0,5);
            answer = "";
        }
    }
}
