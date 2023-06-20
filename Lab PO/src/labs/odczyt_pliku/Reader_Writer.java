package labs.odczyt_pliku;

import java.io.*;

public class Reader_Writer {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("text.txt"));
        writer.write("stacjonarny;3;16;3000;2750");
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader("text.txt"));

        reader.close();

    }
}
