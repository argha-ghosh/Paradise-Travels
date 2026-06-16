package Bus;
import LogIn.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class User_Dashboard implements ActionListener{
    static User u;
	
	JFrame f;
	
	JLabel intro, name;
	
	JButton previous, logout, bookTicket;
	
	public User_Dashboard(User a)
	{
		u = a;
		
		f = new JFrame();

		Font f1 = new Font("Serif", Font.BOLD,22);

		ImageIcon logo = new ImageIcon("Bus/Picture/Logo.png");
		f.setIconImage(logo.getImage());
		f.setSize(900,650);
		f.setTitle("PARADISE TRAVELS");
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		ImageIcon background_image = new ImageIcon("Bus/Picture/UserDetails.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(900, 650, Image.SCALE_SMOOTH); // Adjusted the width here as well
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 650);
        f.setContentPane(background);
		
		intro = new JLabel("HAPPY TO SEE YOU ");
		intro.setForeground(Color.YELLOW);
		intro.setFont(f1);
		intro.setBounds(320,176,370,23);

		name = new JLabel(a.getUserName());
		name.setForeground(Color.YELLOW);
		name.setFont(f1);
		name.setBounds(420,210,370,23);
		

		previous = new JButton("Previous");  
        previous.setBounds(290,250,110,25); 
		previous.setFocusable(false);
		previous.setBackground(Color.WHITE);
		previous.setCursor(new Cursor(Cursor.HAND_CURSOR));
		previous.addActionListener(this);
        
        logout = new JButton("Logout");  
        logout.setBounds(400,280,77,25);
		logout.setFocusable(false);
		logout.setBackground(Color.red);
		logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logout.addActionListener(this);
		
		bookTicket = new JButton("Book a Bus Ticket");  
        bookTicket.setBounds(420,250,180,25); 
		bookTicket.setFocusable(false);
		bookTicket.setBackground(Color.WHITE);
		bookTicket.setCursor(new Cursor(Cursor.HAND_CURSOR));
		bookTicket.addActionListener(this);

		f.add(previous);
		f.add(logout);
		f.add(bookTicket);
		f.add(intro);
		f.add(name);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==previous)
		{
			new SecondPage();
			f.setVisible(false);
		}
		else if(e.getSource()==logout)
		{
			new FirstPage();
			f.setVisible(false);
		}
		else if(e.getSource()==bookTicket)
		{	
			new Ticket_Dtails(u);
		    f.setVisible(false);
		}
	}

}
