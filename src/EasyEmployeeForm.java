import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EasyEmployeeForm {
    public static void main(String[] args) {
        // Frame
        JFrame frame = new JFrame("Employee Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new BorderLayout());

        // Input panel
        JPanel panel = new JPanel(new GridLayout(4, 2));

        JTextField nameField = new JTextField();
        JTextField deptField = new JTextField();
        JTextField salaryField = new JTextField();
        JButton addButton = new JButton("Add");

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Department:"));
        panel.add(deptField);
        panel.add(new JLabel("Salary:"));
        panel.add(salaryField);
        panel.add(new JLabel()); // empty cell
        panel.add(addButton);

        // Table
        String[] cols = {"Name", "Department", "Salary"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        // Button action
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String dept = deptField.getText();
            String salary = salaryField.getText();

            if (!name.isEmpty() && !dept.isEmpty() && !salary.isEmpty()) {
                model.addRow(new Object[]{name, dept, salary});
                nameField.setText("");
                deptField.setText("");
                salaryField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Fill all fields!");
            }
        });

        // Add to frame
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
