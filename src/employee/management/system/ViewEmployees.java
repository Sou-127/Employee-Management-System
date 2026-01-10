
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployees extends JFrame implements ActionListener {
    
    JTable table;
    Choice cempid;
    JButton search,print,update,back;
    ViewEmployees(){
        
        JLabel lbser = new JLabel("Search by EmployeeID");
        lbser.setBounds(20,30,150,20);
        add(lbser);
        
        cempid = new Choice();
        cempid.setBounds(170,30,150,20);
        add(cempid);
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
           
            
            
            while(rs.next()){
                cempid.add(rs.getString("EmployeeID"));
            }
            
        }catch(Exception e){
        e.printStackTrace();
    }
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
           
            
        }catch(Exception e){
        e.printStackTrace();
    }
        JScrollPane jsp = new JScrollPane(table);
            jsp.setBounds(0,100,1050,600);
            add(jsp);
            
            search = new JButton("Search");
            search.setBounds(350,30,80,20);
            search.setBackground(Color.BLACK);
            search.setForeground(Color.WHITE);
            search.addActionListener(this);
            add(search);
            
            print = new JButton("Print");
            print.setBounds(500,30,80,20);
            print.setBackground(Color.BLACK);
            print.setForeground(Color.WHITE);
            print.addActionListener(this);
            add(print);
            
            update = new JButton("Update");
            update.setBounds(650,30,80,20);
            update.setBackground(Color.BLACK);
            update.setForeground(Color.WHITE);
            update.addActionListener(this);
            add(update);
            
            back = new JButton("Back");
            back.setBounds(800,30,80,20);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.addActionListener(this);
            add(back);
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1050,700);
        setLocation(450,170);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== search){
            String query = "select * from employee where EmployeeID = '"+cempid.getSelectedItem()+"'";
            try{
               Conn c = new Conn();
               ResultSet rs = c.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()== print){
            try{
                table.print();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()== update){
            setVisible(false);
            new UpdateEmployee(cempid.getSelectedItem());
            
        }else{
            setVisible(false);
            new Home();
        }
    }

   
    public static void main(String[] args) {
        new ViewEmployees();
        
    }
    
}
