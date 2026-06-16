package Admin;

import Plane.CustomSizedBasePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AdminCreateAccount extends CustomSizedBasePage implements ActionListener{
    private JFrame frame;

    private JButton createAccountButton = new JButton("Create Account");
    private JButton logInButton = new JButton("Log In");

    Font font = new Font("Arial", Font.BOLD, 25);

    JLabel name1 = new JLabel("TRAVEL AGENCY");
    JLabel name2 = new JLabel("MANAGEMENT");
    JLabel name3 = new JLabel("SYSTEM");


    JLabel firstNameLabel = new JLabel("First Name:");
    JTextField firstNameField = new JTextField(20);

    JLabel lastNameLabel = new JLabel("Last Name:");
    JTextField lastNameField = new JTextField(20);

    JLabel birthDateLabel = new JLabel("Birth Date:");
    JTextField birthDateField = new JTextField(20);

    JLabel mobileNumberLabel = new JLabel("Mobile Number:");
    JTextField mobileNumberField = new JTextField(20);

    JLabel emailLabel = new JLabel("Email:");
    JTextField emailField = new JTextField(20);

    JLabel nidLabel = new JLabel("NID Number:");
    JTextField nidField = new JTextField(20);

    JLabel passwordLabel = new JLabel("Password:");
    JPasswordField passwordField = new JPasswordField(20);

    JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
    JPasswordField confirmPasswordField = new JPasswordField(20);



    

    public AdminCreateAccount() {




        

        super("Create Account");



        

        


        name1.setFont(font);
        name2.setFont(font);
        name3.setFont(font);



        addComponent(name1,90, 160, 300, 30);
        addComponent(name2,105, 200, 300, 30);
        addComponent(name3,137, 240, 300, 30);

        addComponent(firstNameLabel,500, 90, 100, 30);

        addComponent(firstNameField,630, 90, 200, 30);
        addComponent(lastNameLabel,500, 125, 100, 30);
        addComponent(lastNameField,630, 125, 200, 30);
        addComponent(birthDateLabel,500, 160, 100, 30);
        addComponent(birthDateField,630, 160, 200, 30);
        addComponent(mobileNumberLabel,500, 195, 100, 30);
        addComponent(mobileNumberField,630, 195, 200, 30);
        addComponent(emailLabel,500, 230, 100, 30);
        addComponent(emailField,630, 230, 200, 30);
        addComponent(nidLabel,500, 265, 100, 30);
        addComponent(nidField,630, 265, 200, 30);
        addComponent(passwordLabel,500, 300, 100, 30);
        addComponent(passwordField,630, 300, 200, 30);
        addComponent(confirmPasswordLabel,500, 335, 130, 30);
        addComponent(confirmPasswordField,630, 335, 200, 30);
        addComponent(createAccountButton,498, 375, 150, 40);
        addComponent(logInButton,650, 375, 150, 40);


        show();

        logInButton.addActionListener(this);
        createAccountButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==logInButton){
            frame.setVisible(false);
            Admin adminPage = new Admin();
            
        }
        if (e.getSource() == createAccountButton) {



            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String birthDate = birthDateField.getText();
            String mobileNumber = mobileNumberField.getText();
            String email = emailField.getText();
            String nidNumber = nidField.getText();
            String password = new String(passwordField.getPassword());

            if(!isValidMobileNumber(mobileNumber)){
            JOptionPane.showMessageDialog(frame, "Invalid email or phone number. Please enter a valid phone number or email.");
                return;
            }
            if(!isValidEmail(email)){
            JOptionPane.showMessageDialog(frame, "Invalid email or phone number. Please enter a valid phone number or email.");
                return;
            }



            String userFileName = "AdminUsers.txt";

            boolean registrationSuccessful = AdminUser.registerUser(firstName, lastName, birthDate, mobileNumber, email, nidNumber, password, userFileName);

            if (registrationSuccessful) {
            JOptionPane.showMessageDialog(null, "Registration successful.");
            Admin adminPage = new Admin();
            frame.setVisible(false);
            } 
            else {
            JOptionPane.showMessageDialog(null, "Registration failed. User already exists.");
            }
        }
    }

    private boolean isValidMobileNumber(String mobileNumber) {

        if (mobileNumber.length() != 11) {

            return false;
        }
    
        for (int i = 0; i < mobileNumber.length(); i++) {

            if (!Character.isDigit(mobileNumber.charAt(i))) {

                return false;
            }
        }
        
    
        return true;

    }

    private boolean isValidEmail(String email) {
        //check "@"  "."
        return email.contains("@") && email.contains(".");
    }


}
