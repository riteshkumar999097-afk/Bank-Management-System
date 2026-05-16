package BankManagementSystem;
import java.sql.*;
public class Conn {

	Connection con;
	Statement s;
	public Object Conn;
	
	public Conn() {
		try {
			//step 1 (not required in newer version of java)
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step 2 create string      jdbc:<sql editor name>://localhost(not neccessary to write) <port no>/<databse name>, "username of sql","password");
		con = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","root");
		con.setAutoCommit(true);//because when i created table auto commit was off
		//step 3 -> create statement
		s = con.createStatement();
		//step 4 insert query
		
		}catch(Exception e){
			System.out.println(e);
			
		}
	}

}
