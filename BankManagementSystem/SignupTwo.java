
package BankManagementSystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class SignupTwo extends JFrame implements ActionListener{

	//  JLabel formno, personDetails, name, fname,dob, gender, email, martialStatus, address, state, city, pincode;
	JTextField panTextField, aadharTextField;
	JRadioButton cyes, cno, yes, no;
	JButton next;
	JComboBox religionBox, categoryBox, educationBox, occupationBox, citizenshipBox,  incomeBox;
	String formno;
	SignupTwo(String formno){
		this.formno = formno;

		setLayout(null);
		setTitle("Additional Details");



		JLabel AdditionalDetails = new JLabel("Part B: \"Additional Details\"");
		AdditionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
		AdditionalDetails.setBounds(290, 80, 400, 30);
		add(AdditionalDetails);

		JLabel religion = new JLabel("Religion: ");
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(100, 140, 200, 30);//total height covered from frame 170
		add(religion);

		String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christan", "Other"};
		religionBox = new JComboBox(valReligion);
		religionBox.setBounds(300, 140, 400, 30);
		religionBox.setBackground(Color.white);
		add(religionBox);


		JLabel category = new JLabel("Category: ");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100, 190, 200, 30);//total height covered from frame 190+30
		add(category);

		String valCategory[] = {"General", "OBC", "SC/ST", "Other"};
		categoryBox = new JComboBox(valCategory);
		categoryBox.setBounds(300, 190, 400, 30);
		categoryBox.setBackground(Color.white);
		add(categoryBox);


		JLabel income = new JLabel("Income: ");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100, 240, 100, 30);//total height covered from frame 240+30
		add(income);

		String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000"};
		incomeBox = new JComboBox(valIncome);
		incomeBox.setBounds(300, 240, 400, 30);
		incomeBox.setBackground(Color.white);
		add(incomeBox);

		JLabel citizenship = new JLabel("CitizenShip: ");
		citizenship.setFont(new Font("Raleway", Font.BOLD, 20));
		citizenship.setBounds(100, 290, 200, 30);//total height covered from frame 240+30
		add(citizenship);

		String valCitizenship[] = {"Indian", "Non Residential Indian(NRI)", "Other"};
		citizenshipBox = new JComboBox(valCitizenship);
		citizenshipBox.setBounds(300, 290, 400, 30);
		citizenshipBox.setBackground(Color.white);
		add(citizenshipBox);

		JLabel education = new JLabel("Education: ");
		education.setFont(new Font("Raleway", Font.BOLD, 20));
		education.setBounds(100, 340, 200, 30);//total height covered from frame 240+30
		add(education);

		String valEducation[] = {"Matric", "Intermediate", "Graduate", "Post-Graduate", "Phd.", "Other"};
		educationBox = new JComboBox(valEducation);
		educationBox.setBounds(300, 340, 400, 30);
		educationBox.setBackground(Color.white);
		add(educationBox);

		JLabel occupation = new JLabel("Occupation: ");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(100, 390, 200, 30);//total height covered from frame 240+30
		add(occupation);

		String valOccupation[] = {"Salaried", "Self-Employed", "Student", "Other"};
		occupationBox = new JComboBox(valOccupation);
		occupationBox .setBounds(300, 390, 400, 30);
		occupationBox .setBackground(Color.white);
		add(occupationBox );

		JLabel pan = new JLabel("PAN no: ");
		pan.setFont(new Font("Raleway", Font.BOLD, 20));
		pan.setBounds(100, 440, 100, 30);//total height covered from frame 240+30
		add(pan);

		panTextField = new JTextField();
		panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		panTextField.setBounds(300, 440, 400, 30);
		add(panTextField);

		JLabel aadhar = new JLabel("Aadhar No.: ");
		aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
		aadhar.setBounds(100, 490, 200, 30);//total height covered from frame 240+30
		add(aadhar);


		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		aadharTextField.setBounds(300, 490, 400, 30);
		add(aadharTextField);

		JLabel citizen = new JLabel("Senior Citizen: ");
		citizen.setFont(new Font("Raleway", Font.BOLD, 20));
		citizen.setBounds(100, 540, 200, 30);//total height covered from frame 240+30
		add(citizen);

		cyes = new JRadioButton("Yes");
		cyes.setBounds(300,540, 60, 30);
		cyes.setFont(new Font("Raleway",Font.BOLD,12 ));
		cyes.setForeground(Color.black);
		cyes.setBackground(Color.white);
		add(cyes);

		cno = new JRadioButton("No");
		cno.setBounds(410, 540, 120, 30);
		cno.setFont(new Font("Raleway",Font.BOLD,12 ));
		cno.setForeground(Color.black);
		cno.setBackground(Color.WHITE);
		add(cno);

		ButtonGroup citizenGroup = new ButtonGroup();
		citizenGroup.add(cyes);
		citizenGroup.add(cno);


		JLabel  existing_account = new JLabel("Existing Account: ");
		existing_account.setFont(new Font("Raleway", Font.BOLD, 20));
		existing_account.setBounds(100, 590, 200, 30);//total height covered from frame 240+30
		add(existing_account);


		yes = new JRadioButton("Yes");
		yes.setBounds(300,590, 60, 30);
		yes.setFont(new Font("Raleway",Font.BOLD,12 ));
		yes.setForeground(Color.black);
		yes.setBackground(Color.white);
		add(yes);

		no = new JRadioButton("No");
		no.setBounds(410,590, 120, 30);
		no.setFont(new Font("Raleway",Font.BOLD,12 ));
		no.setForeground(Color.black);
		no.setBackground(Color.WHITE);
		add(no);

		ButtonGroup existing_accountGroup = new ButtonGroup();
		existing_accountGroup.add(yes);
		existing_accountGroup.add(no);


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



	@Override
	public void actionPerformed(ActionEvent ae) {
		String formno = this.formno; //long
		String religion = (String)religionBox.getSelectedItem();  //not null
		String category = (String)categoryBox.getSelectedItem();
		String income = (String)incomeBox.getSelectedItem();
		String education = (String)educationBox.getSelectedItem();
		String occupation = (String)occupationBox.getSelectedItem();

		String pan = panTextField.getText().trim();
		String aadhar = aadharTextField.getText().trim();

		String seniorcitizen = null;
		if(cyes.isSelected()) {
			seniorcitizen = "yes";
		}else if(cno.isSelected()) { seniorcitizen = "no"; 
		}else {
			JOptionPane.showMessageDialog(null, "Please select Senior Citizen"); 
			return; 
		}

		String existingaccount = null;
		if(yes.isSelected()) {
			existingaccount = "yes";
		}else if(no.isSelected()) { existingaccount = "no"; 
		}else {
			JOptionPane.showMessageDialog(null, "Please select existing account"); 
			return; 
		}

		String citizenship = (String)citizenshipBox.getSelectedItem();



		try {
			Conn c = new Conn();
			//String query =  "insert into signup values('"+formno+"', '"+name+"', '"+fname+"','"+dob+"','"+gender+"', '"+email+"','"+martialStatus+"', '"+address+"', '"+city+"', '"+pincode+"','"+state+"')";


			String query = "INSERT INTO signup2(formno, religion, category, income, education, occupation, pan, aadhar, seniorcitizen, existingaccount, citizenship) " +
					"VALUES(?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = c.con.prepareStatement(query);

			ps.setString(1, formno);
			ps.setString(2, religion);
			ps.setString(3, category);
			ps.setString(4, income);
			ps.setString(5, education);
			ps.setString(6, occupation);
			ps.setString(7, pan);
			ps.setString(8, aadhar);
			ps.setString(9, seniorcitizen);
			ps.setString(10, existingaccount);
			ps.setString(11, citizenship);

			//this will insert data in table

			ps.executeUpdate();



			ps.close();

			JOptionPane.showMessageDialog(null, "Data saved Successfully");
			setVisible(false);

		}catch (Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {

		new SignupTwo("");
	}


}
