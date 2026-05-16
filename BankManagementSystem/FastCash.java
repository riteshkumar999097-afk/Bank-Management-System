package BankManagementSystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class FastCash extends JFrame implements ActionListener{



	JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000, cancel, withdraw;
	String pin;
	FastCash(String pin){
		this.pin = pin;
		this.setLayout(null);
		this.setTitle("ATM");

		String path = "D:\\Bank-Management-System\\ATM.png";
		ImageIcon i1 = new ImageIcon(path);
		Image i2 = i1.getImage().getScaledInstance(850,  900,  Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		//to get better quality
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		this.add(image);

		JLabel text = new JLabel("Select Withdrawl Amount");
		text.setBounds(250,80, 400, 20);
		text.setFont(new Font("Roboto", Font.BOLD, 24));
		text.setForeground(Color.BLUE);
		text.setBackground(Color.GREEN);
		image.add(text);

		//button on right

		rs500 = new JButton("Rs. 500");
		rs500.setFont(new Font("Roboto", Font.BOLD, 16));
		rs500.setForeground(Color.white);
		rs500.setBounds(450, 300, 170, 30);//450,300
		rs500.setBackground(new Color(0, 0, 128));
		rs500.addActionListener(this);
		image.add(rs500);

		rs2000 = new JButton("Rs. 2000");
		rs2000.setFont(new Font("Roboto", Font.BOLD, 16));
		rs2000.setForeground(Color.white);
		rs2000.setBounds(450, 350, 170, 30);//450,350
		rs2000.setBackground(new Color(0, 0, 128)); 
		rs2000.addActionListener(this);
		image.add(rs2000);

		rs10000 = new JButton("Rs. 10000");
		rs10000.setFont(new Font("Roboto", Font.BOLD, 16));
		rs10000.setForeground(Color.white);
		rs10000.setBounds(450, 400, 170, 30);//450,400
		rs10000.setBackground(new Color(0, 0, 128));
		rs10000.addActionListener(this);
		image.add(rs10000);

		//button in Left
		rs100 = new JButton("Rs. 100");
		rs100.setFont(new Font("Roboto", Font.BOLD, 16));
		rs100.setForeground(Color.white);
		rs100.setBounds(160, 300, 170, 30);//160,300
		rs100.setBackground(new Color(0, 0, 128));
		rs100.addActionListener(this);
		image.add(rs100);

		rs1000 = new JButton("Rs. 1000");
		rs1000.setFont(new Font("Roboto", Font.BOLD, 16));
		rs1000.setForeground(Color.white);
		rs1000.setBounds(160, 350, 170, 30);//160,350
		rs1000.setBackground(new Color(0, 0, 128));
		rs1000.addActionListener(this);
		image.add(rs1000);


		rs5000 = new JButton("Rs. 5000");
		rs5000.setFont(new Font("Roboto", Font.BOLD, 16));
		rs5000.setForeground(Color.white);
		rs5000.setBounds(160, 400, 170, 30);//160,400
		rs5000.setBackground(new Color(0, 0, 128)); 
		rs5000.addActionListener(this);
		image.add(rs5000);




		//button on bottom

		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Roboto", Font.BOLD, 16));
		cancel.setForeground(Color.white);
		cancel.setBounds(520, 600, 100, 30);
		cancel.setBackground(new Color(0, 0, 128));
		cancel.addActionListener(this);
		image.add(cancel);





		this.setSize(900, 900);
		this.setLocation(300, 20);
		setUndecorated(true);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FastCash("");

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == cancel) {
			this.setVisible(false);
			new Transactions(pin).setVisible(true);
		}else {
			String amount = ((JButton)ae.getSource()).getText().substring(4);//this will take text from button after 3rd index char

			Conn con = new Conn();
			try {
				ResultSet rs = con.s.executeQuery("Select* From bank WHERE pin ='"+pin+"'");

				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")){
						balance += Integer.parseInt(rs.getString("amount"));

					}else{
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}

				if(ae.getSource() != cancel && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
					return;
				}

				String query = "INSERT INTO bank(pin, date, type, amount)" +
						" values(?, now(), ?, ?)";
				PreparedStatement ps = con.con.prepareStatement(query);
				ps.setString(1, pin);
				ps.setString(2, "Withdraw");
				ps.setString(3, amount);
				ps.executeUpdate();

				JOptionPane.showMessageDialog(null, "RS "+amount+" is Debited Successfully");

				setVisible(false);
				new Transactions(pin).setVisible(true);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}


	}




}
