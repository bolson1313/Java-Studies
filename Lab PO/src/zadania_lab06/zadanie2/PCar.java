package zadania_lab06.zadanie2;

public class PCar extends Car{
    double weight, capacity;
    int nOfPeople;

    public PCar(String mark, String model, String body, String color, int yearOfProd, int course, double weight, double capacity, int nOfPeople) {
        super(mark, model, body, color, yearOfProd, course);
        this.weight = weight;
        if(this.weight < 2 || this.weight > 4.5){
            System.out.print("Niepoprawna waga " +this.mark+ " " +this.model+ "! Proszę sprawdzić i wprowadzić poprawne dane (przedział 2t do 4.5t): ");
            this.weight = InputDouble();
        }
        this.capacity = capacity;
        if(this.capacity > 3 || this.capacity < 0.8){
            System.out.print("Niepoprawna pojemność silnika w " +this.mark+ " " +this.model+ " ! Proszę sprawdzić i wprowadzić poprawne dane (przedział 0.8l do 3.0l): ");
            this.capacity = InputDouble();
        }
        this.nOfPeople = nOfPeople;
    }

    //przesloniecie zwracanai w klasie PCar
    public String toString(){
        return super.toString()+"\nweight: " +this.weight+ "\ncapacity: " +this.capacity+ "\nNumber of People: " +this.nOfPeople;
    }
}
