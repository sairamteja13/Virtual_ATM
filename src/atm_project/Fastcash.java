package atm_project;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{

	JButton rs100,rs500,rs1000,rs2000,rs5000,rs10000,back;
	String pinnumber;
	
	Fastcash(String pinnumber){
		
		this.pinnumber=pinnumber;
		
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,800,800);
		add(image);
		
		JLabel text=new JLabel("Please Select Withdraw cash");
		text.setBounds(200,300,600,40);
		text.setFont(new Font("Ariel",Font.BOLD,18));
		image.add(text);
		
		rs100=new JButton("Rs 100");
		rs100.setBounds(190, 392, 120, 20);
		rs100.addActionListener(this);
		image.add(rs100);
		
		rs500=new JButton("Rs 500");
		rs500.setBounds(190, 418, 120, 20);
		rs500.addActionListener(this);
		image.add(rs500);
		
		rs1000=new JButton("Rs 1000");
		rs1000.setBounds(190, 443, 120, 20);
		rs1000.addActionListener(this);
		image.add(rs1000);
		
		rs2000=new JButton("Rs 2000");
		rs2000.setBounds(335, 392, 150, 20);
		rs2000.addActionListener(this);
		image.add(rs2000);
		
		rs5000=new JButton("Rs 5000");
		rs5000.setBounds(335, 418, 150, 20);
		rs5000.addActionListener(this);
		image.add(rs5000);
		
		rs10000=new JButton("Rs 10000");
		rs10000.setBounds(335, 443, 150, 20);
		rs10000.addActionListener(this);
		image.add(rs10000);
	
		back=new JButton("BACK");
		back.setBounds(335, 468, 150, 20);
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
		
		if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}else  {
			String amount= ((JButton)ae.getSource()).getText().substring(3);
			DatabaseConn c=new DatabaseConn();
			try {
				
				ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"' ");
				int balance=0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance+= Integer.parseInt( rs.getString("amount"));
					}else {
						balance-= Integer.parseInt(rs.getString("amount"));
					}
				}
				
				if(ae.getSource()!=back && balance<Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficent Balance");
					return;
				}
				
				Date date=new Date();
				
				String query="insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl' , '"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Successfully");
				
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
				
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
	  new Fastcash("");
	}

	

}
