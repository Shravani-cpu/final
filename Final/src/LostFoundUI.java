package shravani;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class LostFoundUI extends JFrame {

    private JTextField nameField, placeField;
    private JComboBox<String> statusBox;
    private JTable table;
    private DefaultTableModel model;
    private ItemDAO dao;

    public LostFoundUI() {
        dao = new ItemDAOImpl();

        setTitle("Lost & Found System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Top Panel (Form)
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        panel.add(new JLabel("Item Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Place:"));
        placeField = new JTextField();
        panel.add(placeField);

        panel.add(new JLabel("Status:"));
        statusBox = new JComboBox<>(new String[]{"LOST", "FOUND"});
        panel.add(statusBox);

        JButton addBtn = new JButton("Add Item");
        panel.add(addBtn);

        JButton viewBtn = new JButton("View Items");
        panel.add(viewBtn);

        add(panel, BorderLayout.NORTH);

        // Table
        model = new DefaultTableModel(new String[]{"ID", "Name", "Place", "Status"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Button Actions
        addBtn.addActionListener(e -> addItem());
        viewBtn.addActionListener(e -> viewItems());

        setVisible(true);
    }

    private void addItem() {
        String name = nameField.getText();
        String place = placeField.getText();
        String status = statusBox.getSelectedItem().toString();

        if (name.isEmpty() || place.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        dao.addItem(new Item(name, place, status));
        JOptionPane.showMessageDialog(this, "Item Added!");

        nameField.setText("");
        placeField.setText("");
    }

    private void viewItems() {
        String status = statusBox.getSelectedItem().toString();
        List<Item> items = dao.viewItems(status);

        model.setRowCount(0); // clear table

        for (Item i : items) {
            model.addRow(new Object[]{
                    i.getId(),
                    i.getName(),
                    i.getPlace(),
                    i.getStatus()
            });
        }
    }

    public static void main(String[] args) {
        new LostFoundUI();
    }
}