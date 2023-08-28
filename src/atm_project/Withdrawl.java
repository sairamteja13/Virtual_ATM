package atm_project;

import java.awt.Font;
import java.sql.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener{
	
	JTextField amount;
	JButton withdraw,back;
	String pinnumber;
	
	Withdrawl(String pinnumber){
		
		this.pinnumber=pinnumber;
		
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,800,800);
		add(image);
		
		JLabel text=new JLabel("Enter The Amount You Want To Withdraw");
		text.setBounds(195,300,600,40);
		text.setFont(new Font("Ariel",Font.BOLD,14));
		image.add(text);
		
		amount=new JTextField();
		amount.setFont(new Font("Ariel",Font.BOLD,25));
		amount.setBounds(188, 345, 300, 30);
		image.add(amount);
		
		withdraw=new JButton("Withdraw");
		withdraw.setFont(new Font("Times new roman",Font.BOLD,18));
		withdraw.setBounds(345, 443, 135, 20);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back=new JButton("BACK");
		back.setFont(new Font("Times new roman",Font.BOLD,18));
		back.setBounds(345, 470, 135, 20);
		back.addActionListener(this);
		image.add(back);
		
		setSize(800,800);
		setLocation(350,10);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==withdraw) {
			
			String number=amount.getText();
			Date date=new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
			}else {
				
				try {
				 
					DatabaseConn conn=new DatabaseConn();
					
					ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"' ");
					
					int balance=0;
					while(rs.next()) {
						if(rs.getString("type").equals("Deposit")) {
							balance+= Integer.parseInt( rs.getString("amount"));
						}else {
							balance-= Integer.parseInt(rs.getString("amount"));
						}
					}
					
					
					if(ae.getSource()!=back && balance<Integer.parseInt(number)) {
						JOptionPane.showMessageDialog(null, "Insufficent Balance");
						return;
					}
					
					
					String query="insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+number+"')";
					conn.s.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null, "Rs "+number+" Withdraw Successfully ");
					
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
					
				}catch (Exception e){
					System.out.println(e);
				}
			}
			
		}else if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		new Withdrawl("");
	}

	

}
