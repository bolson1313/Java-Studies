package FigureProblem;

import java.util.Random;

public class FigureMC {
    static int draws = 1000;

    public static double area(int tries) {
        Random random = new Random();
        double x,y;
        int count = 0;
        for(int i = 0; i < draws; i++) {
            x = random.nextInt(0,101)/(double)100;
            y = random.nextInt(0,101)/(double)100;

            if(x >= 0.7 && y <= 0.3) {
                count++;
            }
        }
        return (double) count/draws;
    }

    public static void main(String[] args) {
        System.out.println("pole = "+area(draws));
    }
}
