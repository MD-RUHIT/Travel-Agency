import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.*;


public class forgotPass extends JFrame implements ActionListener{
    
    JPanel p1;
    ImageIcon img1,img2;
    JLabel imglbl1;
    JTextField tmail,tpass;
    JButton find;


    forgotPass(){
        super("TravelBro | Login");
        this.setSize(400,450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        img1 = new ImageIcon("Images/PassFinder.png");
        img2 = new ImageIcon("Images/Find.png");
       
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setSize(new Dimension(400,450));


        tmail = new JTextField();
        //tmail.setBorder(BorderFactory.createEmptyBorder());
        tmail.setBounds(150,195,170,25);
        p1.add(tmail);

        tpass = new JTextField();
        tpass.setFont(new Font("Arial", Font.BOLD, 16));
        tpass.setText("");
        tpass.setBounds(130,300,150,30);
        tpass.setHorizontalAlignment(SwingConstants.CENTER);
        tpass.setBorder(BorderFactory.createEmptyBorder());
        tpass.setOpaque(false);
        tpass.setBackground(new Color(0, 0, 0, 0));
        tpass.setEditable(false);
        p1.add(tpass);

        find = new JButton(img2);
        find.setBounds(180,225,40,40);
        find.setContentAreaFilled(false);
        find.setBorderPainted(false);
        find.addActionListener(this);
        p1.add(find);

        
        
        imglbl1 = new JLabel(img1);
        imglbl1.setBounds(0,0,400,450);
        p1.add(imglbl1);
       
       
        this.add(p1);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==find){
            if(tmail.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter your mail First!!","Travel Bro | Pass Finder",2);
            }else{

        String email = "Email : "+ tmail.getText();
        
        try {
            FileReader file = new FileReader("Datas/User_Data.txt");
            BufferedReader bfw = new BufferedReader(file);

            int numberOfLines = 0;
            while(bfw.readLine()!=null){
                numberOfLines ++;
            }
            bfw.close();

            int count = 11;

            for(int i = 0;i<numberOfLines ; i++){
                String line = Files.readAllLines(Paths.get("Datas/User_Data.txt")).get(i); 
                
                if(email.equals(line)){
                    String passoo = Files.readAllLines(Paths.get("Datas/User_Data.txt")).get(i+1);
                    String pass = passoo.substring(11);
                    tpass.setText(pass);
                    count = 0;
                    break;
                }
            }

                    if(count != 0){
                        JOptionPane.showMessageDialog(null,"Cant Find the Mail","Travel Bro | Pass Finder",2);
                    }

            
        
        }catch (IOException e) {
            System.out.println(e);
        }

       }
    }
}
}
