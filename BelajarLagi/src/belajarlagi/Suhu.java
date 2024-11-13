
package belajarlagi;

import javax.swing.*;
import java.awt.event.*;

public class Suhu extends JFrame {
    private JTextField inputField;
    private JLabel labelInput, labelOutput, resultLabel;
    private JButton btnConvert;
    private JRadioButton rbCtoF, rbFtoC, rbCtoR, rbCtoK;
    private ButtonGroup conversionGroup;

    // Objek KonversiSuhu sebagai model
    private KonversiSuhu konversiModel;

    public KonversiSuhuView() {
        setTitle("Aplikasi Konversi Suhu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        konversiModel = new KonversiSuhu(); // Inisialisasi model konversi

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Label dan Input Field
        labelInput = new JLabel("Masukkan Suhu:");
        labelInput.setBounds(20, 20, 100, 25);
        panel.add(labelInput);

        inputField = new JTextField(10);
        inputField.setBounds(130, 20, 100, 25);
        panel.add(inputField);

        // KeyAdapter untuk membatasi input angka saja
        inputField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume(); // Hanya angka dan titik yang diperbolehkan
                }
            }
        });

        // Opsi Konversi
        rbCtoF = new JRadioButton("Celcius ke Fahrenheit");
        rbCtoF.setBounds(20, 60, 150, 25);
        rbFtoC = new JRadioButton("Fahrenheit ke Celcius");
        rbFtoC.setBounds(20, 90, 150, 25);
        rbCtoR = new JRadioButton("Celcius ke Reamur");
        rbCtoR.setBounds(180, 60, 150, 25);
        rbCtoK = new JRadioButton("Celcius ke Kelvin");
        rbCtoK.setBounds(180, 90, 150, 25);

        // Group RadioButton
        conversionGroup = new ButtonGroup();
        conversionGroup.add(rbCtoF);
        conversionGroup.add(rbFtoC);
        conversionGroup.add(rbCtoR);
        conversionGroup.add(rbCtoK);

        panel.add(rbCtoF);
        panel.add(rbFtoC);
        panel.add(rbCtoR);
        panel.add(rbCtoK);

        // Tombol Konversi
        btnConvert = new JButton("Konversi");
        btnConvert.setBounds(130, 130, 100, 25);
        panel.add(btnConvert);

        // Label untuk Hasil
        labelOutput = new JLabel("Hasil Konversi:");
        labelOutput.setBounds(20, 170, 100, 25);
        panel.add(labelOutput);

        resultLabel = new JLabel("");
        resultLabel.setBounds(130, 170, 200, 25);
        panel.add(resultLabel);

        // Event Listener untuk Tombol Konversi
        btnConvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performConversion();
            }
        });

        add(panel);
    }

    // Metode untuk mengonversi suhu dan menampilkan hasilnya
    private void performConversion() {
        String inputText = inputField.getText();

        // Validasi input
        if (inputText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan nilai suhu!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double suhu = Double.parseDouble(inputText);
            konversiModel.setSuhuInput(suhu); // Set suhu pada model

            // Tentukan jenis konversi berdasarkan pilihan radio button
            if (rbCtoF.isSelected()) {
                konversiModel.setJenisKonversi("Celcius ke Fahrenheit");
            } else if (rbFtoC.isSelected()) {
                konversiModel.setJenisKonversi("Fahrenheit ke Celcius");
            } else if (rbCtoR.isSelected()) {
                konversiModel.setJenisKonversi("Celcius ke Reamur");
            } else if (rbCtoK.isSelected()) {
                konversiModel.setJenisKonversi("Celcius ke Kelvin");
            } else {
                JOptionPane.showMessageDialog(this, "Pilih jenis konversi terlebih dahulu!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Lakukan konversi suhu menggunakan model
            double hasil = konversiModel.konversiSuhu();
            resultLabel.setText(String.format("%.2f", hasil));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main Method untuk menjalankan aplikasi
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new KonversiSuhuView().setVisible(true);
            }
        });
    }
}
