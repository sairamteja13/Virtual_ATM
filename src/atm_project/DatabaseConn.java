package atm_project;

import java.sql.*;



public class DatabaseConn {

	Connection c;
	Statement s;
	public DatabaseConn() {
		try {
			
			c=DriverManager.getConnection("jdbc:mysql:///virtualatmsimulator","root","123456");
			s=c.createStatement();
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
}
