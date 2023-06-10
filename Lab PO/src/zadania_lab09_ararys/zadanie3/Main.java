package zadania_lab09_ararys.zadanie3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        List<String> parts = new LinkedList<>();
        Participants part1 = new Participants("Adam", 15);
        Participants part2 = new Participants("Karol", 20);
        Participants part3 = new Participants("Kacper", 18);
        Participants part4 = new Participants("Jakub", 11);
        Participants part5 = new Participants("Maja", 21);
        Participants part6 = new Participants("Nikodem", 22);
        parts.add(part1.toString());
        parts.add(part2.toString());
        parts.add(part3.toString());
        parts.add(part4.toString());
        parts.add(part5.toString());
        parts.add(part6.toString());
        for(String i: parts){
            System.out.println(i);
        }
        System.out.println("Osoby niepełnoletnie: ");

    }
}
