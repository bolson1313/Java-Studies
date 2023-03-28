package zadania_lab04.figures;

public class Cuboid {
    String name;
    double base, side, height;
    public double Field(double base, double side, double height){
        double field;
        field = (base * side)*2+(height * side)*2+(base * height)*2;
        return field;
    }
    public double Velocity(double base, double side, double height){
        double velocity;
        velocity = base * side * height;
        return velocity;
    }
    public void Params(){
        System.out.println("Wybrana figura: "+this.getName());
        System.out.println("Krawędzie prostopadłościanu wynosi: "+this.base+", "+this.side+", "+this.height);
        System.out.println("Pole wynosi: "+this.Field(base, side, height));
        System.out.println("Objętość wynosi: "+this.Velocity(base, side, height));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }
}
