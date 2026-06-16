package Admin;

import Plane.CustomSizedBasePage;
import LogIn.FirstPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AdminCustomize extends CustomSizedBasePage implements ActionListener {
    public JButton planeButton, busButton, homeButton;
    public JLabel titleLabel;

    public AdminCustomize() {
        super("Admin Customization");
        Font font = new Font("Arial", Font.BOLD, 24);

        ImageIcon background_image = new ImageIcon("Admin/Picture/AdminCustomize.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 650);

        titleLabel = new JLabel("What do you want to customize?");
        titleLabel.setFont(font);
        addComponent(titleLabel, 280, 50, 500, 50);

        planeButton = new JButton("Plane");
        busButton = new JButton("Bus");
        homeButton = new JButton("Home");

        addComponent(planeButton, 330, 150, 250, 50);
        addComponent(busButton, 330, 200, 250, 50);
        addComponent(homeButton, 330, 250, 250, 35);



        planeButton.addActionListener(this);
        busButton.addActionListener(this);
        homeButton.addActionListener(this);

        show();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == planeButton) {
            PlaneCustomize planeCustomizePage = new PlaneCustomize();
            frame.setVisible(false);
        } else if (e.getSource() == busButton) {



            // Handle Bus customization


            
        } else if (e.getSource() == homeButton) {
            FirstPage firstPage = new FirstPage();
            frame.setVisible(false);
        }
    }
}
