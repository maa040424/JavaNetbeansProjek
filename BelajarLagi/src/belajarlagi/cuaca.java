
package belajarlagi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import org.json.*;

public class cuaca {
    private JTextField cityField;
    private JComboBox<String> cityComboBox;
    private JButton checkWeatherButton;
    private JLabel weatherIconLabel;
    private JTable weatherTable;
    private DefaultTableModel tableModel;
    
    private static final String API_KEY = "YOUR_API_KEY"; // Ganti dengan API Key Anda
    
    public WeatherApp() {
        // Setup JFrame
        setTitle("Aplikasi Cek Cuaca");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panel utama
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // Panel input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        
        cityField = new JTextField(15);
        checkWeatherButton = new JButton("Cek Cuaca");
        cityComboBox = new JComboBox<>();
        weatherIconLabel = new JLabel();
        
        inputPanel.add(new JLabel("Kota:"));
        inputPanel.add(cityField);
        inputPanel.add(checkWeatherButton);
        inputPanel.add(new JLabel("Favorit:"));
        inputPanel.add(cityComboBox);
        
        panel.add(inputPanel, BorderLayout.NORTH);
        
        // Tombol untuk cek cuaca
        checkWeatherButton.addActionListener(e -> checkWeather());
        
        // Panel cuaca
        JPanel weatherPanel = new JPanel();
        weatherPanel.add(weatherIconLabel);
        panel.add(weatherPanel, BorderLayout.CENTER);
        
        // Tabel untuk menyimpan data cuaca
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Kota");
        tableModel.addColumn("Suhu");
        tableModel.addColumn("Kondisi");
        weatherTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(weatherTable);
        panel.add(scrollPane, BorderLayout.SOUTH);
        
        // Menambahkan panel ke frame
        add(panel);
    }

    private void checkWeather() {
        String city = cityField.getText();
        if (city.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Masukkan nama kota", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String response = getWeatherData(city);
            JSONObject jsonResponse = new JSONObject(response);
            if (jsonResponse.getInt("cod") == 200) {
                JSONObject main = jsonResponse.getJSONObject("main");
                JSONArray weather = jsonResponse.getJSONArray("weather");
                String weatherCondition = weather.getJSONObject(0).getString("main");
                double temp = main.getDouble("temp") - 273.15;  // Convert Kelvin to Celsius
                
                // Tampilkan cuaca di label
                updateWeatherIcon(weatherCondition);
                
                // Update tabel dengan data baru
                tableModel.addRow(new Object[]{city, temp, weatherCondition});
                
                // Tambahkan kota ke comboBox sebagai favorit
                cityComboBox.addItem(city);
            } else {
                JOptionPane.showMessageDialog(this, "Kota tidak ditemukan", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getWeatherData(String city) throws IOException {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY;
        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }

    private void updateWeatherIcon(String condition) {
        // Update gambar berdasarkan kondisi cuaca
        String iconPath = "";
        switch (condition.toLowerCase()) {
            case "clear":
                iconPath = "/icons/sunny.png";  // Ganti dengan path gambar yang sesuai
                break;
            case "clouds":
                iconPath = "/icons/cloudy.png";
                break;
            case "rain":
                iconPath = "/icons/rainy.png";
                break;
            default:
                iconPath = "/icons/default.png";
        }
        weatherIconLabel.setIcon(new ImageIcon(getClass().getResource(iconPath)));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new cuaca().setVisible(true);
        });
    }
}
