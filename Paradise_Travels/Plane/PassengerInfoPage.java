package Plane;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import LogIn.FirstPage;
import LogIn.SecondPage;

public class PassengerInfoPage extends CustomSizedBasePage implements ActionListener {
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderButtonGroup;
    private JButton nextButton;
    private JButton previousButton;
    private JButton logoutButton;

    public PassengerInfoPage() {
        super("PARADISE TRAVELS - Passenger Information");

        ImageIcon background_image = new ImageIcon("Plane/Picture/PassengerInfoPage.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);

        nameField = new JTextField(20);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        genderButtonGroup =  new ButtonGroup();


        nextButton = new JButton("Next");
        nextButton.setBackground(Color.white);
        nextButton.setFocusable(false);
		nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        previousButton = new JButton("Previous");
        previousButton.setBackground(Color.white);
        previousButton.setFocusable(false);
		previousButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        logoutButton = new JButton("Logout");
        logoutButton.setBackground(Color.red);
        logoutButton.setFocusable(false);
		logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        nextButton.addActionListener(this);
        previousButton.addActionListener(this);
        logoutButton.addActionListener(this);

        
        addComponent(new JLabel("Name : "), 590, 105, 50, 30);
        addComponent(nameField, 640, 105, 200, 35);
        addComponent(new JLabel("Phone : "), 590, 155, 50, 30);
        addComponent(phoneField, 640, 150, 200, 35);
        addComponent(new JLabel("Email : "), 590, 205, 50, 30);
        addComponent(emailField, 640, 200, 200, 35);

        addComponent(new JLabel("Gender : "), 540, 250, 50, 30);
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        addComponent(maleRadioButton, 646, 250, 80, 30);
        maleRadioButton.setBackground(Color.WHITE);
        maleRadioButton.setFocusable(false);
		maleRadioButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addComponent(femaleRadioButton, 646, 280, 80, 30);
        femaleRadioButton.setBackground(Color.WHITE);
        femaleRadioButton.setFocusable(false);
		femaleRadioButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        maleRadioButton.setSelected(true);

        
        addComponent(nextButton, 780, 550, 100, 35);
        addComponent(previousButton, 10, 550, 100, 35);
        addComponent(logoutButton, 780, 0, 100, 35);
        addComponent(background,0, 0, 900, 650);

        frame.setVisible(false);
    }
    
    public boolean isMaleSelected() {
        return maleRadioButton.isSelected();
    }

    public boolean isFemaleSelected() {
        return femaleRadioButton.isSelected();
    }

    private void validateFields() throws FieldEmptyException {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();

        if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            throw new FieldEmptyException("Please fill in all required fields.");
        }
    }

    public void addActionListenerToNextButton(ActionListener listener) {
        nextButton.addActionListener(listener);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {

            try {
                validateFields(); // Check if required fields are empty
                String name = nameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                
                // Validate phone number
                if (!isValidPhoneNumber(phone)) {
                    JOptionPane.showMessageDialog(frame, "Invalid email or phone number. Please enter a valid phone number or email.");
                    return;
                }
                // Validate Email
                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(frame, "Invalid email or phone number. Please enter a valid phone number or email.");
                    return;
                }

                boolean isMale = isMaleSelected();
                boolean isFemale = isFemaleSelected();

                PaymentPage paymentPage = new PaymentPage();
                paymentPage.showPaymentPage();
                frame.setVisible(false);
            } 
            catch (FieldEmptyException ex) {
                JOptionPane.showMessageDialog(frame,  "Please fill up all the fields!"/* JOptionPane.ERROR_MESSAGE*/);
            }
            /*finally{
                JOptionPane.showMessageDialog(frame,  "All the informations are verified."/* , JOptionPane.ERROR_MESSAGE);
            }*/
        }
        if (e.getSource() == logoutButton) {
            frame.setVisible(false);
            FirstPage firstPage = new FirstPage();
            
        }
        if (e.getSource() == previousButton) {
            frame.setVisible(false);
            TicketBookingPage ticketBookingPage = new TicketBookingPage();
            ticketBookingPage.setVisibility();
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {

        if (phoneNumber.length() != 11) {
            return false;
        }
    
        for (int i = 0; i < phoneNumber.length(); i++) {

            if (!Character.isDigit(phoneNumber.charAt(i))) {
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
