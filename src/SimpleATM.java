import javax.swing.*;

public class SimpleATM {
    private static double balance = 500; // starting balance
    private static final String PIN = "1234";

    public static void main(String[] args) {
        // Ask for PIN
        String enteredPin = JOptionPane.showInputDialog("Enter PIN:");
        if (PIN.equals(enteredPin)) {
            showMenu();
        } else {
            JOptionPane.showMessageDialog(null, "Wrong PIN!");
        }
    }

    private static void showMenu() {
        String[] options = {"Check Balance", "Deposit", "Withdraw", "Exit"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose an option",
                    "ATM Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == 0) { // Check Balance
                JOptionPane.showMessageDialog(null, "Balance: $" + balance);
            } else if (choice == 1) { // Deposit
                String amt = JOptionPane.showInputDialog("Enter deposit amount:");
                if (amt != null) {
                    try {
                        balance += Double.parseDouble(amt);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid amount!");
                    }
                }
            } else if (choice == 2) { // Withdraw
                String amt = JOptionPane.showInputDialog("Enter withdraw amount:");
                if (amt != null) {
                    try {
                        double w = Double.parseDouble(amt);
                        if (w <= balance) {
                            balance -= w;
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient funds!");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid amount!");
                    }
                }
            } else { // Exit or closed
                break;
            }
        }
    }
}

