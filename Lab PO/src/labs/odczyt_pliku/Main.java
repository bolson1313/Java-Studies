package labs.odczyt_pliku;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TextFile TextFilee = new TextFile();
        TextFilee.ReadFile();
        TextFilee.SaveFile();
        TextFilee.ReadFile();
        TextFilee.SaveFileWrite();
        TextFilee.ReadFile();

        int number = 123123123;

    }
}