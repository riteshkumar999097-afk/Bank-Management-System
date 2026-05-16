package BankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class MiniStatement extends JFrame{
	
	String pin;
	
	MiniStatement(String pin) {
		this.pin = pin;
		setTitle("Mini Statement");
		setLayout(null);
		
		
		JLabel bank = new JLabel("Bharat Bank");
		bank.setBounds(150, 20, 100, 20);
		bank.setFont(new Font("Arial", Font.BOLD, 16));
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20, 80, 300, 20);
		add(card);
		
		JLabel mini = new JLabel();
		mini.setBounds(20, 110, 400, 200);
		add(mini);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400, 300, 20);
		balance.setForeground(new Color(0, 128, 0));
		bank.setFont(new Font("Arial", Font.BOLD, 14));
		add(balance);
		
		
		//card number
		try {
			Conn con = new Conn();
			String query = "SELECT* FROM login where pin = ? ";
			PreparedStatement ps = con.con.prepareStatement(query);
			ps.setString(1,  pin);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				card.setText("Card Numner: " + rs.getString("card_number").substring(0,4)+"xxxxxxxx"+ rs.getString("card_number").substring(12));
			}
			
			rs.close();
			ps.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//fetch mini statement & balance
		try {
			Conn con = new Conn();
			int bal =0;
			String query = "SELECT* FROM bank where pin = ? ";
			PreparedStatement ps = con.con.prepareStatement(query);
			ps.setString(1,  pin);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				mini.setText(mini.getText() + "<html>" 
			      + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				  + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" 
			      + rs.getString("amount") + "<br><br></html>");
				
				
				if(rs.getString("type").equals("Deposit")){
					bal += Integer.parseInt(rs.getString("amount"));

				}else{
					bal -= Integer.parseInt(rs.getString("amount"));
				}
			}
			
			balance.setText("Your current Account Balance is Rs. " + bal);
			rs.close();
			ps.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		setSize(400,600);
		setLocation(20,20);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new MiniStatement("");
	}

}
