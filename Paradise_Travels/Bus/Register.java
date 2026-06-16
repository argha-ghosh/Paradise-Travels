package Bus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register implements ActionListener {
    User u;

	JFrame f;
	
	JLabel l1,l2,l3,l4,l5;
	
	JTextField tf1, tf2;
	
	JPasswordField pf1;
	
	JButton b1, b2, b3;
	
	Register(User a)
	{
		u=a;
		
		f = new JFrame();
		
		l1 = new JLabel();
		l1.setBounds(0,0,700,500);
		
		l2 = new JLabel("");
		l2.setBounds(400, 300, 400, 20);
		
		l3 = new JLabel("Your Id");
		l3.setBounds(245,160,100,30);
		
		l4 = new JLabel("User name:");
		l4.setBounds(247,186,100,30);
		
		l5 = new JLabel("Password:");
		l5.setBounds(249, 210, 100, 30);
		
		tf1 = new JTextField();
		tf1.setBounds(326,160,160,23);
		
		tf2 = new JTextField();
		tf2.setBounds(326,186,160,23);
		
		pf1 = new JPasswordField();
		pf1.setBounds(326,210,160,23);
		
		b1 = new JButton("Pervious");  
        b1.setBounds(290,260,77,25);  
        b1.addActionListener(this);
        
        b2 = new JButton("Exit");  
        b2.setBounds(380,290,70,25);  
        b2.addActionListener(this);
        
        b3 = new JButton("Sign up");  
        b3.setBounds(380,260,137,25);  
        b3.addActionListener(this);
		
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(tf1);
		f.add(tf2);
		f.add(pf1);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(l1);
		
		f.setSize(700,500);
		f.setTitle("Register");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			new First_Page();
			f.setVisible(false);
		}
		
		if(e.getSource()==b2)
		{
			System.exit(0);
		}
		
		if(e.getSource()==b3)
		{
			
			String b = tf2.getText();
			String c = String.valueOf(pf1.getPassword());
			
			User u=null;
			
			if((b.isEmpty()!=true) && (c.isEmpty()!=true))
			{
				u = new User(b,c);
				
				if(Login.searchUser(u)!=null)
				{
					JOptionPane.showMessageDialog(null,"an user name repeated");
				}
				else
				{
					Login.addUser(u);
					f.setVisible(false);
					new Login(u);
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"Give your information");
			}
		}
	}
}
