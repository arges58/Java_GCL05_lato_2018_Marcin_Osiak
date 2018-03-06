import java.util.Scanner;

public class Main {
    public static void main(String [] args)
    {
        System.out.println("Type 1 for Cone, type 2 for Tetrahedron");
        Scanner read1 = new Scanner(System.in);
        byte bool = read1.nextByte();
        boolean decide = (bool != 2);

        ExtendedCalculator extendedCalculator = (decide ? new ExtendedConeCalculatror() : new ExtendedTerahedronCalculator());

        extendedCalculator.useCalculator();
    }
    
}
