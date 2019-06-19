import javax.swing.*;
import java.awt.*;

public class EastPanel extends JScrollPane {

    private JPanel mainPanel = new JPanel();

    public EastPanel() {
        mainPanel.setSize(100, 800);
        GridBagLayout ly = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        mainPanel.setLayout(ly);
        setViewportView(mainPanel);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }
}
