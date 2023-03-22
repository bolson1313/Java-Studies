package zadania_lab03;

//import java.util.Arrays;
import java.util.Arrays;
import java.util.Scanner;

public class zadanie5 {
    public static void main(String[] args) {
        if(checkIfPalindrom()){
            System.out.println("Podane słowo jest palindromem");
        }else{
            System.out.println("Podane słowo nie jest palindromem");
        }
    }

    public static char[] readWord(){
        Scanner input = new Scanner(System.in);
        String word;
        System.out.print("Podaj słowo: ");
        word = input.nextLine();
        char[] charArr;
        charArr = word.toCharArray();
        return charArr;
    }

    public static boolean checkIfPalindrom(){
        char[] wordChar;
        wordChar = readWord();
        char[] wordCharRev = new char[wordChar.length];
        int j = wordChar.length;
        for(int i = 0; i < wordChar.length; i++){
            wordCharRev[j-1] = wordChar[i];
            j = j - 1;
        }
        return Arrays.equals(wordChar, wordCharRev);


    }
}
