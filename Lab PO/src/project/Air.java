package project;

public class Air extends Utility{
    double temperature;

    public Air() {
        this.temperature = Math.random() * 15+10;
    }
    @Override
    public String toString() {
        return "Temperatura powietrza: "+String.format("%.2f",this.temperature)+"\n";
    }
}
