package Part1_algorithms.bulaskacper.src;

import java.util.Arrays;

public class ZADANIE2 {
    static int[][] drogi = {

                {0  ,300,402,356,  0,  0,  0,  0,  0},
                {300,  0,  0,  0,440,474,  0,  0,  0},
                {402,  0,  0,  0,  0,330,  0,  0,  0},
                {356,  0,  0,  0,  0,  0,823,  0,  0},
                {  0,440,  0,  0,  0,  0,  0,430,  0},
                {  0,474,330,  0,  0,  0,813,365,774},
                {  0,  0,  0,823,  0,813,  0,  0,403},
                {  0,  0,  0,  0,430,365,  0,  0,768},
                {  0,  0,  0,  0,  0,774,403,768,  0}
        };

    static String[] nazwy_miast = {"Warszawa, ", "Katowice, ", "Zakopane, ", "Lwów, ", "Wiedeń, ", "Budapeszt, ", "Bukareszt, ", "Zagrzeb, ", "Sofia, "};

    static int dystans = 0;
    public static void Najkrotsza_Droga() {
        int[] polaczenia = new int[9];
        String kolejnosc_miast = "";
        for (int i = 0; i < drogi.length; i++) {
            for (int j = 0; j < drogi.length; j++) {
                if (drogi[i][j] != 0) {
                    polaczenia[i]++;
                }
            }
        }
        int index_najwiecej_pol = 0;
        for (int i = 0; i < polaczenia.length; i++) {
            if (polaczenia[i] > index_najwiecej_pol) {
                index_najwiecej_pol = i;
            }
        }
        boolean[] odwiedzone = new boolean[9];
        odwiedzone[index_najwiecej_pol] = true;
        kolejnosc_miast += nazwy_miast[index_najwiecej_pol];
        int min;
        int a, b = 0;
        a = index_najwiecej_pol;
        int breakpointpetli = 0;
        while (breakpointpetli < 8) {
            System.out.println("while true obrot: "+breakpointpetli+" start: "+kolejnosc_miast);
            min = Integer.MAX_VALUE;
            for (int i = 0; i < drogi.length; i++) {
                if (drogi[a][i] != 0 && drogi[a][i] < min && !odwiedzone[i]) {
                    min = drogi[a][i];
                    b = i;
                }
                System.out.println("MIN: "+min);
            }
            odwiedzone[b] = true;
            dystans += drogi[a][b];
            drogi[a][b] = 0;
            System.out.println("A: "+a+" B: "+b);
            a = b;
            kolejnosc_miast += nazwy_miast[a];
            System.out.println("MIN = "+min);
            System.out.println("ZMIANA "+b+" NA ODWIEDZONY");
            breakpointpetli++;
        }
        System.out.println("MIASTO Z NAJWIEKSZA ILOSCIA POLACZEN: "+nazwy_miast[index_najwiecej_pol]);
        System.out.println("KOLEJNOSC MIAST: "+kolejnosc_miast+" DYSTANS: "+dystans);

    }
    public static void main(String[] args) {
        Najkrotsza_Droga();
    }
}
