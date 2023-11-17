package BacteriaProblem;

public class BacteriaProblemDC {
    static int time = 0;
    static boolean[] milestone = new boolean[3];

    static public int bacteria_counter(int n) {
        if(n >= 1000 && !milestone[0]) {
            milestone[0] = true;
            System.out.println("Bacteria number passed 1000 in "+ time*2 + " minutes and count = " +n);
        } else if(n >= 10000 && !milestone[1]) {
            milestone[1] = true;
            System.out.println("Bacteria number passed 10000 in "+ time*2 + " minutes and count = " +n);
        } else if(n >= 100000 && !milestone[2]) {
            milestone[2] = true;
            System.out.println("Bacteria number passed 100000 in "+ time*2 + " minutes and count = " +n);
        } else if(n >= 1000000) {
            System.out.println("Bacteria number passed 1 mil in "+ time*2 + " minutes and count = " +n);
            return 1;
        }
        time++;
        return bacteria_counter(n*2);
    }
    public static void main(String[] args) {
        bacteria_counter(1);
    }
}
