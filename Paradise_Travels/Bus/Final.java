package Bus;

import LogIn.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Final implements ActionListener
{	
	static User u;
	
	JFrame f;
	
	JButton previousBtn, logOutBtn;
	JLabel title;
	
	Final(User a)
	{
	    u = a;
		Font font = new Font("Serif", Font.BOLD,22);
		
		f = new JFrame();
		f.setSize(900,650);
		f.setTitle("PARADISE TRAVELS");
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon logo = new ImageIcon("Bus/Picture/Logo.png");
		f.setIconImage(logo.getImage());
		
		ImageIcon background_image = new ImageIcon("Bus/Picture/Bus.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH); // Adjusted the width here as well
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 650);
        f.setContentPane(background);

		title = new JLabel();
		title.setText("Your Ticket is Booked Successfully. Happy Journey!!!");
		title.setBounds(150, 170, 600, 30);
		title.setFont(font);
		title.setHorizontalAlignment(JLabel.CENTER);
		f.add(title);
		
		previousBtn = new JButton("Previous");  
        previousBtn.setBounds(330,350,110,25);
		previousBtn.setFocusable(false);
		previousBtn.setBackground(Color.WHITE);
		previousBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		previousBtn.addActionListener(this);
		f.add(previousBtn);
		
		logOutBtn = new JButton("Logout");  
		logOutBtn.setBounds(500,350,110,25);
        logOutBtn.setFocusable(false);
		logOutBtn.setBackground(Color.red);
		logOutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logOutBtn.addActionListener(this);
		f.add(logOutBtn);
				

		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==previousBtn)
		{
			f.setVisible(false);
			new Payment_Dtails(u);
		}
		
		if(e.getSource() == logOutBtn)
		{
			new FirstPage();
			f.setVisible(false);
		}
	}
}