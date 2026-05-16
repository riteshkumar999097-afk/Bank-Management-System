package BankManagementSystem;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.*;
	import java.util.Date;
	import javax.swing.*;
public class Withdrawl extends JFrame implements ActionListener{

		JButton exit, cancel, withdraw;
		JTextField amount;
		String pin;

		Withdrawl(String pin){
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

			JLabel welcome = new JLabel("Enter the Amount to be Withdraw");
			welcome.setBounds(230,250, 400, 20);
			welcome.setFont(new Font("Roboto", Font.BOLD, 24));
			welcome.setForeground(Color.BLUE);
			welcome.setBackground(Color.GREEN);
			image.add(welcome);
			
			amount = new JTextField();
			amount.setFont(new Font("Raleway", Font.BOLD,18));
			amount.setBounds(250,300, 300, 30);
			image.add(amount);
			
			cancel = new JButton("Cancel");
			cancel.setFont(new Font("Roboto", Font.BOLD, 16));
			cancel.setBackground(new Color(0, 0, 128));
			cancel.setForeground(Color.white);
			cancel.setBounds(260, 400, 120, 30);
			cancel.addActionListener(this);
			image.add(cancel);
			
			withdraw = new JButton("Withdraw");
			withdraw.setFont(new Font("Roboto", Font.BOLD, 16));
			withdraw.setBackground(new Color(0, 0, 128));
			withdraw.setForeground(Color.white);
			withdraw.setBounds(420, 400, 120, 30);
			withdraw.addActionListener(this);
			image.add(withdraw);


			/*button on bottom

			exit = new JButton("Exit");
			exit.setFont(new Font("Roboto", Font.BOLD, 16));
			exit.setForeground(Color.white);
			exit.setBounds(520, 600, 100, 30);
			exit.setBackground(new Color(0, 0, 128));
			exit.addActionListener(this);
			image.add(exit);
	*/
			




			this.setSize(900, 900);
			this.setLocation(300, 20);
			setUndecorated(true);
			this.setVisible(true);
		}


		public static void main(String[] args) {
			new Withdrawl("");
		}


		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == cancel) {
				this.setVisible(false);
				new Transactions(pin).setVisible(true);
			}else if(ae.getSource() == withdraw) {
				
				String money = amount.getText();
				Date date = new Date();
				
				if(money.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter a Valid Amount");
					
					
				}else {
					
					Conn con = new Conn();
					String query = "INSERT INTO bank (pin, date, type, amount)"+
					"VALUES(?, now(), ?, ?)";//now() -> for date and time, curdate() -> for date only
					try {
						PreparedStatement ps = con.con.prepareStatement(query);

						ps.setString(1, pin);
						ps.setString(2, "Withdraw");
						ps.setString(3, money);
						
						ps.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Withdraw of Rs. "+ money +" is Successfull!");
						
						setVisible(false);
						new Transactions(pin).setVisible(true);
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				
				
			}
			
		}
	}
