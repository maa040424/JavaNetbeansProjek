
package belajarjavagui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BelajarJavaGUI {

    
    public static void main(String[] args) {
        //container
        JFrame form = new JFrame(" Aplikasi Perpustakaan ");
        //ukura form
        form.setSize(400, 550);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// membuat form bisa diberhentikan running
        form.setLocationRelativeTo(null);// form berada di tengah
        form.setLayout(null);
        form.setVisible(true);
        
        JLabel labelJudul = new JLabel("Aplikasi Perpustakan");
        labelJudul.setBounds(100, 30,150, 30);// x, y , widht, height mun kd salah
        form.add(labelJudul);
        
        JLabel labelKodeBuku = new JLabel("Kode Buku");
        labelKodeBuku.setBounds(20, 80, 150, 30);
        form.add(labelKodeBuku);
        
        JTextField txtKodeBuku = new JTextField();
        txtKodeBuku.setBounds(150, 80, 150, 30);
        form.add(txtKodeBuku);
        
    }
    
}
