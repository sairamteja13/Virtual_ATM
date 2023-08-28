package atm_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener{

	JButton deposit,fastcash,pinchange,withdraw,ministatement,balanceenquiry,exit;
	String pinnumber;
	
	Transactions(String pinnumber){
		
		this.pinnumber=pinnumber;
		
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,800,800);
		add(image);
		
		JLabel text=new JLabel("Please Select Your Transaction");
		text.setBounds(200,300,600,40);
		text.setFont(new Font("Ariel",Font.BOLD,18));
		image.add(text);
		
		deposit=new JButton("DEPOSIT");
		deposit.setBounds(190, 392, 120, 20);
		deposit.addActionListener(this);
		image.add(deposit);
		
		fastcash=new JButton("FAST CASH");
		fastcash.setBounds(190, 418, 120, 20);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		pinchange=new JButton("PIN CHANGE");
		pinchange.setBounds(190, 443, 120, 20);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		withdraw=new JButton("CASH WITHDRAWL");
		withdraw.setBounds(335, 392, 150, 20);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		ministatement=new JButton("MINI STATEMENT");
		ministatement.setBounds(335, 418, 150, 20);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		balanceenquiry=new JButton("BALANCE ENQUIRY");
		balanceenquiry.setBounds(335, 443, 150, 20);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
	
		exit=new JButton("EXIT");
		exit.setBounds(335, 468, 150, 20);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(800,800);
		setLocation(350,10);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==exit) {
			System.exit(0);
		}else if(ae.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}else if(ae.getSource()==withdraw) {
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		}else if(ae.getSource()==fastcash) {
			setVisible(false);
			new Fastcash(pinnumber).setVisible(true);
		}else if(ae.getSource()==pinchange) {
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		}else if(ae.getSource()==balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}else if(ae.getSource()==ministatement) {
			new MiniStatement(pinnumber).setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		
	  new Transactions("");
	}

	

}
