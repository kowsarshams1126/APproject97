import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame=new JFrame("Somayyeh");
        jFrame.setSize(1000 , 1000);

        WestPanel westPanel = new WestPanel();
        EastPanel eastPanel = new EastPanel();
        North North = new North();
        jFrame.add(westPanel , BorderLayout.WEST);
        jFrame.add(eastPanel , BorderLayout.EAST);
        jFrame.add(North, BorderLayout.NORTH);
        jFrame.setVisible(true);
    }
}
