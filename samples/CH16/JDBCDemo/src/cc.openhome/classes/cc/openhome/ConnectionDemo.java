package cc.openhome;

import static java.lang.System.out;
import java.sql.*;

public class ConnectionDemo {
    public static void main(String[] args)
                              throws ClassNotFoundException, SQLException {
        String jdbcUrl = "jdbc:sqlite:demo.sqlite";
        try(Connection conn = 
                DriverManager.getConnection(jdbcUrl)) {
            out.printf("已%s資料庫連線%n", 
                    conn.isClosed() ? "關閉" : "開啟");
        } 
    }
}
