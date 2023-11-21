package IceCreamProblme;

public class IceCreamGreed {
    public static int[][] ice_cream = {
            //0   1   2   3   4   5
            { 0,  7, 20, 21, 12, 23},//0
            {27,  0, 13, 16, 46,  5},//1
            {53, 15,  0, 25, 27,  6},//2
            {16,  2, 35,  0, 47, 10},//3
            {31, 29,  5, 18,  0,  4},//4
            {28, 24,  1, 17,  5,  0} //5
    };

    static void ice_cream_order() {
        int min = 1000;
        int index = 0;
        int current_icecream = 0;
        String result = "";
        int licz = 0;
        while(licz < 5) {
            min = 1000;
            for (int i = 0; i < ice_cream.length; i++) {
                if (min > ice_cream[current_icecream][i] && ice_cream[current_icecream][i] != 0) {
                    min = ice_cream[current_icecream][i];
                    index = i;
                }
                ice_cream[current_icecream][i] = 0;
                ice_cream[i][current_icecream] = 0;
            }
            current_icecream = index;
            result += (index+1);
            licz++;
        }
        System.out.println("index: 1"+result+ "1 in time: ");
    }

    public static void main(String[] args) {
        ice_cream_order();
    }
}
