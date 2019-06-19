import javax.swing.*;
import java.awt.*;

public class WestPanel extends JScrollPane {
    private JPanel mainPanel=new JPanel();

    public WestPanel(){
        mainPanel.setSize(100 , 800);
        GridBagLayout ly=new GridBagLayout();
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill = GridBagConstraints.VERTICAL;
        mainPanel.setLayout(ly);
        setViewportView(mainPanel);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        gbc.gridx = 0;
        gbc.gridy = 0;
        JButton addMusic = new JButton("addMusic");
        mainPanel.add(addMusic , gbc);


        JPanel Library=new JPanel();
        JButton jButton=new JButton("+");
        Library.add(jButton,BorderLayout.EAST);
        JTextField jTextField=new JTextField("Library");
        Library.add(jTextField,BorderLayout.WEST);

        gbc.gridx=0;
        gbc.gridy=1;
        mainPanel.add(Library,gbc);
        JButton PlayList=new JButton("PlayList");
        gbc.gridx=0;
        gbc.gridy=2;
        mainPanel.add(PlayList,gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 0;       //reset to default
        gbc.weighty = 1.0;   //request any extra vertical space
        gbc.anchor = GridBagConstraints.PAGE_END; //bottom of space
        gbc.insets = new Insets(10,0,0,0);  //top padding
        gbc.gridx = 0;       //aligned with button 2
        gbc.gridwidth = 2;   //2 columns wide
        gbc.gridy = 3;
        JButton newPlayList = new JButton("newPlayList");
        mainPanel.add(newPlayList , gbc);





    }
}
