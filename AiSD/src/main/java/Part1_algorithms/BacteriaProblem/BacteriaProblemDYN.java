package Part1_algorithms.BacteriaProblem;

public class BacteriaProblemDYN {
    static int time = 0;
    public static void main(String[] args) {
        bacteria_counter();
    }
    static void bacteria_counter(){
        boolean[] milestone = new boolean[4];
        int[] bacteriaArr = {1, 0};
        while(true) {
            bacteriaArr[1] = bacteriaArr[0]*2;
            if (bacteriaArr[0] >= 1000 && !milestone[0]) {
                milestone[0] = true;
                System.out.println("Bacteria number passed 1000 in " + time + " minutes and count = " + bacteriaArr[0]);
            } else if (bacteriaArr[0] >= 10000 && !milestone[1]) {
                milestone[1] = true;
                System.out.println("Bacteria number passed 10000 in " + time + " minutes and count = " + bacteriaArr[0]);
            } else if (bacteriaArr[0] >= 100000 && !milestone[2]) {
                milestone[2] = true;
                System.out.println("Bacteria number passed 100000 in " + time + " minutes and count = " + bacteriaArr[0]);
            } else if (bacteriaArr[0] >= 1000000) {
                System.out.println("Bacteria number passed 1 mil in " + time + " minutes and count = " + bacteriaArr[0]);
                break;
            }
            time +=2;
            System.out.println("arr[0] = " + bacteriaArr[0] + " | arr[1] = "+ bacteriaArr[1]+ " | time: "+time);
            bacteriaArr[0] = bacteriaArr[1];
        }
    }
}
