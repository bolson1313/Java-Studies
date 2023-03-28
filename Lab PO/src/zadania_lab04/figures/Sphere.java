package zadania_lab04.figures;

public class Sphere {
    String name;
    double radius;
    public double Field(double radius){
        return 4 * Math.PI * (Math.pow(radius, 2));
    }
    public double Velocity(double radius){
        return (4F/3F) * Math.PI * Math.pow(radius,3);
    }
    public void Params(){
        System.out.println("Wybrana figura: "+this.getName());
        System.out.println("Promień kuli wynosi: "+this.getRadius());
        System.out.println("Pole wynosi: "+this.Field(radius));
        System.out.println("Objętość wynosi: "+this.Velocity(radius));
    }

    public String getName() {
        return name;
    }
    public double getRadius() {
        return radius;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
