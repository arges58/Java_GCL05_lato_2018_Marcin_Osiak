public class ScatterSystem {
    Double sumElements(double [] input)
    {
        double sum = 0;
        for(int i=0; i<input.length; i++)
        {
            sum += input[i];
        }
        return sum;
    }
}
