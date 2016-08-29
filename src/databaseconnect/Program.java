 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseconnect;




import edu.softwarica.dbcon.NameEntry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Toshiba
 */
public class Program {
    Scanner sc=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
     while(true){   
   try{
        NameEntry nameentry=new NameEntry();
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/newcon", "root", null);
        System.out.println("Connection Succesful");
        String sql = "INSERT INTO newtable(name,age) VALUES(?,?)";
        
        PreparedStatement pr = conn.prepareStatement(sql);
        System.out.println("Please enter name");
        nameentry.setName(sc.nextLine());
        System.out.println("Please enter the age:");
        nameentry.setAge(sc.nextInt());
        
        pr.setString(1, nameentry.getName());
        pr.setInt(2, nameentry.getAge());
        int result = pr.executeUpdate();

        System.out.println("Value Inserted");

        conn.close();
   }catch(ClassNotFoundException | SQLException is){
       System.out.println(is.getMessage());
   }
   
       
         System.out.println("Do you want to continue? [Y/N]");
         String a=sc.next();
         if(a.equalsIgnoreCase("n")){
             System.out.println("Thank You");
             System.exit(0);
         }
    }
    
}
}