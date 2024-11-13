package penjualan_app;

import java.sql.Connection;
import java.sql.SQLException;
import penjualan_app.setting.Koneksi;

public class Penjualan_App {

    public static void main(String[] args) {
        // Membuat instance dari class Koneksi
        Koneksi koneksi = new Koneksi();
        
        // Mendapatkan koneksi ke database
        Connection conn = koneksi.getKoneksi();
        
        // Jika perlu, tutup koneksi setelah selesai
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Koneksi ditutup.");
            } catch (SQLException e) {
                System.out.println("Gagal menutup koneksi: " + e.getMessage());
            }
        }
    }
}
