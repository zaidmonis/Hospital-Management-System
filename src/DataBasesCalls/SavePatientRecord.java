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
public class SavePatientRecord {
    Statement stm;
    public void save(int ID, String name, String dob, String contact, String bloodGroup){
        try{
            stm = DBConnect.createConnection("HospitalDB.db");
            String sql = "INSERT INTO RECORD(ID, Name, [Date of Birth], Contact, [Blood Group]) VALUES(" + ID +", \"" +name +"\", \"" +dob +"\", \"" +contact +"\", \"" +bloodGroup +"\")";
            //System.out.println(sql);
            stm.executeUpdate(sql);
        } catch(Exception e){
            System.out.println("INVALID!!!");
            System.out.println(e);
        }
        
    }
    
}
