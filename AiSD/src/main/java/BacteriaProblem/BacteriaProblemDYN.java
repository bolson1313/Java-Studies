package BacteriaProblem;

public class BacteriaProblemDYN {
    public static void main(String[] args) {
        bacteria_counter();
    }
    static void bacteria_counter(){
        int i = 1;
        int time = 0;
        boolean[] milestone = new boolean[4];
        while(i < 10000000) {
            time++;
            if (i >= 1000 && !milestone[0]) {
                milestone[0] = true;
                System.out.println("Bacteria number passed 1000 in " + time * 2 + " minutes and count = " + i);
            } else if (i >= 10000 && !milestone[1]) {
                milestone[1] = true;
                System.out.println("Bacteria number passed 10000 in " + time * 2 + " minutes and count = " + i);
            } else if (i >= 100000 && !milestone[2]) {
                milestone[2] = true;
                System.out.println("Bacteria number passed 100000 in " + time * 2 + " minutes and count = " + i);
            } else if (i >= 1000000) {
                System.out.println("Bacteria number passed 1 mil in " + time * 2 + " minutes and count = " + i);
                break;
            }
            i = i + i * 2;
        }
    }
}
