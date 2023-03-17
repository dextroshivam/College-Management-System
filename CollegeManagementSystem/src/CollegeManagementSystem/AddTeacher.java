package CollegeManagementSystem;

import javax.swing.*;
import  java.awt.*;
import  java.sql.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddTeacher extends JFrame implements ActionListener{
    JDateChooser dcdob;
    JLabel empId;
    Random rn=new Random();
    JButton submitButton;
    JTextField email;
    JTextField Fathername;
    JButton cancelButton;
    JTextField aadharNo;
    JTextField phone;
    JTextField address;
    JTextField name;
    long first4=Math.abs((rn.nextLong()%9000L)+1000L);
     AddTeacher() {
         
         setSize(900,700);
         setLocation(300,100);
         setLayout(null);
         
         JLabel heading=new JLabel("New Teacher Details");
         heading.setBounds(280,40,400,40);
         heading.setFont(new Font("serif",Font.BOLD,40));
         add(heading);
//         name label and father name lable
//         name lable
         JLabel namelbl=new JLabel("Name");
         namelbl.setBounds(100 ,150,50,20);
         namelbl.setFont(new Font("serif",Font.BOLD,20));
         add(namelbl);
         
         name=new JTextField();
         name.setBounds(170,150,150,25);
         add(name);
//         father name label
         JLabel fatherNamelbl=new JLabel("Father Name");
         fatherNamelbl.setBounds(370 ,150,120,20);
         fatherNamelbl.setFont(new Font("serif",Font.BOLD,20));
         add(fatherNamelbl);
         
          Fathername=new JTextField();
         Fathername.setBounds(500,150,150,25);
         add(Fathername);
//         Roll and Dob lable
//         Roll number lable
         JLabel rollNolbl=new JLabel("Emp Id");
         rollNolbl.setBounds(100 ,200,80,20);
         rollNolbl.setFont(new Font("serif",Font.BOLD,20));
         add(rollNolbl);
         
          empId=new JLabel("1000"+first4);
         empId.setBounds(170,199,150,25);
         empId.setFont( new Font("serif",Font.BOLD,20) );
         add(empId);
//         Dob label
         JLabel doblbl=new JLabel("Date Of Birth");
         doblbl.setBounds(370 ,200,120,20);
         doblbl.setFont(new Font("serif",Font.BOLD,20));
         add(doblbl);
         
         dcdob=new JDateChooser();
         dcdob.setBounds(500,200,150,25);
         add(dcdob);

//         Address label and phone lable
//         name lable
         JLabel addresslbl=new JLabel("Address");
         addresslbl.setBounds(100 ,250,80,20);
         addresslbl.setFont(new Font("serif",Font.BOLD,20));
         add(addresslbl);
         
          address=new JTextField();
         address.setBounds(170,250,150,25);
         add(address);
//         father name label
         JLabel phonelbl=new JLabel("Phone");
         phonelbl.setBounds(370 ,250,80,20);
         phonelbl.setFont(new Font("serif",Font.BOLD,20));
         add(phonelbl);
         
          phone=new JTextField();
         phone.setBounds(500,250,150,25);
         add(phone);

//         Email label and class 10 marks lable
//         name lable
         JLabel emaillbl=new JLabel("Email");
         emaillbl.setBounds(100 ,300,80,20);
         emaillbl.setFont(new Font("serif",Font.BOLD,20));
         add(emaillbl);
         
          email=new JTextField();
         email.setBounds(170,300,150,25);
         add(email);
//         father name label
         JLabel aadharNolbl=new JLabel("Aadhar No");
         aadharNolbl.setBounds(370 ,300,100,20);
         aadharNolbl.setFont(new Font("serif",Font.BOLD,20));
         add(aadharNolbl);
         
         aadharNo=new JTextField();
         aadharNo.setBounds(500,300,150,25);
         add(aadharNo);         
//button login
         submitButton=new JButton("Submit");
        submitButton.setBounds(250,400,100,30);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        submitButton.setFont(new Font("Tahoma",Font.BOLD,13));
        add(submitButton);
        
//        cancel button
        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(400,400,100,30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.addActionListener(this);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Tahoma",Font.BOLD,13));
        add(cancelButton);
         
         
         
         setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submitButton){
            String name=this.name.getText();
            String fatherName=Fathername.getText();
            String empId="1000"+this.empId.getText();
            String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address=this.address.getText();
            String phone=this.phone.getText();
            String email=this.email.getText();
            String aadharNo=this.aadharNo.getText();
            try {
                String query="insert into teacher(name,fatherName,empId,dob,address,phone,email,aadharNo"
                        + ") values ('"+name+"','"+fatherName+"','"+empId+"','"+dob+"','"+address+"','"+phone+"','"+email
                        + "','"+ aadharNo+"')";
                Conn conn=new Conn();
                conn.s.executeUpdate(query);
                System.out.println("Teacher enrolled");
                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                setVisible(false);
                
            } catch (Exception ea) {
                ea.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddTeacher();
    }
}
