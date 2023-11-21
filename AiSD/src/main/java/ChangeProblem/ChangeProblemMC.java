package ChangeProblem;

import java.util.Random;
import java.util.Scanner;

public class ChangeProblemMC {
    static final int[] monety = {500, 200, 100, 50, 20, 10, 5 ,2 ,1};
    static int[] ilosc_monet = {1,   2,   0,   7,  2,  2,  5, 2, 10};
    static int proby = 100;
    static final int LIMIT_WYDANYCH_MONET = 11; //Limit monet + 1
    static int minLiczbaWydanychMonet = LIMIT_WYDANYCH_MONET;
    static int[] najlepsze_rozwiazanie = new int[LIMIT_WYDANYCH_MONET];

    public static void WydawanieReszty() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int losowa_moneta, zl, gr, reszta;
        System.out.print("Podaj zl: ");
        zl = input.nextInt();
        System.out.print("Podaj gr: ");
        gr = input.nextInt();

        for (int i = 0; i < proby; i++) {
            int[] aktualne_rozwiazanie = new int[LIMIT_WYDANYCH_MONET];
            System.out.println("LOSOWANIE NR: "+i);
            reszta = zl * 100 + gr;
            System.out.println("reszta: "+reszta);
            int liczbaWydanychMonet = 0;
            ilosc_monet = new int[]{1, 2, 0, 7, 2, 2, 5, 2, 10};
            while(reszta > 0 && liczbaWydanychMonet < LIMIT_WYDANYCH_MONET) {
                System.out.println("do wydania: "+reszta+" obrot petli glownej: "+i);
                int losowy_index = random.nextInt(monety.length);
                losowa_moneta = monety[losowy_index];
                System.out.println("LOSOWA MONETA: "+(double)losowa_moneta/100);
                if(reszta >= losowa_moneta && ilosc_monet[losowy_index] > 0) {
                    aktualne_rozwiazanie[liczbaWydanychMonet] = losowa_moneta;
                    reszta = reszta - losowa_moneta;
                    System.out.println("Pozostała reszta: "+(double) reszta/100);
                    liczbaWydanychMonet++;
                    ilosc_monet[losowy_index]--;
                    System.out.println("Stan zasobnika!!!!");
                    System.out.print("ILOSC = ");
                    for (int j = 0; j < ilosc_monet.length; j++){
                        System.out.println(ilosc_monet[j]+", ");
                    }
                }
            }
            if(liczbaWydanychMonet < minLiczbaWydanychMonet) {
                minLiczbaWydanychMonet = liczbaWydanychMonet;
                for (int j = 0; j < aktualne_rozwiazanie.length; j++) {
                    System.out.println("aktualna moneta: "+aktualne_rozwiazanie[j]);
                    najlepsze_rozwiazanie[j] = aktualne_rozwiazanie[j];
                }
            }
        }

        if(minLiczbaWydanychMonet < LIMIT_WYDANYCH_MONET) {
            System.out.println("Reszta: ");
            System.out.println("min liczba wydanych monet: "+ minLiczbaWydanychMonet);
            double poprawna_reszta = 0;
            for (int i = 0; i < najlepsze_rozwiazanie.length; i++){
                System.out.print(" "+najlepsze_rozwiazanie[i]/100.0);
                poprawna_reszta = poprawna_reszta + najlepsze_rozwiazanie[i];
            }
            System.out.println("\nPoprawna reszta: "+poprawna_reszta/100.0);
        } else {
            System.out.println("Nie znaleziono rozwiazania!");
        }
    }

    public static void main(String[] args) {
        WydawanieReszty();
    }
}
