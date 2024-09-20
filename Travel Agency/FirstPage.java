import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstPage extends JFrame implements ActionListener{

private ImageIcon img,iconimg;
private JLabel imglbl;
private JButton loginbtn,registerbtn,exitbtn,adminloginbtn;
private JPanel p1;



    FirstPage(){
        
        super("TravelBro");
        this.setSize(720,430);
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font f = new Font("Poppins", Font.BOLD, 24);

        

        p1 =new JPanel();
        p1.setLayout(null);
        p1.setSize(new Dimension(720,420));

        loginbtn = new JButton("Login");
        loginbtn.setBounds(410,180,100,30);
        loginbtn.setFont(f);
        loginbtn.setFocusable(false);
        loginbtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        loginbtn.setFocusPainted(false);
        loginbtn.setContentAreaFilled(false);
        loginbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginbtn.addActionListener(this);
        p1.add(loginbtn);


        registerbtn = new JButton("Register");
        registerbtn.setBounds(542,180,100,30);
        registerbtn.setFont(f);
        registerbtn.setFocusable(false);
        registerbtn.setContentAreaFilled(false);
        registerbtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        registerbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerbtn.addActionListener(this);
        p1.add(registerbtn);


        adminloginbtn = new JButton("Admin");
        adminloginbtn.setBounds(542,246,100,30);
        adminloginbtn.setFont(f);
        adminloginbtn.setFocusable(false);
        adminloginbtn.setContentAreaFilled(false);
        adminloginbtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        adminloginbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminloginbtn.addActionListener(this);
        p1.add(adminloginbtn);


        exitbtn = new JButton("Exit");
        exitbtn.setBounds(410,246,100,30);
        exitbtn.setFont(f);
        exitbtn.setBackground(Color.RED);
        exitbtn.setFocusable(false);
        exitbtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        exitbtn.setContentAreaFilled(false);
        exitbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitbtn.addActionListener(this);
        p1.add(exitbtn);



        img = new ImageIcon("Images/Page_1.png");
        imglbl = new JLabel(img);
        imglbl.setBounds(0,0,720,400);

        iconimg = new ImageIcon("Images/Icon.png");
        this.setIconImage(iconimg.getImage());


        p1.add(imglbl);
        add(p1);
        this.setLocationRelativeTo(null); //eta dia monitor er majhkhane ashe.
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==loginbtn){
            this.dispose();
           new Login();

        }else if(e.getSource()==adminloginbtn){
            this.dispose();
            new adminLogin();
        }else if(e.getSource()==registerbtn){
            this.dispose();
            new Register();
        }else{

            System.exit(0);
        }
    }

    

}
