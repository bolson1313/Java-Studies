package zadania_lab04.figures.figures_but_not;

public class Figures {

    //podklasa koła
    public static class Circle{
        double radius;

        String name;

        public Circle(double radius, String name) {
            this.radius = radius;
            this.name = name;
        }

        public double Field(double radius){
            return Math.PI * Math.pow(radius, 2);
        }
        public double Circut(double radius){
            return 2*Math.PI * radius;
        }

        public void output(){
            System.out.println("Wybrana figura: "+this.name+ "\nPromień koła: " +this.radius+ "\nObwód koła: " +this.Circut(radius)+ "\nPole koła: "+this.Field(radius));
        }
    }

    //podklasa kwadratu
    public static class Square{
        double side;
        String name;

        public Square(double side, String name) {
            this.side = side;
            this.name = name;
        }

        public double Field(double side){
            return Math.pow(side, 2);
        }
        public double Circut(double side){
            return 4 * side;
        }
        public void output(){
            System.out.println("Wybrana figura: "+this.name+ "\nPromień koła: " +this.side+ "\nObwód koła: " +this.Circut(side)+ "\nPole koła: "+this.Field(side));
        }
    }
}
