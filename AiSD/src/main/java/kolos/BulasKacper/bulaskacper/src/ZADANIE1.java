public class ZADANIE1 {
    static int N = 5;
    public static double ciag(double n){
        if(n==1) {
            return 2;
        } else if (n == 2) {
            return 4;
        } else {
            return (ciag(n-1) * ciag(n-2))/ 2;
        }

    }
    public static void main(String[] args) {
        System.out.println(ciag(N));
    }
}