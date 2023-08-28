package atm_project;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	String pinnumber;
	JButton back;
	
	BalanceEnquiry(String pinnumber){
		this.pinnumber=pinnumber;
		
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,800,800);
		add(image);
		
		JLabel text=new JLabel("KNOW YOUR BALANCE");
		text.setBounds(238, 305, 600, 20);
		text.setFont(new Font("Ariel",Font.BOLD,18));
		image.add(text);
		
		back=new JButton("BACK");
		back.setFont(new Font("Times new roman",Font.BOLD,18));
		back.setBounds(350, 460, 125, 25);
		back.addActionListener(this);
		image.add(back);
		
		
		DatabaseConn c=new DatabaseConn();
		int balance=0;
		
		try {
			ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"' ");
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance+= Integer.parseInt( rs.getString("amount"));
				}else {
					balance-= Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel baltext=new JLabel("Current Account Balance is Rs "+ balance);
		baltext.setBounds(190, 350, 600, 20);
		baltext.setFont(new Font("Ariel",Font.BOLD,16));
		image.add(baltext);
		
		setSize(800,800);
		setLocation(350,10);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new BalanceEnquiry("");

	}



}
