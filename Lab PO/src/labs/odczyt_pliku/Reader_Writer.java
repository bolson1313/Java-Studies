package labs.odczyt_pliku;

import java.io.*;

public class Reader_Writer {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("text.txt"));
        writer.write("123123123123");
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader("text.txt"));
        System.out.println(reader.readLine());
        reader.close();

    }
}
