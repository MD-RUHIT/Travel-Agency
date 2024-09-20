import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class bandarban extends JFrame implements ActionListener{

    JPanel pan1;
    JButton btn1,btn2,btn3;
    ImageIcon imgback,exitimg;
    JLabel background;
    JTextField tf1;
    JButton confbtn,backbtn,rstbtn,exit;
    int per;
    double total;
    String name,phone,mail;
    
    bandarban(){

        super("Travel Bro | Package");
        this.setSize(716,495);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);

        Font f1 = new Font("Oswald", Font.BOLD, 20);
        Font f2 = new Font("Oswald", Font.BOLD, 14);

        exitimg = new ImageIcon("Images/exit.png");

        pan1 = new JPanel();
        pan1.setLayout(null);
        pan1.setBounds(0,0,700,455);

        tf1 = new JTextField();
        tf1.setBounds(556,125,70,30);
        tf1.setBorder(BorderFactory.createEmptyBorder());
        tf1.setOpaque(false);
        tf1.setHorizontalAlignment(JTextField.CENTER);
        tf1.setFont(f1);
        tf1.setBackground(new Color(0, 0, 0, 0));
        pan1.add(tf1);

        confbtn = new JButton("Confirm");
        confbtn.setBounds(525,200,130,30);
        confbtn.setContentAreaFilled(false);
        confbtn.setFocusable(false);
        confbtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        confbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        confbtn.setFont(f1);
        confbtn.addActionListener(this);
        pan1.add(confbtn);

        backbtn = new JButton("Back");
        backbtn.setBounds(482,252,130,30);
        backbtn.setContentAreaFilled(false);
        backbtn.setFocusable(false);
        backbtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        backbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backbtn.setFont(f2);
        backbtn.addActionListener(this);
        pan1.add(backbtn);

        rstbtn = new JButton("Reset");
        rstbtn.setBounds(568,252,130,30);
        rstbtn.setContentAreaFilled(false);
        rstbtn.setFocusable(false);
        rstbtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        rstbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rstbtn.setFont(f2);
        rstbtn.addActionListener(this);
        pan1.add(rstbtn);

        exit = new JButton(exitimg);
        exit.setBounds(540,252,100,100);
        exit.setContentAreaFilled(false);
        exit.setFocusable(false);
        exit.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.addActionListener(this);
        pan1.add(exit);
        

        imgback = new ImageIcon("Images/Bandarban.png");
        
        background = new JLabel(imgback);
        background.setBounds(0,0,700,455);
        pan1.add(background);

        

        this.add(pan1);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new bandarban();
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confbtn){

            String person = tf1.getText();

            try{

            per = Integer.parseInt(person);
            if(per>5){
                JOptionPane.showMessageDialog(null,"You got 10% discount!!","TravelBro | Discounting",3);
                total = per * 3000;
                total = total - total*.1;
            }else{
                total = per * 3000;
            }
            
            

            }catch(Exception ex){
                System.out.println(ex);
            }

            try {

            name = Files.readAllLines(Paths.get("Datas/Current_User_Data.txt")).get(0);
            phone = Files.readAllLines(Paths.get("Datas/Current_User_Data.txt")).get(1);
            mail = Files.readAllLines(Paths.get("Datas/Current_User_Data.txt")).get(2);

            FileWriter file = new FileWriter("Datas/Premade_packages.txt",true);
            BufferedWriter bf = new BufferedWriter(file);
            PrintWriter prw = new PrintWriter(bf);

            prw.println("Package: 5");
            prw.println(name);
            prw.println(phone);
            prw.println(mail);
            prw.println("Number of Persons: "+per);
            prw.println("Total Cost: "+ total);
            prw.close();

            FileWriter file1 = new FileWriter("Datas/Premade_packages_temp.txt",true);
            BufferedWriter bf1 = new BufferedWriter(file1);
            PrintWriter prw1 = new PrintWriter(bf1);

            prw1.println("Package: 5");
            prw1.println(name);
            prw1.println(phone);
            prw1.println(mail);
            prw1.println("Number of Persons: "+per);
            prw1.println("Total Cost: "+ total);
            prw1.close();

            }catch (IOException ex) {
            System.out.println(ex);
            }

            new invoice();
            
        }else if(e.getSource() == backbtn){

            this.dispose();
            new travelPacks();

        }else if(e.getSource() == rstbtn){

            this.dispose();
            new bandarban();

        }else if(e.getSource() == exit){
            try {
                Path path = Paths.get("Datas/Current_User_Data.txt");
                var lines = Files.readAllLines(path);
                lines.removeIf(line->line.contains(""));
                Files.write(path,lines);
    
            } catch (IOException ex) {
                System.out.println(ex);
            }
            System.exit(0);
        }
        
        
        
    }
}
