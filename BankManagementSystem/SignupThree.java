package BankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;
public class SignupThree extends JFrame implements ActionListener{

	JComboBox type;
	JRadioButton saving, current, recurringDeposit, fixedDeposit;
	JCheckBox atm, cheque, mobilebanking, internetbanking, sms, estatement, declaration;
	JButton submit, cancel;
	String formno;
	SignupThree(String formno) {
		this.formno = formno;

		this.setTitle("Additional details");
		this.setLayout(null);
		JLabel details = new JLabel ("Part \"C\" Additional Details");
		details.setFont(new Font("Raleway", Font.BOLD, 22));
		details.setBounds(280, 40, 400, 40);
		this.add(details);

		JLabel accountType = new JLabel ("Account type");
		accountType.setFont(new Font("Raleway", Font.BOLD, 22));
		accountType.setBounds(100, 140, 200, 30);
		this.add(accountType);

		this.saving = new JRadioButton("Saving Account");
		this.saving.setBounds(110, 180, 220, 20);
		this.saving.setFont(new Font("Raleway", Font.BOLD,14));
		this.saving.setBackground(Color.white);
		this.add(saving);

		this.current = new JRadioButton("Current Account");
		this.current.setBounds(350, 180, 220, 20);
		this.current.setFont(new Font("Raleway", Font.BOLD,14));
		this.current.setBackground(Color.white);
		this.add(current);


		this.fixedDeposit = new JRadioButton("Fixed Deposit Account");
		this.fixedDeposit.setBounds(110, 220, 220,20);
		this.fixedDeposit.setFont(new Font("Raleway", Font.BOLD,14));
		this.fixedDeposit.setBackground(Color.white);
		this.add(fixedDeposit);

		this.recurringDeposit = new JRadioButton("Recurring Deposit Account");
		this.recurringDeposit.setBounds(350, 220, 220, 20);
		this.recurringDeposit.setFont(new Font("Raleway", Font.BOLD,14));
		this.recurringDeposit.setBackground(Color.white);
		this.add(recurringDeposit);

		//this will protect from selecting all buttons
		ButtonGroup groupaccount = new ButtonGroup();
		groupaccount.add(this.saving);
		groupaccount.add(this.current);
		groupaccount.add(this.recurringDeposit);
		groupaccount.add(this.fixedDeposit);

		//dummy card preview

		JLabel card = new JLabel("Card Number:");
		card.setFont(new Font("Raleway", Font.BOLD, 22));
		card.setBounds(100, 300, 200, 30);
		this.add(card);

		JLabel number = new JLabel("5040-9xxx-xxxx-xxxx");
		number.setFont(new Font("Raleway", Font.BOLD, 22));
		number.setBounds(330, 300, 300, 30);
		this.add(number);

		JLabel carddetail = new JLabel("Your 16 digit Card Number");
		carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
		carddetail.setBounds(100, 330, 300, 20);
		this.add(carddetail);

		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(100, 370, 200, 30);
		this.add(pin);


		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
		pnumber.setBounds(330, 370, 200, 30);
		this.add(pnumber);


		JLabel pindetail = new JLabel("Your 4 digit PIN Number");
		pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
		pindetail.setBounds(100, 400, 300, 30);
		this.add(pindetail);

		JLabel services = new JLabel("Services Required");
		services.setFont(new Font("Raleway", Font.BOLD, 22));
		services.setBounds(100, 450, 200, 30);
		this.add(services);

		this.atm = new JCheckBox("ATM CARD");
		this.atm.setBackground(Color.white);
		this.atm.setFont(new Font("Raleway",Font.BOLD, 14));
		this.atm.setBounds(100, 500, 200, 20);
		this.add(this.atm);

		this.sms = new JCheckBox("Email & SMS Alert");
		this.sms.setBackground(Color.white);
		this.sms.setFont(new Font("Raleway",Font.BOLD, 14));
		this.sms.setBounds(350, 500, 200, 20);
		this.add(this.sms);


		this.mobilebanking = new JCheckBox("MOBILE BANKING");
		this.mobilebanking.setBackground(Color.white);
		this.mobilebanking.setFont(new Font("Raleway",Font.BOLD, 14));
		this.mobilebanking.setBounds(100, 550, 200, 20);
		this.add(this.mobilebanking);

		this.internetbanking = new JCheckBox("INTERNET BANKING");
		this.internetbanking.setBackground(Color.white);
		this.internetbanking.setFont(new Font("Raleway",Font.BOLD, 14));
		this.internetbanking.setBounds(350, 550, 200, 20);
		this.add(this.internetbanking);

		this.cheque = new JCheckBox("CHEQUE");
		this.cheque.setBackground(Color.white);
		this.cheque.setFont(new Font("Raleway",Font.BOLD, 14));
		this.cheque.setBounds(100, 600, 200, 20);
		this.add(this.cheque);

		this.estatement = new JCheckBox("E-STATEMENT");
		this.estatement.setBackground(Color.white);
		this.estatement.setFont(new Font("Raleway",Font.BOLD, 14));
		this.estatement.setBounds(350, 600, 200, 20);
		this.add(this.estatement);


		this.declaration = new JCheckBox("I here by declare that all the  above details are correct to the best of my knowlwdge.");
		this.declaration.setBackground(Color.white);
		this.declaration.setFont(new Font("Raleway",Font.BOLD, 10));
		this.declaration.setBounds(100, 640, 450, 30);
		this.add(this.declaration);


		this.submit = new JButton("Submit");
		this.submit.setBackground(Color.black);
		this.submit.setForeground(Color.white);
		this.submit.setFont(new Font("Segoe UI", Font.BOLD, 16));
		this.submit.setBounds(220,720,100,30);
		this.submit.addActionListener(this);
		this.add(this.submit);

		this.cancel = new JButton("cancel");
		this.cancel.setBackground(Color.black);
		this.cancel.setForeground(Color.WHITE);
		this.cancel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		this.cancel.setBounds(420,720,100,30);
		this.cancel.addActionListener(this);
		this.add(this.cancel);




		this.getContentPane().setBackground(Color.white);
		this.setSize(850, 820);
		this.setLocation(350, 10);
		this.setVisible(true);

	}
	public static void main(String[] args) {
		new SignupThree("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {

			String account_type = null;
			if(this.saving.isSelected()) {
				account_type = "saving Account";
			}else if(this.current.isSelected()) {
				account_type = "Current Account";
			}else if(this.fixedDeposit.isSelected()) {
				account_type = "Fixed Depoit Account";
			}else if(this.recurringDeposit.isSelected()) {
				account_type = "Recurring Deposit Account";
			}else {
				JOptionPane.showMessageDialog(null, "Please choose Account Type");
				return;
			}

			Random num = new Random();
			String card_number = ""+ Math.abs((num.nextLong() % 90000000L) + 5040922100000000L);
			String pin = ""+ Math.abs((num.nextLong() % 9000L) + 1000L);

			String facility = "";
			if(this.atm.isSelected()) {
				facility = facility + "ATM Card";
			}
			if(this.cheque.isSelected()) {
				facility = facility + "Cheque, ";
			}
			if(this.sms.isSelected()) {
				facility = facility + "Email & SMS Alert, ";
			}
			if(this.mobilebanking.isSelected()) {
				facility = facility + "Mobile Banking, ";
			}
			if(this.internetbanking.isSelected()) {
				facility = facility + "Internet Banking, ";
			}
			if(this.estatement.isSelected()) {
				facility = facility + "E- Statement, ";
			}
			
			if(!this.declaration.isSelected()) {
			    JOptionPane.showMessageDialog(null, "Please confirm the declaration!");
			    return;
			}


			try{
				Conn c = new Conn();
				String query1 = "insert into signup3 (formno, account_type, card_number, pin, facility)" +
						" Values(?, ?, ?, ?, ?)";
				String query2 = "insert into login (formno, card_number, pin)" +
						" Values(?, ?, ?)";
				PreparedStatement ps = c.con.prepareStatement(query1);
				ps.setString(1, formno);
				ps.setString(2, account_type);
				ps.setString(3, card_number);
				ps.setString(4, pin);
				ps.setString(5, facility);

				PreparedStatement pl = c.con.prepareStatement(query2);
				pl.setString(1,  formno);
				pl.setString(2, card_number);
				pl.setString(3, pin);

				ps.executeUpdate();
				pl.executeUpdate();

				JOptionPane.showMessageDialog(null,"Your Account is Generated Successfully!! Please note your details " + "\n Card Number: "+ card_number + "\n Pin: "+ pin);

				this.setVisible(false);
				new Deposit(pin).setVisible(true);
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if (ae.getSource() == cancel) {
			this.setVisible(false);
			new Login().setVisible(true);

		}

	}

}
