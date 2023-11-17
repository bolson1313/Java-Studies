package BacteriaProblem;

public class BacteriaProblemDYN {
    static int time = 0;
    public static void main(String[] args) {
        bacteria_counter();
    }
    static void bacteria_counter(){
        boolean[] milestone = new boolean[4];
        int[] bacteriaArr = {1};
        while(true) {
            if (bacteriaArr[0] >= 1000 && !milestone[0]) {
                milestone[0] = true;
                System.out.println("Bacteria number passed 1000 in " + time * 2 + " minutes and count = " + bacteriaArr[0]);
            } else if (bacteriaArr[0] >= 10000 && !milestone[1]) {
                milestone[1] = true;
                System.out.println("Bacteria number passed 10000 in " + time * 2 + " minutes and count = " + bacteriaArr[0]);
            } else if (bacteriaArr[0] >= 100000 && !milestone[2]) {
                milestone[2] = true;
                System.out.println("Bacteria number passed 100000 in " + time * 2 + " minutes and count = " + bacteriaArr[0]);
            } else if (bacteriaArr[0] >= 1000000) {
                System.out.println("Bacteria number passed 1 mil in " + time * 2 + " minutes and count = " + bacteriaArr[0]);
                break;
            }
            time++;
            bacteriaArr[0] = bacteriaArr[0] + bacteriaArr[0]*2;
        }
    }
}
