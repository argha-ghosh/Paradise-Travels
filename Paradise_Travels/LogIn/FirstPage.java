package LogIn;

import Admin.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FirstPage extends JFrame implements ActionListener {
    JButton logIn = new JButton("Log In");
    JButton createAccount = new JButton("Create Account");
    JButton adminButton = new JButton("Admin LogIn"); 

    JTextField userName = new JTextField(15);
    JPasswordField passWord = new JPasswordField(15);

    public FirstPage() {
        ImageIcon i = new ImageIcon("LogIn/Picture/Logo.png");

        setTitle("Paradise Travels");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(i.getImage());

        JLabel wlc = new JLabel("Welcome to PARADISE TRAVELS!");
        Font font = new Font("Arial", Font.BOLD, 25);
        wlc.setFont(font);
        wlc.setForeground(Color.white);

        JLabel description1 = new JLabel("Are you ready to embark on an extraordinary journey?");
        description1.setForeground(Color.white);
        JLabel description2 = new JLabel("Our Travel Agency Management System offers a world of");
        description2.setForeground(Color.white);
        JLabel description3 = new JLabel("possibilities, enabling you to explore the globe like");
        description3.setForeground(Color.white);
        JLabel description4 = new JLabel("never before. Whether you dream of soaring through the");
        description4.setForeground(Color.white);
        JLabel description5 = new JLabel("skies on a plane, embracing the scenic routes of trains,");
        description5.setForeground(Color.white);
        JLabel description6 = new JLabel("or immersing yourself in the charm of bus travel, our");
        description6.setForeground(Color.white);
        JLabel description7 = new JLabel("platform caters to all your wanderlust desires.");
        description7.setForeground(Color.white);

        Font font2 = new Font("Segeo UI", Font.BOLD, 20);
        JLabel name = new JLabel("Username : ");
        name.setForeground(Color.white);
        name.setFont(font2);
        JLabel pass = new JLabel("Password : ");
        pass.setForeground(Color.white);
        pass.setFont(font2);

        ImageIcon background_image = new ImageIcon("Login/Picture/LoginPage.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 650);

        setLayout(null);
        add(wlc);
        add(description1);
        add(description2);
        add(description3);
        add(description4);
        add(description5);
        add(description6);
        add(description7);
        add(logIn);
        add(createAccount);
        add(adminButton);

        add(name);
        add(userName);
        add(pass);
        add(passWord);
        add(background);

        wlc.setBounds(30, 20, 800, 30);
        description1.setBounds(30, 55, 850, 15);
        description2.setBounds(30, 72, 850, 15);
        description3.setBounds(30, 89, 850, 15);
        description4.setBounds(30, 106, 850, 15);
        description5.setBounds(30, 123, 850, 15);
        description6.setBounds(30, 140, 850, 15);
        description7.setBounds(30, 157, 850, 15);

        logIn.setBounds(450, 330, 140, 35);
        createAccount.setBounds(600, 330, 140, 35);
        adminButton.setBounds( 520, 380, 140, 35);

        name.setBounds(300, 220, 150, 60);
        userName.setBounds(450, 230, 280, 35);
        userName.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        pass.setBounds(300, 268, 150, 60);
        passWord.setBounds(450, 278, 280, 35);
        passWord.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        background.setBounds(0, 0, 900, 650);

        logIn.addActionListener(this);
        createAccount.addActionListener(this);
        adminButton.addActionListener(this);

        logIn.setFocusable(false);
		logIn.setBackground(Color.WHITE);
		logIn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        createAccount.setFocusable(false);
		createAccount.setBackground(Color.WHITE);
		createAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminButton.setFocusable(false);
		adminButton.setBackground(Color.WHITE);
		adminButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logIn) {
            String enteredName = userName.getText();
            String enteredPassword = new String(passWord.getPassword());

            
            int loginStatus = UserInformation.checkUser(enteredName, enteredPassword, "users.txt");

            if (loginStatus == 1) {
                // Successful
                new SecondPage();
                setVisible(false); // Hide the current frame
            } 
            else if (loginStatus == 2) {
                // Incorrect password
                JOptionPane.showMessageDialog(this, "Incorrect password. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
            } 
            else {
                // User not found
                JOptionPane.showMessageDialog(this, "User not found. Please create an account or check your credentials.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == createAccount) {
            new CreateAccount();
            setVisible(false);
        }
        if (e.getSource() == adminButton) {
            new Admin();
            setVisible(false);
        }
    }
}
