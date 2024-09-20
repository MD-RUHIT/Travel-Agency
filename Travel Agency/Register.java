import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Register extends JFrame implements ActionListener{

    ImageIcon img,iconimg,on,off;
    JLabel imglbl,lfname,llname,lphnnum,lpass,lchkpass,lemail;
    JPanel p1;
    JButton submitbtn,backbtn,resetButton;
    JToggleButton showpassButton;
    JTextField tfname,tlname,tphnnum,temail;
    JPasswordField tpass,tchkpass;

    Register(){
        super("TravelBro | Register");
        this.setSize(1000,700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font f = new Font("Poppins", Font.BOLD, 16);

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setSize(new Dimension(1000,700));

        lfname = new JLabel("First Name :");
        lfname.setBounds(100,150,200,30);
        lfname.setFont(f);
        p1.add(lfname);

        llname = new JLabel("Last Name :");
        llname.setBounds(100,210,200,30);
        llname.setFont(f);
        p1.add(llname);

        
        lphnnum = new JLabel("Phone Number  :");
        lphnnum.setBounds(100,270,200,30);
        lphnnum.setFont(f);
        p1.add(lphnnum);


        lemail = new JLabel("E- mail       :");
        lemail.setBounds(100,330,200,30);
        lemail.setFont(f);
        p1.add(lemail);


        lpass = new JLabel("Enter Password :");
        lpass.setBounds(100,390,200,30);
        lpass.setFont(f);
        p1.add(lpass);


        lchkpass = new JLabel("Re-enter Password :");
        lchkpass.setBounds(100,450,230,30);
        lchkpass.setFont(f);
        p1.add(lchkpass);


        tfname = new JTextField();
        tfname.setBounds(350,150,200,30);
        tfname.addActionListener(this);
        p1.add(tfname);

        tlname = new JTextField();
        tlname.setBounds(350,210,200,30);
        tlname.addActionListener(this);
        p1.add(tlname);

        tphnnum = new JTextField();
        tphnnum.setBounds(350,270,200,30);
        tphnnum.addActionListener(this);
        p1.add(tphnnum);

        temail = new JTextField();
        temail.setBounds(350,330,200,30);
        temail.addActionListener(this);
        p1.add(temail);

        tpass = new JPasswordField();
        tpass.setBounds(350,390,200,30);
        tpass.addActionListener(this);
        p1.add(tpass);

        tchkpass = new JPasswordField();
        tchkpass.setBounds(350,450,200,30);
        tchkpass.addActionListener(this);
        p1.add(tchkpass);

        submitbtn = new JButton("Submit");
        submitbtn.setBounds(410,530,100,40);
        submitbtn.addActionListener(this);
        submitbtn.setFont(f);
        p1.add(submitbtn);

        resetButton = new JButton("Reset");
        resetButton.setBounds(270,530,100,40);
        resetButton.addActionListener(this);
        resetButton.setFont(f);
        p1.add(resetButton);

        backbtn = new JButton("Back");
        backbtn.setBounds(120,530,100,40);
        backbtn.addActionListener(this);
        backbtn.setFont(f);
        p1.add(backbtn);

        


        img = new ImageIcon("Images/Register_Page.png");
        
        imglbl = new JLabel(img);
        imglbl.setBounds(0,0,1000,700);

        iconimg = new ImageIcon("Images/Icon.png");
        this.setIconImage(iconimg.getImage());
        p1.add(imglbl);
        add(p1);
        this.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==submitbtn){
            
            String first_name = tfname.getText();
            String last_name = tlname.getText();
            String pass = tpass.getText();
            String chkpass = tchkpass.getText();
            String phn_num = tphnnum.getText();
            String email = temail.getText();

            Boolean bool = false;

           try{
            FileReader file = new FileReader("Datas/User_Data.txt");
            BufferedReader reader = new BufferedReader(file);

            int numberOfLines = 0;
            while(reader.readLine()!=null){
                numberOfLines ++;
            }

            reader.close();

    for(int i = 0 ; i<=numberOfLines;i++){
        String line1 = Files.readAllLines(Paths.get("Datas/User_Data.txt")).get(i);

        if(line1.substring(8).equals(email)){
            bool = true;
            break;
        }
    }
           }catch(Exception ex){
            System.out.println(ex);
           }
           
            

            if(first_name.isEmpty()||last_name.isEmpty()||pass.isEmpty()||phn_num.isEmpty()||chkpass.isEmpty()||email.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill all the credentials!!","Error",2);
            }else if(phn_num.length()!=11){
                JOptionPane.showMessageDialog(null,"Please fill the Phone Number Correctly!","Error",2);
            }else if(bool == true){
                JOptionPane.showMessageDialog(null,"Email already exists!","Error",2);
            }else{
            
                 if(!pass.equals(chkpass)){
                JOptionPane.showMessageDialog(null,"Re-enter Password!!","Error",2);
                }else{
                    try{    
                    FileWriter filee = new FileWriter("Datas/User_Data.txt",true);
                    BufferedWriter bfw = new BufferedWriter(filee);
                    PrintWriter pw = new PrintWriter(bfw);
                            
                            pw.println("Email : " + email);
                            pw.println("Password : " + pass);
                            pw.println("Name : " + last_name+","+first_name);
                            pw.println("Phone Number : "+phn_num);
                            pw.println("===============================================");
                            pw.close();
                

                    JOptionPane.showMessageDialog(null,"Registration Succeessfull","TravelBro:)",2);

                    tfname.setText("");
                    tlname.setText("");
                    temail.setText("");
                    tphnnum.setText("");
                    tpass.setText("");
                    tchkpass.setText("");
                        this.dispose();
                        new FirstPage();

                    }
                    catch(Exception ex){
                    System.out.println(ex);
                }
            }
            
            
        }   
        }else if(e.getSource()==backbtn){
            this.dispose();
            new FirstPage();
        }else if(e.getSource()==resetButton){
            this.dispose();
            new Register();
        }
    }
}
