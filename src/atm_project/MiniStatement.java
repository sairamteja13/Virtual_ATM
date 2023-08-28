package atm_project;

import java.awt.*;
import java.sql.*;
import javax.swing.*;


public class MiniStatement extends JFrame{
	
	String pinnumber;
	
	MiniStatement(String pinnumber){
		
		this.pinnumber=pinnumber;
		
		setTitle("MINI STATEMENT");
		setLayout(null);
		
		
		
		
		JLabel bank=new JLabel("PEOPLE'S BANK");
		bank.setBounds(110,20,200,20);
		bank.setFont(new Font("Raleway",Font.BOLD,18));
		add(bank);
		
		JLabel card=new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);
		
		JLabel mini=new JLabel();
		add(mini);
		
		JLabel balance=new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		try {
			
			DatabaseConn conn=new DatabaseConn();
			ResultSet rs=conn.s.executeQuery("select * from login where pin_number='"+pinnumber+"'");
			while(rs.next()) {
				card.setText("Card Number: "+rs.getString("card_number").substring(0,4)+"-XXXX-XXXX-"+rs.getString("card_number").substring(12));
				
				
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		try {
			
			DatabaseConn conn=new DatabaseConn();
			int bal=0;
			
			ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
			
			while(rs.next()) {
				
				mini.setText(mini.getText()+ "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html> ");
				
				if(rs.getString("type").equals("Deposit")) {
					bal+= Integer.parseInt( rs.getString("amount"));
				}else {
					bal-= Integer.parseInt(rs.getString("amount"));
				}
			}
			
			balance.setText("Your current account balance is "+bal);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		mini.setBounds(20, 140, 400, 200);
		setSize(400,600);
		setLocation(150,60);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MiniStatement("");

	}

}
