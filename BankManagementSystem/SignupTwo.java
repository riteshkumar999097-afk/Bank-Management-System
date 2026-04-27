
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

		this.setLayout(null);
		this.setTitle("Additional Details");



		JLabel AdditionalDetails = new JLabel("Part B: \"Additional Details\"");
		AdditionalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
		AdditionalDetails.setBounds(290, 80, 400, 30);
		this.add(AdditionalDetails);

		JLabel religion = new JLabel("Religion: ");
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(100, 140, 200, 30);//total height covered from frame 170
		this.add(religion);

		String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christan", "Other"};
		this.religionBox = new JComboBox(valReligion);
		this.religionBox.setBounds(300, 140, 400, 30);
		this.religionBox.setBackground(Color.white);
		this.add(this.religionBox);


		JLabel category = new JLabel("Category: ");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100, 190, 200, 30);//total height covered from frame 190+30
		this.add(category);

		String valCategory[] = {"General", "OBC", "SC/ST", "Other"};
		this.categoryBox = new JComboBox(valCategory);
		this.categoryBox.setBounds(300, 190, 400, 30);
		this.categoryBox.setBackground(Color.white);
		this.add(this.categoryBox);


		JLabel income = new JLabel("Income: ");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100, 240, 100, 30);//total height covered from frame 240+30
		this.add(income);

		String valIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000"};
		this.incomeBox = new JComboBox(valIncome);
		this.incomeBox.setBounds(300, 240, 400, 30);
		this.incomeBox.setBackground(Color.white);
		this.add(this.incomeBox);

		JLabel citizenship = new JLabel("CitizenShip: ");
		citizenship.setFont(new Font("Raleway", Font.BOLD, 20));
		citizenship.setBounds(100, 290, 200, 30);//total height covered from frame 240+30
		this.add(citizenship);

		String valCitizenship[] = {"Indian", "Non Residential Indian(NRI)", "Other"};
		this.citizenshipBox = new JComboBox(valCitizenship);
		this.citizenshipBox.setBounds(300, 290, 400, 30);
		this.citizenshipBox.setBackground(Color.white);
		this.add(this.citizenshipBox);

		JLabel education = new JLabel("Education: ");
		education.setFont(new Font("Raleway", Font.BOLD, 20));
		education.setBounds(100, 340, 200, 30);//total height covered from frame 240+30
		this.add(education);

		String valEducation[] = {"Matric", "Intermediate", "Graduate", "Post-Graduate", "Phd.", "Other"};
		this.educationBox = new JComboBox(valEducation);
		this.educationBox.setBounds(300, 340, 400, 30);
		this.educationBox.setBackground(Color.white);
		this.add(this.educationBox);

		JLabel occupation = new JLabel("Occupation: ");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(100, 390, 200, 30);//total height covered from frame 240+30
		this.add(occupation);

		String valOccupation[] = {"Salaried", "Self-Employed", "Student", "Other"};
		this.occupationBox = new JComboBox(valOccupation);
		this.occupationBox .setBounds(300, 390, 400, 30);
		this.occupationBox .setBackground(Color.white);
		this.add(this.occupationBox );

		JLabel pan = new JLabel("PAN no: ");
		pan.setFont(new Font("Raleway", Font.BOLD, 20));
		pan.setBounds(100, 440, 100, 30);//total height covered from frame 240+30
		this.add(pan);

		this.panTextField = new JTextField();
		this.panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		this.panTextField.setBounds(300, 440, 400, 30);
		this.add(this.panTextField);

		JLabel aadhar = new JLabel("Aadhar No.: ");
		aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
		aadhar.setBounds(100, 490, 200, 30);//total height covered from frame 240+30
		this.add(aadhar);


		this.aadharTextField = new JTextField();
		this.aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		this.aadharTextField.setBounds(300, 490, 400, 30);
		this.add(this.aadharTextField);

		JLabel citizen = new JLabel("Senior Citizen: ");
		citizen.setFont(new Font("Raleway", Font.BOLD, 20));
		citizen.setBounds(100, 540, 200, 30);//total height covered from frame 240+30
		this.add(citizen);

		this.cyes = new JRadioButton("Yes");
		this.cyes.setBounds(300,540, 60, 30);
		this.cyes.setFont(new Font("Raleway",Font.BOLD,12 ));
		this.cyes.setForeground(Color.black);
		this.cyes.setBackground(Color.white);
		this.add(this.cyes);

		this.cno = new JRadioButton("No");
		this.cno.setBounds(410, 540, 120, 30);
		this.cno.setFont(new Font("Raleway",Font.BOLD,12 ));
		this.cno.setForeground(Color.black);
		this.cno.setBackground(Color.WHITE);
		this.add(cno);

		ButtonGroup citizenGroup = new ButtonGroup();
		citizenGroup.add(this.cyes);
		citizenGroup.add(this.cno);


		JLabel  existing_account = new JLabel("Existing Account: ");
		existing_account.setFont(new Font("Raleway", Font.BOLD, 20));
		existing_account.setBounds(100, 590, 200, 30);//total height covered from frame 240+30
		this.add(existing_account);


		this.yes = new JRadioButton("Yes");
		this.yes.setBounds(300,590, 60, 30);
		this.yes.setFont(new Font("Raleway",Font.BOLD,12 ));
		this.yes.setForeground(Color.black);
		this.yes.setBackground(Color.white);
		this.add(this.yes);

		this.no = new JRadioButton("No");
		this.no.setBounds(410,590, 120, 30);
		this.no.setFont(new Font("Raleway",Font.BOLD,12 ));
		this.no.setForeground(Color.black);
		this.no.setBackground(Color.WHITE);
		this.add(this.no);

		ButtonGroup existing_accountGroup = new ButtonGroup();
		existing_accountGroup.add(yes);
		existing_accountGroup.add(no);


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



	@Override
	public void actionPerformed(ActionEvent ae) {
		String formno = this.formno; //long
		String religion = (String)this.religionBox.getSelectedItem();  //not null
		String category = (String)this.categoryBox.getSelectedItem();
		String income = (String)this.incomeBox.getSelectedItem();
		String education = (String)this.educationBox.getSelectedItem();
		String occupation = (String)this.occupationBox.getSelectedItem();

		String pan = this.panTextField.getText().trim();
		String aadhar = this.aadharTextField.getText().trim();

		String seniorcitizen = null;
		if(this.cyes.isSelected()) {
			seniorcitizen = "yes";
		}else if(this.cno.isSelected()) { seniorcitizen = "no"; 
		}else {
			JOptionPane.showMessageDialog(null, "Please select Senior Citizen"); 
			return; 
		}

		String existingaccount = null;
		if(this.yes.isSelected()) {
			existingaccount = "yes";
		}else if(this.no.isSelected()) { existingaccount = "no"; 
		}else {
			JOptionPane.showMessageDialog(null, "Please select existing account"); 
			return; 
		}

		String citizenship = (String)this.citizenshipBox.getSelectedItem();



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
			this.setVisible(false);
		
			new SignupThree(this.formno).setVisible(true);

		}catch (Exception e) {
			e.printStackTrace();
		}
	}



	public static void main(String[] args) {

		new SignupTwo("");
	}


}
