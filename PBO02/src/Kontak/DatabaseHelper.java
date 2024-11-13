
package Kontak;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseHelper {
    private static Connection conn;
    
    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                String url = "jdbc:sqlite:kontak.db"; // pastikan file `kontak.db` berada di path proyek atau tentukan path absolut
                conn = DriverManager.getConnection(url);
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
        return conn;
    }
}
