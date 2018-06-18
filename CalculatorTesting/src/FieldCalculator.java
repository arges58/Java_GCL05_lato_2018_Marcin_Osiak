public class FieldCalculator {

    public double calculateSquare(double a) throws IllegalArgumentException
    {
        if(a <= 0) {
            throw new java.lang.IllegalArgumentException("Length of a side should be higher than zero");
        }
        return a*a;
    }
    public double calculateCircle(double radius) throws IllegalArgumentException
    {
        if(radius <= 0) {
            throw new java.lang.IllegalArgumentException("Length of a radius should be higher than zero");
        }
        return Math.PI * 2 * radius;
    }
    public double calculateTriangle(double a, double h) throws IllegalArgumentException
    {
        if(a <= 0) {
            throw new java.lang.IllegalArgumentException("Length of a side should be higher than zero");
        }
        if(h <= 0) {
            throw new java.lang.IllegalArgumentException("Length of a height should be higher than zero");
        }
        return (a*h)/2;
    }
    public double calculateRectangle(double a, double b) throws IllegalArgumentException
    {
        if(a <= 0) {
            throw new java.lang.IllegalArgumentException("Length of a side should be higher than zero");
        }
        if(b <= 0) {
            throw new java.lang.IllegalArgumentException("Length of a side should be higher than zero");
        }
        return a * b;
    }
}
