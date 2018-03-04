package fibonacci;

import basic.FibbonaciCalculator;

public class RecurentFibonacciCalculator implements FibbonaciCalculator {

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
        if(n==1 || n==0)
            return n;
        if(n < 0)
        {
           throw new IllegalArgumentException("Number mustn't be less than 1: " + n);
        }

    return calculateFibonacciElement(n-1) + calculateFibonacciElement(n-2);
    }
}
