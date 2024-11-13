
package belajarlagi;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DiskonApp extends JFrame {
    
    private JTextField hargaAsliField;
    private JTextField hasilField;
    private JTextField penghematanField;
    private JComboBox<String> diskonComboBox;
    private JSlider diskonSlider;
    private JTextField kodeKuponField;
    private JLabel riwayatLabel;
    private DiskonCalculator calculator;

    public DiskonApp() {
        calculator = new DiskonCalculator();
        initComponents();
    }

    private void initComponents() {
        setTitle("Aplikasi Perhitungan Diskon");
        setLayout(new FlowLayout());

        // Membuat label dan textfield untuk harga asli
        JLabel hargaAsliLabel = new JLabel("Harga Asli:");
        hargaAsliField = new JTextField(10);
        
        // ComboBox untuk memilih persentase diskon
        JLabel diskonLabel = new JLabel("Pilih Persentase Diskon:");
        diskonComboBox = new JComboBox<>(new String[] { "5%", "10%", "15%", "20%", "25%" });
        diskonComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                hitungDiskon();
            }
        });

        // JSlider untuk memilih persentase diskon (Alternatif ComboBox)
        diskonSlider = new JSlider(0, 100, 0);
        diskonSlider.setMajorTickSpacing(10);
        diskonSlider.setMinorTickSpacing(1);
        diskonSlider.setPaintTicks(true);
        diskonSlider.setPaintLabels(true);
        diskonSlider.addChangeListener(e -> hitungDiskon());

        // Label untuk menunjukkan hasil perhitungan
        JLabel hasilLabel = new JLabel("Harga Akhir:");
        hasilField = new JTextField(10);
        hasilField.setEditable(false);

        JLabel penghematanLabel = new JLabel("Jumlah Penghematan:");
        penghematanField = new JTextField(10);
        penghematanField.setEditable(false);

        // Input untuk kode kupon diskon tambahan
        JLabel kuponLabel = new JLabel("Kode Kupon Diskon (Optional):");
        kodeKuponField = new JTextField(10);

        // Tombol untuk menghitung diskon
        JButton hitungButton = new JButton("Hitung");
        hitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hitungDiskon();
            }
        });

        // Riwayat perhitungan diskon
        riwayatLabel = new JLabel("Riwayat Perhitungan: ");
        JButton clearButton = new JButton("Clear Riwayat");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                riwayatLabel.setText("Riwayat Perhitungan: ");
            }
        });

        // Menambahkan komponen ke JFrame
        add(hargaAsliLabel);
        add(hargaAsliField);
        add(diskonLabel);
        add(diskonComboBox);
        add(diskonSlider);
        add(hasilLabel);
        add(hasilField);
        add(penghematanLabel);
        add(penghematanField);
        add(kuponLabel);
        add(kodeKuponField);
        add(hitungButton);
        add(clearButton);
        add(riwayatLabel);

        // Mengatur ukuran dan pengaturan JFrame
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Metode untuk menghitung diskon
    private void hitungDiskon() {
        try {
            double hargaAsli = Double.parseDouble(hargaAsliField.getText());
            String diskonString = (String) diskonComboBox.getSelectedItem();
            double persenDiskon = Integer.parseInt(diskonString.replace("%", ""));
            double diskon = calculator.hitungDiskon(hargaAsli, persenDiskon);
            double hargaAkhir = calculator.hargaAkhir(hargaAsli, diskon);

            double diskonKupon = 0;
            String kupon = kodeKuponField.getText();
            if (!kupon.isEmpty()) {
                diskonKupon = 10; // Misalnya kupon diskon 10% jika kode valid
                double diskonKuponTambahan = calculator.hitungDiskonKupon(hargaAkhir, diskonKupon);
                hargaAkhir -= diskonKuponTambahan;
            }

            // Update harga akhir dan penghematan
            hasilField.setText(String.format("%.2f", hargaAkhir));
            penghematanField.setText(String.format("%.2f", diskon));

            // Menambahkan riwayat perhitungan
            riwayatLabel.setText("Riwayat Perhitungan: Harga Asli = " + hargaAsli + ", Diskon = " + diskon + ", Harga Akhir = " + hargaAkhir);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Harga harus berupa angka!");
        }
    }

    public static void main(String[] args) {
        new DiskonApp();
    }
}
