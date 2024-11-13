package penjualan_app.setting;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException; // Import SQLException
import java.util.logging.Level;
import java.util.logging.Logger;

public class Koneksi {
    // Membuat variable yang mengarah ke database penjualan_app
    public  static String DB = "jdbc:mysql://localhost/penjualan_app";
    
    // Function untuk konek ke database
    public static Connection getKoneksi() {
        Connection conn = null;
        MysqlDataSource data = new MysqlDataSource();
        data.setUser("root");
        data.setPassword("");
        data.setUrl(DB);
        
        try {
            conn = data.getConnection();
            System.out.println("Koneksi berhasil ke database: " + DB); // Pesan koneksi berhasil
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage()); // Pesan koneksi gagal
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return conn; // Mengembalikan objek Connection
    }
}
