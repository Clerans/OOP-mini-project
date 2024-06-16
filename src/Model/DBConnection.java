
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author micha
 */
public class DBConnection {
    static Connection conn;
    static Statement stat = null;
 
     public static Statement getStatementConnection() {
    try {
 //Establish the connection
    String url = "jdbc:mysql://localhost:3306/studentdb";
    conn = DriverManager.getConnection(url, "root", "");
//Create the connection
    stat = conn.createStatement();
 
    } catch (Exception e) {
    e.printStackTrace(); 
    }
     return stat;
    }
 //Close the connection
    public static void closeCon() throws SQLException {
         conn.close();
    }
 }
