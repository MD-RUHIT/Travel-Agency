import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Login extends JFrame implements ActionListener,MouseListener{ 
   
    private JPanel p1;
    private ImageIcon img,iconimg,on,off;
    private JLabel imglbl,lemail,lpass;
    private JTextField temail;
    private JPasswordField tpass;
    private JButton loginbtn,backbtn,exit,fpass,resetbtn;
    private JToggleButton showpassButton;

    private String name,email,code;
    private String phn;
   
    Login(){
        super("TravelBro | Login");
        this.setSize(1000,700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Font f = new Font("Poppins", Font.BOLD, 22);
        Font f1 = new Font("Poppins", Font.BOLD, 20);
        Font f3 = new Font("Poppins", Font.BOLD, 14);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setSize(new Dimension(1000,700));

        lemail = new JLabel("E-mail :");
        lemail.setBounds(100,270,200,30);
        lemail.setFont(f);
        p1.add(lemail);

        lpass = new JLabel("Password :");
        lpass.setBounds(100,370,200,30);
        lpass.setFont(f);
        p1.add(lpass);

        temail = new JTextField("rishanto108@gmail.com");
        temail.setBounds(300,270,230,40);
        temail.addActionListener(this);
        p1.add(temail);

        tpass = new JPasswordField("1234");
        tpass.setBounds(300,370,230,40);
        tpass.addActionListener(this);
        p1.add(tpass);

        loginbtn = new JButton("Login");
        loginbtn.setBounds(430,460,100,50);
        loginbtn.addActionListener(this);
        loginbtn.setFont(f1);
        p1.add(loginbtn);


      
        backbtn = new JButton("Back");
        backbtn.setBounds(300,460,100,50);
        backbtn.addActionListener(this);
        backbtn.setFont(f1);
        p1.add(backbtn);

        fpass = new JButton("Forgot password??");
        fpass.setBounds(380,414,180,30);
        fpass.setFont(f3);
        fpass.setForeground(Color.GRAY);
        fpass.setFocusable(false);
        fpass.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        fpass.setFocusPainted(false);
        fpass.setContentAreaFilled(false);
        fpass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        fpass.addActionListener(this);
        fpass.addMouseListener(this);
        p1.add(fpass);

        ImageIcon exitimg = new ImageIcon("Images/exit.png");

        exit = new JButton(exitimg);
        exit.setBounds(870,0,100,100);
        exit.addActionListener(this);
        exit.setContentAreaFilled(false);
        exit.setFocusable(false);
        exit.setBorderPainted(false);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p1.add(exit);

        resetbtn = new JButton("Reset");
        resetbtn.setBounds(140,460,100,50);
        resetbtn.setFont(f1);
        resetbtn.addActionListener(this);
        resetbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p1.add(resetbtn);

        on = new ImageIcon("Images/on.png");
        off = new ImageIcon("Images/off.png");
        showpassButton = new JToggleButton(off);
        showpassButton.setBounds(535,373,40,40);
        showpassButton.setContentAreaFilled(false);
        showpassButton.setBorder(null);
        showpassButton.addActionListener(this);
        p1.add(showpassButton);


        img = new ImageIcon("Images/Register_Page.png");
        imglbl = new JLabel(img);
        imglbl.setBounds(0,0,1000,700);

        iconimg = new ImageIcon("Images/Icon.png");
        this.setIconImage(iconimg.getImage());

        p1.add(imglbl);
        add(p1);
        this.setVisible(true);

    }

   


    public void actionPerformed(ActionEvent ae){

        
        if(ae.getSource() == showpassButton){
            if(showpassButton.isSelected()){
                showpassButton.setIcon(on);
                tpass.setEchoChar((char)0);
            }else{
                showpassButton.setIcon(off);
                tpass.setEchoChar('*');
            }
        }


        if(ae.getSource()==loginbtn){
            String email = temail.getText();
            String pass = tpass.getText();

            if(email.isEmpty()||pass.isEmpty()){

                JOptionPane.showMessageDialog(null,"Please enter all the credentials","Empty Parameter Error!!",2);
                lemail.setText("*E-mail : ");
                lpass.setText("*Password : ");
                lemail.setForeground(Color.red);
                lpass.setForeground(Color.red);
            
            }else{
                   try{ 
                        String emailTxt = "Email : " + email;
                        String passTxt = "Password : " + pass;

                        FileReader file = new FileReader("Datas/User_Data.txt");
                        BufferedReader reader = new BufferedReader(file);

                        int numberOfLines = 0;
                        while(reader.readLine()!=null){
                            numberOfLines ++;
                        }

                        reader.close();

                        for(int i=0; i<=numberOfLines;i++){
                            
                            String line1 = Files.readAllLines(Paths.get("Datas/User_Data.txt")).get(i);
                            String line2 = Files.readAllLines(Paths.get("Datas/User_Data.txt")).get(i+1);
                            

                            if(line1.equals(emailTxt) && line2.equals(passTxt)){
                                
                                
                                String Nfs = Files.readAllLines(Paths.get("Datas/User_Data.txt")).get(i + 2);
                                name = Nfs.substring(7);
                                String Pfs = Files.readAllLines(Paths.get("Datas/User_Data.txt")).get(i + 3);
                                phn = Pfs.substring(15);
                                String Efs = Files.readAllLines(Paths.get("Datas/User_Data.txt")).get(i);
                                email = Efs.substring(8);


                                try{
                                    FileWriter file1 = new FileWriter("Datas/Current_User_Data.txt",true);
                                    BufferedWriter bfw = new BufferedWriter(file1);
                                    PrintWriter pww = new PrintWriter(bfw);

                                    pww.println(name);
                                    pww.println(phn);
                                    pww.println(email);
                                    pww.close();
                                }catch(Exception e){
                                    JOptionPane.showMessageDialog(null,e,"Travel Bro",0);
                                }
                                
                                JOptionPane.showMessageDialog(null,"Login Successfull","TravelBro",1);
                                this.dispose();
                                new Home();
                                
                                
                                break;
                            }
                        }
                     }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Invalid Input!!","TravelBro",2);
                        lemail.setForeground(Color.RED);
                        lpass.setForeground(Color.RED);

            }
        }
        
    }else if(ae.getSource()==backbtn){
        this.dispose();
        new FirstPage();
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
    }else if(ae.getSource() == fpass){

        String code = JOptionPane.showInputDialog("Enter The Code!");
        System.out.println(code);
        

        try (FileReader file = new FileReader("Datas/admin_data.txt")) {
            BufferedReader reader = new BufferedReader(file);

            int numberOfLines = 0;
            while(reader.readLine()!=null){
                numberOfLines ++;
            }

            reader.close();

            for(int i=0; i<=numberOfLines;i++){
                            
                String line = Files.readAllLines(Paths.get("Datas/admin_data.txt")).get(i);
                if(line.equals(code)){
                    new forgotPass();
                    break;
                }
                               
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Wrong Code!!!","Travel Bro",0);
            System.out.println(e);
        }

        


        
    }else if(ae.getSource() == resetbtn){
        temail.setText("");
        tpass.setText("");
    }
}
    public void mouseClicked(MouseEvent e) {
      
    }

    public void mousePressed(MouseEvent e) {
        fpass.setForeground(Color.RED);
    }

    public void mouseReleased(MouseEvent e) {
        fpass.setForeground(Color.GRAY);
    }

    public void mouseEntered(MouseEvent e) {
        fpass.setForeground(Color.RED);
    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
    public void mouseExited(MouseEvent e) {
        fpass.setForeground(Color.GRAY);
    }
}
                        