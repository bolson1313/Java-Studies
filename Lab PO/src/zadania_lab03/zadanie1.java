package zadania_lab03;

import java.util.Scanner;

public class zadanie1 {
    public static void main(String[] args) {
        System.out.println("Średnia liczba zdobytych punktów przez wszystkich studentów: "+avgStudentPoints(studentsList()));
    }

    public static int studentsList(){
        Scanner input = new Scanner(System.in);
        System.out.print("Podaj liczbę studentów: ");
        double[] sList;
        sList = new double[input.nextInt()];
        return sList.length;
    }

    public static double avgStudentPoints(int a){
        Scanner input = new Scanner(System.in);
        double avgPoints, points = 0;
        double[] studentsList = new double[a];
        int i = 0;
        while(i < studentsList.length){
            System.out.print("Podaj ilość punktów zdobytych przez studenta z nr. "+i+": ");
            studentsList[i] = input.nextDouble();
            points = studentsList[i] + points;
            i++;
        }
        avgPoints = points / studentsList.length;
        return avgPoints;
    }
}
