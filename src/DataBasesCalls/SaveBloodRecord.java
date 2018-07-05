/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBasesCalls;

import java.sql.Statement;

/**
 *
 * @author zaid
 */
public class SaveBloodRecord {
    Statement stm;
    public void save(String name, int age, String contact, String address, String date, String bloodGroup){
        try{
            stm = DBConnect.createConnection("HospitalDB.db");
            String sql = "INSERT INTO BloodRecord(name, age, contact, address, date, [blood group]) VALUES(\"" +name +"\", " +age +", \"" +contact +"\", \"" +address +"\", \"" +date +"\", \"" +bloodGroup +"\")";
            System.out.println(sql);
            stm.executeUpdate(sql);
        } catch(Exception e){
            System.out.println("INVALID!!!");
            System.out.println(e);
        }
        
    }
}
