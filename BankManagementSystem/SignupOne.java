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
		this.application_number = random.nextLong(1111, 9999);

		JLabel formno = new JLabel("Application Form No. "+  this.application_number);
		formno.setFont(new Font("Arial", Font.BOLD, 38));
		formno.setBounds(140,20,600,40);
		this.add(formno);

		JLabel personDetails = new JLabel("Part A: \"Personal Details\"");
		personDetails.setFont(new Font("Arial", Font.BOLD, 20));
		personDetails.setBounds(290, 80, 400, 30);
		this.add(personDetails);

		JLabel name = new JLabel("Name: ");
		name.setFont(new Font("Arial", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);//total height covered from frame 170
		this.add(name);

		this.nameTextField = new JTextField();
		this.nameTextField.setFont(new Font("Arial", Font.BOLD, 14));
		this.nameTextField.setBounds(300, 140, 400, 30);
		this.add(this.nameTextField);

		JLabel father_name = new JLabel("Father Name: ");
		father_name.setFont(new Font("Arial", Font.BOLD, 20));
		father_name.setBounds(100, 190, 200, 30);//total height covered from frame 190+30
		this.add(father_name);

		this.father_nameTextField = new JTextField();
		this.father_nameTextField.setFont(new Font("Arial", Font.BOLD, 14));
		this.father_nameTextField.setBounds(300, 190, 400, 30);
		this.add(this.father_nameTextField);

		JLabel dob = new JLabel("DOB: ");
		dob.setFont(new Font("Arial", Font.BOLD, 20));
		dob.setBounds(100, 240, 100, 30);//total height covered from frame 240+30
		this.add(dob);

		//need calendar
		this.dateChooser = new JDateChooser();
		this.dateChooser.setBounds(300, 240, 400, 25);
		this.dateChooser.setForeground(Color.black);
		this.add(this.dateChooser);



		JLabel gender = new JLabel("Gender: ");
		gender.setFont(new Font("Arial", Font.BOLD, 20));
		gender.setBounds(100, 290, 100, 30);//total height covered from frame 240+30
		this.add(gender);

		//need radio button

		this.male = new JRadioButton("male");
		this.male.setBounds(300,290, 60, 30);
		this.male.setFont(new Font("Arial",Font.BOLD,12 ));
		this.male.setForeground(Color.black);
		this.male.setBackground(Color.white);
		this.add(this.male);

		this.female = new JRadioButton("Female");
		this.female.setBounds(410,290, 120, 30);
		this.female.setFont(new Font("Arial",Font.BOLD,12 ));
		this.female.setForeground(Color.black);
		this.female.setBackground(Color.WHITE);
		this.add(this.female);

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(this.male);
		genderGroup.add(this.female);


		JLabel email = new JLabel("Email: ");
		email.setFont(new Font("Arial", Font.BOLD, 20));
		email.setBounds(100, 340, 100, 30);//total height covere from frame 240+30
		this.add(email);

		this.emailTextField = new JTextField();
		this.emailTextField.setFont(new Font("Arial", Font.BOLD, 14));
		this.emailTextField.setBounds(300, 340, 400, 30);
		this.add(this.emailTextField);

		JLabel martial_status = new JLabel("Martial Status: ");
		martial_status.setFont(new Font("Arial", Font.BOLD, 20));
		martial_status.setBounds(100, 390, 200, 30);//total height covere from frame 240+30
		this.add(martial_status);

		//need radio button
		this.married = new JRadioButton("Married");
		this.married.setBounds(300,390, 100, 30);
		this.married.setFont(new Font("Arial",Font.BOLD,12 ));
		this.married.setForeground(Color.black);
		this.married.setBackground(Color.WHITE);
		this.add(this.married);

		this.unmarried = new JRadioButton("Unmarried");
		this.unmarried.setBounds(410,390, 120, 30);
		this.unmarried.setFont(new Font("Arial",Font.BOLD,12 ));
		this.unmarried.setForeground(Color.black);
		this.unmarried.setBackground(Color.WHITE);
		this.add(this.unmarried);

		this.other = new JRadioButton("Other");
		this.other.setBounds(540,390, 120, 30);
		this.other.setFont(new Font("Arial",Font.BOLD,12 ));
		this.other.setForeground(Color.black);
		this.other.setBackground(Color.WHITE);
		this.add(this.other);

		ButtonGroup martialStatusGroup = new ButtonGroup();
		martialStatusGroup.add(this.married);
		martialStatusGroup.add(this.unmarried);
		martialStatusGroup.add(this.other);


		JLabel address = new JLabel("Address: ");
		address.setFont(new Font("Arial", Font.BOLD, 20));
		address.setBounds(100, 440, 100, 30);//total height covere from frame 240+30
		this.add(address);

		this.addressTextField = new JTextField();
		this.addressTextField.setFont(new Font("Arial", Font.BOLD, 14));
		this.addressTextField.setBounds(300, 440, 400, 30);
		this.add(this.addressTextField);

		JLabel city = new JLabel("City: ");
		city.setFont(new Font("Arial", Font.BOLD, 20));
		city.setBounds(100, 490, 100, 30);//total height covere from frame 240+30
		this.add(city);


		this.cityTextField = new JTextField();
		this.cityTextField.setFont(new Font("Arial", Font.BOLD, 14));
		this.cityTextField.setBounds(300, 490, 400, 30);
		this.add(this.cityTextField);

		JLabel state = new JLabel("State: ");
		state.setFont(new Font("Arial", Font.BOLD, 20));
		state.setBounds(100, 540, 100, 30);//total height covere from frame 240+30
		this.add(state);

		this.stateTextField = new JTextField();
		this.stateTextField.setFont(new Font("Arial", Font.BOLD, 14));
		this.stateTextField.setBounds(300, 540, 400, 30);
		this.add(this.stateTextField);


		JLabel pincode = new JLabel("Pincode: ");
		pincode.setFont(new Font("Arial", Font.BOLD, 20));
		pincode.setBounds(100, 590, 100, 30);//total height covered from frame 240+30
		this.add(pincode);

		this.pincodeTextField = new JTextField();
		this.pincodeTextField.setFont(new Font("Arial", Font.BOLD, 14));
		this.pincodeTextField.setBounds(300, 590, 400, 30);
		this.add(this.pincodeTextField);

		this.next = new JButton("Next");
		this.next.setBackground(Color.black);
		this.next.setForeground(Color.white);
		this.next.setFont(new Font("Raleway", Font.BOLD, 14));
		this.next.setBounds(620,660, 80, 30);
		this.next.addActionListener(this);
		this.add(this.next);


		this.getContentPane().setBackground(Color.white);
		this.setSize(850, 800);
		this.setLocation(350,10);
		this.setVisible(true);
	}

	public static void main(String[] args) {

		new SignupOne();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String formno = ""+this.application_number; //long
		String name = this.nameTextField.getText().trim();  //not null
		String father_name = this.father_nameTextField.getText().trim();
		Date dob = this.dateChooser.getDate(); //not null

		String gender = null;
		if(this.male.isSelected()) {
			gender = "Male";
		}else if(this.female.isSelected()) { gender = "Female"; 
		}else {
			JOptionPane.showMessageDialog(null, "Please select Gender"); 
			return; 
		}
		String email = this.emailTextField.getText().trim(); //email

		String martial_status = null;
		if(this.married.isSelected()) {
			martial_status = "Married";
		}else if (this.unmarried.isSelected()) {
			martial_status = "Unmarried";
		}else if(this.other.isSelected()) {
			martial_status = "Other";
		}else {
			JOptionPane.showMessageDialog(null, "Please select Martial Status");
			return;
		}

		String address = this.addressTextField.getText().trim();
		String city = this.cityTextField.getText().trim(); //not null
		String pincode = this.pincodeTextField.getText().trim(); //not null
		String state = this.stateTextField.getText().trim();

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
			this.setVisible(false);
			new SignupTwo(formno).setVisible(true);




		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}