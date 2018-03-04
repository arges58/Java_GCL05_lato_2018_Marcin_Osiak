package fibonacci;

import basic.Calculator;

import java.util.Scanner;

public class CustomCalculator implements Calculator {
    @Override
    public double add(double a, double b)
    {
        return a+b;
    }
    @Override
    public double substract(double a, double b)
    {
        return a-b;
    }
    @Override
    public double multiply(double a, double b)
    {
        return a*b;
    }
    @Override
    public double divide(double a, double b)
    {
        return a/b;
    }
    @Override
    public double power(double x, double n)
    {
        return Math.pow(x,n);
    }
    public void useCalculator()
    {
        int x,y;
        int choice;

        Scanner read1 = new Scanner(System.in);
        Scanner read2 = new Scanner(System.in);

        Scanner read = new Scanner(System.in);

        boolean stop = true;
        while (stop) {
            System.out.println("1. Dodawanie");
            System.out.println("2. Odejmowanie");
            System.out.println("3. Mnozenie");
            System.out.println("4. Dzielenie");
            System.out.println("5. Potegowanie");
            System.out.println("6. Wyjdz");
            choice = read.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Podaj dwie liczby: ");
                    x = read1.nextInt();
                    y = read2.nextInt();
                    System.out.println(add(x, y));
                    break;
                case 2:
                    System.out.println("Podaj dwie liczby: ");
                    x = read1.nextInt();
                    y = read2.nextInt();
                    System.out.println(substract(x, y));
                    break;
                case 3:
                    System.out.println("Podaj dwie liczby: ");
                    x = read1.nextInt();
                    y = read2.nextInt();
                    System.out.println(multiply(x, y));
                    break;
                case 4:
                    System.out.println("Podaj dwie liczby: ");
                    x = read1.nextInt();
                    y = read2.nextInt();
                    System.out.println(divide(x, y));
                    break;
                case 5:
                    System.out.println("Podaj dwie liczby: ");
                    x = read1.nextInt();
                    y = read2.nextInt();
                    System.out.println(power(x, y));
                    break;
                case 6:
                    stop = false;
                    break;

                default:
                    break;

            }
        }
    }
}
