package BankManagementSystem;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceEnquiry extends JFrame implements ActionListener {
	JButton back;
	String pin;
	BalanceEnquiry(String pin){
		this.pin = pin;
		
		setLayout(null);
		
		String path = "D:\\Bank-Management-System\\ATM.png";
		ImageIcon i1 = new ImageIcon(path);
		Image i2 = i1.getImage().getScaledInstance(850, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Account Balance");
		text.setBounds(280,150, 400, 20);
		text.setFont(new Font("Roboto", Font.BOLD, 24));
		text.setForeground(Color.BLUE);
		image.add(text);
		
		int amount = 0;
		Conn con = new Conn();
		try {
	
			String query = "SELECT type, amount from bank WHERE pin = ?";
			PreparedStatement ps = con.con.prepareStatement(query);
			ps.setString(1, pin);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")){
					amount += Integer.parseInt(rs.getString("amount"));

				}else{
					amount -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		String user_balance = "" + amount;
		JLabel balance = new JLabel(user_balance);
		balance.setBounds(360, 300, 550, 60);
		balance.setForeground(new Color(0, 128, 0));
		balance.setFont(new Font("Roboto", Font.BOLD, 52));
		image.add(balance);
		
		
		//buttons
	
		
		back = new JButton("BACK");
		back.setFont(new Font("Roboto", Font.BOLD, 16));
		back.setForeground(Color.white);
		back.setBounds(520, 600, 130, 30);
		back.setBackground(new Color(0, 0, 128));
		back.addActionListener(this);
		image.add(back);
		
		
		
		
		setSize(900, 900);
		setLocation(300,20);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new BalanceEnquiry("");
		
		
	}

	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Transactions(pin).setVisible(true);
		
	}

}
