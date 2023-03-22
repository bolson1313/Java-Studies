package zadania_lab02.Calculator;

import java.util.Scanner;

public class zadanie7 {
    public static void main(String[] args) {
        bubbleSorting();
    }
    public static int[] newArray(){
        Scanner input = new Scanner(System.in);
        int tabSize;
        System.out.print("Podaj rozmiar tablicy: ");
        tabSize = input.nextInt();
        int[] tabN = new int[tabSize];
        for(int i = 0; i < tabN.length; i++){
            System.out.print("Podaj [" +i+ "] element tablicy: ");
            tabN[i] = input.nextInt();
        }
        return tabN;
    }

    public static void bubbleSorting(){
        int[] tabN = newArray();
        int[] temp = new int[1];
        int count = tabN.length;
        do {
            for(int i = 0; i < count-1; i++){
                if (tabN[i] > tabN[i + 1]) {
                    temp[0] = tabN[i];
                    tabN[i] = tabN[i + 1];
                    tabN[i + 1] = temp[0];
                }
            }
            count = count -1;
        }while(count > 1);


        for(int i = 0; i < tabN.length; i++){
            System.out.println("["+i+"] = "+tabN[i]);
        }
    }
}
