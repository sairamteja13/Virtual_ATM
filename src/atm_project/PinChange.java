package atm_project;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{

	String pinnumber;
	JButton change,back;
	JPasswordField newpin,renewpin;
	
	PinChange(String pinnumber){
		
		this.pinnumber=pinnumber;
		
		
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,800,800);
		add(image);
		
		JLabel text=new JLabel("CHANGE YOUR PIN");
		text.setBounds(248, 305, 600, 20);
		text.setFont(new Font("Ariel",Font.BOLD,18));
		image.add(text);
		
		JLabel pintext=new JLabel("ENTER NEW PIN:");
		pintext.setBounds(213, 338, 150, 20);
		pintext.setFont(new Font("Ariel",Font.BOLD,15));
		image.add(pintext);
		
		newpin=new JPasswordField();
		newpin.setBounds(350, 340, 130, 20);
		newpin.setFont(new Font("Ariel",Font.BOLD,15));
		image.add(newpin);
		
		JLabel repintext=new JLabel("RE-ENTER NEW PIN:");
		repintext.setBounds(190, 365, 150, 30);
		repintext.setFont(new Font("Ariel",Font.BOLD,15));
		image.add(repintext);
		
		renewpin=new JPasswordField();
		renewpin.setBounds(350, 371, 130, 20);
		renewpin.setFont(new Font("Ariel",Font.BOLD,15));
		image.add(renewpin);
		
		change = new JButton("SUBMIT");
		change.setFont(new Font("Times new roman",Font.BOLD,18));
		change.setBounds(350, 430, 135, 25);
		change.addActionListener(this);
		image.add(change);
		
		
		back=new JButton("BACK");
		back.setFont(new Font("Times new roman",Font.BOLD,18));
		back.setBounds(350, 460, 135, 25);
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
	if(ae.getSource()==change) {	 
	try {
		String npin=newpin.getText();
		String repin=renewpin.getText();
		
			if(!npin.equals(repin)) {
				JOptionPane.showMessageDialog(null, "Entered PIN Does not match");
				return;
			}
		
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Pin must not be empty");
			}else if(npin.length()<4 || npin.length()>4) {
				JOptionPane.showMessageDialog(null, "Pin must 4-Digit");
			}
			
			DatabaseConn conn =new DatabaseConn();
			String query1="update bank set pin='"+npin+"' where pin='"+pinnumber+"'";
			String query2="update login set pin_number='"+npin+"' where pin_number='"+pinnumber+"'";
			String query3="update signupthree set pin_number='"+npin+"' where pin_number='"+pinnumber+"'";
			
			conn.s.executeUpdate(query1);
			conn.s.executeUpdate(query2);
			conn.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
			
			setVisible(false);
			new Transactions(npin).setVisible(true);
			
		 }catch(Exception e) {
			System.out.println(e);
		} 
	
	
	}else if(ae.getSource()==back) {
		setVisible(false);
		new Transactions(pinnumber).setVisible(true);
	}
		
}

public static void main(String[] args) {
	 
	   new PinChange("").setVisible(true);
	
	}





}