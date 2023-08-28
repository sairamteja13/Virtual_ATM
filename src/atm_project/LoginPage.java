package atm_project;

import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;



public class LoginPage extends JFrame implements ActionListener
{
	//globally defining so that we can access them in other methods
	  JButton loginbtn,clearbtn,signupbtn;
	  JTextField cardtextfield;
	  JPasswordField pintextfield;
	
	LoginPage(){  	//constructor
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("PEOPLES BANK ATM machine");
		
		setLayout(null);
		
		setSize(800,480);
		setVisible(true);
		setLocation(300,200);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.jpg"));
		Image i2=i1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		
		JLabel label=new JLabel(i3);
		label.setBounds(30,10,70,70);
		
		add(label);
		
		
		JLabel text=new JLabel("WELCOME TO ATM");
		text.setFont(new Font("Ariel",Font.BOLD,38));
		text.setBounds(140, 30, 400, 40);
		add(text);
		
		
		
		JLabel cardno=new JLabel("CARD NO:");
		cardno.setFont(new Font("Ariel",Font.BOLD,28));
		cardno.setBounds(100, 120, 300, 30);
		add(cardno);
		
		cardtextfield=new JTextField();
		cardtextfield.setBounds(300,120,300,30);
		cardtextfield.setFont(new Font("Times new roman",Font.BOLD,14));
		add(cardtextfield);
		
		
		
		JLabel pin=new JLabel("PIN:");
		pin.setFont(new Font("Ariel",Font.BOLD,28));
		pin.setBounds(100, 170, 100, 30);
		add(pin);
		
		pintextfield=new JPasswordField();
		pintextfield.setBounds(300,170,300,30);
		add(pintextfield);
		
		loginbtn=new JButton("LOG IN");
		loginbtn.setBounds(330,240,100,30);
		loginbtn.setBackground(Color.orange);
		loginbtn.setForeground(Color.white);
		add(loginbtn);
		loginbtn.addActionListener(this);
		
		clearbtn=new JButton("CLEAR");
		clearbtn.setBounds(450,240,100,30);
		clearbtn.setBackground(Color.orange);
		clearbtn.setForeground(Color.white);
		add(clearbtn);
		clearbtn.addActionListener(this);
		
		
		signupbtn=new JButton("SIGN UP");
		signupbtn.setBounds(300,300,300,30);
		signupbtn.setBackground(Color.orange);
		signupbtn.setForeground(Color.white);
		add(signupbtn);
		signupbtn.addActionListener(this);
		
		
		getContentPane().setBackground(Color.WHITE);
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==clearbtn) {
			cardtextfield.setText("");
			pintextfield.setText("");
		}
		else if(ae.getSource()==loginbtn) {
			DatabaseConn conn=new DatabaseConn();
			String cardnumber=cardtextfield.getText();
			String pinnumber=pintextfield.getText();
			String query = "select * from login where card_number = '"+cardnumber+"' and pin_number= '"+pinnumber+"'";
			
			try {
				ResultSet rs= conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect card number or pin");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
		else if(ae.getSource()==signupbtn) {
			setVisible(false);
			new Signupone().setVisible(true);
		}
	}
	
	public static void main(String[] args)
	{
		new LoginPage();
		

	}

}
