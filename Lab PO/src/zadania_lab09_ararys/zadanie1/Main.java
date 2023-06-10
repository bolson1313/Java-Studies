package zadania_lab09_ararys.zadanie1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        Scanner input = new Scanner(System.in);
        String input2;
        System.out.print("Podaj imie: ");
        input2 = input.nextLine();
        if(input2.equals("-")){
            System.exit(0);
        }
        names.add(input2);
        while(true){
            System.out.print("Podaj następne imię: ");
            input2= input.nextLine();
            if(input2.equals("-")){
                break;
            }
            names.add(input2);
        }
        System.out.println("Unikalna liczba imion: " +names.size());
    }

}
