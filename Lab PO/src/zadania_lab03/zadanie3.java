package zadania_lab03;

import java.util.Scanner;

public class zadanie3 {
    public static void main(String[] args) {
        int n = evenNumbersCounter();
        System.out.println("Suma liczb parzystych w podanym ciągu wynosi: " +n);
    }

    public static int evenNumbersCounter(){
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj długość ciągu liczba musi byc dodatnia: ");
        int N;
        N = input.nextInt();
        int counter = 0;
        if(N > 0){
            int i = 1;
            do {
                if(i%2 == 0){
                    counter = counter + i;
                }
                ++i;
            }while( i <= N);
        }else {
            evenNumbersCounter();
        }
        return counter;
    }
}
