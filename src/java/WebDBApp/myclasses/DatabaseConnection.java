/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebDBApp.myclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mathekga M. Emmanuel
 */
public class DatabaseConnection {
    
    private Connection conn;
    private  Statement st; 
    private ResultSet rs; 
 
    public DatabaseConnection()
    {
        
    }
    
    public Connection setConnection()
    {
        try{
           String url = "jdbc:mysql://localhost:3306/student?zeroDateTimeBehavior=convertToNull"; /*    ?zeroDateTimeBehavior=convertToNull */
           String user = "root";
           String pass = "abcdef";
           
           Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/student?zeroDateTimeBehavior=convertToNull",  "root", "abcdef"); 
           
        }
        
        catch(SQLException ex)
                   {
                   System.out.println(ex.toString() +  ": No Connection / Failure");
                   }
        catch(Exception ex)
        {
            System.out.println(ex.toString() +  ": No Connection / Failure");
        }
        
            return conn; 
        
    }
    
     public ResultSet searchQuery(String sql)
    {
        try{
           setConnection();
           st = conn.createStatement();
           rs = st.executeQuery(sql); 
        }
        
        catch(SQLException ex)
        {
            System.out.println(ex.toString() + ", Connection Failure");
        }
        
        return rs;
    }
     
     public ResultSet getResults(String sql, Connection conn)
     {
         this.conn = conn; 
         try
         {
             st = conn.createStatement(); 
             rs = st.executeQuery(sql); 
         }
         
         catch(Exception e )
         {
             
         }
         return rs;
     }
     
}
