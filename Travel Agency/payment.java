import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.*;


public class payment extends JFrame implements ActionListener{
   
    JPanel p1;
    JLabel imglbl;
    JTextField tfname,tlname,tphn,temail,tcardnum,texpd,tnameOnCard,tcvv;
JButton paybtn,resetbtn,backbtn,exitbtn;


    payment(){
        super("TravelBro");
        this.setSize(1000,740);
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        ImageIcon img = new ImageIcon("Images/paymentBack.png");
        ImageIcon homeimg = new ImageIcon("Images/home.png");
        ImageIcon exitimg = new ImageIcon("Images/exit.png");

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setSize(new Dimension(1000,700));

        tfname = new JTextField();
        tfname.setBounds(230,283,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        tfname.setOpaque(false);
        tfname.setBackground(new Color(0, 0, 0, 0));
        tfname.addActionListener(this);
        p1.add(tfname);

        tlname = new JTextField();
        tlname.setBounds(580,283,180,25);
        tlname.setBorder(BorderFactory.createEmptyBorder());
        tlname.setOpaque(false);
        tlname.setBackground(new Color(0, 0, 0, 0));
        tlname.addActionListener(this);
        p1.add(tlname);

        tphn = new JTextField();
        tphn.setBounds(230,346,180,25);
        tphn.setBorder(BorderFactory.createEmptyBorder());
        tphn.setOpaque(false);
        tphn.setBackground(new Color(0, 0, 0, 0));
        tphn.addActionListener(this);
        p1.add(tphn);

        temail = new JTextField();
        temail.setBounds(580,348,180,25);
        temail.setBorder(BorderFactory.createEmptyBorder());
        temail.setOpaque(false);
        temail.setBackground(new Color(0, 0, 0, 0));
        temail.addActionListener(this);
        p1.add(temail);


        tcardnum = new JTextField();
        tcardnum.setBounds(230,453,180,25);
        tcardnum.setBorder(BorderFactory.createEmptyBorder());
        tcardnum.setOpaque(false);
        tcardnum.setBackground(new Color(0, 0, 0, 0));
        tcardnum.addActionListener(this);
        p1.add(tcardnum);

        tnameOnCard = new JTextField();
        tnameOnCard.setBounds(230,518,180,25);
        tnameOnCard.setBorder(BorderFactory.createEmptyBorder());
        tnameOnCard.setOpaque(false);
        tnameOnCard.setBackground(new Color(0, 0, 0, 0));
        tnameOnCard.addActionListener(this);
        p1.add(tnameOnCard);

        texpd = new JTextField();
        texpd.setBounds(580,454,180,25);
        texpd.setBorder(BorderFactory.createEmptyBorder());
        texpd.setOpaque(false);
        texpd.setBackground(new Color(0, 0, 0, 0));
        texpd.addActionListener(this);
        p1.add(texpd);

        tcvv = new JTextField();
        tcvv.setBounds(580,519,180,25);
        tcvv.setBorder(BorderFactory.createEmptyBorder());
        tcvv.setOpaque(false);
        tcvv.setBackground(new Color(0, 0, 0, 0));
        tcvv.addActionListener(this);
        p1.add(tcvv);


        backbtn = new JButton(homeimg);
        backbtn.setBounds(70,50,100,100);
        backbtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        backbtn.setFocusPainted(false);
        backbtn.setContentAreaFilled(false);
        backbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backbtn.addActionListener(this);
        p1.add(backbtn);

        exitbtn = new JButton(exitimg);
        exitbtn.setBounds(850,20,100,100);
        exitbtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        exitbtn.setFocusPainted(false);
        exitbtn.setContentAreaFilled(false);
        exitbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitbtn.addActionListener(this);
        p1.add(exitbtn);

        resetbtn = new JButton("Reset");
        resetbtn.setBounds(550,580,100,30);
        resetbtn.setFocusable(false);
        resetbtn.addActionListener(this);
        p1.add(resetbtn);

        paybtn = new JButton("Pay");
        paybtn.setBounds(700,580,100,30);
        paybtn.setFocusable(false);
        paybtn.addActionListener(this);
        p1.add(paybtn);

        

        imglbl = new JLabel(img);
        imglbl.setBounds(0,0,1000,700);
        p1.add(imglbl);

        this.add(p1);
        this.setVisible(true);

    }
    public static void main(String[] args) {
        new payment();
    }
   
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == backbtn){
            this.dispose();
            new Home();

        }else if(ae.getSource()==resetbtn){

            tfname.setText("");
            tlname.setText("");
            tphn.setText("");
            temail.setText("");
            tcardnum.setText("");
            texpd.setText("");
            tnameOnCard.setText("");
            tcvv.setText("");
        }else if(ae.getSource() == paybtn){
           String phone = tphn.getText();
           String cardnum = tcardnum.getText();
           String cvv = tcvv.getText();
           

           if(phone.length() == 11 && cardnum.length() == 16 && cvv.length() == 3){
            JOptionPane.showMessageDialog(null,"Payment Successful","Travel Bro | Payment",1);
            int x = JOptionPane.showConfirmDialog(null,"Want to go back to home page?","Travel Bro | Payment",JOptionPane.OK_CANCEL_OPTION);

            if(x == JOptionPane.OK_OPTION){
                this.dispose();
                new Home();
            }else{
                System.exit(0);
            }


           }else{
            JOptionPane.showMessageDialog(null,"Please Fill all the credentials properly","Travel Bro | Payment",1);
           }
        }else if(ae.getSource()==exitbtn){
            try {
                
                Path path = Paths.get("Datas/Current_User_Data.txt");
                var lines = Files.readAllLines(path);
                lines.removeIf(line->line.contains(""));
                Files.write(path,lines);
    
            } catch (IOException e) {
                System.out.println(e);
            }
            System.exit(0);
        }
        }
}

