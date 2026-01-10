/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author USER
 */
public class Splash extends JFrame implements ActionListener{

   Splash(){
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel heading = new JLabel("Employee Management System");
       heading.setBounds(80,30,1200,60);
       heading.setFont(new Font("serif",Font.PLAIN,60));
       heading.setForeground(Color.RED);
       add(heading);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
       Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(50,100,1050,500);
       add(image);
       
       JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
       clickhere.setBounds(400,500,300,70);
       clickhere.setBackground(Color.BLACK);
       clickhere.setForeground(Color.WHITE);
       clickhere.addActionListener(this);
       add(clickhere);
       
        setSize(1170,650);
        setLocation(400,170);
        setVisible(true);
        
    }
   public void actionPerformed(ActionEvent ae){
       setVisible(false);
       new Login();
       
   }
    public static void main(String[] args) {
        // TODO code application logic here
        new Splash();
    }
    
}

