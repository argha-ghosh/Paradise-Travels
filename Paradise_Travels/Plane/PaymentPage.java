package Plane;

import LogIn.FirstPage;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PaymentPage extends CustomSizedBasePage implements ActionListener {
    private JLabel cardNum;
    private JLabel cardHolder;
    private JLabel cvv;
    private JTextField cardNumberField;
    private JTextField cardHolderField;
    private JTextField cvvField;
    private JButton payButton;
    private JButton previousButton;
    private JButton logoutButton;

    public PaymentPage() {
        super("PARADISE TRAVELS - Payment");

        ImageIcon background_image = new ImageIcon("Plane/Picture/PaymentPage.png");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);

        cardNum = new JLabel("Card Number : ");
        cardNum.setForeground(Color.red);
        cardNumberField = new JTextField(20);
        cardHolder = new JLabel("Card Holder : ");
        cardHolder.setForeground(Color.red);
        cardHolderField = new JTextField(20);
        cvv = new JLabel("CVV : ");
        cvv.setForeground(Color.red);
        cvvField = new JTextField(5);


        payButton = new JButton("Pay");
        payButton.setBackground(Color.white);
        payButton.setFocusable(false);
		payButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        previousButton = new JButton("Previous");
        previousButton.setBackground(Color.white);
        previousButton.setFocusable(false);
		previousButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        logoutButton = new JButton("Log out");
        logoutButton.setBackground(Color.red);
        logoutButton.setFocusable(false);
		logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));


        payButton.addActionListener(this);
        previousButton.addActionListener(this);
        logoutButton.addActionListener(this);

        addComponent(cardNum, 540, 145, 100, 30);
        addComponent(cardNumberField, 640, 145, 200, 35);
        addComponent(cardHolder, 540, 195, 100, 30);
        addComponent(cardHolderField, 640, 195, 200, 35);
        addComponent(cvv, 590, 245, 100, 30);
        addComponent(cvvField, 640, 240, 200, 35);

        addComponent(payButton, 780, 550, 100, 35);
        addComponent(previousButton,10, 550, 100, 35);
        addComponent(logoutButton, 780, 0, 100, 35);
        addComponent(background,0, 0, 900, 650);

        frame.setVisible(false);
    }

    private void validateFields() throws FieldEmptyException {
        String cardNumber = getCardNumber();
        String cardHolder = getCardHolder();
        String cvv = getCVV();

        if (cardNumber.isEmpty() || cardHolder.isEmpty() || cvv.isEmpty()) {
            throw new FieldEmptyException("Please fill in all payment fields.");
        }
    }

    public String getCardNumber() {
        return cardNumberField.getText();
    }

    public String getCardHolder() {
        return cardHolderField.getText();
    }

    public String getCVV() {
        return cvvField.getText();
    }

    public void addActionListenerToPayButton(ActionListener listener) {
        payButton.addActionListener(listener);
    }

    public void showPaymentPage() {
        frame.setVisible(true);
    }

    private boolean isValidCardNumber(String cardNumber) {
    
        for (int i = 0; i < cardNumber.length(); i++) {

            if (!Character.isDigit(cardNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidCVV(String cvvString) {
    
        for (int i = 0; i < cvvString.length(); i++) {

            if (!Character.isDigit(cvvString.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == payButton) {
            try{
                validateFields();
                String cardNumber = cardNumberField.getText();
                String cardHolder = cardHolderField.getText();
                String CVV = cvvField.getText();

                // Validate card number
                if (!isValidCardNumber(cardNumber)) {
                    JOptionPane.showMessageDialog(frame, "Invalid card number. Please enter a valid card number.");
                    return;
                }
                // Validate cvv
                if (!isValidCVV(CVV)) {
                    JOptionPane.showMessageDialog(frame, "Invalid CVV. Please enter a valid CVV.");
                    return;
                }

                JOptionPane.showMessageDialog(null, "Your ticket purchase has been successfully processed");
                frame.setVisible(false);

                FinalPage finalPage = new FinalPage();
                finalPage.showFinalPage();
            }
            catch (FieldEmptyException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Please fill up all the fields!", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == previousButton) {
            PassengerInfoPage passengerInfoPage = new PassengerInfoPage();
            passengerInfoPage.show();
            frame.setVisible(false);
        }
        if (e.getSource() == logoutButton) {
            new FirstPage();
            frame.setVisible(false);
        }
    }
}