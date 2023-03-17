
package CollegeManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Project extends JFrame implements ActionListener{
    Project(){
        setSize(1550,900);
        // bg image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);// awt
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        // menu bar
        JMenuBar mb=new JMenuBar();
//        new infor
        JMenu newInfo=new JMenu("New Information");
        newInfo.setForeground(Color.BLUE);
        mb.add(newInfo);
        
   
        JMenuItem facultyinfo=new JMenuItem("New Faculty Information");
        facultyinfo.setBackground(Color.WHITE);
        facultyinfo.addActionListener(this);
        newInfo.add(facultyinfo);
        
        JMenuItem studentinfo=new JMenuItem("New Student Information");
        studentinfo.setBackground(Color.WHITE);
        studentinfo.addActionListener(this);
        newInfo.add(studentinfo);
        
//        view details
        JMenu details=new JMenu("View Details");
        details.setForeground(Color.BLUE);
        mb.add(details);
        
        
        JMenuItem facultydetails=new JMenuItem("Faculty Details");
        facultydetails.addActionListener(this);
        facultydetails.setBackground(Color.WHITE);
        details.add(facultydetails);
        
        JMenuItem studentdetails=new JMenuItem("Student Details");
        studentdetails.addActionListener(this);
        studentdetails.setBackground(Color.WHITE);
        details.add(studentdetails);
//        leave
        JMenu leave=new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        
        
        JMenuItem facultyleave=new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        JMenuItem studentleave=new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);
        
//        leave details
        JMenu leaveDetails=new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLUE);
        mb.add(leaveDetails);
        
        
        JMenuItem facultyleaveDetails=new JMenuItem("Faculty Leave Details");
        facultyleaveDetails.addActionListener(this);
        facultyleaveDetails.setBackground(Color.WHITE);
        leaveDetails.add(facultyleaveDetails);
        
        JMenuItem studentleaveDetails=new JMenuItem("Student Leave Details");
        studentleaveDetails.addActionListener(this);
        studentleaveDetails.setBackground(Color.WHITE);
        leaveDetails.add(studentleaveDetails);
        
//        Exam
        JMenu exam=new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);
        
        
        JMenuItem examResults=new JMenuItem("Exam Results");
        examResults.addActionListener(this);
        examResults.setBackground(Color.WHITE);
        exam.add(examResults);
        
        JMenuItem enterMarks=new JMenuItem("Enter Student Marks");
        enterMarks.addActionListener(this);
        enterMarks.setBackground(Color.WHITE);
        exam.add(enterMarks);
        
//        Update Details
        JMenu update=new JMenu("Update Details");
        update.setForeground(Color.BLUE);
        mb.add(update);
        
        
        JMenuItem updateStudentDetails=new JMenuItem("Update Student Details");
        updateStudentDetails.addActionListener(this);
        updateStudentDetails.setBackground(Color.WHITE);
        update.add(updateStudentDetails);
        
        JMenuItem updateFacultyDetails=new JMenuItem("Update Faculty Details");
        updateFacultyDetails.addActionListener(this);
        updateFacultyDetails.setBackground(Color.WHITE);
        update.add(updateFacultyDetails);
        
//        fee
        JMenu fee=new JMenu("Fee");
        fee.setForeground(Color.BLUE);
        mb.add(fee);
        
        
        JMenuItem feeStructure=new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);
        
        JMenuItem payFee=new JMenuItem("Pay Fee");
        payFee.addActionListener(this);
        payFee.setBackground(Color.WHITE);
        fee.add(payFee);

//        about
        JMenu about=new JMenu("About");
                about.setForeground(Color.BLUE);

        about.addActionListener(this);
        mb.add(about);
        
        
        JMenuItem aboutProject=new JMenuItem("About Project");
        aboutProject.setBackground(Color.WHITE);
        aboutProject.addActionListener(this);
        about.add(aboutProject);

        
//        utility
        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility);
        
        
        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calc=new JMenuItem("Calculator");
        calc.addActionListener(this);
        calc.setBackground(Color.WHITE);
        utility.add(calc);

//        exit
        JMenu exit=new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        mb.add(exit);
        
        
        JMenuItem ex=new JMenuItem("Exit");
        ex.addActionListener(this);
        ex.setBackground(Color.WHITE);
        exit.add(ex);
        

        
        
        
        
        setJMenuBar(mb);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String msg=e.getActionCommand();
        if(msg.equals("Exit")){
            setVisible(false);
        }else if(msg.equals("Calculator")){
            try{
            Runtime.getRuntime().exec("calc.exe");
                
            }catch(Exception ae){
                
            }
        }else if(msg.equals("Notepad")){
            try{
                            Runtime.getRuntime().exec("notepad.exe");

            }catch (Exception ae){
                
            }
        }else if(msg.equals("New Faculty Information")){
            new AddTeacher();
        }else if(msg.equals("New Student Information")){
            new AddStudent();
        }else if(msg.equals("Faculty Details")){
            new TeacherDetails();    
        }else if(msg.equals("Student Details")){
            new StudentDetails();
        }else if (msg.equals("Faculty Leave")) {
            new TeacherLeave();
        }else if(msg.equals("Student Leave")){
            new StudentLeave();
        }else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        }else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        }else if(msg.equals("Enter Student Marks")){
            new EnterMarks();
        }else if(msg.equals("Exam Results")){
            new ExaminationDetails();
        }else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }else if(msg.equals("About Project")){
            new About();
        }else if(msg.equals("Pay Fee")){
            new PayFee();
        }
    }
    public static void main(String[] args) {
        new Project();
    }
}
