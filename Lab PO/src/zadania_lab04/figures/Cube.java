package zadania_lab04.figures;

public class Cube {
    String name;
    double base;
    public double Field(double base){
        double field;
        field = (Math.pow(base, 2)*6);
        return field;
    }
    public double Velocity(double base){
        double velocity;
        velocity = (Math.pow(base, 3));
        return velocity;
    }
    public void Params(){
        System.out.println("Wybrana figura: "+this.getName());
        System.out.println("Krawędź sześcianu wynosi: "+this.base);
        System.out.println("Pole wynosi: "+this.Field(base));
        System.out.println("Objętość wynosi: "+this.Velocity(base));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public String getName() {
        return name;
    }

}
