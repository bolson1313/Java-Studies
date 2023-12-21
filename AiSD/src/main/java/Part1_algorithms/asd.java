package Part1_algorithms;
public class asd {

    static double consumeRatio = 0.004;
    static int time = 0;
    // 0 - time = 1,
    // 0 - before, 1 - currentPopulation
//    static double currentPopulation = 1000.0;
    static int populationTable = 1000;
    public static double calculatePopulation(int timeInMinutes) {
        populationTable = (int) ((populationTable * Math.pow(3.14, 0.002)) - (populationTable * consumeRatio));
        System.out.println("populacja: "+populationTable);
        System.out.println("czas: "+timeInMinutes);
        if (populationTable < 10) {
            System.out.println("populacja spadla ponizej 10, populacja: "+populationTable+" w czasie: "+timeInMinutes);
        }
        timeInMinutes++;
        if (populationTable < 10){
            return 1;
        }else {
            return calculatePopulation(timeInMinutes);
        }
    }

    public static void main(String[] args) {


            calculatePopulation(time);

    }

}