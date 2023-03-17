package CollegeManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import javax.swing.*;

public class PayFee extends JFrame implements ActionListener{
    Choice choice;
    JLabel name,Fathername,totalFee;
    JComboBox course,branch,semester;
    JButton submitButton,payFeeButton,cancelButton;
    PayFee(){
        setSize(850,600);
        setLocation(300,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);// awt
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,500,400);
        add(image);
        
        JLabel heading=new JLabel("Search by Roll No");
        heading.setBounds(20,50,200,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);
        
        choice=new Choice();
        choice.setBounds(240,65,150,40);
        add(choice);
        
        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from student");
            while(rs != null && rs.next()){
                choice.add(rs.getString("rollNo"));
            }
        } catch (Exception ea) {
            ea.printStackTrace();
        }
        
        
        
        
         JLabel namelbl=new JLabel("Name");
         namelbl.setBounds(20 ,150,50,20);
         namelbl.setFont(new Font("serif",Font.BOLD,20));
         add(namelbl);
         
         name=new JLabel();
         name.setBounds(200,150,150,25);
         name.setForeground(Color.red);
         name.setFont(new Font("Tahoma",Font.ITALIC,25));
         add(name);
         
//         father name label
         JLabel fatherNamelbl=new JLabel("Father Name");
         fatherNamelbl.setBounds(20 ,200,120,20);
         fatherNamelbl.setFont(new Font("serif",Font.BOLD,20));
         add(fatherNamelbl);
         
          Fathername=new JLabel();
          Fathername.setFont(new Font("Tahoma",Font.ITALIC,25));
          Fathername.setForeground(Color.red);
         Fathername.setBounds(200,200,150,25);
         add(Fathername);
        
        JLabel courselbl=new JLabel("Course");
         courselbl.setBounds(20 ,250,120,20);
         courselbl.setFont(new Font("serif",Font.BOLD,20));
         add(courselbl);
        
        String[] courses={"B.Tech","BCA","B.Sc","BBA","LLB","BA","M.Sc","MBA","M.Com","MA"};
        course=new JComboBox(courses);
        course.setBounds(200,250,150,25);
         add(course);
         
         JLabel branchlbl=new JLabel("Branch");
         branchlbl.setBounds(20 ,300,120,20);
         branchlbl.setFont(new Font("serif",Font.BOLD,20));
         add(branchlbl);
         
         String[] branches={"Computer Science","Physics","Chemistry","Mathematics","Physical Science"};
          branch=new JComboBox(branches);
         branch.setBounds(200,300,150,25);
         add(branch);
        
        JLabel semesterlbl=new JLabel("Semester");
         semesterlbl.setBounds(20 ,350,120,20);
         semesterlbl.setFont(new Font("serif",Font.BOLD,20));
         add(semesterlbl);
         
         String[] semesters={"sem1","sem2","sem3","sem4","sem5","sem6"};
          semester=new JComboBox(semesters);
         semester.setBounds(200,350,150,25);
         add(semester);
         
        JLabel totalFeelbl=new JLabel("Total Fee");
         totalFeelbl.setBounds(20 ,400,120,20);
         totalFeelbl.setFont(new Font("serif",Font.BOLD,20));
         add(totalFeelbl);
         
          totalFee=new JLabel();
          totalFee.setFont(new Font("Tahoma",Font.BOLD,25));
         totalFee.setBounds(200,400,150,25);
         add(totalFee);
         
         
        try {
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from student where rollNo='"+ choice.getSelectedItem()+"'");
            if(rs!=null && rs.next()){
                name.setText(rs.getString("name"));
                Fathername.setText(rs.getString("fatherName"));
            }else{
                name.setText("");
                Fathername.setText("");
            }
            
        } catch (Exception ea) {
            ea.printStackTrace();
        }
         
        choice.addItemListener(new ItemListener(){
            
            @Override
            public void itemStateChanged(ItemEvent ie){
                try {
                    Conn conn=new Conn();
                    ResultSet rs=conn.s.executeQuery("select * from student where rollNo='"+ choice.getSelectedItem()+"'");
                    if(rs!=null && rs.next()){
                        name.setText(rs.getString("name"));
                        Fathername.setText(rs.getString("fatherName"));
                    }else{
                        name.setText("");
                        Fathername.setText("");
                    }

                } catch (Exception ea) {
                    ea.printStackTrace();
                }
            }
        
        });
        submitButton=new JButton("Get Fee");
        submitButton.setBounds(150,480,100,30);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        submitButton.setFont(new Font("Tahoma",Font.BOLD,13));
        add(submitButton);
        
        payFeeButton=new JButton("Pay Fee");
        payFeeButton.setBounds(300,480,100,30);
        payFeeButton.setBackground(Color.BLACK);
        payFeeButton.setForeground(Color.WHITE);
        payFeeButton.addActionListener(this);
        payFeeButton.setFont(new Font("Tahoma",Font.BOLD,13));
        add(payFeeButton);
        
//        cancel button
        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(450,480,100,30);
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
                String query="select * from feeStructure where course='"+(String)course.getSelectedItem()+"'";
                Conn conn=new Conn();
                ResultSet rs=conn.s.executeQuery(query);
                if(rs!=null && rs.next()){
                    totalFee.setText(rs.getString((String)semester.getSelectedItem()));
                }else{
                    totalFee.setText("");
                }
                
            } catch (Exception eaException) {
                eaException.printStackTrace();
            }
        }else if(e.getSource()==payFeeButton){
            try {
                String query="insert into collegefee values ('"+(String)choice.getSelectedItem()+"','"+(String)course.getSelectedItem()+"','"+(String)branch.getSelectedItem()+"','"+(String)semester.getSelectedItem()+"','"+totalFee.getText()+"')";
                Conn conn=new Conn();
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Fee Submitted");
                
            } catch (Exception eaException) {
                eaException.printStackTrace();
            }
        }else if(e.getSource()==cancelButton){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new PayFee();
    }
}
