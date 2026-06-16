package Bus;

import LogIn.*;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import LogIn.FirstPage;

public class Ticket_Dtails implements ActionListener
{	
	static User u;
	
	JFrame f;
	JLabel fromLabel,toLabel,dateLabel,busTypeLabel,passengerNoLabel,seatLabel,title;
	JComboBox fromBox,toBox,seatBox,busTypeBox,dateBox;
	JButton next,previous,logOut;
	JLabel startLabel;
	
	Ticket_Dtails(User a)
	{
	    u = a;

		Font font = new Font("Serif", Font.BOLD,22);

		f = new JFrame();

		f.setSize(900,650);
		f.setTitle("PARADISE TRAVELS - Ticket Details");
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
        title.setText("Complete Your Ticket Information");
        title.setBounds(300, 20, 400, 50);
		title.setFont(font);
		title.setForeground(Color.RED);
        f.add(title);
		
		String[] str1 = { "Dhaka", "Sylhet", "Chittagong", "Rajshahi", "Jashore" };
		fromBox = new JComboBox(str1); //from locations added
		fromBox.setBounds(350, 120, 190, 30);
		fromBox.setBackground(Color.WHITE);
		f.add(fromBox);

		fromLabel = new JLabel("From : ");
		fromLabel.setBounds(220, 120, 190, 30);
		f.add(fromLabel);
		
		String[] str2 = { "Dhaka", "Syllet", "Chittagong", "Rajshahi", "Jashore" };
		toBox = new JComboBox(str2);
		toBox.setBounds(350, 170, 190, 30);
		toBox.setBackground(Color.WHITE);
		f.add(toBox);

		toLabel = new JLabel("To : ");
		toLabel.setBounds(220, 170, 190, 30);
		f.add(toLabel);

		String[] str3 = {"9 September", "10 September", "11 September", "12 September", "13 September", "14 September", "15 September", "16 September", "17 September", "18 September"};
		dateBox = new JComboBox(str3);
		dateBox.setBounds(350, 220, 190, 30);
		dateBox.setBackground(Color.WHITE);
		f.add(dateBox);

		dateLabel = new JLabel("Date : ");
		dateLabel.setBounds(220, 220, 190, 30);
		f.add(dateLabel);

		String[] str4 = { "AC", "NON AC" };
		busTypeBox = new JComboBox(str4);
		busTypeBox.setBounds(350, 270, 190, 30);
		busTypeBox.setBackground(Color.WHITE);
		f.add(busTypeBox);

		busTypeLabel = new JLabel("Bus Type : ");
		busTypeLabel.setBounds(220, 270, 190, 30);
		f.add(busTypeLabel);
		
		String[] str5 = { "A1", "A2","A3", "A4","B1", "B3", "C1", "C2","C3", "C4","D1", "D2","D3", "D4","E1", "E2","E3", "E4","F1", "F2","F3", "F4" };
		seatBox = new JComboBox(str5);
		seatBox.setBounds(350, 320, 190, 30);
		seatBox.setBackground(Color.WHITE);
		f.add(seatBox);

		seatLabel = new JLabel(" Seat number ");
		seatLabel.setBounds(220, 320, 190, 30);
		f.add(seatLabel);

		previous = new JButton("Previous");  
        previous.setBounds(340,400,110,25);
		previous.setFocusable(false);
		previous.setBackground(Color.WHITE);
		previous.setCursor(new Cursor(Cursor.HAND_CURSOR));
		previous.addActionListener(this);	
			
		f.add(previous);
		
		next = new JButton("Next");  
        next.setBounds(465,400,77,25); 
        next.setFocusable(false);
		next.setBackground(Color.WHITE);
		next.setCursor(new Cursor(Cursor.HAND_CURSOR));
		next.addActionListener(this);

		f.add(next);
		
		logOut = new JButton("Logout");  
        logOut.setBounds(400,460,77,25);
		logOut.setFocusable(false);
		logOut.setBackground(Color.red);
		logOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logOut.addActionListener(this);

		f.add(logOut);

		f.setVisible(true);
	}
	
	public boolean validationCheck(String from, String to){
		if (from.equals(to)){
			return false;
		}
		return true;
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==previous)
		{
			f.setVisible(false);
			new User_Dashboard(u);
		}
		
		else if(e.getSource() == next)
		{
			String from, to;
			from = fromBox.getSelectedItem().toString();
			to = toBox.getSelectedItem().toString();
			if (validationCheck(from, to)==false){
				JOptionPane.showMessageDialog(null, "Please select your starting city and destination city properly");
			}
			else{
				f.setVisible(false);
				new User_Dtails(u);	
			}
		}

		else if(e.getSource()==logOut)
		{
			new FirstPage();
			f.setVisible(false);
		}
	}
}