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
public class UpdateStudent extends JFrame implements ActionListener{
     
    JLabel rollno, dcdob,class10marks,class12marks,Fathername,aadharNo,name;
    JButton cancelButton,submitButton;
    JTextField email,phone,address,course,branch;
    Choice rollNoChoice;
     UpdateStudent() {
         
         setSize(900,700);
         setLocation(300,100);
         setLayout(null);
         
         JLabel heading=new JLabel("Update Student Details");
         heading.setBounds(280,40,400,40);
         heading.setFont(new Font("serif",Font.BOLD,40));
         add(heading);
         
         JLabel chooseByRollNumlbl=new JLabel("Choose By Roll No");
         chooseByRollNumlbl.setBounds(150,90,200,40);
         chooseByRollNumlbl.setFont(new Font("serif",Font.BOLD,20));
         add(chooseByRollNumlbl);
         
         rollNoChoice=new Choice();
         
         rollNoChoice.setBounds(350,100,160,60);
         add(rollNoChoice);
         
         try {
             Conn conn=new Conn();
             ResultSet rs=conn.s.executeQuery("select * from student");
             while (rs!= null && rs.next()) {
                    rollNoChoice.add(rs.getString("rollNo"));
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
         name.setFont(new Font("Tahoma",Font.PLAIN,20));
         name.setBounds(170,150,150,25);
         add(name);
         
//         father name label
         JLabel fatherNamelbl=new JLabel("Father Name");
         fatherNamelbl.setBounds(370 ,150,120,20);
         fatherNamelbl.setFont(new Font("serif",Font.BOLD,20));
         add(fatherNamelbl);
         
          Fathername=new JLabel();
         Fathername.setBounds(500,150,150,25);
         add(Fathername);
         Fathername.setFont(new Font("Tahoma",Font.PLAIN,20));
//         Roll and Dob lable
//         Roll number lable
         JLabel rollNolbl=new JLabel("Roll No");
         rollNolbl.setBounds(100 ,200,80,20);
         rollNolbl.setFont(new Font("serif",Font.BOLD,20));
         add(rollNolbl);
         
          rollno=new JLabel();
         rollno.setBounds(170,199,150,25);
         rollno.setFont( new Font("serif",Font.BOLD,20) );
         add(rollno);
//         Dob label
         JLabel doblbl=new JLabel("Date Of Birth");
         doblbl.setBounds(370 ,200,120,20);
         doblbl.setFont(new Font("serif",Font.BOLD,20));
         add(doblbl);
         
         dcdob=new JLabel();
         dcdob.setFont(new Font("Tahoma",Font.PLAIN,20));
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
         JLabel class10markslbl=new JLabel("Class X(%)");
         class10markslbl.setBounds(370 ,300,100,20);
         class10markslbl.setFont(new Font("serif",Font.BOLD,20));
         add(class10markslbl);
         

          class10marks=new JLabel();
          class10marks.setFont(new Font("Tahoma",Font.PLAIN,20));
         class10marks.setBounds(500,300,150,25);
         add(class10marks);

//         Class 12 marks label and Aadhar no. lable
//         name lable
         JLabel class12markslbl=new JLabel("ClassXII(%)");
         class12markslbl.setBounds(100 ,350,120,20);
         class12markslbl.setFont(new Font("serif",Font.BOLD,20));
         add(class12markslbl);
         
          class12marks=new JLabel();
          class12marks.setFont(new Font("Tahoma",Font.PLAIN,20));
         class12marks.setBounds(210,350,110,25);
         add(class12marks);
//         father name label
         JLabel aadharNolbl=new JLabel("Aadhar No");
         aadharNolbl.setBounds(370 ,350,100,20);
         aadharNolbl.setFont(new Font("serif",Font.BOLD,20));
         add(aadharNolbl);
         
         aadharNo=new JLabel();
         aadharNo.setFont(new Font("Tahoma",Font.PLAIN,20));
         aadharNo.setBounds(500,350,150,25);
         add(aadharNo);

//         Course label and Branch lable
//         name lable
         JLabel courselbl=new JLabel("Course");
         courselbl.setBounds(100 ,400,80,20);
         courselbl.setFont(new Font("serif",Font.BOLD,20));
         add(courselbl);
         
          course=new JTextField();
         course.setBounds(170,400,150,25);
         add(course);
//         father name label
         JLabel branchlbl=new JLabel("Branch");
         branchlbl.setBounds(370 ,400,100,20);
         branchlbl.setFont(new Font("serif",Font.BOLD,20));
         add(branchlbl);
         
          branch=new JTextField();
         branch.setBounds(500,400,150,25);
         add(branch);
         
//         change values
         try {
             Conn conn=new Conn();
             ResultSet rs=conn.s.executeQuery("select * from student where rollNo='"+rollNoChoice.getSelectedItem()+"'");
             while(rs != null && rs.next()){
                 name.setText(rs.getString("name"));
                 Fathername.setText(rs.getString("fatherName"));
                 rollno.setText(rs.getString("rollNo"));
                 dcdob.setText(rs.getString("dob"));
                 address.setText(rs.getString("address"));
                 phone.setText(rs.getString("phone"));
                 email.setText(rs.getString("email"));
                 class10marks.setText(rs.getString("class10per"));
                 class12marks.setText(rs.getString("class12per"));
                 aadharNo.setText(rs.getString("aadharNo"));
                 course.setText(rs.getString("course"));
                 branch.setText(rs.getString("branch"));
             }
         } catch (Exception eaException) {
             eaException.printStackTrace();
         }
         rollNoChoice.addItemListener(new ItemListener(){
             @Override
             public void itemStateChanged(ItemEvent ie){
                    try {
                    Conn conn=new Conn();
                    ResultSet rs=conn.s.executeQuery("select * from student where rollNo='"+rollNoChoice.getSelectedItem()+"'");
                    while(rs != null && rs.next()){
                        name.setText(rs.getString("name"));
                        Fathername.setText(rs.getString("fatherName"));
                        rollno.setText(rs.getString("rollNo"));
                        dcdob.setText(rs.getString("dob"));
                        address.setText(rs.getString("address"));
                        phone.setText(rs.getString("phone"));
                        email.setText(rs.getString("email"));
                        class10marks.setText(rs.getString("class10per"));
                        class12marks.setText(rs.getString("class12per"));
                        aadharNo.setText(rs.getString("aadharNo"));
                        course.setText(rs.getString("course"));
                        branch.setText(rs.getString("branch"));
                        }
                    } catch (Exception eaException) {
                        eaException.printStackTrace();
                    }
             }
         });
//button login
         submitButton=new JButton("Update");
        submitButton.setBounds(250,500,100,30);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        submitButton.setFont(new Font("Tahoma",Font.BOLD,13));
        add(submitButton);
        
//        cancel button
        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(400,500,100,30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.addActionListener(this);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Tahoma",Font.BOLD,13));
        add(cancelButton);
         
         
         
         setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submitButton){
            String rollNum=rollNoChoice.getSelectedItem();
            String address=this.address.getText();
            String phone=this.phone.getText();
            String email=this.email.getText();
            String course=this.course.getText();
            String branch=this.branch.getText();
            
            try {
                String query="update student set address='"+address+"', phone='"+phone+"',email='"+email+"',course='"+course+"',branch='"+branch+"' where rollNo='"+rollNum+"'";
                
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
        new UpdateStudent();
    }
}
