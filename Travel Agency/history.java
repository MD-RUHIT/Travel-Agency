import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class history extends JFrame implements ActionListener{

    private JPanel p1;
    private ImageIcon img,iconimg;
    private JLabel imglbl;
    private JButton procced,back,refresh;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private String name;
    private ImageIcon imgback;
   // private String tname,tcost,tper,tfrom,tto;
    
    private String[] clmn = {"Name","From","To","No. of Person","Total Cost"};
    private String[] row = new String[7];

    history(){
        super("TravelBro | History");
        this.setSize(1012,700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font f = new Font("Poppins", Font.BOLD, 25);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setSize(new Dimension(1000,700));

        imgback = new ImageIcon("Images/back1.png");
        

        back = new JButton(imgback);
        back.setBounds(80,70,64,64);
        back.setFocusable(false);
        back.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);
        p1.add(back);

        refresh = new JButton();
        refresh.setBounds(800,95,120,130);
        refresh.setFocusable(false);
        refresh.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        refresh.setFocusPainted(false);
        refresh.setContentAreaFilled(false);
        refresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        refresh.addActionListener(this);
        p1.add(refresh);
        
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(clmn);
        table.setModel(model);
        table.setBackground(Color.WHITE);
        table.setSelectionBackground(Color.GRAY);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setDefaultEditor(Object.class,null);
        table.setCellSelectionEnabled(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        table.getColumnModel().getColumn(4).setPreferredWidth(160);
        
        scroll = new JScrollPane(table);
        scroll.setBounds(106,260,785,277);
        scroll.setBackground(Color.WHITE);
        p1.add(scroll);

        
        try {
            FileReader file = new FileReader("Datas/Current_User_Data.txt");
            BufferedReader reader = new BufferedReader(file);
            name = Files.readAllLines(Paths.get("Datas/Current_User_Data.txt")).get(0);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        try {                 
                    FileReader file = new FileReader("Datas/Customized_Package_User.txt");
                    BufferedReader reader = new BufferedReader(file);

                        int LineCount = 0;
                        while(reader.readLine()!=null){
                            LineCount ++;
                        }
                        reader.close();
                        
                        int i = 0;

                        //for(int j=0; j<=LineCount/7; j++){ // na korle to 1 bar e kaj korbe only!..cz of the break.

                            for(int q=i; q<=(LineCount-5);q++){
                    String nm = Files.readAllLines(Paths.get("Datas/Customized_Package_User.txt")).get(q);

                    if(name.equals(nm)){
                        row[0] = Files.readAllLines(Paths.get("Datas/Customized_Package_User.txt")).get(q);
                        row[1] = Files.readAllLines(Paths.get("Datas/Customized_Package_User.txt")).get(q + 4).substring(5);
                        row[2] = Files.readAllLines(Paths.get("Datas/Customized_Package_User.txt")).get(q+5).substring(4);
                        row[3] = Files.readAllLines(Paths.get("Datas/Customized_Package_User.txt")).get(q+3).substring(9);
                        row[4] = Files.readAllLines(Paths.get("Datas/Customized_Package_User.txt")).get(q+2).substring(12);
                        model.addRow(row);
                        i+=6;// 7 dilei out of bound
                              
                    }
                    
                }
            //}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e,"TravelBro",2);
            
        }
        



        img = new ImageIcon("Images/history.png");
        imglbl = new JLabel(img);
        imglbl.setBounds(0,0,1000,700);

        iconimg = new ImageIcon("Images/Icon.png");
        this.setIconImage(iconimg.getImage());

        p1.add(imglbl);
        add(p1);
        this.setVisible(true);

    }
    public static void main(String[] args) {
        new history();
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            this.dispose();
            
        }else if(ae.getSource()==refresh){
            this.dispose();
            new history();
        }
    }
}
    