import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class customize extends JFrame implements ActionListener, MouseListener{

    private JPanel p1,p2;
    private  JLabel imglbl;
    private JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
    private  JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,ldate;
    private  JLabel lname,lphn,lTrCost,lHtlCost,lTper,lTotal;
    private ImageIcon imgback, check1, check2,check2_2,saveimg, historyicon,historyicon1;
    private JButton back,reset,next,procceed,exit,save,historybtn;
    private JComboBox tourType,dest,per,days,htype,travby,veht;
    private String name,phn,email;
    private double Total;
    private int totalPer;

    customize(){
        
        super("TravelBro");
        this.setSize(1000,700);
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        saveimg = new ImageIcon("Images/save.png");
        historyicon = new ImageIcon("Images/historyicon.png");
        historyicon1 = new ImageIcon("Images/historyicon1.png");


        check1 = new ImageIcon("Images/check1.png");
        check2 = new ImageIcon("Images/check2.png");
        check2_2 = new ImageIcon("Images/check2_2.png");

        Font f = new Font("Poppins", Font.BOLD, 24);
        Font f1 = new Font("Bahnschrift SemiBold SemiConden",Font.BOLD,22);

        p1 =new JPanel();
        p1.setLayout(null);
        p1.setSize(new Dimension(1000,700));

        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(650,140,320,400);
        p2.setBorder(BorderFactory.createLineBorder(Color.black,2));
        
        


        back = new JButton("back");
        back.setBounds(172,614,100,30);
        back.setFont(f);
        back.setFocusable(false);
        back.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        back.setFocusPainted(false);
        back.setContentAreaFilled(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);
        p1.add(back);

        reset = new JButton("reset");
        reset.setBounds(337,614,100,30);
        reset.setFont(f);
        reset.setFocusable(false);
        reset.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        reset.setFocusPainted(false);
        reset.setContentAreaFilled(false);
        reset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reset.addActionListener(this);
        p1.add(reset);

        next = new JButton("next");
        next.setBounds(507,614,100,30);
        next.setFont(f);
        next.setFocusable(false);
        next.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        next.setFocusPainted(false);
        next.setContentAreaFilled(false);
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        next.addActionListener(this);
        p1.add(next);

        


        //Tour Type
        lbl1 = new JLabel("Tour Type  :");
        lbl1.setBounds(200,150, 150, 50);
        lbl1.setFont(f1);
        p1.add(lbl1);

        String [] tT = new String[]{"Choose tour type!","International","Domestic"};
        tourType = new JComboBox(tT);
        tourType.setBounds(360,162,220,30);
        tourType.setSelectedIndex(0);
        tourType.addActionListener(this);
        p1.add(tourType);


        //Destination
        lbl2 = new JLabel("Destination:");
        lbl2.setBounds(200,210, 150, 50);
        lbl2.setFont(f1);
        p1.add(lbl2);

        String [] intId = new String[]{"Choose tour type First!"};
        dest = new JComboBox(intId);
        dest.setBounds(360,222,220,30);
        dest.setSelectedIndex(0);
        dest.disable();
        p1.add(dest);


        //Number of Person
        lbl3 = new JLabel("Person       :");
        lbl3.setBounds(200,270, 150, 50);
        lbl3.setFont(f1);
        p1.add(lbl3);

        String [] pr = new String[]{"Total person number...", "1", "2", "3", "4", "5"};
        per = new JComboBox(pr);
        per.setBounds(360,282,220,30);
        per.setSelectedIndex(0);
       // per.disable();
        p1.add(per);


        //Total Days
        lbl4 = new JLabel("Total Days :");
        lbl4.setBounds(200,330, 150, 50);
        lbl4.setFont(f1);
        p1.add(lbl4);

        String [] td = new String[]{"Number of days...", "1", "2", "3", "4", "5", "6", "7"};
        days = new JComboBox(td);
        days.setBounds(360,342,220,30);
        days.setSelectedIndex(0);
       // days.disable();
        p1.add(days);



        //Hotel Type
        lbl5 = new JLabel("Hotel Type :");
        lbl5.setBounds(200,390, 150, 50);
        lbl5.setFont(f1);
        p1.add(lbl5);

        String [] ht = new String[]{"Select Tour Type First"};
        htype = new JComboBox(ht);
        htype.setBounds(360,402,220,30);
        htype.setSelectedIndex(0);
       // htype.disable();
        p1.add(htype);


        //Travel By
        lbl6 = new JLabel("Travel By   :");
        lbl6.setBounds(200,450, 150, 50);
        lbl6.setFont(f1);
        p1.add(lbl6);

        String [] tb = new String[]{"Select Tour Type First!!"};
        travby = new JComboBox(tb);
        travby.setBounds(360,462,220,30);
        travby.setSelectedIndex(0);
        travby.disable();
        p1.add(travby);

        //Vehicle Type
        lbl7 = new JLabel("Vehicle Type :");
        lbl7.setBounds(200,510, 150, 50);
        lbl7.setFont(f1);
        p1.add(lbl7);

        String [] vh = new String[]{"Select Vehicle First!!"};
        veht = new JComboBox(tb);
        veht.setBounds(360,522,220,30);
        veht.setSelectedIndex(0);
        veht.disable();
        p1.add(veht);

        //Recipt
        Font f2 = new Font("bitMatrix",Font.BOLD,22);
        Font f3 = new Font("bitMatrix",Font.PLAIN,12);
        Font f4 = new Font("bitMatrix",Font.BOLD,12);

        l1 = new JLabel("Travel Bro");
        l1.setBounds(100,40,140,50);
        l1.setFont(f2);
        p2.add(l1);


        l2 = new JLabel("Commercial Plot-17/1");
        l2.setBounds(94,60,200,50);
        l2.setFont(f3);
        p2.add(l2);

        l3 = new JLabel("section-06/ka,Mirpur-2,Dhaka-1216");
        l3.setBounds(56,75,200,50);
        l3.setFont(f3);
        p2.add(l3);

        l4 = new JLabel("www.travelbro.com");
        l4.setBounds(96,90,200,50);
        l4.setFont(f3);
        p2.add(l4);

        //current date ar time nibe
        LocalDateTime now = LocalDateTime.now();
        //etare string e convert korbe
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        ldate = new JLabel(formattedDateTime);
        ldate.setBounds(90,120,200,30);
        ldate.setFont(f3);
        p2.add(ldate);


        try {
            name = Files.readAllLines(Paths.get("Datas/Current_User_Data.txt")).get(0);
            phn = Files.readAllLines(Paths.get("Datas/Current_User_Data.txt")).get(1);
            email = Files.readAllLines(Paths.get("Datas/Current_User_Data.txt")).get(2);
        } catch (IOException e) {
           System.out.println(e);
        }



        l5 = new JLabel("Name                          :");
        l5.setBounds(30,140,200,50);
        l5.setFont(f4);
        p2.add(l5);

        lname = new JLabel(name);//Login.name
        lname.setBounds(150,140,200,50);
        lname.setFont(f4);
        p2.add(lname);

        l6 = new JLabel("Phone Number         :");
        l6.setBounds(30,160,200,50);
        l6.setFont(f4);
        p2.add(l6);

        lphn = new JLabel(phn);//Login.phn
        lphn.setBounds(150,160,200,50);
        lphn.setFont(f4);
        p2.add(lphn);

        l7 = new JLabel("Transportation Cost                 :");
        l7.setBounds(30,190,200,50);
        l7.setFont(f3);
        p2.add(l7);

        lTrCost = new JLabel("000000");
        lTrCost.setBounds(205,190,200,50);
        lTrCost.setFont(f3);
        lTrCost.setForeground(new Color(220,220,220));
        p2.add(lTrCost);

        l8 = new JLabel("Hotel Cost                                  :");
        l8.setBounds(30,215,200,50);
        l8.setFont(f3);
        p2.add(l8);

        lHtlCost = new JLabel("000000");
        lHtlCost.setBounds(205,215,200,50);
        lHtlCost.setFont(f3);
        lHtlCost.setForeground(new Color(220,220,220));
        p2.add(lHtlCost);

        l9 = new JLabel("Total Person                              :");
        l9.setBounds(30,240,200,50);
        l9.setFont(f3);
        p2.add(l9);

        lTper = new JLabel("000000");
        lTper.setBounds(205,240,200,50);
        lTper.setFont(f3);
        lTper.setForeground(new Color(220,220,220));
        p2.add(lTper);

        l10 = new JLabel("==================================");
        l10.setBounds(30,260,300,50);
        l10.setFont(f3);
        p2.add(l10);

        l11 = new JLabel("Total                                             :");
        l11.setBounds(30,280,200,50);
        l11.setFont(f3);
        p2.add(l11);

        lTotal = new JLabel("000000");
        lTotal.setBounds(205,280,200,50);
        lTotal.setFont(f3);
        lTotal.setForeground(new Color(220,220,220));
        p2.add(lTotal);

        l12 = new JLabel("No discounts available for customized packages!");
        l12.setBounds(20,310,300,50);
        l12.setFont(f3);
        l12.setForeground(Color.GRAY);
        p2.add(l12);

        


        procceed = new JButton(check1);
        procceed.setBounds(855,560,50,50);
        procceed.addActionListener(this);
        procceed.addMouseListener(this);
        procceed.setContentAreaFilled(false);
        procceed.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        procceed.setCursor(new Cursor(Cursor.HAND_CURSOR));
        procceed.setFocusable(false);
        p1.add(procceed);

        historybtn = new JButton(historyicon);
        historybtn.setBounds(700,560,50,50);
        historybtn.addActionListener(this);
        historybtn.addMouseListener(this);
        historybtn.setContentAreaFilled(false);
        historybtn.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        historybtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        historybtn.setFocusable(false);
        p1.add(historybtn);

        ImageIcon exitimg = new ImageIcon("Images/exit.png");

        exit = new JButton(exitimg);
        exit.setBounds(770,0,100,100);
        exit.addActionListener(this);
        exit.setContentAreaFilled(false);
        exit.setFocusable(false);
        exit.setBorderPainted(false);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p1.add(exit);

        save = new JButton(saveimg);
        save.setBounds(780,560,50,50);
        save.addActionListener(this);
        save.setContentAreaFilled(false);
        save.setFocusable(false);
        save.setBorderPainted(false);
        save.setCursor(new Cursor(Cursor.HAND_CURSOR));
        save.setEnabled(false);
        p1.add(save);

        
        imgback = new ImageIcon("Images/Customizeback.png");
        imglbl = new JLabel(imgback);
        imglbl.setBounds(0,0,1000,700);
        p1.add(imglbl);


        this.add(p2);
        p2.setVisible(false);
        this.add(p1);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==tourType){

            int a = tourType.getSelectedIndex();
            // int b = dest.getSelectedIndex();
            // int c = per.getSelectedIndex();
            // int d = days.getSelectedIndex();
            // int e = htype.getSelectedIndex();
            // int f = travby.getSelectedIndex();
            // int g = veht.getSelectedIndex();

            //for Tour Type
            switch(a){
                case 0 :
                    dest.disable();
                   // per.disable();
                    //days.disable();
                    //htype.disable();
                    travby.disable();
                    veht.disable();

                    break;
                case 1 :
                    lbl2.setText("Country   :");
                    dest.removeAllItems();
                    htype.removeAllItems();

                    String countries [] = {"Choose a country!","Germany","Indonesia","India","Italy"};
                    String hotelType [] = {"Choose Hotel Type!","2 Star","3 Star","5 Star"};
                    
                    for(int i=0; i<5;i++){
                        dest.addItem(countries[i]);
                    }
                    for(int i=0; i<4;i++){
                        htype.addItem(hotelType[i]);
                    }
                    veht.removeAllItems();
                    travby.removeAllItems();
                    travby.addItem("Select Transporation System!");
                    travby.addItem("AirPlane.");

                    String airClass[] ={"Select Class !","Busicness Class","Economy Class"}; 
                    for(int i=0; i<3;i++){
                        veht.addItem(airClass[i]);
                    }
                    
                    
                    travby.enable();
                    veht.enable();
                    htype.enable();
                    dest.enable();

                    break;
                case 2 :
                    lbl2.setText("Destination :");
                    dest.removeAllItems();
                    htype.removeAllItems();
                    String destination [] = {"Choose a destination","Bandarban","Cox's Bazar Beach","Sajek Valley","Srimangal","Sundarban"};
                    String hotelType1 [] = {"Choose Hotel Type!","2 Star","3 Star","5 Star"};
                    for(int i=0; i<5;i++){
                        dest.addItem(destination[i]);
                    }
                    for(int i=0; i<4;i++){
                        htype.addItem(hotelType1[i]);
                    }

                   
                    travby.removeAllItems();
                    String transportations [] = {"Select Transportation System","Bus"}; 
                    for(int i=0; i<2;i++){
                        travby.addItem(transportations[i]);
                    }

                    veht.removeAllItems();
                    String vehType[]={"Choose vehicle Type!","Non-AC","AC"};

                    for(int i=0 ;i<3;i++){
                        veht.addItem(vehType[i]);
                    }
                    dest.enable();
                    travby.enable();
                    htype.enable();
                    veht.enable();

                    break;
                default:
                    System.out.println("~~~~~");
                    }
                }
                //Back Button,Reset Button,next
        if(ae.getSource()==back){

            this.dispose();
            new Home();

        }else if(ae.getSource()==reset){

            this.dispose();
            new customize();
            

        }else if(ae.getSource()==next){

                
            //international
                if(tourType.getSelectedIndex()==1){

                double destinationCost = 0;
               
                if(dest.getSelectedIndex() == 1){
                    destinationCost = 500;
                }else if(dest.getSelectedIndex() == 2){
                    destinationCost = 300;
                }else if(dest.getSelectedIndex() == 3){
                    destinationCost = 200;
                }else if(dest.getSelectedIndex() == 4){
                    destinationCost = 1000;
                }
                
                double travbyCost = destinationCost;
                
                double vehicleTypeCost = 0;

                if(veht.getSelectedIndex()==1){
                    vehicleTypeCost = 50;
                }else if(veht.getSelectedIndex()==2){
                    vehicleTypeCost = 100;
                }


                double hotelTypeCost = 0;
                if(htype.getSelectedIndex()==1){
                    hotelTypeCost = 50;
                }else if(htype.getSelectedIndex()==2){
                    hotelTypeCost = 100;
                }else if(htype.getSelectedIndex()==3){
                    hotelTypeCost = 150;  
                }

                double hotelTypeXdays = days.getSelectedIndex()*hotelTypeCost;
                double transCost = vehicleTypeCost+travbyCost;
                totalPer = per.getSelectedIndex();
                Total = (per.getSelectedIndex()*(destinationCost+vehicleTypeCost+hotelTypeXdays));

                lTrCost.setText(""+transCost+" $");
                lTrCost.setForeground(Color.BLACK);

                lHtlCost.setText(""+hotelTypeCost+" $"+" "+"*"+days.getSelectedIndex()+" days");
                lHtlCost.setForeground(Color.BLACK);

                lTper.setText(""+totalPer);
                lTper.setForeground(Color.BLACK);

                lTotal.setText(""+Total+" $");
                lTotal.setForeground(Color.BLACK);
                
                

                //domestic
            }else if(tourType.getSelectedIndex()==2){

                double destinationCost = 0;
                double hotelTypeCost = 0;
                double vehicleTypeCost = 0;
                

                if(dest.getSelectedIndex()==1){
                    destinationCost = 900;
                }else if(dest.getSelectedIndex()==2){
                    destinationCost = 1800;
                }else if(dest.getSelectedIndex()==3){
                    destinationCost = 1000;
                }else if(dest.getSelectedIndex()==4){
                    destinationCost = 600;
                }else if(dest.getSelectedIndex()==5){
                    destinationCost = 1400;
                }
                double travbyCost = destinationCost;
                
                
                if(htype.getSelectedIndex() == 1){
                    hotelTypeCost = 800;
                }else if(htype.getSelectedIndex() == 2){
                    hotelTypeCost = 2000;
                }else if(htype.getSelectedIndex() == 3){
                    hotelTypeCost = 5000;
                }

                if(veht.getSelectedIndex()==1){
                    vehicleTypeCost = 0;
                }else if(veht.getSelectedIndex()==2){
                    vehicleTypeCost = 500;
                }

                double hotelTypeXdays = days.getSelectedIndex()*hotelTypeCost;
                double transCost = vehicleTypeCost+travbyCost;
                totalPer = per.getSelectedIndex(); 
                Total = (per.getSelectedIndex()*(destinationCost+vehicleTypeCost+hotelTypeXdays));
                
                lTrCost.setText(""+transCost+" BDT");
                lTrCost.setForeground(Color.BLACK);

                lHtlCost.setText(""+hotelTypeCost+" BDT"+" "+"*"+days.getSelectedIndex()+" days");
                lHtlCost.setForeground(Color.BLACK);

                lTper.setText(""+totalPer);
                lTper.setForeground(Color.BLACK);

                lTotal.setText(""+Total+" BDT");
                lTotal.setForeground(Color.BLACK);
                
                
                
            }
            
            if(tourType.getSelectedIndex()==0 || dest.getSelectedIndex()==0 || per.getSelectedIndex()==0 || days.getSelectedIndex()==0 || htype.getSelectedIndex()==0 || travby.getSelectedIndex()==0 || veht.getSelectedIndex()==0){

                JOptionPane.showMessageDialog(null,"Please fill all the credentials!!","TravelBro",2);
            }else{
                p2.setVisible(true);
                save.setEnabled(true);
            }
            
            
                

        
        }else if(ae.getSource()==procceed){
            if(tourType.getSelectedIndex()==0 || dest.getSelectedIndex()==0 || per.getSelectedIndex()==0 || days.getSelectedIndex()==0 || htype.getSelectedIndex()==0 || travby.getSelectedIndex()==0 || veht.getSelectedIndex()==0){

                JOptionPane.showMessageDialog(null,"Please fill all the credentials!!","TravelBro",2);
            }else{

            new payment();
        }
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
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        else if(ae.getSource() == save){
            try {
                save.setEnabled(false);
                FileWriter filee = new FileWriter("Datas/Customized_Package_User.txt",true);
                BufferedWriter bfw = new BufferedWriter(filee);
                PrintWriter pw = new PrintWriter(bfw);

                pw.println(email);
                pw.println(name);
                pw.println(phn);
                pw.println("Total Cost: "+Total);
                pw.println("Persons: "+totalPer);
                pw.println("From: Dhaka");
                pw.println("To: "+ dest.getSelectedItem());
                pw.println("=========================================");



                pw.close();
                //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+++++++++++++++++++++++
            }catch (IOException e) {
                System.out.println(e);
            }

        }else if(ae.getSource()==historybtn){
            
                  new history();
            }
}  
    public void mouseEntered(MouseEvent e) {
        
        procceed.setIcon(check2);
        historybtn.setIcon(historyicon1);
    }
    public void mouseExited(MouseEvent e) {
        
        procceed.setIcon(check1);
        historybtn.setIcon(historyicon);
    }    
    public void mouseClicked(MouseEvent e) {
        procceed.setIcon(check2_2);
    }
    public void mousePressed(MouseEvent e) {
        procceed.setIcon(check2_2);
    }
   
    public void mouseReleased(MouseEvent e) {
        procceed.setIcon(check2);
    }
   
}
