package CollegeManagementSystem;

import javax.swing.*;
import  java.awt.*;
import  java.sql.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddStudent extends JFrame implements ActionListener{
    JDateChooser dcdob;
    JLabel rollno;
    Random rn=new Random();
    JButton submitButton;
    JTextField email;
         JTextField class10marks;
         JTextField class12marks;
    JTextField Fathername;
    JButton cancelButton;
    JTextField aadharNo;
         JComboBox course;
         JComboBox branch;
    JTextField phone;
    JTextField address;
    JTextField name;
    long first4=Math.abs((rn.nextLong()%9000L)+1000L);
     AddStudent() {
         
         setSize(900,700);
         setLocation(300,100);
         setLayout(null);
         
         JLabel heading=new JLabel("New Student Details");
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
         JLabel rollNolbl=new JLabel("Roll No");
         rollNolbl.setBounds(100 ,200,80,20);
         rollNolbl.setFont(new Font("serif",Font.BOLD,20));
         add(rollNolbl);
         
          rollno=new JLabel("1555"+first4);
         rollno.setBounds(170,199,150,25);
         rollno.setFont( new Font("serif",Font.BOLD,20) );
         add(rollno);
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
         

          class10marks=new JTextField();
         class10marks.setBounds(500,300,150,25);
         add(class10marks);

//         Class 12 marks label and Aadhar no. lable
//         name lable
         JLabel class12markslbl=new JLabel("ClassXII(%)");
         class12markslbl.setBounds(100 ,350,120,20);
         class12markslbl.setFont(new Font("serif",Font.BOLD,20));
         add(class12markslbl);
         
          class12marks=new JTextField();
         class12marks.setBounds(210,350,110,25);
         add(class12marks);
//         father name label
         JLabel aadharNolbl=new JLabel("Aadhar No");
         aadharNolbl.setBounds(370 ,350,100,20);
         aadharNolbl.setFont(new Font("serif",Font.BOLD,20));
         add(aadharNolbl);
         
         aadharNo=new JTextField();
         aadharNo.setBounds(500,350,150,25);
         add(aadharNo);

//         Course label and Branch lable
//         name lable
         JLabel courselbl=new JLabel("Course");
         courselbl.setBounds(100 ,400,80,20);
         courselbl.setFont(new Font("serif",Font.BOLD,20));
         add(courselbl);
         
        String[] courses={"B.Tech","BCA","B.Sc","BBA","LLB","BA","M.Sc","MBA","M.Com","MA"};
          course=new JComboBox(courses);
         course.setBounds(170,400,150,25);
         add(course);
//         father name label
         JLabel branchlbl=new JLabel("Branch");
         branchlbl.setBounds(370 ,400,100,20);
         branchlbl.setFont(new Font("serif",Font.BOLD,20));
         add(branchlbl);
         
        String[] branches={"Computer Science","Physics","Chemistry","Mathematics","Physical Science"};
        branch=new JComboBox(branches);
         branch.setBounds(500,400,150,25);
         add(branch);
         
//button login
         submitButton=new JButton("Submit");
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
            String name=this.name.getText();
            String fatherName=Fathername.getText();
            String rollNum="1555"+rollno.getText();
            String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address=this.address.getText();
            String phone=this.phone.getText();
            String email=this.email.getText();
            String class10per=class10marks.getText();
            String class12per=class12marks.getText();
            String aadharNo=this.aadharNo.getText();
            String course=(String)this.course.getSelectedItem();
            String branch=(String)this.branch.getSelectedItem();
            
            try {
                String query="insert into student(name,fatherName,rollNo,dob,address,phone,email,class10per,class12per,aadharNo,course,branch"
                        + ") values ('"+name+"','"+fatherName+"','"+rollNum+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+class10per
                        +"','"+class12per+ "','"+ aadharNo+ "','"+course+"','"+branch+"')";
                Conn conn=new Conn();
                conn.s.executeUpdate(query);
                System.out.println("Student enrolled");
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
                
            } catch (Exception ea) {
                ea.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddStudent();
    }
}
