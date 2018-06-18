import java.util.Arrays;
import java.util.HashMap;
public class SystemCache
{
    public HashMap<Parameter, Double> cache = new HashMap<>();
    public void put(double[] input, double output)
    {
        this.cache.put(new Parameter(input), output);
    }
    public Double get(double[] input)
    {
        return this.cache.get(new Parameter(input) );
    }
    public class Parameter
    {
        public double[] values;
        public Parameter(double[] values)
        {
            this.values = values;
        }
        @Override
        public int hashCode()
        {
            return 31 + Arrays.hashCode(this.values);
        }
        @Override
        public boolean equals( Object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (this.getClass() != obj.getClass() )
                return false;
            Parameter other = (Parameter) obj;
            if ( !Arrays.equals(this.values, other.values) )
                return false;

            return true;
        }
    }
    public void showMap()
    {
        for (Parameter name: cache.keySet()){

            String key =name.toString();
            String value = cache.get(name).toString();
            System.out.println(key + " " + value);
        }
    }
}

