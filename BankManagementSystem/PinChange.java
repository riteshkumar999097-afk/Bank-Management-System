package BankManagementSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {
	JButton change, cancel;
	JPasswordField pintextField, repintextField;
	String pin;
	PinChange(String pin){
		this.pin = pin;
		
		setLayout(null);
		
		String path = "D:\\Bank-Management-System\\ATM.png";
		ImageIcon i1 = new ImageIcon(path);
		Image i2 = i1.getImage().getScaledInstance(850, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setBounds(280,150, 400, 20);
		text.setFont(new Font("Roboto", Font.BOLD, 24));
		text.setForeground(Color.BLUE);
		text.setBackground(Color.GREEN);
		image.add(text);
		
		JLabel pintext = new JLabel("New PIN:");
		pintext.setBounds(160, 300, 170, 30);
		pintext.setFont(new Font("Roboto", Font.BOLD, 16));
		image.add(pintext);
		
		pintextField = new JPasswordField();
		pintextField.setFont(new Font("Arial", Font.BOLD,14));
		pintextField.setBounds(350,300, 250, 30);
		image.add(pintextField);
		
		JLabel repintext = new JLabel("Re-Enter New PIN:");
		repintext.setBounds(160, 350, 170, 30);
		repintext.setFont(new Font("Roboto", Font.BOLD, 16));
		image.add(repintext);
		
		
	    repintextField = new JPasswordField();
		repintextField.setFont(new Font("Arial", Font.BOLD,14));
		repintextField.setBounds(350,350, 250, 30);
		image.add(repintextField);
		
		//buttons
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Roboto", Font.BOLD, 16));
		cancel.setForeground(Color.white);
		cancel.setBounds(150, 600, 100, 30);
		cancel.setBackground(new Color(0, 0, 128));
		cancel.addActionListener(this);
		image.add(cancel);
		
		change = new JButton("CHANGE");
		change.setFont(new Font("Roboto", Font.BOLD, 16));
		change.setForeground(Color.white);
		change.setBounds(520, 600, 130, 30);
		change.setBackground(new Color(0, 0, 128));
		change.addActionListener(this);
		image.add(change);
		
		
		
		
		setSize(900, 900);
		setLocation(300,20);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new PinChange("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == change) {
			try {
				String npin = pintextField.getText();
				String rpin = repintextField.getText();
				
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Enterd PIN does not match");
					return;
				}
				if(npin.equals("") || rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please enter your New Pin");
					return;
				}
				Conn con = new Conn();
				String query1 = "UPDATE bank SET pin = ? WHERE pin = ?";
				String query2 = "UPDATE login SET pin = ? WHERE pin = ?";
				String query3 = "UPDATE signup3 SET pin = ? WHERE pin = ?";
				
				PreparedStatement ps = con.con.prepareStatement(query1);
				PreparedStatement ps2 = con.con.prepareStatement(query2);
				PreparedStatement ps3 = con.con.prepareStatement(query3);

				ps.setString(1, npin);
				ps.setString(2, pin);
				
				ps2.setString(1, npin);
				ps2.setString(2, pin);
				
				ps3.setString(1, npin);
				ps3.setString(2, pin);
				
				ps.executeUpdate();
				ps2.executeUpdate();
				ps3.executeUpdate();
				
				ps.close(); ps2.close();ps3.close();
				
				JOptionPane.showMessageDialog(null,  "PIN Change Successfully!");
				setVisible(false);
				new Transactions(npin).setVisible(true);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(ae.getSource() == cancel) {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}
		
	}

}
