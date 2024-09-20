import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class travelPacks extends JFrame implements ActionListener{

    private JPanel pan1;
    private JLabel imagelbl,wlcmlbl;
    private ImageIcon img,backimg,exitimg;
    private JButton btn1,btn2,btn3,btn4,btn5,btn6,exitbtn,backbtn;
    private String name,phn,email;

    

    travelPacks(){

        super("TravelBro");
        this.setSize(1015,700);
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        img = new ImageIcon("Images/Package_1st.png");
        backimg = new ImageIcon("Images/back.png");
        exitimg = new ImageIcon("Images/exit.png");


        Font f1 = new Font("Calibri", Font.BOLD, 11);
        Font f2 = new Font("Calibri", Font.ITALIC, 16);

        pan1 = new JPanel();
        pan1.setLayout(null);
        pan1.setSize(new Dimension(1015,700));


        // try {

        //     name = Files.readAllLines(Paths.get("Datas/Current_User_Data.txt")).get(0);

        // } catch (IOException e) {

        //     System.out.println(e);
        // }
            


        wlcmlbl = new JLabel("Welcome  "+ "name");//replace the cotation
        wlcmlbl.setBounds(170,133,200,30);
        wlcmlbl.setFont(f2);
        pan1.add(wlcmlbl);


        btn1 = new JButton("Book Now!!");
        btn1.setFont(f1);
        btn1.setBounds(281,260,100,20);
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn1.setContentAreaFilled(false);
        btn1.setFocusable(false);
        btn1.setBorderPainted(false);
        btn1.addActionListener(this);
        pan1.add(btn1);


        btn2 = new JButton("Book Now!!");
        btn2.setFont(f1);
        btn2.setBounds(281,407,100,20);
        btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn2.setContentAreaFilled(false);
        btn2.setFocusable(false);
        btn2.setBorderPainted(false);
        btn2.addActionListener(this);
        pan1.add(btn2);

        btn3 = new JButton("Book Now!!");
        btn3.setFont(f1);
        btn3.setBounds(281,551,100,20);
        btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn3.setContentAreaFilled(false);
        btn3.setFocusable(false);
        btn3.setBorderPainted(false);
        btn3.addActionListener(this);
        pan1.add(btn3);

        btn4 = new JButton("Book Now!!");
        btn4.setFont(f1);
        btn4.setBounds(744,261,100,20);
        btn4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn4.setContentAreaFilled(false);
        btn4.setFocusable(false);
        btn4.setBorderPainted(false);
        btn4.addActionListener(this);
        pan1.add(btn4);

        btn5 = new JButton("Book Now!!");
        btn5.setFont(f1);
        btn5.setBounds(744,407,100,20);
        btn5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn5.setContentAreaFilled(false);
        btn5.setFocusable(false);
        btn5.setBorderPainted(false);
        btn5.addActionListener(this);
        pan1.add(btn5);

        btn6 = new JButton("Book Now!!");
        btn6.setFont(f1);
        btn6.setBounds(744,551,100,20);
        btn6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn6.setContentAreaFilled(false);
        btn6.setFocusable(false);
        btn6.setBorderPainted(false);
        btn6.addActionListener(this);
        pan1.add(btn6);

        backbtn = new JButton(backimg);
        backbtn.setBounds(820,5,100,100);
        backbtn.addActionListener(this);
        backbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backbtn.setBorderPainted(false);
        backbtn.setContentAreaFilled(false);
        backbtn.setFocusable(false);
        pan1.add(backbtn);

        exitbtn = new JButton(exitimg);
        exitbtn.setBounds(450,575,100,100);
        exitbtn.addActionListener(this);
        exitbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitbtn.setBorderPainted(false);
        exitbtn.setContentAreaFilled(false);
        exitbtn.setFocusable(false);
        pan1.add(exitbtn);





        


        imagelbl = new JLabel(img);
        imagelbl.setBounds(0,0,1000,700);
        pan1.add(imagelbl);
        this.add(pan1);
        this.setVisible(true);

    


    }

    public static void main(String[] args) {
        new travelPacks();
    }

   
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == backbtn){

            this.dispose();
            new Home();

        }else if(ae.getSource() == exitbtn){
            this.dispose();

        }else if(ae.getSource() == btn1){
            System.out.println("Sajek");
        }else if(ae.getSource() == btn2){
            System.out.println("Saint martin");
        }else if(ae.getSource() == btn3){
            System.out.println("Srimangal");
        }else if(ae.getSource() == btn4){
            System.out.println("Coxs Bazar");
        }else if(ae.getSource() == btn5){
            new bandarban();
        }else if(ae.getSource() == btn6){
            System.out.println("Jaflong");
        }
    }
}
