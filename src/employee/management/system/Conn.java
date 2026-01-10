package employee.management.system;
import java.sql.*;

public class Conn {
    public Connection c;
    public Statement s;
    
    public Conn(){
        
        try{
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","Sou@1234");
            s = c.createStatement();
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }

   
    public static void main(String[] args) {
        
    }
    
}
