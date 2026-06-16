package LogIn;

import Plane.TicketBookingPage;
import Bus.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SecondPage implements ActionListener {

    JFrame frame = new JFrame("Paradise Travels");

    JButton planeButton = new JButton("Plane");

    JButton busButton = new JButton("Bus");
    JButton previousButton = new JButton("Previous");
    JButton logoutButton = new JButton("Log out");

    Font font = new Font("Arial", Font.BOLD, 35);
    Font font2 = new Font ("Segeo UI", Font.BOLD, 25);

    JLabel name1 = new JLabel("How would you like");
    JLabel name2 = new JLabel("to embark");
    JLabel name3 = new JLabel("on your journey?");

    ImageIcon i = new ImageIcon("LogIn/Picture/Logo.png");

    public SecondPage() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 650);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(i.getImage());
        frame.setLayout(null);

        ImageIcon background_image = new ImageIcon("Login/Picture/SecondPage.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH); // Adjusted the width here as well
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 650);
        frame.setContentPane(background);

        name1.setBounds(120, 260, 300, 30);
        name2.setBounds(165, 300, 300, 30);
        name3.setBounds(137, 340, 300, 30);

        name1.setFont(font);
        name2.setFont(font);
        name3.setFont(font);

        //button customization
        planeButton.setBounds(650, 150, 200, 60);
        planeButton.setFocusable(false);
		planeButton.setBackground(Color.WHITE);
		planeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        planeButton.setFont(font2);

        busButton.setBounds(650, 350, 200, 60);
        busButton.setFocusable(false);
		busButton.setBackground(Color.WHITE);
		busButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        busButton.setFont(font2);

        previousButton.setBounds(50, 500, 100, 40);
        previousButton.setFocusable(false);
		previousButton.setBackground(Color.WHITE);
		previousButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        logoutButton.setBounds(750, 500, 100, 40); 
        logoutButton.setFocusable(false);
		logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutButton.setBackground(Color.red);
        

        frame.add(name1);
        frame.add(name2);
        frame.add(name3);

        frame.add(planeButton);
        frame.add(busButton);
        frame.add(previousButton);
        frame.add(logoutButton);

        frame.setVisible(true);

        busButton.addActionListener(this);
        planeButton.addActionListener(this);
        previousButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == busButton) {
            String userFileName = "users.txt";

            String username = UserInformation.getUsername(userFileName);
            String password = UserInformation.getPassword(userFileName);

            User u = new User(username, password);
            new User_Dashboard(u);
            frame.setVisible(false);
        }
        if (e.getSource() == planeButton) {
            TicketBookingPage ticketBookingPage = new TicketBookingPage();
            ticketBookingPage.setVisibility();
            frame.setVisible(false);
        }

        if (e.getSource() == previousButton) {
            new FirstPage();
            frame.setVisible(false);
        }
        if (e.getSource() == logoutButton) {
            FirstPage firstPage = new FirstPage();
            frame.setVisible(false);
        }
    }
}
