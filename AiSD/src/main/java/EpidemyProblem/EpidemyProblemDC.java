package EpidemyProblem;

public class EpidemyProblemDC {
    static int  population = 100000;
    static final int  starting_sick_population = 10;
    static final int starting_healthy_population = 100000;
    static int days = 0;
    static int weeks = 1;
    static int[] SickOfWeek = new int[7];

    public static int epidemy(int sick, int i) {
        days++;
        if(i==7){
            i = 0;
            weeks++;
            System.out.println("Tydzien: "+weeks);
        }

        if(weeks % 2 == 0 && weeks != 1) {
            SickOfWeek[i] -= (SickOfWeek[i]*2);
        }


        SickOfWeek[i] += sick;
        population = starting_healthy_population - sick;
        if(population <= 0) {
            System.out.println("Whole population will get sick in "+days+" days");
            return 0;
        } else {
            System.out.println("SICK: "+sick+ " HEALTHY: "+ population+ " DAYS: " +days+ "\nDAY of Week: "+(i+1)+ " = "+SickOfWeek[i]);
        }
        sick = sick + sick*2;

        i++;
        return epidemy(sick, i);
    }

    public static void main(String[] args) {
        epidemy(starting_sick_population, 0);
    }
}
