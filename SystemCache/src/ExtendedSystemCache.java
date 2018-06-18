import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Scanner;

public class ExtendedSystemCache extends SystemCache implements Serializable {


    public void exportCSV(String path) throws IOException
    {
        FileWriter writer;
        writer = new FileWriter(path, false);
        exportCSV(writer);
    }
    public void exportCSV(FileWriter writer) throws IOException
    {
        for (Parameter name: cache.keySet()){
            double tmp;
            for(int i =0 ;i<name.values.length; i++)
            {
                tmp = name.values[i];
                String xd = String.valueOf(tmp);
                writer.write(xd.toString());
                if(i != name.values.length - 1)
                    writer.write(";");
            }
            writer.write(",");
            String value = cache.get(name).toString();
            writer.write(value.toString());
            writer.write("\r\n");
        }
        writer.close();
    }
    public void exportCSV(Writer writer) throws IOException
    {
        for (Parameter name: cache.keySet()){
            double tmp;
            for(int i =0 ;i<name.values.length; i++)
            {
                tmp = name.values[i];
                String xd = String.valueOf(tmp);
                writer.write(xd.toString());
                if(i != name.values.length - 1)
                    writer.write(";");
            }
            writer.write(",");
            String value = cache.get(name).toString();
            writer.write(value.toString());
            writer.write("\r\n");
        }
        writer.close();
    }
    public void exportCSV(File file) throws IOException
    {
        FileWriter writer;
        writer = new FileWriter(file, false);
        exportCSV(writer);
    }
    public void exportCSV(OutputStream stream) throws IOException
    {
        Writer writer = new OutputStreamWriter(stream);
        exportCSV(writer);
    }
    public void importCSV(String path) throws IOException
    {
        Scanner scanner = new Scanner(new File(path));
        importCSV(scanner);
    }
    public void importCSV(File file) throws IOException
    {
        Scanner scanner = new Scanner(file);
        importCSV(scanner);
    }
    public void importCSV(InputStream stream) throws IOException
    {
        Scanner scanner = new Scanner(stream);
        importCSV(scanner);

    }
    public void importCSV(Scanner scanner) throws IOException
    {
        int i = 0;
        String [] tmp = new String[1000];
        scanner.useDelimiter("\n");
        while(scanner.hasNext()){
            tmp[i] = scanner.next();
            System.out.println(tmp[i]);
            i++;
        }


        for(int j=0; j<i; j++)
        {
            String [] tmp2 = tmp[j].split(",");
            String [] tmp3 = tmp2[0].split(";");
            double [] valuesToHashmap = new double[5];
            for(int k=0; k<5; k++)
            {
                valuesToHashmap[k] = Double.parseDouble(tmp3[k]);
                //System.out.println(valuesToHashmap[k]);
            }
            if (get(valuesToHashmap) == null)
                put(valuesToHashmap, Double.parseDouble(tmp2[1]));

        }
        scanner.close();

    }
    public void serialize(String path) throws IOException
    {
        FileOutputStream fileOut = new FileOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        serialize(out);
        fileOut.close();
    }
    public void serialize(File file) throws IOException
    {
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        serialize(out);
        fileOut.close();
    }
    public void serialize(OutputStream stream) throws IOException
    {
        serialize(stream);
    }
    public void serialize(ObjectOutputStream out) throws IOException
    {
        out.writeObject(this);
        out.close();

    }
    public void deserialize(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        deserialize(in);
        fileIn.close();
    }

    public void deserialize(File file) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        deserialize(in);
        fileIn.close();
    }

    public void deserialize(InputStream stream) throws IOException, ClassNotFoundException
    {
        deserialize(stream);
    }
    public void deserialize(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ExtendedSystemCache e = new ExtendedSystemCache();
        e = (ExtendedSystemCache)in.readObject();
        in.close();
    }

}
