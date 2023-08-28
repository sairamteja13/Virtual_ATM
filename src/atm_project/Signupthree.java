package atm_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signupthree extends JFrame implements ActionListener{

	JRadioButton savings,current,fixeddeposit,reccuringdeposit;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit,cancel;
	String formno;
	
	Signupthree(String formno){
		this.formno=formno;
		
		JLabel maintext=new JLabel("PAGE 3: ACCOUNT DETAILS");
		maintext.setFont(new Font("Ariel",Font.BOLD,24));
		maintext.setBounds(130, 40, 400, 40);
		add(maintext);		
		
		JLabel accounttype=new JLabel("ACCOUNT TYPE:");
		accounttype.setFont(new Font("Times new roman",Font.BOLD,18));
		accounttype.setBounds(40, 100, 180, 30);
		add(accounttype);
		
		savings=new JRadioButton("SAVINGS ACCOUNT");
		savings.setBounds(60,140,200,20);
		add(savings);
		
		current=new JRadioButton("CURRENT ACCOUNT");
		current.setBounds(60,165,200,20);
		add(current);
		
		fixeddeposit=new JRadioButton("FIXED DEPOSIT ACCOUNT");
		fixeddeposit.setBounds(260,140,220,20);
		add(fixeddeposit);
		
		reccuringdeposit=new JRadioButton("RECCURING DEPOSIT ACCOUNT");
		reccuringdeposit.setBounds(260,165,220,20);
		add(reccuringdeposit);
		
		ButtonGroup accountgroup=new ButtonGroup();
		accountgroup.add(savings);
		accountgroup.add(current);
		accountgroup.add(fixeddeposit);
		accountgroup.add(reccuringdeposit);
		
		JLabel card=new JLabel("CARD NUMBER:");
		card.setFont(new Font("Times new roman",Font.BOLD,18));
		card.setBounds(40, 200, 150, 40);
		add(card);
		
		JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
		number.setFont(new Font("Times new roman",Font.BOLD,18));
		number.setBounds(200, 200, 250, 40);
		add(number);
		
		JLabel carddetail=new JLabel("Your 16 Digit Card number");
		carddetail.setFont(new Font("Times new roman",Font.ITALIC,12));
		carddetail.setBounds(40, 220, 150, 40);
		add(carddetail);
		
		JLabel pin=new JLabel("PIN NUMBER:");
		pin.setFont(new Font("Times new roman",Font.BOLD,18));
		pin.setBounds(40, 255, 150, 40);
		add(pin);
		
		JLabel pindetail=new JLabel("Your 4 Digit PIN");
		pindetail.setFont(new Font("Times new roman",Font.ITALIC,12));
		pindetail.setBounds(40, 290, 150, 15);
		add(pindetail);
		
		JLabel pnum=new JLabel("XXXX");
		pnum.setFont(new Font("Times new roman",Font.BOLD,18));
		pnum.setBounds(200, 255, 250, 40);
		add(pnum);
		
		JLabel services=new JLabel("SERVICES REQUIRED:");
		services.setFont(new Font("Times new roman",Font.BOLD,18));
		services.setBounds(40, 320, 250, 40);
		add(services);
		
		c1=new JCheckBox("ATM CARD");
		c1.setBounds(45, 360, 150, 20);
		add(c1);
		
		c2=new JCheckBox("MOBILE BANKING");
		c2.setBounds(45, 385, 150, 20);
		add(c2);
		
		c3=new JCheckBox("CHEQUE BOOK");
		c3.setBounds(45, 410, 150, 20);
		add(c3);
		
		c4=new JCheckBox("INTERNET BANKING");
		c4.setBounds(200, 360, 150, 20);
		add(c4);
		
		c5=new JCheckBox("SMS ALERTS");
		c5.setBounds(200, 385, 150, 20);
		add(c5);
		
		c6=new JCheckBox("E-STATEMENT");
		c6.setBounds(200, 410, 150, 20);
		add(c6);
		
		c7=new JCheckBox("I here by declare that the details I have entered are correct to the best of my knowledge");
		c7.setBounds(30, 480, 600, 20);
		add(c7);
		
		
		submit=new JButton("SUBMIT");
		submit.setBounds(110, 540, 150, 30);
		submit.setFont(new Font("Times new roman",Font.BOLD,20));
		submit.setBackground(Color.orange);
		submit.addActionListener(this);
		add(submit);
		
		cancel=new JButton("CANCEL");
		cancel.setBounds(290, 540, 150, 30);
		cancel.setFont(new Font("Times new roman",Font.BOLD,20));
		cancel.setBackground(Color.orange);
		cancel.addActionListener(this);
		add(cancel);
		
		setTitle("USER GENERATION");
		setLayout(null);
		setSize(600,700);
		setLocation(400,90);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()== submit) {
			String accounttype=null;
			if(savings.isSelected()) {
				accounttype="Saving Account";
			}else if(current.isSelected()) {
				accounttype="Current Account";
			}else if(fixeddeposit.isSelected()) {
				accounttype="Fixed Deposit Account";
			}else if(reccuringdeposit.isSelected()) {
				accounttype="Reccuring Deposit Account";
			}
			
			Random random=new Random();	
			String cardnumber=""+Math.abs((random.nextLong() % 90000000L)+ 9040541100000000L);
			
			String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
			
			String facility="";
			if(c1.isSelected()) {
				facility=facility+" ATM Card";
			}else if(c2.isSelected()) {
				facility=facility+" Mobile Banking";
			}else if(c3.isSelected()) {
				facility=facility+" Cheque Book";
			}else if(c4.isSelected()) {
				facility=facility+" Internet Banking";
			}else if(c5.isSelected()) {
				facility=facility+" SMS Alerts";
			}else if(c6.isSelected()) {
				facility=facility+" E-Statement";
			}
			
			try {
				
				if(accounttype.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is Required");
				}else {
					DatabaseConn conn=new DatabaseConn();
					String query1= "insert into signupthree values('"+formno+"', '"+accounttype+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
					String query2= "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
					
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
					
					
					JOptionPane.showMessageDialog(null, "Card Number: "+ cardnumber +"\n Pin: "+pinnumber);
					
					setVisible(false);
					new Deposit(pinnumber).setVisible(true);
				}
				
			}catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
		else if(ae.getSource()==cancel){
			setVisible(false);
			new LoginPage().setVisible(true);
		}
		
	}
	public static void main(String[] args) {
		
		new Signupthree("");
		
	}


	
	

}
