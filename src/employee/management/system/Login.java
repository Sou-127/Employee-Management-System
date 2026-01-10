
package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JTextField tfusername,tfpassword;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("USERNAME");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(40,50,150,30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("PASSWORD");
        lblpassword.setBounds(40,90,100,30);
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(40,120,150,30);
        add(tfpassword);
        
        JButton login = new JButton("LOGIN");
        login.setBounds(220,180,130,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360,0,200,200);
        add(image);
        
        setSize(600,300);
        setLocation(600,290);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String username = tfusername.getText();
            String password = tfpassword.getText();
            Conn c = new Conn();
            
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
            }else{
                JOptionPane.showMessageDialog(null,"Invalid Username of password");
                setVisible(false);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    
    public static void main(String[] args) {
        new Login();
       
    }
    
}
