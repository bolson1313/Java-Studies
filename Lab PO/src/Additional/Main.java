package Additional;

import project.Inputs;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dane = {9,5,6,8,2,3,1};
        int tmp;
        for(int i=0; i < dane.length; i++) {
            System.out.print(dane[i] + ", ");
            for (int j = 1; j < dane.length; j++) {
                if(dane[j-1] > dane[j]){
                    tmp = dane[j-1];
                    dane[j-1] = dane[j];
                    dane[j] = tmp;
                }
            }
        }
        System.out.println();
        for (int i=0; i < dane.length; i++) System.out.print(dane[i]+", ");
    }
}
