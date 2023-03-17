package CollegeManagementSystem;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.net.URL;
import javax.swing.*;

public class About extends  JFrame {   
    
//    @SuppressWarnings("deprecation")
    JButton github;
    About() {
        setSize(800,700);
        getContentPane().setBackground(Color.WHITE);
        setLocation(300,100);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);// awt
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(300,50,400,300);
        add(image);
        
        JLabel heading=new JLabel("<html> College <br> Management System </html>");
        heading.setBounds(30,10,300,200);
        heading.setFont(new Font("serif",Font.ITALIC,40));
        add(heading);
        
        JLabel devBylbl=new JLabel("Developed by  ");
        devBylbl.setBounds(30,300,300,200);
        devBylbl.setFont(new Font("serif",Font.BOLD,35));
        add(devBylbl);
        
        
        JLabel shivam=new JLabel("Shivam Human");
        shivam.setBounds(300,300,300,200);
        shivam.setForeground(Color.red);
        shivam.setFont(new Font("serif",Font.ITALIC,40));
        add(shivam);
        
        
        JLabel emaillbl=new JLabel("Email ");
        emaillbl.setBounds(30,380,300,200);
        emaillbl.setFont(new Font("serif",Font.BOLD,35));
        add(emaillbl);
        
        JLabel email=new JLabel("shivamp9148@gmail.com");
        email.setBounds(300,380,450,200);
        email.setForeground(Color.red);
        email.setFont(new Font("serif",Font.ITALIC,40));
        add(email);
        
        JLabel phonelbl=new JLabel("Phone");
        phonelbl.setBounds(30,460,300,200);
        phonelbl.setFont(new Font("serif",Font.BOLD,35));
        add(phonelbl);
        
        JLabel phone=new JLabel("+91 9540802098");
        phone.setBounds(300,460,450,200);
        phone.setForeground(Color.red);
        phone.setFont(new Font("serif",Font.ITALIC,40));
        add(phone);
        
        github=new JButton("GitHub");
        github.setBounds(250,600,200,50);
        github.setForeground(Color.BLUE);
        github.setFont(new Font("serif",Font.BOLD,30));
        github.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                try {
                    Desktop.getDesktop().browse(new URL("https://github.com/dextroshivam").toURI());

                } catch (Exception eaException) {
                    eaException.printStackTrace();
                }
            }
        });
        github.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(github);
        
        
        
        
        
        setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        new About();
    }
}
