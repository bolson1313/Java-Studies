package lab04.figures;

public class Circle {
    double name, radius, area, square;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double circleArea(double radius){
        area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    public double circleSquare(double radius){
        square = 2 * Math.PI * radius;
        return square;
    }

    
}
