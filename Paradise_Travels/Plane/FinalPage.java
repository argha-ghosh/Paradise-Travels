package Plane;

import LogIn.FirstPage;
import LogIn.SecondPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FinalPage extends CustomSizedBasePage implements ActionListener{
    public JButton homeButton = new JButton("Home");
    public JButton logOutButton = new JButton("Log Out");

    public FinalPage() {
    super("PARADISE TRAVELS");


    ImageIcon background_image = new ImageIcon("Plane/Picture/FinalPage.png");
    Image img = background_image.getImage();
    Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
    background_image = new ImageIcon(temp_img);
    JLabel background = new JLabel("", background_image, JLabel.CENTER);

    
    JPanel panel = new JPanel();
    panel.add(new JLabel("Thank you for booking!"));

    Font font = new Font("Arial", Font.BOLD, 25);

    JLabel instructionLabel1 = new JLabel("Instructions for Your Plane Journey!");
    instructionLabel1.setFont(font);

    JLabel instructionLabel2 = new JLabel("# Arrive at the airport at least 2 hours before your departure time.");
    JLabel instructionLabel3 = new JLabel("# Present your ID and ticket at the check-in counter.");
    JLabel instructionLabel4 = new JLabel("# Proceed to the security checkpoint after check-in.");
    JLabel instructionLabel5 = new JLabel("# Follow the boarding announcements for your flight.");
    JLabel instructionLabel6 = new JLabel("# Enjoy your journey and have a safe flight!");

    addComponent(instructionLabel1, 250, 50, 800, 30);
    addComponent(instructionLabel2, 450, 180, 800, 30);
    addComponent(instructionLabel3, 450, 210, 800, 30);
    addComponent(instructionLabel4, 450, 240, 800, 30);
    addComponent(instructionLabel5, 450, 270, 800, 30);
    addComponent(instructionLabel6, 450, 300, 800, 30);


    addComponent(homeButton, 550, 350, 100, 40);
    homeButton.setBackground(Color.white);
    homeButton.setFocusable(false);
	homeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    addComponent(logOutButton, 550, 400, 100, 40);
    logOutButton.setBackground(Color.red);
    logOutButton.setFocusable(false);
	logOutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

    addComponent(background,0, 0, 900, 650);

    homeButton.addActionListener(this);

    frame.setVisible(false);
    }

    public void showFinalPage() {
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == homeButton) {
            frame.setVisible(false);
            SecondPage secondpage = new SecondPage();

        }

        else if (e.getSource() == logOutButton) {
            new FirstPage();
            frame.setVisible(false);
        }
    }
}
