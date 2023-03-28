package zadania_lab04.figures;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            System.out.print("Podaj figure: ");
            String name = readString();
            switch (name) {
                case "koło":
                    System.out.println("Podaj promień koła");
                    double radius = readDouble();
                    Circle circle = new Circle();
                    circle.setRadius(radius);
                    circle.setName(name);
                    circle.output();
                    break;

                case "kwadrat":
                    System.out.println("Podaj dł. boku kwadratu: ");
                    double side = readDouble();
                    Square square = new Square();
                    square.setSide(side);
                    square.setName(name);
                    square.output();
                    break;

                case "prostokąt":
                    System.out.println("Podaj dl. boku A prostokąta");
                    double side1 = readDouble();
                    System.out.println("Podaj dl. boku B prostokąta");
                    double side2 = readDouble();
                    Rectangle rectangle = new Rectangle();
                    rectangle.setSide1(side1);
                    rectangle.setSide2(side2);
                    rectangle.output();
                    break;

                case "Sześcian":
                    System.out.println("Podaj podstawę sześcianu");
                    double base = readDouble();

                    Cube cube = new Cube();
                    cube.setBase(base);
                    cube.setName(name);
                    cube.Params();
                    break;

                case "prostopadłościan":
                    System.out.println("Podaj podstawę prostopadłościanu");
                    base = readDouble();
                    System.out.println("Podaj bok prostopadłościanu");
                    side = readDouble();
                    System.out.println("Podaj wysokość prostopadłościanu");
                    double height = readDouble();

                    Cuboid cuboid = new Cuboid();
                    cuboid.setBase(base);
                    cuboid.setSide(side);
                    cuboid.setHeight(height);
                    cuboid.setName(name);
                    cuboid.Params();
                    break;

                case "kula":
                    System.out.println("Podaj promień Kuli");
                    radius = readDouble();

                    Sphere sphere = new Sphere();
                    sphere.setRadius(radius);
                    sphere.setName(name);
                    sphere.Params();
                    break;

                case "stożek":
                    System.out.println("Podaj promień podstawy stożka:");
                    radius = readDouble();
                    System.out.println("Podaj tworzącą stożka:");
                    double l = readDouble();

                    Cone cone = new Cone();
                    cone.setRadius(radius);
                    cone.setL(l);
                    cone.setName(name);
                    cone.Params();
                    break;

                default:
                    System.out.println("Jeśli chcesz wyjść wpisz T jeśli nie N");
                    if(readString().equals("T") || readString().equals("t")){
                        System.exit(1);
                    }
                    break;
            }
        }

    }
    //read string
    public static String readString(){
        Scanner input = new Scanner(System.in);
        String name;
        name = input.nextLine();
        return name;
    }
    //read double input
    public static double readDouble(){
        Scanner input = new Scanner(System.in);
        double dinput;
        dinput = input.nextDouble();
        return dinput;
    }
}
