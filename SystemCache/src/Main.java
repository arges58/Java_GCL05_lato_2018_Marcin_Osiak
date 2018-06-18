import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String [] args) throws IOException {
        ScatterSystem system = new ScatterSystem();
        ExtendedSystemCache cache = new ExtendedSystemCache();

        String choice;
        boolean stop = false;

       try {
            cache.importCSV("C:\\Users\\Admin\\Desktop\\hest.csv");
        }
        catch(IOException e)
        {
            System.out.println(e);
        }

       while(!stop)
        {
            System.out.println("1. Add random values");
            System.out.println("2. Enter the values manually and add them");
            System.out.println("3. Exit");

            Scanner userChoice = new Scanner(System.in);
            choice = userChoice.nextLine();
            Double output;
            double [] values = new double[5];

            switch(choice){
                case "1":

                    Random generator = new Random();
                    for(int i=0; i<5; i++)
                    {
                        values[i] = generator.nextDouble() * 10;
                        System.out.println("Value "+ (i+1)+ ": " + values[i]);
                    }
                    output = cache.get(values);
                    if(output == null)
                    {
                        System.out.println("There is no output saved for those values. System needs to calculate reslut");
                        output = system.sumElements(values);
                        cache.put(values, output);
                    }
                    else
                        System.out.println("There is saved result for such values: " + output);
                    break;
                case "2":
                    Scanner usersValues = new Scanner(System.in);
                    for(int i = 0; i<5; i++)
                    {
                       System.out.println("Enter value no. "+ (i+1));
                       values[i] = usersValues.nextDouble();
                    }
                    output = cache.get(values);
                    if(output == null)
                    {
                        System.out.println("There is no output saved for those values. System needs to calculate reslut");
                        output = system.sumElements(values);
                        cache.put(values, output);
                        System.out.println(output);
                    }
                    else
                        System.out.println("There is saved result for such values: " + output);
                    break;
                case "3":
                    stop = true;
                    break;
                default:
                    break;
            }
        }
        try {
            cache.exportCSV("C:\\Users\\Admin\\Desktop\\hest.csv");
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        cache.showMap();
        try {
            cache.serialize("C:\\Users\\Admin\\Desktop\\serial.ser");
            cache.deserialize("C:\\Users\\Admin\\Desktop\\serial.ser");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
