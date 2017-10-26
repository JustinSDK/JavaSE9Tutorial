package cc.openhome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlite:demo.sqlite";
        try(Connection conn = DriverManager.getConnection(jdbcUrl);
            Statement statement = conn.createStatement()) {
            statement.executeUpdate(
                "CREATE TABLE messages (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL," +
                    "name TEXT NOT NULL," +
                    "email TEXT NOT NULL," + 
                    "msg TEXT NOT NULL)"
            );
            System.out.println("建立 messages 表格了");
        } catch(SQLException ex) {
            throw new RuntimeException(ex);
        }        
    }
}
