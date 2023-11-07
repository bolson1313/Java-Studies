package SalmonsAndSharks;

public class SalmonAndSharks {
    static int minutes_passed = 0;
    static final int salmon_statring_population = 1000000;
    static final double e = Math.pow(Math.E, 0.003);
    static final double salmon_consume_ratio = 0.002; //sharks eats at 0.002 salmons per minute
    static final double salmon_run_ratio = 0.002; //salmons runsaway at 0.002 per minute
    static boolean[] isExecuted = {true, true, true, true};
    public static double salmon_population(int population){
        minutes_passed++;
        population = (int) (population - population * salmon_consume_ratio);
        population = (int) (population - population * salmon_run_ratio);
        population = (int) (population * e);
        if(population <= salmon_statring_population / 2 && population > salmon_statring_population / 3 && isExecuted[0]){
            System.out.println("POPULATION DROPS BELOW 1/2 IN "+minutes_passed+" MINUTES");
            isExecuted[0] = false;
            return salmon_population(population);
        } else if(population <= salmon_statring_population/3 && population > salmon_statring_population/10 && isExecuted[1]) {
            System.out.println("POPULATION DROPS BELOW 1/3 IN "+minutes_passed+" MINUTES");
            isExecuted[1] = false;
            return salmon_population(population);
        } else if(population <= salmon_statring_population/10 && population > salmon_statring_population/100  && isExecuted[2]) {
            System.out.println("POPULATION DROPS BELOW 1/10 IN "+minutes_passed+" MINUTES");
            isExecuted[2] = false;
            return salmon_population(population);
        } else if(population <= salmon_statring_population/100 && population >= 100 && isExecuted[3]) {
            System.out.println("POPULATION DROPS BELOW 1/100 IN "+minutes_passed+" MINUTES");
            isExecuted[3] = false;
            return salmon_population(population);
        } else if(population < 100){
            System.out.print("\nSALMONS POPULATION DROPS BELOW 100, SALMONS ARE FOREIGN SPECIE ");
            System.out.print(minutes_passed);
            System.out.print(" MINUTES");
            return 1;
        } else {
            return salmon_population(population);
        }
    }

    public static void main(String[] args) {
        salmon_population(salmon_statring_population);
    }

}
