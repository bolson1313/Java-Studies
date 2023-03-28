package zadania_lab04.figures;

public class Circle {
    String name;
    double radius;
    public double Field(double radius){
        return Math.PI * Math.pow(radius, 2);
    }
    public double Circut(double radius){
        return 2*Math.PI * radius;
    }

    public void output(){
        System.out.println("Wybrana figura: " +this.getName());
        System.out.println("Promień koła: " +this.getRadius());
        System.out.format("Pole wynosi: %.2f\n" ,this.Field(radius));
        System.out.format("Obwód wynosi: %.2f" ,this.Circut(radius));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
