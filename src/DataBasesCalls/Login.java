/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBasesCalls;
import java.sql.*;

/**
 *
 * @author zaid
 */
public class Login {
    Statement stm;
    public void initialize(){
        stm = null;
        try{
           stm = DBConnect.createConnection("HM.db");
           stm.executeUpdate("CREATE TABLE IF NOT EXISTS LOGIN(ID TEXT(20), PASS TEXT(20))");
           ResultSet rst = stm.executeQuery("SELECT * from Login");
           int i = 0;
           while(rst.next()){
               ++i;
               System.out.println(i);
           }
           System.out.println(i);
           if(i<1){
               stm.executeUpdate("INSERT INTO LOGIN Values('Zaid', 'monis') ");
           }
           stm.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    
   public boolean checkPassword(String user, String pass){
       try{
           ResultSet rs = stm.executeQuery("SELECT * FROM LOGIN");
           while(rs.next()){
               String u = rs.getString("ID");
               String p = rs.getString("PASS");
               System.out.println("Checking...");
               System.out.println("User = " +u +"password= " +p);
               System.out.println("User = " +user +"password= " +pass);
               if(p.equals(pass) && u.equals(user)){
                   System.out.println("True");
                   return true;
               }
           }
       }catch(Exception e){
           System.out.println(e);
       }
       System.out.println("false");
       return false;
   }
}
