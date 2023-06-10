package zadania_lab06.zadanie2;

import java.util.Scanner;


public class Car {
    String mark, model, body, color;
    int yearOfProd, mileage;

    public Car(String mark, String model, String body, String color) {
        this.mark = mark;
        this.model = model;
        this.body = body;
        this.color = color;
    }

    public Car(String mark, String model, String body, String color, int yearOfProd, int mileage) {
        this.mark = mark;
        this.model = model;
        this.body = body;
        this.color = color;
        this.yearOfProd = yearOfProd;
        this.mileage = mileage;
        while(this.mileage <=0){
            System.out.print("Przebieg " +this.mark+ " " +this.model+ " jest ujemny, podaj prawidłowy: ");
            this.mileage = (int)InputDouble();
        }
    }


    @Override
    public String toString() {
        return "Car{" +
                "mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", body='" + body + '\'' +
                ", color='" + color + '\'' +
                ", yearOfProd=" + yearOfProd +
                ", mileage=" + mileage +
                '}';
    }

    public static double InputDouble(){
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }
}
