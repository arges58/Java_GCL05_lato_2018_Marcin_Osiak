package ui;

import basic.Calculator;
import basic.FibbonaciCalculator;
import fibonacci.CustomCalculator;
import fibonacci.IterativeFibonacciCalculator;
import fibonacci.RecurentFibonacciCalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("1. Custom calculator");
        System.out.println("2. Fibonacci calculator");

        Scanner type = new Scanner(System.in);
        int choose = type.nextInt();

        switch(choose) {
            case 1:
                CustomCalculator calculate = new CustomCalculator();
                calculate.useCalculator();
                break;
            case 2: {
                System.out.println("If you want to use IterativeFibonacciCalculator type true, if RecurentFibonacciCalulator, type false");
                boolean recurent;
                Scanner read = new Scanner(System.in);
                recurent = read.nextBoolean();
                FibbonaciCalculator fibonacci = (recurent ? new IterativeFibonacciCalculator() : new RecurentFibonacciCalculator());

                int n;
                System.out.println("Which Fibonnaci number want you to calculate?");
                Scanner read1 = new Scanner(System.in);
                n = read1.nextInt();
                int result;
                result = fibonacci.calculateFibonacciElement(n);

                System.out.println("Result: " + result);

                Calculator calculator = fibonacci;
                fibonacci.add(5, 7);
                break;
            }
            default:
                break;
        }
    }
}
