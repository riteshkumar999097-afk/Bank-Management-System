package BankManagementSystem;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener {
	
	JButton deposit, withdraw, balance, setPin, fastCash, statement, exit, cancel;
	String pin;
	Transactions(String pin){
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
		
		JLabel welcome = new JLabel("Welcome to Bharat Bank");
		welcome.setBounds(250,80, 400, 20);
		welcome.setFont(new Font("Roboto", Font.BOLD, 24));
		welcome.setForeground(Color.BLUE);
		welcome.setBackground(Color.GREEN);
		image.add(welcome);
		
		//button on right
		deposit = new JButton("Deposit");
		deposit.setFont(new Font("Roboto", Font.BOLD, 16));
		deposit.setForeground(Color.white);
		deposit.setBounds(450, 300, 170, 30);
		deposit.setBackground(new Color(0, 0, 128));
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdraw = new JButton("Withdraw");
		withdraw.setFont(new Font("Roboto", Font.BOLD, 16));
		withdraw.setForeground(Color.white);
		withdraw.setBounds(450, 350, 170, 30);
		withdraw.setBackground(new Color(0, 0, 128));
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		balance = new JButton("Balance Enquiry");
		balance.setFont(new Font("Roboto", Font.BOLD, 16));
		balance.setForeground(Color.white);
		balance.setBounds(450, 400, 170, 30);
		balance.setBackground(new Color(0, 0, 128));
		balance.addActionListener(this);
		image.add(balance);
		
		/*JButton transfer = new JButton("Fund Transfer");
		transfer.setFont(new Font("Roboto", Font.BOLD, 16));
		transfer.setForeground(Color.white);
		transfer.setBounds(450, 450, 170, 30);
		transfer.setBackground(new Color(0, 0, 128)); 
		transfer.addActionListener(this);
		add(transfer);
		image.add(transfer);*/
		
		
		//button in Left
		setPin = new JButton("PIN Change");
		setPin.setFont(new Font("Roboto", Font.BOLD, 16));
		setPin.setForeground(Color.white);
		setPin.setBounds(160, 300, 170, 30);
		setPin.setBackground(new Color(0, 0, 128)); 
		setPin.addActionListener(this);
		image.add(setPin);
		

		fastCash = new JButton("Fast Cash");
		fastCash.setFont(new Font("Roboto", Font.BOLD, 16));
		fastCash.setForeground(Color.white);
		fastCash.setBounds(160, 350, 170, 30);
		fastCash.setBackground(new Color(0, 0, 128)); 
		fastCash.addActionListener(this);
		image.add(fastCash);
		

		statement = new JButton("Mini Statement");
		statement.setFont(new Font("Roboto", Font.BOLD, 16));
		statement.setForeground(Color.white);
		statement.setBounds(160, 400, 170, 30);
		statement.setBackground(new Color(0, 0, 128));
		statement.addActionListener(this);
		image.add(statement);
		
		//button on bottom
		
		exit = new JButton("Exit");
		exit.setFont(new Font("Roboto", Font.BOLD, 16));
		exit.setForeground(Color.white);
		exit.setBounds(520, 600, 100, 30);
		exit.setBackground(new Color(0, 0, 128));
		exit.addActionListener(this);
		image.add(exit);
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Roboto", Font.BOLD, 16));
		cancel.setForeground(Color.white);
		cancel.setBounds(150, 600, 100, 30);
		cancel.setBackground(new Color(0, 0, 128));
		cancel.addActionListener(this);
		image.add(cancel);
		
		
		
		
		
		this.setSize(900, 900);
		this.setLocation(300, 20);
		setUndecorated(true);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Transactions("");
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == exit) {
			System.exit(0);
		}else if(ae.getSource() == cancel) {
			this.setVisible(false);
			new Login().setVisible(true);
		} else if(ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pin).setVisible(true);
		}else if(ae.getSource() == withdraw) {
			setVisible(false);
			new Withdrawl(pin).setVisible(true);
		}else if(ae.getSource() == fastCash) {
			setVisible(false);
			new FastCash(pin).setVisible(true);
		}else if(ae.getSource()== setPin) {
			setVisible(false);
			new PinChange(pin).setVisible(true);
		}else if(ae.getSource() == balance) {
			setVisible(false);
			new BalanceEnquiry(pin);
		}else if(ae.getSource() == statement) {
			
			new MiniStatement(pin).setVisible(true);
		}
		try {
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
