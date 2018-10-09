import javaapplication6.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Андрюха on 09.10.2018.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int P = 11;
        int A = 5;

        int min = 2;

        int x1 = 0;
        int x2 = 0;

        Random random = new Random(System.currentTimeMillis());
        Random random1 = new Random(System.currentTimeMillis());

        try
        {
            FileInputStream fstream = new FileInputStream("Число P.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));
            List<String> strList = new ArrayList<>();
            String strLine;

            while((strLine = reader.readLine()) != null)
            {
                strList.add(strLine);
            }
            int num = random.nextInt(strList.size());
            P = Integer.parseInt(strList.get(num));

            A = min + random.nextInt(P - 1 - min + 1);

            x1 = (int)((min + random1.nextInt(P - min - 1))/3);
            x2 = (int)((min + random1.nextInt(P - min - 1))/3);
        }
        catch (IOException e)
        {
            System.err.println("Ошибка");
        }

        try (FileWriter writer = new FileWriter("log.txt", false))
        {
            writer.write("X1 = " + x1 + "; X2 = " + x2 + ";\n");
            writer.write("A = " + A + "; \n");
            writer.write("P =" + P + ".");

            User Bob = new User(P, A, x1, "Bob");
            User Alise = new User(P, A, x2, "Alise");

            writer.write(Bob.countY());
            writer.write(Bob.sendToUser(Bob, Alise, Bob.Y));

            writer.write(Alise.countY());
            writer.write(Alise.sendToUser(Alise, Bob, Alise.Y));

            writer.write(Bob.closedKey());
            writer.write(Alise.closedKey());

        }
    }

}