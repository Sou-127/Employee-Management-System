package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfeducation,tffname,tfsal,tfaddress,tfphone,tfemail,tfdesignation,tfadhaar;
    JButton add,back;
    JLabel lblid;
    String EmployeeID;
    
    UpdateEmployee(String EmployeeID){
        this.EmployeeID = EmployeeID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(300,20,400,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,130,150,30);
        lblname.setFont(new Font("serif",Font.PLAIN,20));
        add(lblname);
        
        JLabel lbname = new JLabel();
        lbname.setBounds(180,130,150,30);
        add(lbname);
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(500,130,150,30);
        lblfname.setFont(new Font("serif",Font.PLAIN,20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(660,130,150,30);
        add(tffname);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(50,200,150,30);
        lbldob.setFont(new Font("serif",Font.PLAIN,20));
        add(lbldob);
        
        JLabel lbdob = new JLabel();
        lbdob.setBounds(180,200,150,30);
        add(lbdob);
        
        
        
        JLabel lblsal = new JLabel("Salary");
        lblsal.setBounds(500,200,150,30);
        lblsal.setFont(new Font("serif",Font.PLAIN,20));
        add(lblsal);
        
        tfsal = new JTextField();
        tfsal.setBounds(660,200,150,30);
        add(tfsal);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,270,150,30);
        lbladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(180,270,150,30);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500,270,150,30);
        lblphone.setFont(new Font("serif",Font.PLAIN,20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(660,270,150,30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50,340,150,30);
        lblemail.setFont(new Font("serif",Font.PLAIN,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(180,340,150,30);
        add(tfemail);
        
        JLabel lbleducation = new JLabel("Highest Education");
        lbleducation.setBounds(500,340,150,30);
        lbleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(lbleducation);
        
        
        
        tfeducation = new JTextField();
        tfeducation.setBounds(660,340,150,30);
        add(tfeducation);
        
        JLabel lbldesignation = new JLabel("Designation");
        lbldesignation.setBounds(50,410,150,30);
        lbldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(lbldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(180,410,150,30);
        add(tfdesignation);
        
        JLabel lbladhaar = new JLabel("Adhaar Number");
        lbladhaar.setBounds(500,410,150,30);
        lbladhaar.setFont(new Font("serif",Font.PLAIN,20));
        add(lbladhaar);
        
        JLabel lbadhaar= new JLabel();
        lbadhaar.setBounds(660,410,150,30);
        add(lbadhaar);
        
        JLabel lblempid = new JLabel("Employee ID");
        lblempid.setBounds(50,480,150,30);
        lblempid.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempid);
        
        lblid = new JLabel();
        lblid.setBounds(180,480,150,30);
        lblid.setFont(new Font("serif",Font.PLAIN,20));
        add(lblid);
        
        try{
            Conn c= new Conn();
            String query = "select * from employee where EmployeeID = '"+EmployeeID+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lbname.setText(rs.getString("Name"));
                tffname.setText(rs.getString("FatherName"));
                lbdob.setText(rs.getString("DateofBirth"));
                tfsal.setText(rs.getString("Salary"));
                tfaddress.setText(rs.getString("Address"));
                tfphone.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("Email"));
                tfeducation.setText(rs.getString("Education"));
                tfdesignation.setText(rs.getString("Designation"));
                lbadhaar.setText(rs.getString("AdhaarNo"));
                lblid.setText(rs.getString("EmployeeID"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
        add.setBounds(240,560,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(480,560,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
       
        
        
        
        
        setSize(900,700);
        setLocation(510,170);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==add){
           
           String fname = tffname.getText();
           String salary = tfsal.getText();
           String address = tfaddress.getText();
           String phone = tfphone.getText();
           String email = tfemail.getText();
           String education = tfeducation.getText();
           String designation = tfdesignation.getText();
           
           
           try{
               Conn conn = new Conn();
               String query = "update employee set FatherName = '"+fname+"', Salary ='"+salary+"', Address = '"+address+"', Phone = '"+phone+"', Email = '"+email+"', Education ='"+education+"', Designation = '"+designation+"' where EmployeeID = '"+EmployeeID+"'";
               conn.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Details updated successfully");
               setVisible(false);
               new Home();
           }catch(Exception e){
               e.printStackTrace();
           }
           
       }else{
           setVisible(false);
           new Home();
       }
        
    }

    
    public static void main(String[] args) {
        new UpdateEmployee("");
        
    }
    
}
