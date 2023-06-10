package zadania_lab09_ararys.zadanie2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        List<String> partnerNames = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String input2,input1;
        System.out.print("Podaj imiona par: ");
        input2 = input.nextLine();
        input1 = input.nextLine();
        if(input2.equals("-") || input1.equals("-")){
            System.exit(0);
        }
        names.add(input2);
        partnerNames.add(input1);
        while(true){
            System.out.print("Podaj następne imiona: ");
            input2= input.nextLine();
            input1= input.nextLine();
            if(input2.equals("-") || input1.equals("-")){
                break;
            }
            names.add(input2);
            partnerNames.add(input1);
        }
        System.out.println("Podaj imie partnera żeby znaleźć pare: ");
        input2 = input.nextLine();
            if (names.contains(input2)) {
                System.out.println(partnerNames.get(names.indexOf(input2)));
            } else if (partnerNames.contains(input2)) {
                System.out.println(names.get(partnerNames.indexOf(input2)));
            }
            else {
                System.out.println("Brak pary");
            }
    }
}
