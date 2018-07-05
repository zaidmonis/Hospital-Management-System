/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBasesCalls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author zaid
 */
public class DBConnect {
    private static Connection conn;
    private static Statement stm;
    public static Statement createConnection(String dbName){
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" +dbName);
            stm = conn.createStatement();
        }
        catch(Exception e){
            System.out.println("Unable to Create Connection to SQLite Database");
            System.out.println(e);
        }
        return stm;
    }
    public static void createDB(String dbName){
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" +dbName);
            stm = conn.createStatement();
        }
        catch(Exception e){
            System.out.println("Unable to Create Connection to SQLite Database");
            System.out.println(e);
        }
    }
}
