package BackpackProblem;

public class BackpackGreedy {
                    //0 1 2 3 4 5
    static int[] V = {6,2,3,2,3,1};
    static int[] W = {6,4,5,7,10,2};

    //1 sorted max worth
    static int[] max(){
        int[] max = {0,0};
        for(int i = 0; i < W.length; i++){
            if(W[i] > max[1]){
                max[1] = W[i];
                max[0] = i;
            }
        }
        return max;
    }
    static void backpack1(){
        int Vbp = 10;
        for(int i = 0; i < W.length; i++){
            //System.out.println("id: "+max()[0]+ ", worth: "+max()[1]+ ", volume: "+V[max()[0]]);
            if(Vbp - V[max()[0]] >= 0){
                Vbp = Vbp - V[max()[0]];
                System.out.println("id: "+max()[0]+", free space: "+Vbp);
            }
            W[max()[0]] =- max()[1];
        }
    }

    // 2 min volume sort



    // 3 volume / value sorted
    static void backpack3() {
        int Vbp = 10;
        double[][] result = new double[2][6];
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
        backpack1();
    }

}
