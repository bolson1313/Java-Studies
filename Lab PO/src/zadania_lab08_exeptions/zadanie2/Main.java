package zadania_lab08_exeptions.zadanie2;

import jdk.jshell.spi.ExecutionControlProvider;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception{
        try{
            System.out.println(power(5));
            System.out.println(power(-2));
            System.out.println(power(6));
        }
        catch(silniaExeption x){
            System.out.println("Error: "+x.getMessage());
        }
    }
    public static int power(int a) throws Exception{
        if(a < 0) throw new silniaExeption("liczba ujemna");
        if(a==0) return 1;
        return a * power(a-1);
    }

    static class silniaExeption extends Exception{
        public silniaExeption(String message){
            super(message);
        }
    }
}
