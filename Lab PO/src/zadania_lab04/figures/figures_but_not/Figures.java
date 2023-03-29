package zadania_lab04.figures.figures_but_not;

public class Figures {
    String nameOfFigure;

    public String getNameOfFigure() {
        return nameOfFigure;
    }

    public void setNameOfFigure(String nameOfFigure) {
        this.nameOfFigure = nameOfFigure;
    }



    //podklasa koła
    public static class Circle{
        double radius;

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public double Field(double radius){
            return Math.PI * Math.pow(radius, 2);
        }
        public double Circut(double radius){
            return 2*Math.PI * radius;
        }
    }

    //podklasa kwadratu
}
