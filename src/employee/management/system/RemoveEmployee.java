
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cempid;
    JLabel lblname,lblphone,lblemail;
    JButton delete,back;
    
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempid = new JLabel("Employee ID");
        labelempid.setBounds(50,50,100,30);
        add(labelempid);
        cempid = new Choice();
        cempid.setBounds(150,53,150,30);
        add(cempid);
        
        try{
            Conn c= new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cempid.add(rs.getString("EmployeeID"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cempid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                showEmployeeDetails();
            }
        });
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        add(labelname);
        
        lblname = new JLabel();
        lblname.setBounds(150,100,150,30);
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        add(labelphone);
        
        lblphone = new JLabel();
        lblphone.setBounds(150,150,150,30);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);
        
        lblemail = new JLabel();
        lblemail.setBounds(150,200,150,30);
        add(lblemail);
        
       showEmployeeDetails();
       
       delete = new JButton("Delete");
       delete.setBounds(80,330,100,30);
       delete.setBackground(Color.BLACK);
       delete.setForeground(Color.WHITE);
       delete.addActionListener(this);
       add(delete);
       
       back = new JButton("Back");
       back.setBounds(200,330,100,30);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       back.addActionListener(this);
       add(back);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
       Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(400,0,600,400);
       add(image);
        
        setSize(1050,500);
        setLocation(450,170);
        setVisible(true);
        
    }
    public void showEmployeeDetails(){
         try{
            Conn c= new Conn();
            String query = "select * from employee where EmployeeID = '"+cempid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
               lblname.setText(rs.getString("Name"));
               lblphone.setText(rs.getString("Phone"));
               lblemail.setText(rs.getString("Email"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                Conn c = new Conn();
                String query = "delete from employee where EmployeeID = '"+cempid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Information deleted successfully");
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
        new RemoveEmployee();
    }
    
}
