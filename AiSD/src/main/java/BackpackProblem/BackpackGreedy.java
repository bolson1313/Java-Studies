package BackpackProblem;

public class BackpackGreedy {
    static int Vbp = 10;
                    //0 1 2 3 4 5
    static int[] V = {6,2,3,2,3,1};
    static int[] W = {6,4,5,7,10,2};
    static double[][] result = new double[2][6];

    static void Value() {
        for(int i = 0; i < V.length; i++){
            result[0][i] = i;
            result[1][i] = (double) V[i] / W[i];
        }
        System.out.println("not sorted");
        for (int j = 0; j < 6; j++) {
            System.out.println( "id: " + result[0][j] + " value: " + result[1][j]);
        }
        double tmp = 0;
        double tmp2 = 0;
        for(int i = 0; i < V.length; i++){
            for(int j = 1; j < V.length; j++){
                if(result[1][j-1] < result[1][j]) {
                    tmp2 = result[0][j-1];
                    tmp = result[1][j-1];
                    result[1][j-1] = result[1][j];
                    result[0][j-1] = result[0][j];
                    result[1][j] = tmp;
                    result[0][j] = tmp2;
                }
            }
        }
        System.out.println("sorted");
        for (int j = 0; j < 6; j++) {
            System.out.println( "id: " + result[0][j] + " value: " + result[1][j]);
        }

        for(int i = 0; i < V.length; i++){
                if(Vbp - V [(int) result[0][i]]>= 0) {
                    Vbp = Vbp -  V[(int) result[0][i]];
                    System.out.print("id: "+(int) result[0][i]+" ");
                    System.out.println("free space: "+Vbp);
                }
        }

    }

    public static void main(String[] args) {
        Value();
    }

}
