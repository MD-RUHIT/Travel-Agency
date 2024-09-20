import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class admin1 extends JFrame implements ActionListener{

    private Container c;
    private ImageIcon icon, logo;
    private JLabel label1, imgLabel;
    private Font f1, f2;
    private JButton btn1, btn2, btn3, nBtn;
    private Cursor cursor;

    admin1() {
        // Frame Layout
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(650, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#F2F2F2"));

        // Icon
        icon = new ImageIcon(getClass().getResource("Images/Icon.png"));
        this.setIconImage(icon.getImage());

        // Logo
        logo = new ImageIcon(getClass().getResource("Images/admin.png"));
        imgLabel = new JLabel(logo);
        imgLabel.setBounds(127, 20, logo.getIconWidth(), logo.getIconHeight());
        c.add(imgLabel);

        // Fonts
        f1 = new Font("Tahoma", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);

        // Title
        label1 = new JLabel();
        label1.setText("Admin Panel");
        label1.setBounds(123, 420, 433, 50);
        label1.setFont(f1);
        c.add(label1);

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        // JButtons
        btn1 = new JButton("User Data");
        btn1.setBounds(210, 510, 207, 50);
        btn1.setFont(f2);
        btn1.setCursor(cursor);
        btn1.addActionListener(this);
        btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.decode("#2E75B6"));
        c.add(btn1);

        btn2 = new JButton("Back");
        btn2.setBounds(299, 581, 270, 50);
        btn2.setFont(f2);
        btn2.setCursor(cursor);
        btn2.addActionListener(this);
        btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.decode("#2E75B6"));
        c.add(btn2);

        btn3 = new JButton("Exit");
        btn3.setBounds(64, 581, 207, 50);
        btn3.setFont(f2);
        btn3.addActionListener(this);
        btn3.setCursor(cursor);
        btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.decode("#C00000"));
        c.add(btn3);

        
        
        nBtn = new JButton("");
        nBtn.setBounds(0, 0, 0, 0);
        c.add(nBtn);
        
        this.setVisible(true);

        
    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==btn1){
            setVisible(false);
                UserData frame = new UserData();
                frame.setVisible(true);
    
        }else if(ae.getSource()==btn2){
                this.dispose();
                new FirstPage();
                
        }
        else if(ae.getSource()==btn3){
            System.exit(0);
            }
    }
}