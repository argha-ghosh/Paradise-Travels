package Admin;

import Plane.CustomSizedBasePage;
import LogIn.FirstPage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PlaneCustomize extends CustomSizedBasePage implements ActionListener {
    private JLabel fromLabel, toLabel, className, date;
    private JTextField fromTextField, toTextField,classNameField,dateField;
    private JButton homeButton, addButton;

    public PlaneCustomize() {
        super("Plane Customization");

        ImageIcon background_image = new ImageIcon("Admin/Picture/PlaneCustomize.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 650);

        fromLabel = new JLabel("From:");
        toLabel = new JLabel("To:");
        className = new JLabel("Class:");
        date = new JLabel("Date");

        addComponent(fromLabel, 50, 150, 80, 30);
        addComponent(toLabel, 50, 200, 80, 30);
        addComponent(className, 50, 250, 80, 30);
        addComponent(date, 50, 300, 80, 30);


        fromTextField = new JTextField();
        toTextField = new JTextField();
        classNameField = new JTextField();
        dateField = new JTextField();

        addComponent(fromTextField, 140, 150, 200, 30);
        addComponent(toTextField, 140, 200, 200, 30);
        addComponent(classNameField, 140, 250, 200, 30);
        addComponent(dateField, 140, 300, 200, 30);


        homeButton = new JButton("Home");
        addButton = new JButton("Add");
        addComponent(homeButton, 140, 350, 100, 30);
        addComponent(addButton, 250, 350, 100, 30);


        homeButton.addActionListener(this);
        addButton.addActionListener(this);

        displaySavedDestinations();

        show();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeButton) {
            FirstPage firstPage = new FirstPage();
            frame.setVisible(false);

        } 
        else if (e.getSource() == addButton) {
            String from = fromTextField.getText();
            String to = toTextField.getText();
            String className = classNameField.getText();
            String date = dateField.getText();
            PlaneDestination.saveToFile(from, to , className , date);


            fromTextField.setText("");
            toTextField.setText("");
            classNameField.setText("");
            dateField.setText("");

            PlaneCustomize planeCustomize=new PlaneCustomize();
            frame.setVisible(false);
        }
    }

    private void displaySavedDestinations() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("PlaneDestination.txt"));
            StringBuilder destinations = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 4) {
                    String from = parts[0];
                    String to = parts[1];
                    String className = parts[2];
                    String date = parts[3];
                    
                    destinations.append("From: ").append(from)
                            .append(" | To: ").append(to)
                            .append(" | Class: ").append(className)
                            .append(" | Date: ").append(date)
                            .append("\n");
                }
            }

            reader.close();

            JTextArea destinationsTextArea = new JTextArea(destinations.toString());
            destinationsTextArea.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(destinationsTextArea);
            
            addComponent(scrollPane,400, 150, 400, 300);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
