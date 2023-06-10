package zadania_lab09_ararys.zadanie4;

public class Motorcycle {
    String model, brand;
    float capacity;

    public Motorcycle(String brand, String model, float capacity) {
        this.model = model;
        this.brand = brand;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "--- "+brand+" - "+model+" - "+capacity+" ---";
    }
}
