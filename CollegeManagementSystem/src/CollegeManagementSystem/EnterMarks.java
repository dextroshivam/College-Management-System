package CollegeManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class EnterMarks extends JFrame implements ActionListener{
    
    Choice rollNoChoice,semesterChoice;
            JButton submitButton,cancelButton;

    JTextField sub1,sub2,sub3,sub4,sub5,sub1marks,sub2marks,sub3marks,sub4marks,sub5marks;
    
    EnterMarks(){
        setSize(1300,800);
        setLocation(100,50);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(600,200,600,500);
        add(image);
        
        
         
         JLabel heading=new JLabel("Enter Student Marks");
         heading.setBounds(100,40,400,40);
         heading.setFont(new Font("serif",Font.BOLD,35));
         add(heading);
         
         JLabel chooseByRollNumlbl=new JLabel("Choose By Roll No");
         chooseByRollNumlbl.setBounds(80,200,200,40);
         chooseByRollNumlbl.setFont(new Font("serif",Font.BOLD,20));
         add(chooseByRollNumlbl);
         
         rollNoChoice=new Choice();
         rollNoChoice.setBounds(300,210,200,60);
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
         JLabel selectSemesterlbl=new JLabel("Select Semester");
         selectSemesterlbl.setBounds(80,300,200,40);
         selectSemesterlbl.setFont(new Font("serif",Font.BOLD,20));
         add(selectSemesterlbl);
         
         semesterChoice=new Choice();
         semesterChoice.setBounds(300,310,200,60);
         semesterChoice.add("1st");
         semesterChoice.add("2nd");
         semesterChoice.add("3rd");
         semesterChoice.add("4th");
         semesterChoice.add("5th");
         semesterChoice.add("6th");
         add(semesterChoice);
         
         JLabel enterSublbl=new JLabel("Enter Subject");
         enterSublbl.setBounds(80,380,150,40);
         enterSublbl.setFont(new Font("serif",Font.BOLD,22));
         add(enterSublbl);
         
         JLabel enterMarkslbl=new JLabel("Enter Marks");
         enterMarkslbl.setBounds(350,380,150,40);
         enterMarkslbl.setFont(new Font("serif",Font.BOLD,22));
         add(enterMarkslbl);

         sub1=new JTextField();
         sub1.setBounds(40,450,200,25);
         add(sub1);
         
         sub2=new JTextField();
         sub2.setBounds(40,500,200,25);
         add(sub2);
         
         sub3=new JTextField();
         sub3.setBounds(40,550,200,25);
         add(sub3);
         
         sub4=new JTextField();
         sub4.setBounds(40,600,200,25);
         add(sub4);
         
         sub5=new JTextField();
         sub5.setBounds(40,650,200,25);
         add(sub5);
         
         sub1marks=new JTextField();
         sub1marks.setBounds(300,450,200,25);
         add(sub1marks);
         
         sub2marks=new JTextField();
        sub2marks.setBounds(300,500,200,25);
         add(sub2marks);
         
         sub3marks=new JTextField();
         sub3marks.setBounds(300,550,200,25);
         add(sub3marks);
         
         sub4marks=new JTextField();
         sub4marks.setBounds(300,600,200,25);
         add(sub4marks);
         
         sub5marks=new JTextField();
         sub5marks.setBounds(300,650,200,25);
         add(sub5marks);
         
        submitButton=new JButton("Submit");
        submitButton.setBounds(150,700,100,30);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        submitButton.setFont(new Font("Tahoma",Font.BOLD,13));
        add(submitButton);
        
//        cancel button
        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(300,700,100,30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.addActionListener(this);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Tahoma",Font.BOLD,13));
        add(cancelButton); 
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submitButton){
            try {
                String query1="insert into subject values('"+rollNoChoice.getSelectedItem()+"','"+semesterChoice.getSelectedItem()+"','"+sub1.getText()+"','"+sub2.getText()+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
                String query2="insert into marks values('"+rollNoChoice.getSelectedItem()+"','"+semesterChoice.getSelectedItem()+"','"+sub1marks.getText()+"','"+sub2marks.getText()+"','"+sub3marks.getText()+"','"+sub4marks.getText()+"','"+sub5marks.getText()+"')";
                Conn conn=new Conn();
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Marks Entered Successfully");
                setVisible(false);
            } catch (Exception eaException) {
                eaException.printStackTrace();
            }
            
        }else if(e.getSource()==cancelButton){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new EnterMarks();
    }
}
