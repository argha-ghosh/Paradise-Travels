package LogIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CreateAccount implements ActionListener{
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



    

    public CreateAccount() {




        

        frame = new JFrame("Create Account");
        frame.setSize(900, 650);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);


        

        

        name1.setBounds(90, 160, 300, 30);
        name2.setBounds(105, 200, 300, 30);
        name3.setBounds(137, 240, 300, 30);

        name1.setFont(font);
        name2.setFont(font);
        name3.setFont(font);


        firstNameLabel.setBounds(500, 90, 100, 30);
        firstNameField.setBounds(630, 90, 200, 30);

        lastNameLabel.setBounds(500, 125, 100, 30);
        lastNameField.setBounds(630, 125, 200, 30);

        birthDateLabel.setBounds(500, 160, 100, 30);
        birthDateField.setBounds(630, 160, 200, 30);

        mobileNumberLabel.setBounds(500, 195, 100, 30);
        mobileNumberField.setBounds(630, 195, 200, 30);

        emailLabel.setBounds(500, 230, 100, 30);
        emailField.setBounds(630, 230, 200, 30);

        nidLabel.setBounds(500, 265, 100, 30);
        nidField.setBounds(630, 265, 200, 30);

        passwordLabel.setBounds(500, 300, 100, 30);
        passwordField.setBounds(630, 300, 200, 30);

        confirmPasswordLabel.setBounds(500, 335, 130, 30);
        confirmPasswordField.setBounds(630, 335, 200, 30);

        createAccountButton.setBounds(498, 375, 150, 40);
        logInButton.setBounds(650, 375, 150, 40);



        frame.add(name1);
        frame.add(name2);
        frame.add(name3);

        frame.add(firstNameLabel);

        frame.add(firstNameField);
        frame.add(lastNameLabel);
        frame.add(lastNameField);
        frame.add(birthDateLabel);
        frame.add(birthDateField);
        frame.add(mobileNumberLabel);
        frame.add(mobileNumberField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(nidLabel);
        frame.add(nidField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(confirmPasswordLabel);
        frame.add(confirmPasswordField);
        frame.add(createAccountButton);
        frame.add(logInButton);


        frame.setVisible(true);

        logInButton.addActionListener(this);
        createAccountButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {


        if(e.getSource()==logInButton){
            FirstPage firstPage = new FirstPage();
            frame.setVisible(false);
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



        String userFileName = "users.txt";
        boolean registrationSuccessful = UserInformation.registerUser(firstName, lastName, birthDate, mobileNumber, email, nidNumber, password, userFileName);

        if (registrationSuccessful) {
        JOptionPane.showMessageDialog(null, "Registration successful. Your First Name is your User Name");
        FirstPage firstPage = new FirstPage();
        } else {
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
