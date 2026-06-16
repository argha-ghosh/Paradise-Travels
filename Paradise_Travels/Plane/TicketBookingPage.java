package Plane;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import LogIn.FirstPage;
import LogIn.SecondPage;

public class TicketBookingPage extends CustomSizedBasePage implements ActionListener {
    private JComboBox<String> fromComboBox;
    private JComboBox<String> toComboBox;
    private JComboBox<String> dateComboBox;
    private JComboBox<String> classComboBox;
    private JButton nextButton;
    private JButton previousButton;
    private JButton logoutButton;

    public TicketBookingPage() {
        super("PARADISE TRAVELS - Ticket Booking");

        ImageIcon background_image = new ImageIcon("Plane/Picture/TicketBookingPage.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        
        fromComboBox = new JComboBox<>(new String[]{"Dhaka"});
        toComboBox = new JComboBox<>(new String[]{"Nepal", "Thailand", "Japan", "Bhutan", "China", "India"});
        dateComboBox = new JComboBox<>(new String[]{"9 January", "10 January", "11 January"});
        classComboBox = new JComboBox<>(new String[]{"Economy", "Business", "First Class"});


        nextButton = new JButton("Next");
        nextButton.setBackground(Color.WHITE);
        nextButton.setFocusable(false);
		nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        previousButton = new JButton("Previous");
        previousButton.setBackground(Color.WHITE);
        previousButton.setFocusable(false);
		previousButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        logoutButton = new JButton("Logout");
        logoutButton.setBackground(Color.red);
        logoutButton.setFocusable(false);
		logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        nextButton.addActionListener(this);
        previousButton.addActionListener(this);
        logoutButton.addActionListener(this);

        addComponent(new JLabel("From:"), 620, 105, 100, 30);
        addComponent(fromComboBox, 660, 105, 200, 35);

        addComponent(new JLabel("To:"), 620, 155, 100, 30);
        addComponent(toComboBox, 660, 150, 200, 35);

        addComponent(new JLabel("Date:"), 620, 205, 100, 30);
        addComponent(dateComboBox, 660, 200, 200, 35);

        addComponent(new JLabel("Class:"), 620, 250, 100, 30);
        addComponent(classComboBox, 660, 250, 200, 35);

        addComponent(nextButton, 780, 550, 100, 35);
        addComponent(previousButton, 10, 550, 100, 35);
        addComponent(logoutButton, 780, 0, 100, 35);

        addComponent(background,0, 0, 900, 650);

        frame.setVisible(false);
    }

    public String getSelectedFrom() {
        return (String) fromComboBox.getSelectedItem();
    }

    public String getSelectedTo() {
        return (String) toComboBox.getSelectedItem();
    }

    public String getSelectedDate() {
        return (String) dateComboBox.getSelectedItem();
    }

    public String getSelectedClass() {
        return (String) classComboBox.getSelectedItem();
    }

    public void addActionListenerToNextButton(ActionListener listener) {
        nextButton.addActionListener(listener);
    }

    public void setVisibility() {
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {

            String selectedFrom = getSelectedFrom();
            String selectedTo = getSelectedTo();
            String selectedClass = getSelectedClass();

            CalculateCost costCalculator = new CalculateCost(selectedFrom, selectedTo, selectedClass);
            double calculatedCost = costCalculator.calculateCost();

            JOptionPane.showMessageDialog(null, "Your calculated cost is: $" + calculatedCost);

            frame.setVisible(false);
            PassengerInfoPage passengerInfoPage = new PassengerInfoPage();
            passengerInfoPage.show();
        }
        
        if (e.getSource() == logoutButton) {
            frame.setVisible(false);
            new FirstPage();
        }

        if (e.getSource() == previousButton) {
            frame.setVisible(false);
            new SecondPage();
        }
    }  
}