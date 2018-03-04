package fibonacci;

import basic.FibbonaciCalculator;

public class IterativeFibonacciCalculator implements FibbonaciCalculator {

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
    public int calculateFibonacciElement(int n)
    {
        if(n <= 0)
        {
            throw new IllegalArgumentException("Number mustn't be less than 1: " + n);
        }
        int sumFib = 1;
        int prevFib = 1;
        for(int i=2; i<n; i++)
        {
            int temp = sumFib;
            sumFib = sumFib + prevFib;
            prevFib = temp;

        }
        return sumFib;
    }
}
