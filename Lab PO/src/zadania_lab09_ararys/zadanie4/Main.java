package zadania_lab09_ararys.zadanie4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Motorcycle honda = new Motorcycle("Honda", "GoldWing", 1800);
        Motorcycle suzuki = new Motorcycle("Suzuki", "V-Storm", 1050);
        Motorcycle kawasaki = new Motorcycle("Kawasaki", "Ninja", 650);
        Motorcycle romet = new Motorcycle("Romet", "Ogar", 900);


        //tablica z objektów
        Motorcycle[] motorcyclesArray = {honda, suzuki, kawasaki, romet};
        //lista z tablicy objektow
        List<Object> motorcyclesList = new ArrayList<>(Arrays.asList(motorcyclesArray));


        //wyluskanie 2 elementow od 1-3(nie liczać elementu z indeksem 3) utworzy sie nowa lista posiadająca dwa elementy o indeksach 1,2
        List<Object> motoSubList = new ArrayList<>(motorcyclesList.subList(1,3));

        System.out.println("Sub lista = " +motoSubList);
        System.out.println("Oryginalna lista = " +motorcyclesList);

        //usuniecie sublist z oryginalnej listy
        motorcyclesList.removeAll(motoSubList);

        System.out.println("oryginalna lista po usunieciu sublisty = " +motorcyclesList);



    }
}
