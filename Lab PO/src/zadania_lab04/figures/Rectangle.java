package zadania_lab04.figures;

public class Rectangle {
    String name;
    double side1,side2;
    public double Field(double side1, double side2){
        return side1 * side2;
    }
    public double Circut(double side1, double side2){ return 2*side1+2*side2; }

    public void output(){
        System.out.println("Wybrana figura: " +this.getName());
        System.out.println("Długośc boku A: " +this.getSide1());
        System.out.println("Długośc boku B: " +this.getSide2());
        System.out.format("Pole wynosi: %.2f\n" ,this.Field(side1, side2));
        System.out.format("Obwód wynosi: %.2f" ,this.Circut(side1, side2));
    }

    public String getName() {
        return name;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }
}
