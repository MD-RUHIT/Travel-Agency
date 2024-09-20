import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Home extends JFrame implements ActionListener{
    
    JPanel p1;
    ImageIcon img1,backImg ;
    JLabel  imglbl;
    JButton flightbtn,customize,packages,back,exit;
    

    Home(){
        
        super("TravelBro");
        this.setSize(1000,700);
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Font f = new Font("Rockwell", Font.BOLD, 20);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setSize(new Dimension(1000,700));


        flightbtn = new JButton("Flight");
        flightbtn.setBounds(222,350,100,30);
        flightbtn.addActionListener(this);
        flightbtn.setFont(f);
        flightbtn.setContentAreaFilled(false);
        flightbtn.setFocusable(false);
        flightbtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        flightbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p1.add(flightbtn);


        packages = new JButton("Packages");
        packages.setBounds(451,350,130,30);
        packages.addActionListener(this);
        packages.setFont(f);
        packages.setContentAreaFilled(false);
        packages.setFocusable(false);
        packages.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        packages.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p1.add(packages);

        customize = new JButton("Customize");
        customize.setBounds(673,350,130,30);
        customize.addActionListener(this);
        customize.setFont(f);
        customize.setContentAreaFilled(false);
        customize.setFocusable(false);
        customize.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        customize.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p1.add(customize);


        backImg = new ImageIcon("Images/back.png");
        back = new JButton(backImg);
        back.setBounds(0,500,100,100);
        back.addActionListener(this);
        back.setFont(f);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setContentAreaFilled(false);
        back.setFocusable(false);
        p1.add(back);

        ImageIcon exitimg = new ImageIcon("Images/exit.png");
        exit = new JButton(exitimg);
        exit.setBounds(870,10,100,100);
        exit.addActionListener(this);
        exit.setContentAreaFilled(false);
        exit.setFocusable(false);
        exit.setBorderPainted(false);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p1.add(exit);


        img1 = new ImageIcon("Images/HomeBack.png");
        imglbl = new JLabel(img1);
        imglbl.setBounds(0,0,1000,700);
        p1.add(imglbl);

        this.add(p1);
        this.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == flightbtn){
            System.out.println("Flight Button Clicked");
        }
        else if(ae.getSource() == packages){
            new travelPacks();
        }
        else if(ae.getSource() == customize){
            JOptionPane.showMessageDialog(null,"We only offer package customization for departures from Dhaka.","Note", 0);
            int x = JOptionPane.showConfirmDialog(null,"Want to procceed?","Travel Bro",JOptionPane.OK_CANCEL_OPTION);
            if(x == JOptionPane.OK_OPTION){
                this.dispose();
                new customize();
            }
        }
        else if(ae.getSource() == back){
            this.dispose();
            new Login();
        }else if(ae.getSource()==exit){
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
