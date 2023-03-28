package zadania_lab04.figures;

public class Square {
    String name;
    double side;
    public double Field(double side){
        return Math.pow(side, 2);
    }
    public double Circut(double side){
        return 4*side;
    }

    public void output(){
        System.out.println("Wybrana figura: " +this.getName());
        System.out.println("Długośc boku kwadratu: " +this.getSide());
        System.out.format("Pole wynosi: %.2f\n" ,this.Field(side));
        System.out.format("Obwód wynosi: %.2f" ,this.Circut(side));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
