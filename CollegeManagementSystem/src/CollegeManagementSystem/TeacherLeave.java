package CollegeManagementSystem;
import javax.swing.*;
import  java.awt.*;
import  java.sql.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class TeacherLeave extends  JFrame implements ActionListener{
        JDateChooser date;
        JButton submitButton,cancelButton;
    Choice choice,duration;
    TeacherLeave(){
           setSize(500,600);
           setLocation(400,200);
           setLayout(null);
           getContentPane().setBackground(Color.WHITE);
           
           JLabel heading=new JLabel("Apply Leave(Teacher)");
           heading.setBounds(150,10,250,80);
           heading.setFont(new Font("Tahoma",Font.BOLD,20));
           add(heading);
           
           JLabel searchlbl=new JLabel("Search By Employee Id");
           searchlbl.setBounds(50,100,200,40);
           searchlbl.setFont(new Font("Tahoma",Font.BOLD,17));
           add(searchlbl);
           
           choice=new Choice();
           choice.setBounds(250,110,150,100);
           add(choice);
           
           try {
               Conn conn=new Conn();
               ResultSet rs=conn.s.executeQuery("select * from teacher");
               while(rs!=null && rs.next()){
                   choice.add(rs.getString("empId"));
               }
            } catch (Exception eaException) {
            eaException.printStackTrace();
            }
           JLabel datelbl=new JLabel("Date");
           datelbl.setBounds(50,150,50,30);
           datelbl.setFont(new Font("Tahoma",Font.BOLD,20));
           add(datelbl);
           
            date=new JDateChooser();
            date.setBounds(50,190,150,25);
            add(date);
           
           JLabel durationlbl=new JLabel("Duration");
           durationlbl.setBounds(50,250,100,30);
           durationlbl.setFont(new Font("Tahoma",Font.BOLD,20));
           add(durationlbl);
           
           duration=new Choice();
           duration.add("Half Day");
            duration.add("Full Day");
            duration.setBounds(50,295,150,25);
            add(duration);
        //button login
         submitButton=new JButton("Submit");
        submitButton.setBounds(100,380,100,30);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        submitButton.setFont(new Font("Tahoma",Font.BOLD,13));
        add(submitButton);
        
//        cancel button
        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(220,380,100,30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.addActionListener(this);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Tahoma",Font.BOLD,13));
        add(cancelButton);   
           
           setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submitButton){
            String empId=choice.getSelectedItem();
            String date=((JTextField)this.date.getDateEditor().getUiComponent()).getText();
            String duration=this.duration.getSelectedItem();
            
            try {
                String query="insert into teacherLeave values('"+empId+"','"+date+"','"+duration+"')";
                Conn conn=new Conn();
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Allowed");
                setVisible(false);
            } catch (Exception eaException) {
                eaException.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new TeacherLeave();
    }
}
