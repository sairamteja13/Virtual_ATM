package atm_project;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signupone extends JFrame implements ActionListener{
	
	long random;
	JTextField nametextfield,fnametextfield,dobtextfield,mailtextfield,addresstextfield,citytextfield,statetextfield,pincodetextfield;
	JButton next;
	JRadioButton male,female,other,single,married;
	JDateChooser datechooser;
	
	public Signupone(){
		
		
		Random r=new Random();
		random=Math.abs((r.nextLong()%9000L)+1000L);
		
		JLabel form=new JLabel("APPLICATION FORM: "+random );
		add(form); 
		form.setFont(new Font("Ariel",Font.BOLD,28));
		form.setBounds(130, 40, 400, 30);
		
		JLabel maintext=new JLabel("PAGE 1:PERSONAL DETAILS");
		add(maintext);
		maintext.setFont(new Font("Ariel",Font.BOLD,20));
		maintext.setBounds(160, 70, 400, 40);
		
		
		JLabel name=new JLabel("FULL NAME:");
		add(name);
		name.setFont(new Font("Times new roman",Font.BOLD,18));
		name.setBounds(60, 130, 130, 20);
		
		nametextfield=new JTextField();
		nametextfield.setBounds(240,130,250,20);
		nametextfield.setFont(new Font("Times new roman",Font.BOLD,14));
		add(nametextfield);
		
		JLabel fname=new JLabel("FATHER NAME:");
		add(fname);
		fname.setFont(new Font("Times new roman",Font.BOLD,18));
		fname.setBounds(60, 170, 300, 20);
		
		fnametextfield=new JTextField();
		fnametextfield.setBounds(240,170,250,20);
		fnametextfield.setFont(new Font("Times new roman",Font.BOLD,14));
		add(fnametextfield);
		
		JLabel dob=new JLabel("DATE OF BIRTH:");
		add(dob);
		dob.setFont(new Font("Times new roman",Font.BOLD,18));
		dob.setBounds(60, 210, 300, 20);
		
		
		datechooser=new JDateChooser();
		datechooser.setBounds(240, 210, 250, 20);
		add(datechooser);
		
		
		JLabel gender=new JLabel("GENDER:");
		add(gender);
		gender.setFont(new Font("Times new roman",Font.BOLD,18));
		gender.setBounds(60, 250, 300, 20);
		
		male=new JRadioButton("MALE");
		male.setBounds(240,250,60,20);
		add(male);
		
		female=new JRadioButton("FEMALE");
		female.setBounds(310,250,80,20);
		add(female);
		
		other=new JRadioButton("OTHER");
		other.setBounds(400,250,80,20);
		add(other);
		
		ButtonGroup gendergroup=new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		gendergroup.add(other); 
		
		
		JLabel email=new JLabel("EMAIL:");
		add(email);
		email.setFont(new Font("Times new roman",Font.BOLD,18));
		email.setBounds(60, 290, 200, 20);
		
		mailtextfield=new JTextField();
		mailtextfield.setBounds(240,290,250,20);
		mailtextfield.setFont(new Font("Times new roman",Font.BOLD,14));
		add(mailtextfield);
		
		JLabel marriage=new JLabel("MARTIAL STATUS:");
		add(marriage);
		marriage.setFont(new Font("Times new roman",Font.BOLD,18));
		marriage.setBounds(60, 330, 200, 20);
		
		single=new JRadioButton("SINGLE");
		single.setBounds(240,330,100,20);
		add(single);
		
		married=new JRadioButton("MARRIED");
		married.setBounds(340,330,250,20);
		add(married);
		
		ButtonGroup marriagegroup=new ButtonGroup();
		marriagegroup.add(single);
		marriagegroup.add(married); 
		
		JLabel address=new JLabel("ADDRESS:");
		add(address);
		address.setFont(new Font("Times new roman",Font.BOLD,18));
		address.setBounds(60, 370, 200, 20);
		
		
		addresstextfield=new JTextField();
		addresstextfield.setBounds(240,370,250,20);
		addresstextfield.setFont(new Font("Times new roman",Font.BOLD,14));
		add(addresstextfield);
		
		JLabel city=new JLabel("CITY:");
		add(city);
		city.setFont(new Font("Times new roman",Font.BOLD,18));
		city.setBounds(60, 410, 200, 20);
		
		
		citytextfield=new JTextField();
		citytextfield.setBounds(240,410,250,20);
		citytextfield.setFont(new Font("Times new roman",Font.BOLD,14));
		add(citytextfield);
		
		JLabel state=new JLabel("STATE:");
		add(state);
		state.setFont(new Font("Times new roman",Font.BOLD,18));
		state.setBounds(60, 450, 200, 20);
		
		statetextfield=new JTextField();
		statetextfield.setBounds(240,450,250,20);
		statetextfield.setFont(new Font("Times new roman",Font.BOLD,14));
		add(statetextfield);
		
		JLabel pincode=new JLabel("PIN CODE:");
		add(pincode);
		pincode.setFont(new Font("Times new roman",Font.BOLD,18));
		pincode.setBounds(60, 490, 200, 20);
		
		pincodetextfield=new JTextField();
		pincodetextfield.setBounds(240,490,250,20);
		pincodetextfield.setFont(new Font("Times new roman",Font.BOLD,14));
		add(pincodetextfield);
		
		
		next=new JButton("NEXT");
		next.setBounds(230, 540, 100, 30);
		next.setFont(new Font("Times new roman",Font.BOLD,20));
		next.setBackground(Color.orange);
		next.addActionListener(this);
		add(next);
		
		
		setTitle("SIGNUP FORM");
		setLayout(null);
		setVisible(true);
		setSize(600, 700);
		setLocation(400,90);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String formno=""+random;//long;
		String name=nametextfield.getText();
		String fname=fnametextfield.getText();
		String dob=((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(male.isSelected()) {
			gender="MALE";
		}else if(female.isSelected()){
			gender="FEMALE";
		}else {
			gender="OTHER";
		}
		
		String email=mailtextfield.getText();
		
		String martial=null;
		if(single.isSelected()){
			martial="SINGLE";
		}else {
			martial="MARRIED";
		}
		
		String address=addresstextfield.getText();
		String city=citytextfield.getText();
		String state=statetextfield.getText();
		String pincode=pincodetextfield.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "FULL NAME is Required");
			}else {
				DatabaseConn c=new DatabaseConn();
				String query="insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+martial+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
			    c.s.executeUpdate(query);
			    
			    setVisible(false);
			    new SignupTwo(formno).setVisible(true);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	public static void main(String[] args){
	
		new Signupone();
	
	
	}


}