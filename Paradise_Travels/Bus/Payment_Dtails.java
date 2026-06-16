package Bus;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument;

import LogIn.FirstPage;

public class Payment_Dtails implements ActionListener
{	
	static User u;
	
	JFrame f;
	JLabel title,numberLabel,pinLabel;
	JTextField numberText;
	JButton nextBtn, previousBtn, logOut;
	JPasswordField pinText;
	
	Payment_Dtails(User a)
	{
	    u = a;

		Font font1 = new Font("Serif", Font.BOLD,22);
		
		f = new JFrame();
		f.setSize(900,650);
		f.setTitle("PARADISE TRAVELS - Payment Details");
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon logo = new ImageIcon("Bus/Picture/Logo.png");
		f.setIconImage(logo.getImage());

		ImageIcon background_image = new ImageIcon("Bus/Picture/PaymentDetails.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH); // Adjusted the width here as well
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 650);
        f.setContentPane(background);
		
		title = new JLabel();
        title.setText("Complete Your Payment : ");
        title.setBounds(360, 20, 300, 50);
		title.setFont(font1);
		title.setForeground(Color.RED);
        f.add(title);

        numberLabel = new JLabel("Enter Your Bkash Number : ");
        numberLabel.setBounds(220, 180, 150, 50);
		numberLabel.setForeground(Color.BLACK);
        f.add(numberLabel);

		numberText = new JTextField();
        numberText.setBounds(380, 190, 180, 30);
		numberText.setHorizontalAlignment(JTextField.CENTER);
		((AbstractDocument) numberText.getDocument()).setDocumentFilter(new NumberFilter());
        f.add(numberText);
		
		pinLabel = new JLabel("Your Bkash Pin : ");
        pinLabel.setBounds(220, 220, 120, 50);
		pinLabel.setForeground(Color.BLACK);
        f.add(pinLabel);

		pinText = new JPasswordField();
        pinText.setBounds(380, 230, 180, 30);
        pinText.setHorizontalAlignment(JPasswordField.CENTER);
		((AbstractDocument) pinText.getDocument()).setDocumentFilter(new NumberFilter());
        pinText.setEchoChar('*');
        f.add(pinText);

		nextBtn = new JButton("Next");  
        nextBtn.setBounds(500,340,77,25);
		nextBtn.setFocusable(false);
		nextBtn.setBackground(Color.WHITE);
		nextBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nextBtn.addActionListener(this);
		f.add(nextBtn);
		
		previousBtn = new JButton("Previous");  
		previousBtn.setBounds(350,340,110,25);
        previousBtn.setFocusable(false);
		previousBtn.setBackground(Color.WHITE);
		previousBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		previousBtn.addActionListener(this);
		f.add(previousBtn);	

		logOut = new JButton("Logout");  
        logOut.setBounds(400,475,77,25);
		logOut.setFocusable(false);
		logOut.setBackground(Color.red);
		logOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logOut.addActionListener(this);
		f.add(logOut);
				
		f.setVisible(true);
	}

	class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message);
        }
    }

	public void validationCheck(String num, String pin) throws ValidationException{
		if (num.isEmpty() || pin.isEmpty()){
			throw new ValidationException("Please provide all information.");
		}

		if (num.length() != 11 ) {
            throw new ValidationException("Invalid phone number. Please provide a valid 11-digit phone number.");
        }
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==previousBtn)
		{
			f.setVisible(false);
			new User_Dtails(u);
		}
		else if(e.getSource()==logOut)
		{
			new FirstPage();
			f.setVisible(false);
		}
		else if(e.getSource()==nextBtn)
		{
			String num, pin;
			num = numberText.getText();
			pin = pinText.getText();

			try {
                validationCheck(num, pin);
                f.setVisible(false);
                new Final(u);
            } 
			catch (ValidationException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
		}
	}
}