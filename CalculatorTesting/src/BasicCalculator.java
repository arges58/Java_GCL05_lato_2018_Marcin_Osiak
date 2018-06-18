
public class BasicCalculator {

    public double calculateSum(double a, double b)
    {
        return a+b;
    }
    public double calculateDifference(double a, double b)
    {
        return a-b;
    }
    public double calculateMultiplication(double a, double b)
    {
        return a*b;
    }
    public double calculateDivision(double a, double b) throws IllegalArgumentException
    {
        if(b == 0)
        {
            throw new java.lang.IllegalArgumentException("You can't divide by 0");
        }
        return a/b;
    }
    public double calculatePow(double a)
    {
        return Math.pow(a,2);
    }
    public double calculateSqr(double a) throws IllegalArgumentException
    {
        if(a < 0)
        {
            throw new java.lang.IllegalArgumentException("Number should be higher or equal to zero");
        }
        return Math.sqrt(a);
    }
}
