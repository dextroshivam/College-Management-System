package CollegeManagementSystem;

import javax.swing.*;
import  java.awt.*;
import  java.sql.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class UpdateTeacher extends JFrame implements ActionListener{
     
    JLabel empId, dcdob,Fathername,aadharNo,name;
    JButton cancelButton,submitButton;
    JTextField email,phone,address;
    Choice empIdChoice;
     UpdateTeacher() {
         
         setSize(900,700);
         setLocation(300,100);
         setLayout(null);
         
         JLabel heading=new JLabel("Update Teacher Details");
         heading.setBounds(280,40,400,40);
         heading.setFont(new Font("serif",Font.BOLD,35));
         add(heading);
         
         JLabel chooseByRollNumlbl=new JLabel("Choose By Employee Id");
         chooseByRollNumlbl.setBounds(150,90,250,40);
         chooseByRollNumlbl.setFont(new Font("serif",Font.BOLD,20));
         add(chooseByRollNumlbl);
         
         empIdChoice=new Choice();
         empIdChoice.setBounds(400,100,160,60);
         add(empIdChoice);
         
         try {
             Conn conn=new Conn();
             ResultSet rs=conn.s.executeQuery("select * from teacher");
             while (rs!= null && rs.next()) {
                    empIdChoice.add(rs.getString("empId"));
             }
         } catch (Exception eaException) {
             eaException.printStackTrace();
         }
//         name label and father name lable
//         name lable
         JLabel namelbl=new JLabel("Name");
         namelbl.setBounds(100 ,150,50,20);
         namelbl.setFont(new Font("serif",Font.BOLD,20));
         add(namelbl);
         
         name=new JLabel();
         name.setBounds(170,150,150,25);
         name.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(name);
         
//         father name label
         JLabel fatherNamelbl=new JLabel("Father Name");
         fatherNamelbl.setBounds(370 ,150,120,20);
         fatherNamelbl.setFont(new Font("serif",Font.BOLD,20));
         add(fatherNamelbl);
         
         Fathername=new JLabel();
         Fathername.setFont(new Font("Tahoma",Font.PLAIN,17));
         Fathername.setBounds(500,150,150,25);
         add(Fathername);
//         Roll and Dob lable
//         Roll number lable
         JLabel rollNolbl=new JLabel("Emp Id");
         rollNolbl.setBounds(100 ,200,80,20);
         rollNolbl.setFont(new Font("serif",Font.BOLD,20));
         add(rollNolbl);
         
         empId=new JLabel();
          
         empId.setBounds(170,199,150,25);
         empId.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(empId);
//         Dob label
         JLabel doblbl=new JLabel("Date Of Birth");
         doblbl.setBounds(370 ,200,120,20);
         doblbl.setFont(new Font("serif",Font.BOLD,20));
         add(doblbl);
         
         dcdob=new JLabel();
         dcdob.setFont( new Font("Tahome",Font.PLAIN,17) );

         dcdob.setBounds(500,200,150,25);
         add(dcdob);

//         Address label and phone lable
//         name lable
         JLabel addresslbl=new JLabel("Adress");
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
         
         aadharNo=new JLabel();
         aadharNo.setFont( new Font("Tahome",Font.PLAIN,17) );
         aadharNo.setBounds(500,300,150,25);
         add(aadharNo);
         
//         change values
         try {
             Conn conn=new Conn();
             ResultSet rs=conn.s.executeQuery("select * from teacher where empId='"+empIdChoice.getSelectedItem()+"'");
             while(rs != null && rs.next()){
                 name.setText(rs.getString("name"));
                 Fathername.setText(rs.getString("fatherName"));
                 empId.setText(rs.getString("empId"));
                 dcdob.setText(rs.getString("dob"));
                 address.setText(rs.getString("address"));
                 phone.setText(rs.getString("phone"));
                 email.setText(rs.getString("email"));
                 aadharNo.setText(rs.getString("aadharNo"));
             }
         } catch (Exception eaException) {
             eaException.printStackTrace();
         }
         empIdChoice.addItemListener(new ItemListener(){
             @Override
             public void itemStateChanged(ItemEvent ie){
                    try {
                    Conn conn=new Conn();
                    ResultSet rs=conn.s.executeQuery("select * from teacher where empId='"+empIdChoice.getSelectedItem()+"'");
                    while(rs != null && rs.next()){
                        name.setText(rs.getString("name"));
                        Fathername.setText(rs.getString("fatherName"));
                        empId.setText(rs.getString("empId"));
                        dcdob.setText(rs.getString("dob"));
                        address.setText(rs.getString("address"));
                        phone.setText(rs.getString("phone"));
                        email.setText(rs.getString("email"));
                        aadharNo.setText(rs.getString("aadharNo"));
                        }
                    } catch (Exception eaException) {
                        eaException.printStackTrace();
                    }
             }
         });
//button login
         submitButton=new JButton("Update");
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
            String empId=empIdChoice.getSelectedItem();
            String address=this.address.getText();
            String phone=this.phone.getText();
            String email=this.email.getText();
            
            try {
                String query="update teacher set address='"+address+"', phone='"+phone+"',email='"+email+"' where empId='"+empId+"'";
                
                Conn conn=new Conn();
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Succesfully");
                setVisible(false);
                
            } catch (Exception ea) {
                ea.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new UpdateTeacher();
    }
}
