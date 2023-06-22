package Additional;

import javax.swing.*;
import java.awt.*;

public class Window {
    private static String WindowTitle = "abrakadabra";
    private final JFrame frame = new JFrame();

    //wyswietlenie okna o podanych wymiarach
    public void OpenWindow(){
        frame.setTitle(WindowTitle);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //ustawienie zdjecia jako ikone
        ImageIcon image = new ImageIcon("C:\\Users\\boolson\\Desktop\\comment_1610559700Uv6NSI2SLidmOxoTM2TbLi.jpg");
        frame.setIconImage(image.getImage());
        frame.add(MyLabels("Witaj w panelu logowania!"));
    }

    public String HideWinwow(boolean change){
        frame.setVisible(!change);
        return "Window is hidden";
    }

    public JLabel MyLabels(String message){
        JLabel label = new JLabel();
        label.setVisible(true);
        label.setText(message);
        ImageIcon image = new ImageIcon("C:\\Users\\boolson\\Desktop\\comment_1610559700Uv6NSI2SLidmOxoTM2TbLi.jpg");
        label.setIcon(image);
        return label;
    }
}
