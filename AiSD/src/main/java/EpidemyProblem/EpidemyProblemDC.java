package EpidemyProblem;

public class EpidemyProblemDC {
    static int  population = 100000;
    static final int  starting_sick_population = 10;
    static final int starting_healthy_population = 100000;
    static int days = 0;

    public static int epidemy(int sick) {
        days++;
        population = starting_healthy_population - sick;
        if(population <= 0) {
            System.out.println("Whole population will get sick in "+days+" days");
            return 0;
        } else {
            System.out.println("SICK: "+sick+ " HEALTHY: "+ population+ " DAYS: " +days);
        }
        sick = sick + sick*2;
        return epidemy(sick);
    }

    public static void main(String[] args) {
        epidemy(starting_sick_population);
    }
}
