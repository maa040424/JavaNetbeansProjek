import javax.swing.JFrame;
import javax.swing.JLabel;

public class JavaGUI {
    public static void main(String[] args) {
        //Membuat Frame pada simple GUI 
        JFrame frame = new JFrame("Aplikasi GUI Pertama ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        JLabel label = new JLabel("Ini Label.");
        frame.add(label);
        frame.setVisible(true);
    }
}
