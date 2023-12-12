package Part1_algorithms.IceCreamProblme;

import java.util.Random;

public class IceCreamMC {
    public static int[][] ice_cream = {
            //0   1   2   3   4   5
            { 0,  7, 20, 21, 12, 23},//0
            {27,  0, 13, 16, 46,  5},//1
            {53, 15,  0, 25, 27,  6},//2
            {16,  2, 35,  0, 47, 10},//3
            {31, 29,  5, 18,  0,  4},//4
            {28, 24,  1, 17,  5,  0} //5
    };


    static void ice_cream(int trials) {
        Random random = new Random();
        int[] time_array = new int[trials];
        int random_index;
        int[] used_ic = new int[6];
        int current_index = 0;
        int time = 0;
        String ice_cream_odrder = "";
        for(int i = 0; i < trials; i++) {
            random_index = random.nextInt(1, 6);
            if(ice_cream[current_index][random_index] != 0) {
                time += ice_cream[current_index][random_index];
                current_index = random_index;
            }
        }
        System.out.println(time);
    }

    public static void main(String[] args) {
        ice_cream(100);
    }
}