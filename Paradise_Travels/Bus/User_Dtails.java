package Bus;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument;

import LogIn.FirstPage;


public class User_Dtails implements ActionListener
{	
	static User u;
	
	JFrame f;
	
	JLabel header,nameLabel,numberLabel,ageLabel,emailLabel,genderLabel;
	JTextField nameText,numberText,ageText,emailText;
	JComboBox genderBox;
	
	JButton nextBtn, previousBtn, logOut;
	
	User_Dtails(User a)
	{
	    u = a;
		Font font = new Font("Serif", Font.BOLD,22);
		
		f = new JFrame();

		f.setSize(900,650);
		f.setTitle("PARADISE TRAVELS - User Details");
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon logo = new ImageIcon("Bus/Picture/Logo.png");
		f.setIconImage(logo.getImage());

		ImageIcon background_image = new ImageIcon("Bus/Picture/UserDetails.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH); // Adjusted the width here as well
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 650);
        f.setContentPane(background);
		
		header = new JLabel();
        header.setText("Complete Your Information");
        header.setBounds(350, 20, 300, 50);
		header.setFont(font);
		header.setForeground(Color.RED);
        f.add(header);

        nameLabel = new JLabel("Your Full Name : ");
        nameLabel.setBounds(230, 180, 120, 50);
        f.add(nameLabel);

		nameText = new JTextField();
        nameText.setBounds(370, 190, 235, 30);
		nameText.setHorizontalAlignment(JTextField.CENTER);
		((AbstractDocument) nameText.getDocument()).setDocumentFilter(new NoNumbersFilter());
        f.add(nameText);
		
		numberLabel = new JLabel("Your Phone Number : ");
        numberLabel.setBounds(230, 220, 120, 50);
        f.add(numberLabel);

		numberText = new JTextField();
        numberText.setBounds(370, 230, 235, 30);
        numberText.setHorizontalAlignment(JTextField.CENTER);
		((AbstractDocument) numberText.getDocument()).setDocumentFilter(new NumberFilter());
        f.add(numberText);

		emailLabel = new JLabel("Email : ");
        emailLabel.setBounds(230, 250, 120, 50);
        f.add(emailLabel);

		emailText = new JTextField();
        emailText.setBounds(370, 270, 235, 30);
        emailText.setHorizontalAlignment(JTextField.CENTER);
        f.add(emailText); 
		
		String[] str = {"Male", "Female"};
		genderBox = new JComboBox(str);
		genderBox.setBounds(300, 320, 120, 30);
		genderBox.setBackground(Color.WHITE);
		f.add(genderBox);

		genderLabel = new JLabel("Gender : ");
		genderLabel.setBounds(230, 310, 120, 50);
		f.add(genderLabel);
		
		ageLabel = new JLabel("Age : ");
        ageLabel.setBounds(480, 310, 120, 50);
        f.add(ageLabel);

		ageText = new JTextField();
        ageText.setBounds(525, 320, 80, 30);
        ageText.setHorizontalAlignment(JTextField.CENTER);
		((AbstractDocument) ageText.getDocument()).setDocumentFilter(new NumberFilter());
        f.add(ageText);

		nextBtn = new JButton("Next");  
        nextBtn.setBounds(500,400,77,25);
        nextBtn.setFocusable(false);
		nextBtn.setBackground(Color.WHITE);
		nextBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nextBtn.addActionListener(this);
		f.add(nextBtn);
		
		previousBtn = new JButton("Previous");  
        previousBtn.setBounds(350,400,110,25);
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

	public boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@.*\\.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

	public void validateFields(String name, String num, String email, String age) throws ValidationException {
        if (name.isEmpty() || num.isEmpty() || email.isEmpty() || age.isEmpty()) {
            throw new ValidationException("Please provide all information.");
        }

        if (!isValidEmail(email)) {
            throw new ValidationException("Invalid email. Please provide a valid personal email.");
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
			new Ticket_Dtails(u);
		}
		else if(e.getSource()==logOut)
		{
			new FirstPage();
			f.setVisible(false);
		}
		else if (e.getSource() == nextBtn) {
            String name, number, email, age;
            name = nameText.getText();
            number = numberText.getText();
            email = emailText.getText();
            age = ageText.getText();

            try {
                validateFields(name, number, email, age);
                f.setVisible(false);
                new Payment_Dtails(u);
            } 
			catch (ValidationException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
}