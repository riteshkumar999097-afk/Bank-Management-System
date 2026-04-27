package BankManagementSystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class SignupOne extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//  JLabel formno, personDetails, name, fname,dob, gender, email, martialStatus, address, state, city, pincode;
	JTextField nameTextField, father_nameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
	JRadioButton male, female, married, unmarried, other;
	JDateChooser dateChooser;
	long application_number;
	JButton next;

	SignupOne(){
		setLayout(null);
		setTitle("New Account Applicacntion");
		Random random = new Random();
		application_number = random.nextLong(1111, 9999);

		JLabel formno = new JLabel("Application Form No. "+  application_number);
		formno.setFont(new Font("Arial", Font.BOLD, 38));
		formno.setBounds(140,20,600,40);
		add(formno);

		JLabel personDetails = new JLabel("Part A: \"Personal Details\"");
		personDetails.setFont(new Font("Arial", Font.BOLD, 20));
		personDetails.setBounds(290, 80, 400, 30);
		add(personDetails);

		JLabel name = new JLabel("Name: ");
		name.setFont(new Font("Arial", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);//total height covered from frame 170
		add(name);

		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Arial", Font.BOLD, 14));
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);

		JLabel father_name = new JLabel("Father Name: ");
		father_name.setFont(new Font("Arial", Font.BOLD, 20));
		father_name.setBounds(100, 190, 200, 30);//total height covered from frame 190+30
		add(father_name);

		father_nameTextField = new JTextField();
		father_nameTextField.setFont(new Font("Arial", Font.BOLD, 14));
		father_nameTextField.setBounds(300, 190, 400, 30);
		add(father_nameTextField);

		JLabel dob = new JLabel("DOB: ");
		dob.setFont(new Font("Arial", Font.BOLD, 20));
		dob.setBounds(100, 240, 100, 30);//total height covered from frame 240+30
		add(dob);

		//need calendar
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300, 240, 400, 25);
		dateChooser.setForeground(Color.black);
		add(dateChooser);



		JLabel gender = new JLabel("Gender: ");
		gender.setFont(new Font("Arial", Font.BOLD, 20));
		gender.setBounds(100, 290, 100, 30);//total height covered from frame 240+30
		add(gender);

		//need radio button

		male = new JRadioButton("male");
		male.setBounds(300,290, 60, 30);
		male.setFont(new Font("Arial",Font.BOLD,12 ));
		male.setForeground(Color.black);
		male.setBackground(Color.white);
		add(male);

		female = new JRadioButton("Female");
		female.setBounds(410,290, 120, 30);
		female.setFont(new Font("Arial",Font.BOLD,12 ));
		female.setForeground(Color.black);
		female.setBackground(Color.WHITE);
		add(female);

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);


		JLabel email = new JLabel("Email: ");
		email.setFont(new Font("Arial", Font.BOLD, 20));
		email.setBounds(100, 340, 100, 30);//total height covere from frame 240+30
		add(email);

		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Arial", Font.BOLD, 14));
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);

		JLabel martial_status = new JLabel("Martial Status: ");
		martial_status.setFont(new Font("Arial", Font.BOLD, 20));
		martial_status.setBounds(100, 390, 200, 30);//total height covere from frame 240+30
		add(martial_status);

		//need radio button
		married = new JRadioButton("Married");
		married.setBounds(300,390, 100, 30);
		married.setFont(new Font("Arial",Font.BOLD,12 ));
		married.setForeground(Color.black);
		married.setBackground(Color.WHITE);
		add(married);

		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(410,390, 120, 30);
		unmarried.setFont(new Font("Arial",Font.BOLD,12 ));
		unmarried.setForeground(Color.black);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);

		other = new JRadioButton("Other");
		other.setBounds(540,390, 120, 30);
		other.setFont(new Font("Arial",Font.BOLD,12 ));
		other.setForeground(Color.black);
		other.setBackground(Color.WHITE);
		add(other);

		ButtonGroup martialStatusGroup = new ButtonGroup();
		martialStatusGroup.add(married);
		martialStatusGroup.add(unmarried);
		martialStatusGroup.add(other);


		JLabel address = new JLabel("Address: ");
		address.setFont(new Font("Arial", Font.BOLD, 20));
		address.setBounds(100, 440, 100, 30);//total height covere from frame 240+30
		add(address);

		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Arial", Font.BOLD, 14));
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);

		JLabel city = new JLabel("City: ");
		city.setFont(new Font("Arial", Font.BOLD, 20));
		city.setBounds(100, 490, 100, 30);//total height covere from frame 240+30
		add(city);


		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Arial", Font.BOLD, 14));
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);

		JLabel state = new JLabel("State: ");
		state.setFont(new Font("Arial", Font.BOLD, 20));
		state.setBounds(100, 540, 100, 30);//total height covere from frame 240+30
		add(state);

		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Arial", Font.BOLD, 14));
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);


		JLabel pincode = new JLabel("Pincode: ");
		pincode.setFont(new Font("Arial", Font.BOLD, 20));
		pincode.setBounds(100, 590, 100, 30);//total height covered from frame 240+30
		add(pincode);

		pincodeTextField = new JTextField();
		pincodeTextField.setFont(new Font("Arial", Font.BOLD, 14));
		pincodeTextField.setBounds(300, 590, 400, 30);
		add(pincodeTextField);

		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620,660, 80, 30);
		next.addActionListener(this);
		add(next);


		getContentPane().setBackground(Color.white);
		setSize(850, 800);
		setLocation(350,10);
		setVisible(true);
	}

	public static void main(String[] args) {

		new SignupOne();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String formno = ""+application_number; //long
		String name = nameTextField.getText().trim();  //not null
		String father_name = father_nameTextField.getText().trim();
		Date dob = dateChooser.getDate(); //not null

		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}else if(female.isSelected()) { gender = "Female"; 
		}else {
			JOptionPane.showMessageDialog(null, "Please select Gender"); 
			return; 
		}
		String email = emailTextField.getText().trim(); //email

		String martial_status = null;
		if(married.isSelected()) {
			martial_status = "Married";
		}else if (unmarried.isSelected()) {
			martial_status = "Unmarried";
		}else if(other.isSelected()) {
			martial_status = "Other";
		}else {
			JOptionPane.showMessageDialog(null, "Please select Martial Status");
			return;
		}

		String address = addressTextField.getText().trim();
		String city = cityTextField.getText().trim(); //not null
		String pincode = pincodeTextField.getText().trim(); //not null
		String state = stateTextField.getText().trim();

		//check before sending data in sql 

		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "Name is Required");
			return;
		}
		if(dob == null){
			JOptionPane.showMessageDialog(null, "DOB is Required");

			return;
		}
		if(email.equals("")) {
			JOptionPane.showMessageDialog(null, "Email is Required");
			return;
		}
		if(city.equals("")) {
			JOptionPane.showMessageDialog(null, "City is Required");
			return;
		}
		if(pincode.equals("")) {
			JOptionPane.showMessageDialog(null, "Pincode is Required");
			return;
		}

		try {
			Conn c = new Conn();
			//String query =  "insert into signup values('"+formno+"', '"+name+"', '"+fname+"','"+dob+"','"+gender+"', '"+email+"','"+martialStatus+"', '"+address+"', '"+city+"', '"+pincode+"','"+state+"')";
			java.sql.Date sqlDob = new java.sql.Date(dob.getTime());

			String query = "INSERT INTO signup(formno, name, father_name, dob, gender, email, martial_status, address, city, pincode, state) " +
					"VALUES(?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = c.con.prepareStatement(query);

			ps.setString(1, formno);
			ps.setString(2, name);
			ps.setString(3, father_name);
			ps.setDate(4, sqlDob);
			ps.setString(5, gender);
			ps.setString(6, email);
			ps.setString(7, martial_status);
			ps.setString(8, address);
			ps.setString(9, city);
			ps.setString(10, pincode);
			ps.setString(11, state);
			//this will insert data in table
			
			ps.executeUpdate();

			
			
			ps.close();

			JOptionPane.showMessageDialog(null, "Data saved Successfully");
			setVisible(false);
			new SignupTwo(formno).setVisible(true);
			
			
		

		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}