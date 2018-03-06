import java.util.Scanner;

public class ExtendedTerahedronCalculator extends TetrahedronCalculator implements ExtendedCalculator {

    @Override
    public double calculateArea() {
        System.out.println("Type side: ");
        Scanner read1 = new Scanner(System.in);
        double side = read1.nextDouble();
        if(side <= 0)
            throw new IllegalArgumentException("Side must be higher than 0");

        double tetraArea = Math.pow(side,2) * Math.sqrt(3);

        return tetraArea;
    }

    @Override
    public double calculateVolume() {
        System.out.println("Type side: ");
        Scanner read1 = new Scanner(System.in);
        double side = read1.nextDouble();
        if(side <= 0)
            throw new IllegalArgumentException("Side must be higher than 0");

        double tetraVolume = 1.0/12.0 * Math.pow(side,3) * Math.sqrt(2);

        return tetraVolume;
    }
    public void useCalculator() {
        System.out.println("1. Base area of Tetrahedron");
        System.out.println("2. Base parimeter of Tetrahedron");
        System.out.println("3. Area of Tetrahedron");
        System.out.println("4. Volume of Tetrahedron");

        Scanner read = new Scanner(System.in);
        int choose = read.nextInt();
        switch (choose) {
            case 1:
                double bA = calculateBaseArea();
                System.out.println("Base area: " + bA);
                break;
            case 2:
                double bP = calculateBasePerimeter();
                System.out.println("Base parimeter: " + bP);
                break;
            case 3:
                double A = calculateArea();
                System.out.println("Area: " + A);
                break;
            case 4:
                double P = calculateVolume();
                System.out.println("Volume: " + P);
                break;
            default:
                break;
        }
    }
}
