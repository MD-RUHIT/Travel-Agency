import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class invoice extends JFrame implements ActionListener{

    JPanel pan1;
    String name,phn,email,nper,tcost,line0;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JLabel lpkgcst,lTper,lTotal,ldate,lname,lphn;
    JButton tikbtn;
    int packageCost,personNumber;
    ImageIcon tik1;
    invoice(){
        super("Travel Bro | Invoice");
        this.setSize(320,400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        pan1 = new JPanel();
        pan1.setLayout(null);
        pan1.setBounds(0,0,320,400);
        pan1.setBorder(BorderFactory.createLineBorder(Color.black,2));


        Font f2 = new Font("bitMatrix",Font.BOLD,22);
        Font f3 = new Font("bitMatrix",Font.PLAIN,12);
        Font f4 = new Font("bitMatrix",Font.BOLD,12);

        tik1 = new ImageIcon("Images/check2.png");

        tikbtn = new JButton(tik1);
        tikbtn.setBounds(5,5,50,50);
        tikbtn.addActionListener(this);
        tikbtn.setBorderPainted(false);
        tikbtn.setContentAreaFilled(false);
        tikbtn.setFocusable(false);
        tikbtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        tikbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tikbtn.setBorderPainted(false);
        pan1.add(tikbtn);


        l1 = new JLabel("Travel Bro");
        l1.setBounds(100,40,140,50);
        l1.setFont(f2);
        pan1.add(l1);


        l2 = new JLabel("Commercial Plot-17/1");
        l2.setBounds(94,60,200,50);
        l2.setFont(f3);
        pan1.add(l2);

        l3 = new JLabel("section-06/ka,Mirpur-2,Dhaka-1216");
        l3.setBounds(56,75,200,50);
        l3.setFont(f3);
        pan1.add(l3);

        l4 = new JLabel("www.travelbro.com");
        l4.setBounds(96,90,200,50);
        l4.setFont(f3);
        pan1.add(l4);

        //current date ar time nibe
        LocalDateTime now = LocalDateTime.now();
        //etare string e convert korbe
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        ldate = new JLabel(formattedDateTime);
        ldate.setBounds(90,120,200,30);
        ldate.setFont(f3);
        pan1.add(ldate);


        try {
            name = Files.readAllLines(Paths.get("Datas/Premade_packages_temp.txt")).get(1);
            phn = Files.readAllLines(Paths.get("Datas/Premade_packages_temp.txt")).get(2);
            email = Files.readAllLines(Paths.get("Datas/Premade_packages_temp.txt")).get(3);
            String nper_temp = Files.readAllLines(Paths.get("Datas/Premade_packages_temp.txt")).get(4);
            String tcost_temp = Files.readAllLines(Paths.get("Datas/Premade_packages_temp.txt")).get(5);

            nper = nper_temp.substring(19);
            tcost = tcost_temp.substring(12);
        } catch (IOException e) {
           System.out.println(e);
        }



        l5 = new JLabel("Name                          :");
        l5.setBounds(30,140,200,50);
        l5.setFont(f4);
        pan1.add(l5);

        lname = new JLabel(name);//Login.name
        lname.setBounds(150,140,200,50);
        lname.setFont(f4);
        pan1.add(lname);

        l6 = new JLabel("Phone Number         :");
        l6.setBounds(30,160,200,50);
        l6.setFont(f4);
        pan1.add(l6);

        lphn = new JLabel(phn);//Login.phn
        lphn.setBounds(150,160,200,50);
        lphn.setFont(f4);
        pan1.add(lphn);

        l7 = new JLabel("Package Cost                            : " );
        l7.setBounds(30,200,200,50);
        l7.setFont(f3);
        pan1.add(l7);

        try{
            line0 = Files.readAllLines(Paths.get("Datas/Premade_packages_temp.txt")).get(0); 

        }catch(Exception ex){
            System.out.println(ex);
        }


        if(line0.equals("Package: 1")){
            packageCost = 3000;
        }else if(line0.equals("Package: 2")){
            packageCost = 4000;
        }else if(line0.equals("Package: 3")){
            packageCost = 2700;
        }else if(line0.equals("Package: 4")){
            packageCost = 3500;
        }else if(line0.equals("Package: 5")){
            packageCost = 3000;
        }else if(line0.equals("Package: 6")){
            packageCost = 2500;
        }
        

        lpkgcst = new JLabel(""+packageCost);
        lpkgcst.setBounds(205,200,200,50);
        lpkgcst.setFont(f3);
        pan1.add(lpkgcst);

        l9 = new JLabel("Total Person                              :");
        l9.setBounds(30,230,200,50);
        l9.setFont(f3);
        pan1.add(l9);

        lTper = new JLabel(nper);
        lTper.setBounds(205,230,200,50);
        lTper.setFont(f3);
        pan1.add(lTper);

        l10 = new JLabel("==================================");
        l10.setBounds(30,260,300,50);
        l10.setFont(f3);
        pan1.add(l10);

        l11 = new JLabel("Total                                             :");
        l11.setBounds(30,280,200,50);
        l11.setFont(f3);
        pan1.add(l11);

        try{

        personNumber = Integer.parseInt(nper);

        }catch(Exception ex){
            System.out.println(ex);
        }

        if( personNumber > 5 ){
        l12 = new JLabel("After 10% discount.");
        }else{
            l12 = new JLabel("After 0% discount.");
        }
        
        l12.setBounds(195,307,200,50);
        l12.setForeground(Color.RED);
        l12.setFont(f3);
        pan1.add(l12);


        lTotal = new JLabel(tcost);
        lTotal.setBounds(205,280,200,50);
        lTotal.setFont(f3);
        pan1.add(lTotal);

        
        this.add(pan1);
        this.setVisible(true);

    
    }
    public static void main(String[] args) {
        new invoice();
    }
    
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == tikbtn){
        this.dispose();
        new payment();
       }
    }
}
