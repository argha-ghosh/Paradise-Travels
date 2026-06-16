package Admin;

import Plane.CustomSizedBasePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Admin extends CustomSizedBasePage implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton,  createAccountButton;

    public Admin() {
        super("PARADISE TRAVELS");

        ImageIcon background_image = new ImageIcon("Admin/Picture/Admin.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 650);

        // Add font for the large label
        Font labelFont = new Font("Arial", Font.BOLD, 24); // You can change the font name, style, and size
        JLabel largeLabel = new JLabel("Welcome to Admin Panel");
        largeLabel.setFont(labelFont);
        addComponent(largeLabel, 325, 50, 500, 50); // Adjust the coordinates and dimensions as needed

        Font font2 = new Font("Segeo UI", Font.BOLD, 20);
        JLabel name = new JLabel("Username : ");
        name.setFont(font2);

        JLabel pass = new JLabel("Password : ");
        pass.setFont(font2);

        addComponent(name, 200, 150, 150, 60);
        addComponent(pass, 200, 200, 150, 60);

        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        addComponent(usernameField, 330, 150, 250, 50);
        addComponent(passwordField, 330, 200, 250, 50);

        loginButton = new JButton("Login");
        createAccountButton = new JButton("Create Account");

        addComponent(loginButton, 330, 250, 250, 40);
        addComponent(createAccountButton, 330, 290, 250, 40);

        loginButton.addActionListener(this);
        createAccountButton.addActionListener(this);

        show();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {
            String enteredName = usernameField.getText();
            String enteredPassword = new String(passwordField.getPassword());

            
            int loginStatus = AdminUser.checkUser(enteredName, enteredPassword, "AdminUsers.txt");

            if (loginStatus == 1) {
                frame.setVisible(false);
                AdminCustomize adminCustomizePage = new AdminCustomize();
            } 
            else if (loginStatus == 2) {
                // Incorrect password
                JOptionPane.showMessageDialog(frame, "Incorrect password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
            } 
            else {
                // User not found
                JOptionPane.showMessageDialog(frame, "User not found. Please create an account or check your credentials.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == createAccountButton) {
            frame.setVisible(false);
            AdminCreateAccount adminCreateAccount=new AdminCreateAccount();

        }
    }
}
