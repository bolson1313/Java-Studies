package lab04.figures;

public class Square {
    double name, a, area, square;

    public void setA(double a) {
        this.a = a;
    }

    public double squareArea(double a){
        area = a *4;
        return area;
    }

    public double squareSquare(double a){
        square = a*a;
        return square;
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                ", area=" + area +
                ", square=" + square +
                '}';
    }
}
