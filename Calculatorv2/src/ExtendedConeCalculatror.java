import java.util.Scanner;

public class ExtendedConeCalculatror extends ConeCalcularor implements ExtendedCalculator {
    @Override
    public double calculateArea() {
        System.out.println("Type radius: ");
        Scanner read = new Scanner(System.in);
        double radius = read.nextDouble();
        System.out.println("Type length: ");
        Scanner read1 = new Scanner(System.in);
        double length = read1.nextDouble();

        if(radius <= 0)
            throw new IllegalArgumentException("Radius must be higher than 0");
        if(length <= 0)
            throw new IllegalArgumentException("Length must be higher than 0");

        double coneArea = Math.PI * radius *(radius + length);

        return coneArea;
    }

    @Override
    public double calculateVolume() {
        System.out.println("Type radius: ");
        Scanner read = new Scanner(System.in);
        double radius = read.nextDouble();
        System.out.println("Type height: ");
        Scanner read1 = new Scanner(System.in);
        double height = read1.nextDouble();
        if(radius <= 0)
            throw new IllegalArgumentException("Radius must be higher than 0");
        if(height <= 0)
            throw new IllegalArgumentException("Height must be higher than 0");

        double coneVolume =  (1.0/3.0) * Math.PI * radius * radius * height;

        return coneVolume;
    }
    public void useCalculator()
    {
        System.out.println("1. Base area of Cone");
        System.out.println("2. Base parimeter of Cone");
        System.out.println("3. Area of Cone");
        System.out.println("4. Volume of Cone");

        Scanner read = new Scanner(System.in);
        int choose = read.nextInt();
        switch(choose)
        {
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
