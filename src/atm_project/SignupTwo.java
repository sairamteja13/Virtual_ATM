package atm_project;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
	
	JTextField pantextfield,aadhartextfield;
	JButton next;
	JRadioButton syes,sno,eyes,eno;
	JComboBox religions,categories,incomes,educations,occupations;
	String formno;
	
	public SignupTwo(String formno){
		
		this.formno=formno;
		
		JLabel additionaldetails=new JLabel("PAGE 2: ADDITIONAL DETAILS" );
		add(additionaldetails); 
		additionaldetails.setFont(new Font("Ariel",Font.BOLD,28));
		additionaldetails.setBounds(110, 50, 500, 30);
		
		
		JLabel religion=new JLabel("RELIGION:");
		add(religion);
		religion.setFont(new Font("Times new roman",Font.BOLD,18));
		religion.setBounds(60, 130, 130, 20);
		
		String valReligion[]= {"HINDU", "MUSLIM", "CHRISTAIN", "SIKH", "OTHER"};
		religions=new JComboBox(valReligion);
		religions.setBounds(260,130,250,20);
		add(religions);
		
		
		JLabel category=new JLabel("CATEGORY:");
		add(category);
		category.setFont(new Font("Times new roman",Font.BOLD,18));
		category.setBounds(60, 170, 300, 20);
		
		String valCategory[]= {"GENERAL", "OBC","SC","ST"};
		categories=new JComboBox(valCategory);
		categories.setBounds(260,170,250,20);
		add(categories);
		
		JLabel income=new JLabel("INCOME:");
		add(income);
		income.setFont(new Font("Times new roman",Font.BOLD,18));
		income.setBounds(60, 210, 300, 20);
		
		String valincomes[]= {"NULL", "< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
		incomes=new JComboBox(valincomes);
		incomes.setBounds(260, 210, 250, 20);
		add(incomes);
		
		
		JLabel education=new JLabel("EDUCATIONAL ");
		add(education);
		education.setFont(new Font("Times new roman",Font.BOLD,18));
		education.setBounds(60, 250, 300, 20);
		
		JLabel qualification=new JLabel("QUALIFICATION:");
		add(qualification);
		qualification.setFont(new Font("Times new roman",Font.BOLD,18));
		qualification.setBounds(60, 270, 300, 30);
		
		String valeducation[]= {"Non-GRADUATE", "GRADUATE","POST-GRADUATION","DOCTORATE","OTHER"};
		educations=new JComboBox(valeducation);
		educations.setBounds(260, 260, 250, 20);
		add(educations);
		
		
		JLabel occupation=new JLabel("OCCUPATION:");
		add(occupation);
		occupation.setFont(new Font("Times new roman",Font.BOLD,18));
		occupation.setBounds(60, 330, 200, 20);
		
		String valoccupation[]= {"EMPLOYEE", "BUSINESS","RETIRED","SELF-EMPLOYED","DAILY WAGER","STUDENT"};
		occupations=new JComboBox(valoccupation);
		occupations.setBounds(260, 330, 250, 20);
		add(occupations);
		

		
		JLabel pan=new JLabel("PAN NUMBER:");
		add(pan);
		pan.setFont(new Font("Times new roman",Font.BOLD,18));
		pan.setBounds(60, 370, 200, 20);
		
		
		pantextfield=new JTextField();
		pantextfield.setBounds(260,370,250,20);
		pantextfield.setFont(new Font("Times new roman",Font.BOLD,14));
		add(pantextfield);
		
		JLabel aadhar=new JLabel("AADHAR NUMBER:");
		add(aadhar);
		aadhar.setFont(new Font("Times new roman",Font.BOLD,18));
		aadhar.setBounds(60, 410, 200, 20);
		
		
		aadhartextfield=new JTextField();
		aadhartextfield.setBounds(260,410,250,20);
		aadhartextfield.setFont(new Font("Times new roman",Font.BOLD,14));
		add(aadhartextfield);
		
		JLabel seniorcitizen=new JLabel("SENIOR CITIZEN:");
		add(seniorcitizen);
		seniorcitizen.setFont(new Font("Times new roman",Font.BOLD,18));
		seniorcitizen.setBounds(60, 450, 200, 20);
		
		syes=new JRadioButton("YES");
		syes.setBounds(280,450,60,20);
		add(syes);
		
		sno=new JRadioButton("NO");
		sno.setBounds(350,450,60,20);
		add(sno);
		
		ButtonGroup seniorgroup=new ButtonGroup();
		seniorgroup.add(syes);
		seniorgroup.add(sno);
		
		JLabel existingacc=new JLabel("EXISTING ACCOUNT:");
		add(existingacc);
		existingacc.setFont(new Font("Times new roman",Font.BOLD,18));
		existingacc.setBounds(60, 490, 200, 20);
		
		eyes=new JRadioButton("YES");
		eyes.setBounds(280,490,60,20);
		add(eyes);
		
		eno=new JRadioButton("NO");
		eno.setBounds(350,490,60,20);
		add(eno);
		
		ButtonGroup existinggroup=new ButtonGroup();
		existinggroup.add(eyes);
		existinggroup.add(eno);
		
		
		next=new JButton("NEXT");
		next.setBounds(230, 540, 100, 30);
		next.setFont(new Font("Times new roman",Font.BOLD,20));
		next.setBackground(Color.orange);
		next.addActionListener(this);
		add(next);
		
		
		setTitle("NEW APPLICATION PAGE-2");
		setLayout(null);
		setVisible(true);
		setSize(600, 700);
		setLocation(400,90);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
	   
	    
	    String religion=(String)religions.getSelectedItem();
	    String category=(String)categories.getSelectedItem();
	    String income=(String)incomes.getSelectedItem();
	    String education=(String)educations.getSelectedItem();
	    String occupation=(String)occupations.getSelectedItem();
		
	    String pan=pantextfield.getText();
		String aadhar=aadhartextfield.getText();
	    
		String seniorcitizen=null;
		if(syes.isSelected()) {
			seniorcitizen="YES";
		}else if(sno.isSelected()){
			seniorcitizen="NO";
		}
		
		
		String existingaccount=null;
		if(eyes.isSelected()){
			existingaccount="Yes";
		}else if(eno.isSelected()) {
			existingaccount="No";
		}
		
		
		try {
			if(pan.equals("")|| aadhar.equals("")) {
				JOptionPane.showMessageDialog(null, "Details Required");
			}else {
				DatabaseConn c=new DatabaseConn();
				String query="insert into signuptwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
			    c.s.executeUpdate(query);
			    
			    //sign up three
			    setVisible(false);
			    new Signupthree(formno).setVisible(true);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		new SignupTwo("");
	}

}