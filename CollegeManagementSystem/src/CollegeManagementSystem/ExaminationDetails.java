package CollegeManagementSystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import  net.proteanit.sql.DbUtils;

public class ExaminationDetails extends JFrame implements ActionListener{
    JTextField rollNo;
    JButton submitButton,cancelButton;
    JTable table;
    ExaminationDetails() {
        setSize(900,500);
        setLocation(300,200);
        setLayout( null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel heading=new JLabel("Check Result");
        heading.setBounds(100,20,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,25) {
        });
        add(heading);
        
        JLabel rollNolbl=new JLabel("Roll No");
        rollNolbl.setBounds(20,105,80,20);
        rollNolbl.setFont(new Font("Tahoma",Font.BOLD,20) {
        });
        add(rollNolbl);
        
        
        rollNo=new JTextField();
        rollNo.setBounds(120,100,150,30);
        add(rollNo);
        
        
        
        submitButton=new JButton("Check Result");
        submitButton.setBounds(300,100,150,30);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        submitButton.setFont(new Font("Tahoma",Font.BOLD,13));
        add(submitButton);
        
//        cancel button
        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(500,100,100,30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.addActionListener(this);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Tahoma",Font.BOLD,13));
        add(cancelButton);
        
        JLabel selectStudentlbl=new JLabel("Select Student for Roll No");
        selectStudentlbl.setBounds(20,135,200,10);
        selectStudentlbl.setFont(new Font("Tahoma",Font.BOLD,12) {
        });
        add(selectStudentlbl);
        
        
        table=new JTable();
        table.setFont(new Font("Tahome",Font.PLAIN,15) {
        });
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,150,900,315);
        add(jsp);
        
        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception eaException) {
            eaException.printStackTrace();
        }
        
        table.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                int row=table.getSelectedRow();
                rollNo.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });
        
        
        
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submitButton){
            setVisible(false);
            new Marks(rollNo.getText());
        }else if(e.getSource()==cancelButton){
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new ExaminationDetails();
    }
}
