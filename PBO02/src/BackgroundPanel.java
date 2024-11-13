
import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {

    private Image backgroundImage;

    // Constructor untuk memuat gambar
    public BackgroundPanel() {
        // Muat gambar dari resource atau file
        backgroundImage = new ImageIcon(getClass().getResource("C:\\Users\\ASUS\\Pictures\\Camera Roll")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Gambar background disesuaikan dengan ukuran panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

