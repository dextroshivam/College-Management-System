package CollegeManagementSystem;

import  javax.swing.*;
import  java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends  JFrame{
    JTable table;
    FeeStructure(){
        setSize(900,600);
        setLocation(300,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading=new JLabel("Fee Structure");
        heading.setBounds(30,10,200,35);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        table=new JTable();
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,50,900,512);
        add(jsp);
        
        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from feeStructure");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception eaException) {
            eaException.printStackTrace();
        }
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new FeeStructure();
    }
}
