package CollegeManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JButton loginButton,cancelButton;
    JTextField usernametxf;
    JPasswordField passwordtxf;
    Login(){
        setLayout(null);
//        username
        JLabel usernamelbl=new JLabel("Username ");
        usernamelbl.setBounds(40,20,100,20);
        add(usernamelbl);
        
         usernametxf=new JTextField();
        usernametxf.setBounds(150,20,150,20);
        add(usernametxf);
//        password
        JLabel passwordlbl=new JLabel("Passoword ");
        passwordlbl.setBounds(40,70,100,20);
        add(passwordlbl);
        
         passwordtxf=new JPasswordField();
        passwordtxf.setBounds(150,70,150,20);
        add(passwordtxf);
        
        //button login
         loginButton=new JButton("Login");
        loginButton.setBounds(100,120,100,30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        loginButton.setFont(new Font("Tahoma",Font.BOLD,13));
        add(loginButton);
        
//        cancel button
        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(220,120,100,30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.addActionListener(this);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Tahoma",Font.BOLD,13));
        add(cancelButton);

        
        // image 
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200   , 200, Image.SCALE_DEFAULT);// awt
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350 , 50,200,150);
        add(image);
        //content
        getContentPane().setBackground(Color.WHITE);
        setLocation(500,250);
        setSize(600,300);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==loginButton){
            String username=usernametxf.getText();
            String password=passwordtxf.getText();
            
            String query="select * from login where username='"+username+"' and password='" + password+"'";
            
            try {
                Conn c=new Conn();
                ResultSet rs= c.s.executeQuery(query);
                if(rs!=null && rs.next()){
                    setVisible(false);
                    new Project();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Credentials!");
                }
            } catch (Exception ea) {
                ea.printStackTrace();
            }
            
        }else if(e.getSource()==cancelButton){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
