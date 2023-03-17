package CollegeManagementSystem;

import javax.swing.*;
import  java.awt.*;
import  java.sql.*;
import net.proteanit.sql.DbUtils;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class TeacherLeaveDetails extends JFrame implements ActionListener{
    Choice choice;
    JTable table;
    JButton search,print,add,update,cancel;
    TeacherLeaveDetails() {
        getContentPane().setBackground(Color.WHITE);
        setSize(900,750);
        setLocation(300,100);
        setLayout(null);
        
        JLabel heading=new JLabel("Search by Employee Id");
        heading.setBounds(100,50,180,20);
        heading.setFont(new Font("serif",Font.BOLD,18));
        add(heading);
        
        choice=new Choice();
        choice.setBounds(300,50,150,20);
        add(choice);
        
        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from teacherLeave");
            while(rs != null && rs.next()){
                choice.add(rs.getString("empId"));
            }
        } catch (Exception ea) {
            ea.printStackTrace();
        }
        table=new JTable();
        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from teacherLeave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ea) {
            ea.printStackTrace();
        }
        
        JScrollPane scrollPane=new JScrollPane(table);
        scrollPane.setBounds(0,150,900,600);
        add(scrollPane);
        
        search=new JButton("Search");
        search.addActionListener(this);
        search.setBounds(70,100,100,25);
        add(search);
        
        print=new JButton("Print");
        print.addActionListener(this);
        print.setBounds(200,100,100,25);
        add(print);
        
        add=new JButton("Add");
        add.addActionListener(this);
        add.setBounds(330,100,100,25);
        add(add);
        
        update=new JButton("Update");
        update.setBounds(460,100,100,25);
        update.addActionListener(this);
        add(update);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(590,100,100,25);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==search){
            String query="select * from teacherLeave where empId='"+choice.getSelectedItem()+"'";
            try {
                Conn conn=new Conn();
                ResultSet rs=conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception eaException) {
                eaException.printStackTrace();
            }
            
        }else if(e.getSource()==print){
            try {
                table.print();
            } catch (Exception ea) {
                ea.printStackTrace();
            }
            
        }else if(e.getSource()==add){
            setVisible(false);
            new TeacherLeave();
        }else if(e.getSource()==update){
            setVisible(false);
//            new UpdateStudent();
        }else if(e.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}
