import java.util.Scanner;

public class ConeCalcularor implements Calculator {
    public double calculateBaseArea()
    {
        System.out.println("Type radius: ");
        Scanner read = new Scanner(System.in);
        double radius = read.nextDouble();

        double coneArea = Math.PI * radius *radius;

        return coneArea;
    }
    public double calculateBasePerimeter()
    {
        System.out.println("Type radius: ");
        Scanner read = new Scanner(System.in);
        double radius = read.nextDouble();

        double conePerimeter = 2.0 * Math.PI * radius;

        return conePerimeter;
    }
}
