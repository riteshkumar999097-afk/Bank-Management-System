package BankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton login, signup, clear;
	JTextField cardTextField;
	JPasswordField pinTextField;
	Login(){
		
		setTitle("Automatic Taylor Machine by Vasu");

		setLayout(null);

		int WIDTH = 100;
		int HEIGHT = 100;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.png"));//input image from our system
		Image i2 = i1.getImage().getScaledInstance(WIDTH, HEIGHT , Image.SCALE_DEFAULT); //crop image

		ImageIcon i3 = new ImageIcon(i2);

		//JLabel helps to show image or text on frame
		JLabel label = new JLabel(i3);
		label.setBounds(60, 25, WIDTH, HEIGHT);
		add(label);



		//this will show input
		JLabel text = new JLabel("Welcome to Bharat Bank");
		text.setFont(new Font("Osward", Font.BOLD, 38));
		text.setBounds(190, 40, 500, 40);
		add(text);

		//this will show input
		JLabel cardno = new JLabel("Card No:");
		cardno.setFont(new Font("Raleway", Font.BOLD, 30));
		cardno.setBounds(185, 150, 150, 40);
		add(cardno);
		//card box 
		cardTextField = new JTextField();
		cardTextField.setBounds(320, 155, 220, 30);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardTextField);

		//this will show input
		JLabel pin = new JLabel("PIN: ");
		pin.setFont(new Font("Raleway", Font.BOLD, 28));
		pin.setBounds(185, 220, 250, 40);
		add(pin);

		pinTextField = new JPasswordField();
		pinTextField.setBounds(320, 220, 220, 30);
		add(pinTextField);

		//login button



		login = new JButton("SIGN IN");
		login.setFont(new Font("Arial", Font.BOLD, 12));
		login.setBounds(340, 280, 80, 20);
		login.setBackground(new Color(10,31,68));
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);

		//create account button
		clear = new JButton("CLEAR");
		clear.setFont(new Font("Arial", Font.BOLD, 12));
		clear.setBounds(440, 280, 85, 20);
		clear.setBackground(new Color(10,31,68));
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);


		signup = new JButton("SIGN UP");
		signup.setFont(new Font("Arial", Font.BOLD, 12));
		signup.setBounds(340, 310, 185, 20);
		signup.setBackground(new Color(10,31,68));
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		//getContentPane().setBackground(new Color(28, 43, 58));


		getContentPane().setBackground(new Color(255, 255, 255, 80));



		//this will set size of main outer frame
		setSize(800, 480);
		setVisible(true);
		setLocation(350,200);

	}

	public void actionPerformed(ActionEvent ae) {
		//to know who clicked button use action source
		if(ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");

		}else if(ae.getSource() == login) {

		}else if(ae.getSource() == signup) {
			setVisible(false);
			SignupOne start = new SignupOne();
			start.setVisible(true);
			
			//we can also do
			//new start();
		}

	}
	public static void main(String[] args) {
		new Login();

	}
}
