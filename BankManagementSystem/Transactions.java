package BankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Transactions extends JFrame {
	
	

	Transactions(){
		this.setLayout(null);
		this.setTitle("ATM");
		
		String path = "D:\\Bank-Management-System\\machine.png";
		ImageIcon i1 = new ImageIcon(path);
		Image i2 = i1.getImage().getScaledInstance(850,  790,  Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		//to get better quality
		JLabel image = new JLabel(i3);
		image.setBounds(10, 0, 800, 790);
		this.add(image);
		
		
		
		
		
		this.setSize(900, 900);
		this.setLocation(300, 20);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Transactions();
		
	}

}
