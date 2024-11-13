package belajarlagi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.ArrayList;

class AgendaEntry {
    private String title;
    private String description;

    public AgendaEntry(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title;
    }
}

public class AgendaApp extends JFrame {
    private DefaultListModel<AgendaEntry> entryListModel;
    private JList<AgendaEntry> entryList;
    private JTextArea descriptionArea;
    private JTextField titleField;
    private JButton addButton, updateButton, deleteButton;

    public AgendaApp() {
        setTitle("Agenda Pribadi");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        entryListModel = new DefaultListModel<>();
        entryList = new JList<>(entryListModel);
        entryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(entryList);

        descriptionArea = new JTextArea();
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setEditable(false);
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);

        JPanel inputPanel = new JPanel(new GridLayout(2, 1));
        titleField = new JTextField();
        inputPanel.add(new JLabel("Judul:"));
        inputPanel.add(titleField);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Tambah");
        updateButton = new JButton("Ubah");
        deleteButton = new JButton("Hapus");
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(inputPanel, BorderLayout.NORTH);
        rightPanel.add(descriptionScrollPane, BorderLayout.CENTER);
        rightPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(listScrollPane, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        // Event Listener
        addButton.addActionListener(e -> addEntry());
        updateButton.addActionListener(e -> updateEntry());
        deleteButton.addActionListener(e -> deleteEntry());
        entryList.addListSelectionListener(e -> displayEntryDetails());

        setVisible(true);
    }

    private void addEntry() {
        String title = titleField.getText().trim();
        if (!title.isEmpty()) {
            AgendaEntry entry = new AgendaEntry(title, "");
            entryListModel.addElement(entry);
            titleField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Judul tidak boleh kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateEntry() {
        int selectedIndex = entryList.getSelectedIndex();
        if (selectedIndex != -1) {
            AgendaEntry entry = entryList.getSelectedValue();
            String newTitle = JOptionPane.showInputDialog(this, "Ubah Judul", entry.getTitle());
            if (newTitle != null && !newTitle.trim().isEmpty()) {
                entry.setTitle(newTitle.trim());
                entryList.repaint();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih entri yang ingin diubah", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deleteEntry() {
        int selectedIndex = entryList.getSelectedIndex();
        if (selectedIndex != -1) {
            entryListModel.remove(selectedIndex);
            descriptionArea.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Pilih entri yang ingin dihapus", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void displayEntryDetails() {
        AgendaEntry entry = entryList.getSelectedValue();
        if (entry != null) {
            descriptionArea.setText("Judul: " + entry.getTitle());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AgendaApp::new);
    }
}
