package zadania_lab03;

import java.util.*;

import static zadania_lab02.Calculator.Calculator.ReadString;

public class zadanie3i4 {
    public static void main(String[] args) {
        Run();
    }
    //insert values into array
    public static int[] InsertArray(){
        int[] methodArray = new int[10];
        Scanner input = new Scanner(System.in);
        for(int i=0; i < methodArray.length; i++){
            System.out.print("Podaj ["+i+"] tablicy: ");
            methodArray[i] = input.nextInt();
        }
        return methodArray;
    }

    //run method
        public static void Run () {
            int option;
            int[] RunArray = InsertArray();
            String conf;
            Scanner input = new Scanner(System.in);
            do {
                Menu();
                clearScreen();
                System.out.print("Wybierz opcje: ");
                option =  input.nextInt();
                System.out.println("\n");
                if(option == 1){
                    RunArray = InsertArray();
                } else if (option == 2) { //array cells out from 0 to 10
                    for(int i = 0; i < RunArray.length; i++){
                        System.out.print(RunArray[i]+" ");
                    }
                    System.out.print("\n\n");
                } else if (option == 3) { //array cells out from 10 to 0
                    for(int i = RunArray.length-1; i >= 0; i--){
                        System.out.print(RunArray[i]+" ");
                    }
                    System.out.print("\n\n");
                } else if (option == 4) { //even tab cells  out
                    for(int i = 0; i < RunArray.length; i++){
                        if(i%2 == 0){
                            System.out.print(RunArray[i]+ " ");
                        }
                    }
                    System.out.print("\n\n");
                } else if (option == 5) { //not even tab cells out
                    for(int i = 0; i < RunArray.length; i++){
                        if(i%2 != 0){
                            System.out.print(RunArray[i]+ " ");
                        }
                    }
                    System.out.print("\n\n");
                } else if (option == 6) { //summary cells
                    int count;
                    count = 0;
                    for(int i = 0; i < RunArray.length; i++){
                        count = count + RunArray[i];
                    }
                    System.out.println("Suma elementów tablicy: " +count+ "\n\n");
                } else if (option == 7) { //
                    int count2;
                    count2 = 1;
                    for(int i = 0; i < RunArray.length; i++){
                        count2 = count2 * RunArray[i];
                    }
                    System.out.println("Iloczyn elementów tablicy: " +count2+ "\n\n");
                } else if (option == 8) { //avg cells value
                    float avgVal, A;
                    int a = 0;
                    for(int i = 0; i < RunArray.length; i++){
                        a = a + RunArray[i];
                    }
                    A=a;
                    avgVal = A / 10;
                    System.out.println("Średnia wartość elementów tablicy to: " +avgVal+ "\n\n");
                } else if (option == 9) { //min cell output
                    int min = 10000;
                    for(int i = 0; i < RunArray.length; i++){
                        if(RunArray[i]<min){
                            min = RunArray[i];
                        }
                    }
                    System.out.println("Najmniejsza wartosc w tablicy to: " +min);
                } else if (option == 10) {
                    int max = 1;
                    for(int i = 0; i < RunArray.length; i++){
                        if(RunArray[i]>max){
                            max = RunArray[i];
                        }
                    }
                    System.out.println("Najwieksza wartosc w tablicy to: " +max);
                } else if (option == 11) {
                    conf = ReadString();
                    if(conf.equals("T") || conf.equals("t")){
                        System.exit(1);
                    }
                } else if (option == 12) {
                    Run();
                }
            } while (true);
        }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
        //program menu
        public static void Menu() {
            System.out.println("Witaj w narzędziu tablic! \n\n1. Wprowadź zmienne do tablicy\n2. Wypisz tablice od początku do końca\n3. Wypisz tablice od końca do początku\n4. Wypisanie elementów nieparzystych indeksach\n5. Wypisanie elementów parzystych indeksach\n6. Suma elementów tablicy\n7. Iloczyn elementów tablicy\n8. Średnia wartość tablicy\n9. Wartość minimalna tablicy\n10. Wartość maksymalna tablicy\n11. Wyjdź\n12.Zresetuj program");
        }
    }