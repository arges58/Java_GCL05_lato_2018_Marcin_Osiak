import java.util.Scanner;

public class TetrahedronCalculator implements Calculator {
    @Override
    public double calculateBaseArea()
    {
        System.out.println("Type height: ");
        Scanner read = new Scanner(System.in);
        double height = read.nextDouble();
        System.out.println("Type side: ");
        Scanner read1 = new Scanner(System.in);
        double side = read1.nextDouble();

        double tetraArea = (1.0/2.0) * height * side;

        return tetraArea;
    }
    @Override
    public double calculateBasePerimeter()
    {
        System.out.println("side: ");
        Scanner read = new Scanner(System.in);
        double side = read.nextDouble();

        double tetraPerimeter = 3.0 * side;

        return tetraPerimeter;
    }

}
