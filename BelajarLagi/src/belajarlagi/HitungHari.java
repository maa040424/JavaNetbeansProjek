
package belajarlagi;

import javax.swing.*;
import com.toedter.calendar.JCalendar;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;

public class HitungHari {
     private JComboBox<String> bulanComboBox;
    private JSpinner tahunSpinner;
    private JButton hitungButton;
    private JLabel hasilLabel;
    private JLabel infoLabel;
    private JCalendar calendar;
    
    public HitungHari() {
        // Setting up the frame
        setTitle("Aplikasi Perhitungan Hari");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));

        // ComboBox untuk bulan
        bulanComboBox = new JComboBox<>(new String[]{
                "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        });
        mainPanel.add(new JLabel("Pilih Bulan:"));
        mainPanel.add(bulanComboBox);

        // Spinner untuk tahun
        tahunSpinner = new JSpinner(new SpinnerNumberModel(Calendar.getInstance().get(Calendar.YEAR), 1900, 2100, 1));
        mainPanel.add(new JLabel("Masukkan Tahun:"));
        mainPanel.add(tahunSpinner);

        // Kalender untuk memilih tanggal
        calendar = new JCalendar();
        mainPanel.add(calendar);

        // Tombol Hitung
        hitungButton = new JButton("Hitung Hari");
        mainPanel.add(hitungButton);

        // Label untuk hasil
        hasilLabel = new JLabel("Hasil akan tampil di sini", SwingConstants.CENTER);
        infoLabel = new JLabel("", SwingConstants.CENTER);

        // Menambahkan panel dan label ke frame
        add(mainPanel, BorderLayout.NORTH);
        add(hasilLabel, BorderLayout.CENTER);
        add(infoLabel, BorderLayout.SOUTH);

        // Event listener untuk tombol Hitung
        hitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hitungHari();
            }
        });

        // Change listener untuk JSpinner
        tahunSpinner.addChangeListener(e -> hitungHari());
    }

    private void hitungHari() {
        int tahun = (int) tahunSpinner.getValue();
        int bulan = bulanComboBox.getSelectedIndex() + 1; // Index bulan mulai dari 0, jadi tambahkan 1

        // Menghitung jumlah hari dalam bulan
        YearMonth yearMonth = YearMonth.of(tahun, bulan);
        int jumlahHari = yearMonth.lengthOfMonth();

        // Mendapatkan tanggal pertama dan terakhir
        LocalDate tanggalPertama = LocalDate.of(tahun, bulan, 1);
        LocalDate tanggalTerakhir = LocalDate.of(tahun, bulan, jumlahHari);

        // Menampilkan hasil
        hasilLabel.setText("Jumlah hari di bulan ini: " + jumlahHari);
        infoLabel.setText("Hari pertama: " + tanggalPertama.getDayOfWeek() + ", Hari terakhir: " + tanggalTerakhir.getDayOfWeek());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PerhitunganHariApp app = new PerhitunganHariApp();
            app.setVisible(true);
        });
    }
    
    
    
    
    
    
    
    
    
}
