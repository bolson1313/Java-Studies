package odczyt_pliku;

import java.io.*;
import java.util.Scanner;

public class TextFile {

    public void ReadFile() throws IOException{
        File file = new File("D:/kblab01/src/odczyt_pliku/text.txt");
        Scanner in = new Scanner(file);

        String text = in.nextLine();
        System.out.println(text);
    }
    public void SaveFile() throws IOException{
        PrintWriter zapis = new PrintWriter("D:/kblab01/src/odczyt_pliku/text.txt");
        zapis.println("ala ma kota");
        zapis.close();
    }

    public void SaveFileWrite() throws IOException{
        String filePath = "D:/kblab01/src/odczyt_pliku/text.txt";
        int numer = 123;
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(filePath);
            fileWriter.write(Integer.toString(numer));
        }finally {
            if ((filePath != null))
                fileWriter.close();
        }
    }

    public int ReadBufor() throws IOException{
        String filePath = "D:/kblab01/src/odczyt_pliku/text.txt";
        int number = 0;
        BufferedReader fileReader = null;
        try{
            fileReader = new BufferedReader(new FileReader(filePath));
            String numberAsString = fileReader.readLine();
            number = Integer.parseInt(numberAsString);
        }finally {
            if((filePath != null))
                fileReader.close();
        }
        return number;
    }
}
