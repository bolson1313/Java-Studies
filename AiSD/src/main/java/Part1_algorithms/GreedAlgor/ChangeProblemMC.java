package Part1_algorithms.GreedAlgor;

import java.io.*;
class ChangeProblemMC
{
    public static void main(String[] args) throws IOException
    {
        InputStreamReader str = new InputStreamReader(System.in);
        BufferedReader wejscie = new BufferedReader(str);
        String tekst;
        final int[] M = {500,200,100,50,20,10,5,2,1};
        final int[] L = {2,1,0,0,0,0,1,5}; //12,07
        int[] used = new int[9];
        int zl, gr, r, i = 0;
        System.out.println("Podaj reszte..");
        System.out.print("zlotych: ");
        tekst = wejscie.readLine();
        zl = Integer.parseInt(tekst);
        System.out.print("groszy: ");
        tekst = wejscie.readLine();
        gr = Integer.parseInt(tekst);
        System.out.print("Reszta: ");
        r = zl*100 + gr;
        while (r > 0) {
            if (r >= M[i]) {
                System.out.print(M[i] / 100.0 + " ");
                r = r - M[i];

            } else
                i++;
        }
        System.out.println();
        i = 0;
        r = zl * 100 + gr;
        while(r > 0) {
            if(r >= M[i]) {
                used[i]++;
                System.out.println(M[i] / 100.0 + " " + used[i]);
                r = r - M[i];
            } else {
                i++;
            }
        }
        System.out.println("============================");

        i = 0;
        used = new int[8];
        r = zl * 100 + gr;
        while(r > 0 && i < M.length) {

            if(r >= M[i] && L[i] > 0) {
                used[i]++;
                System.out.println(M[i] / 100.0 + " " + used[i]);
                r = r - M[i];
                L[i]--;
            } else {
                i++;
            }
        }
    }
}