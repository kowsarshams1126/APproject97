//import javax.swing.*;
//import java.awt.*;
//
//
//public class Graphic extends JFrame{
//    JFrame frame = new JFrame();
//
//
//
//    public Graphic(){
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(1000 , 1000);
//        frame.setLayout(new BorderLayout());
//
//
///*        JLabel label1 = new JLabel("Hi");
////        JPanel panel = new JPanel();
//        panel.setSize(110 , 900);
//        panel.setLayout(new BorderLayout());
//
//        JPanel panel1 = new JPanel();
//        panel1.add(label1);
//        panel.add(panel1 , BorderLayout.WEST);*/
//
//
////        JLabel label2 = new JLabel("Hi2");
////        JPanel panel2 = new JPanel();
////        panel2.add(label2);
//
//
//
//        JScrollPane scrollPane = new JScrollPane(panel);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//        scrollPane.setBounds(10, 10, 10, 10);
//        JPanel contentPane = new JPanel(null);
//        contentPane.setPreferredSize(new Dimension(10, 10));
//        contentPane.add(scrollPane);
//        scrollPane.setVisible(true);
//
//
//        frame.getContentPane().add(panel , BorderLayout.WEST);
//        frame.pack();
//
//
//
//        frame.setVisible(true);
//        frame.getContentPane().setLayout(new BorderLayout());
//
//
//        JPanel panel = new JPanel();
//
//        panel.setSize(110 , 900);
//        panel.setLayout(new BorderLayout());
//
//
//
//        for (int i = 0; i < 10; i++) {
//            panel.add(new JButton("Hello-" + i ) , BorderLayout.CENTER);
//        }
//        JScrollPane scrollPane = new JScrollPane(panel);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//        scrollPane.setBounds(50, 50, 50, 50);
//        JPanel contentPane = new JPanel(null);
//        contentPane.setPreferredSize(new Dimension(1000, 1000));
//        contentPane.add(scrollPane);
//        frame.setContentPane(contentPane);
//        frame.pack();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel panel1 = new JPanel();
//        panel1.setSize(100 , 900);
//        JLabel label1 = new JLabel("Hello");
//        panel1.add(label1);
//        frame.add(panel1 , BorderLayout.EAST);
//
//        JPanel panel2 = new JPanel();
//        panel2.setSize(790 , 900);
//        JLabel label2 = new JLabel("Hello2");
//        panel2.add(label2);
//        frame.add(panel2 , BorderLayout.CENTER);
//
//        JPanel panel3 = new JPanel();
//        panel3.setSize(1000 , 100);
//        JLabel label3 = new JLabel("Hello3");
//        panel3.add(label3);
//        frame.add(panel3 , BorderLayout.SOUTH);
//
//        frame.setVisible(true);*/
//
//
//        JPanel mainPanel = new JPanel(new GridLayout(2,1));
//
//        JLabel jLabel = new JLabel();
//        JPanel jPanelNorth = new JPanel();
//        JScrollPane scrollPane = new JScrollPane();
//
//        JLabel jLabel2 = new JLabel();
//        JPanel jPanelSouth = new JPanel();
//        JScrollPane scrollPane2 = new JScrollPane();
//
//public Graphic() {
//
//            frame.setSize(1000 , 1000);
//
//            jLabel.setIcon(new ImageIcon("an image here"));
//            jPanelNorth.add(jLabel);
//
//            jLabel2.setIcon(new ImageIcon("an image here"));
//            jPanelSouth.add(jLabel2);
//
//
//            //2.you should place .setViewportView() here :
//            scrollPane.setViewportView(jPanelNorth);
//            scrollPane2.setViewportView(jPanelSouth);
//
//
//            mainPanel.add(scrollPane);//is in the top ("North")
//            mainPanel.add(scrollPane2);//next ("South")
//
//            //3.use setContentPane instead of add()
////            setContentPane(mainPanel);
//
//            frame.setContentPane(mainPanel);
//            frame.setVisible(true);
//        }
//}