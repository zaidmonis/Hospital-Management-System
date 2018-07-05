/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBasesCalls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zaid
 */
public class ShowRecord {
    private Connection conn;
    private Statement stm;
    ResultSet rs;

    public ShowRecord() {
        this.conn = null;
        this.stm = null;
    }
    public void initialize(){
        try{
            stm = DBConnect.createConnection("HospitalDB.db");
            //stm.executeUpdate("CREATE TABLE IF NOT EXISTS RECORD(ID INT, Name TEXT(20), [Date of Birth] TEXT(20), Contact TEXT(20), [Blood Group] TEXT(3))");
        } catch(Exception e){
            System.out.println(e);
        }
        
    }
    public ResultSet display(String tableName){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:HospitalDB.db");
            stm = conn.createStatement();
            rs = stm.executeQuery("SELECT * FROM " + tableName);
        } catch (Exception ex) {
            Logger.getLogger(ShowRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}