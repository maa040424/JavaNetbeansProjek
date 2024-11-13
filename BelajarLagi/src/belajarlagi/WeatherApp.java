import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;

public class WeatherApp extends JFrame {
    private static final String API_KEY = "e57367f6bf9f06154278b83d65a4a557";
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    private JTextField cityField;
    private JButton checkWeatherButton, saveButton;
    private JComboBox<String> favoritesComboBox;
    private JLabel weatherLabel, iconLabel;
    private ArrayList<String> favoriteCities = new ArrayList<>();
    
    public WeatherApp() {
        setTitle("Weather Checker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Komponen GUI
        JLabel titleLabel = new JLabel("Weather Checker");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel);

        JLabel cityLabel = new JLabel("City:");
        add(cityLabel);
        
        cityField = new JTextField(15);
        add(cityField);

        checkWeatherButton = new JButton("Check Weather");
        add(checkWeatherButton);
        
        favoritesComboBox = new JComboBox<>();
        favoritesComboBox.addItem("Select favorite city");
        add(favoritesComboBox);

        weatherLabel = new JLabel("Weather: ");
        add(weatherLabel);

        iconLabel = new JLabel();
        add(iconLabel);

        saveButton = new JButton("Save Weather to CSV");
        add(saveButton);

        // Event Handlers
        checkWeatherButton.addActionListener(e -> checkWeather());
        saveButton.addActionListener(e -> saveWeatherData());
        favoritesComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED && favoritesComboBox.getSelectedIndex() > 0) {
                cityField.setText((String) favoritesComboBox.getSelectedItem());
                checkWeather();
            }
        });
    }

    // Method untuk mengecek cuaca
    private void checkWeather() {
        String city = cityField.getText();
        if (city.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a city name.");
            return;
        }

        try {
            String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric";
            HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            parseWeatherData(response.toString());

            if (!favoriteCities.contains(city)) {
                favoriteCities.add(city);
                favoritesComboBox.addItem(city);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching weather data.");
        }
    }

    // Method untuk parsing data cuaca
    private void parseWeatherData(String jsonData) throws MalformedURLException {
        JSONObject jsonObject = new JSONObject(jsonData);
        String weather = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
        String icon = jsonObject.getJSONArray("weather").getJSONObject(0).getString("icon");
        double temperature = jsonObject.getJSONObject("main").getDouble("temp");

        weatherLabel.setText("Weather: " + weather + ", Temp: " + temperature + "°C");

        // Menampilkan ikon cuaca
        String iconUrl = "http://openweathermap.org/img/wn/" + icon + "@2x.png";
        try {
            ImageIcon weatherIcon = new ImageIcon(new URL(iconUrl));
            iconLabel.setIcon(weatherIcon);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    // Method untuk menyimpan data ke CSV
    private void saveWeatherData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("weather_data.csv", true))) {
            String city = cityField.getText();
            String weather = weatherLabel.getText();
            writer.write(city + "," + weather + "\n");
            JOptionPane.showMessageDialog(this, "Weather data saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WeatherApp().setVisible(true));
    }
}
