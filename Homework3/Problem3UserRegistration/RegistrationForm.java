// resources: 
// https://www.geeksforgeeks.org/java/java-jframe/
// https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame {
    private final Validator validatorChain;

    public RegistrationForm(Validator validatorChain) {
        this.validatorChain = validatorChain;

        // Create the main frame
        JFrame frame = new JFrame("Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Registration Form");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // the main panel for the form
        JPanel panel = new JPanel();

        // components
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(15);
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        JTextField phoneNumberField = new JTextField(15);
        JButton registerButton = new JButton("Register");
        JButton cancelButton = new JButton("Cancel");


        // add components to the panel
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(phoneNumberLabel);
        panel.add(phoneNumberField);
        panel.add(registerButton);
        panel.add(cancelButton);

        // add action Listener to register the user
        // this is where the validator will be used
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserRegistration user = new UserRegistration(
                    userField.getText(),
                    new String(passField.getPassword()),
                    emailField.getText(),
                    phoneNumberField.getText()
                );

                String result = validatorChain.validate(user);
                
                // validate credentials
                if (result == null) {
                    JOptionPane.showMessageDialog(frame, "Registration successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, result, "Validation Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the application
            }
        });

        // Set layout for the main frame
        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(menuBar);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}