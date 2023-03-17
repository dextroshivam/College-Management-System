package CollegeManagementSystem;

import com.mysql.cj.jdbc.result.ResultSetFactory;
import com.mysql.cj.xdevapi.Result;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import  java.sql.*;

public class Marks extends JFrame{
    String rollNo;
    Choice semChoice;
    Marks(String rollNo) {
        setSize(500,600);
        setLocation(350,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading=new JLabel("ARSD College");
        heading.setBounds(150,10,200,35);
        heading.setFont(new Font("Tahoma",Font.BOLD,25) {
        });
        add(heading);
        
        JLabel heading2=new JLabel("Result Of Examination 2023");
        heading2.setBounds(100,80,300,35);
        heading2.setFont(new Font("Tahoma",Font.BOLD,20) {
        });
        add(heading2);
        
        JLabel rollNolbl=new JLabel("Roll No");
        rollNolbl.setBounds(50,150,80,50);
        rollNolbl.setFont(new Font("Tahoma",Font.BOLD,17) {
        });
        add(rollNolbl);
        
        JLabel rollNoVal=new JLabel(rollNo);
        rollNoVal.setBounds(150,150,200,50);
        rollNoVal.setFont(new Font("Tahoma",Font.PLAIN,17) {
        });
        add(rollNoVal);
        
        JLabel semesterlbl=new JLabel("Semester");
        semesterlbl.setBounds(50,200,80,50);
        semesterlbl.setFont(new Font("Tahoma",Font.BOLD,17) {
        });
        add(semesterlbl);
        
        semChoice=new Choice();
        semChoice.add("1st");
        semChoice.add("2nd");
        semChoice.add("3rd");
        semChoice.add("4th");
        semChoice.add("5th");
        semChoice.add("6th");
        semChoice.setBounds(150,210,150,40);
        add(semChoice);
        
        
        JLabel sub1lbl=new JLabel();
        sub1lbl.setBounds(100,250,400,50);
        sub1lbl.setFont(new Font("Tahoma",Font.BOLD,18) {
        });
        add(sub1lbl);
        
        JLabel sub2lbl=new JLabel();
        sub2lbl.setBounds(100,300,400,50);
        sub2lbl.setFont(new Font("Tahoma",Font.BOLD,18) {
        });
        add(sub2lbl);
        
        JLabel sub3lbl=new JLabel();
        sub3lbl.setBounds(100,350,400,50);
        sub3lbl.setFont(new Font("Tahoma",Font.BOLD,18) {
        });
        add(sub3lbl);
        
        JLabel sub4lbl=new JLabel();
        sub4lbl.setBounds(100,400,400,50);
        sub4lbl.setFont(new Font("Tahoma",Font.BOLD,18) {
        });
        add(sub4lbl);
        
        JLabel sub5lbl=new JLabel();
        sub5lbl.setBounds(100,450,400,50);
        sub5lbl.setFont(new Font("Tahoma",Font.BOLD,18) {
        });
        add(sub5lbl);
        
        setVisible(true);
        
        try {
            Conn conn=new Conn();
            ResultSet rs1=conn.s.executeQuery("select * from subject where semester='"+semChoice.getSelectedItem()+"'");
            if(rs1!=null && rs1.next()){
                sub1lbl.setText(rs1.getString("sub1"));
                sub2lbl.setText(rs1.getString("sub2"));
                sub3lbl.setText(rs1.getString("sub3"));
                sub4lbl.setText(rs1.getString("sub4"));
                sub5lbl.setText(rs1.getString("sub5"));
            }else{
                sub1lbl.setText("");
                sub2lbl.setText("");
                sub3lbl.setText("");
                sub4lbl.setText("");
                sub5lbl.setText("No Result Found");
            }
            ResultSet rs2=conn.s.executeQuery("select * from marks where semester='"+semChoice.getSelectedItem()+"'");
            if(rs2!=null && rs2.next()){
                sub1lbl.setText(sub1lbl.getText()+"  :  "+rs2.getString("mark1"));
                sub2lbl.setText(sub2lbl.getText()+"  :  "+rs2.getString("mark2"));
                sub3lbl.setText(sub3lbl.getText()+"  :  "+rs2.getString("mark3"));
                sub4lbl.setText(sub4lbl.getText()+"  :  "+rs2.getString("mark4"));
                sub5lbl.setText(sub5lbl.getText()+"  :  "+rs2.getString("mark5"));
                
            }else{
                sub1lbl.setText("");
                sub2lbl.setText("");
                sub3lbl.setText("");
                sub4lbl.setText("");
                sub5lbl.setText("No Result Found");
            }
        }catch (Exception eaException) {
            eaException.printStackTrace();
        }
        semChoice.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ie){
                try {
                    Conn conn=new Conn();
                    ResultSet rs1=conn.s.executeQuery("select * from subject where semester='"+semChoice.getSelectedItem()+"'");
                    if(rs1!=null && rs1.next()){
                        sub1lbl.setText(rs1.getString("sub1"));
                        sub2lbl.setText(rs1.getString("sub2"));
                        sub3lbl.setText(rs1.getString("sub3"));
                        sub4lbl.setText(rs1.getString("sub4"));
                        sub5lbl.setText(rs1.getString("sub5"));
                    } else{
                        sub1lbl.setText("");
                        sub2lbl.setText("");
                        sub3lbl.setText("");
                        sub4lbl.setText("");
                        sub5lbl.setText("No Result Found");
                    }
                    ResultSet rs2=conn.s.executeQuery("select * from marks where rollNo='"+rollNo+ "' and semester='"+semChoice.getSelectedItem()+"'");
                    if(rs2!=null && rs2.next()){
                        sub1lbl.setText(sub1lbl.getText()+"  :  "+rs2.getString("mark1"));
                        sub2lbl.setText(sub2lbl.getText()+"  :  "+rs2.getString("mark2"));
                        sub3lbl.setText(sub3lbl.getText()+"  :  "+rs2.getString("mark3"));
                        sub4lbl.setText(sub4lbl.getText()+"  :  "+rs2.getString("mark4"));
                        sub5lbl.setText(sub5lbl.getText()+"  :  "+rs2.getString("mark5"));

                    }else{
                        sub1lbl.setText("");
                        sub2lbl.setText("");
                        sub3lbl.setText("");
                        sub4lbl.setText("");
                        sub5lbl.setText("No Result Found");
                    }
                }catch (Exception eaException) {
                    eaException.printStackTrace();
                }
            }
        });
    }
    
    
    
    public static void main(String[] args) {
        new Marks("");
    }
}
