import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BankBalanceApp {

    public double balance = 0.0;
    public JLabel balanceLabel;
    public JTextField depositField;
    public JTextField withdrawField;
    public JButton depositButton;
    public JButton withdrawButton;
    public JButton displayButton;

    public BankBalanceApp() {
        JFrame frame = new JFrame("Bank Balance Application");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));
        balanceLabel = new JLabel("Balance: " + balance);
        depositField = new JTextField(10);
        withdrawField = new JTextField(10);
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        displayButton = new JButton("Display Balance");

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double depositAmount = Double.parseDouble(depositField.getText());
                    balance += depositAmount;
                    updateBalanceLabel();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input for deposit amount.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double withdrawAmount = Double.parseDouble(withdrawField.getText());
                    if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        updateBalanceLabel();
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient funds.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input ford withdraw amount.");
                }
            }
        });
        panel.add(balanceLabel);
        panel.add(depositField);
        panel.add(withdrawField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(displayButton);
    }
    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: " + balance);
    }
        public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BankBalanceApp().setVisible(true);
            }
        });
    }

    private void setVisible(boolean b) {
    }
}





