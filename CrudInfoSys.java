import java.awt.EventQueue;
import java.sql.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel; 

public class CrudInfoSys {

	private JFrame frame;
	private JTextField textFirstName;
	private JTextField textMiddleName;
	private JTextField textFamilyName;
	private JTextField textDoB;
	private JTextField textSSN;
	private JTextField textCurrentAddress;
	private JTable table; 

    
	String[] col = {"ID","First Name", "M. Name", "Fam. Name", "Suffix",
	 "Gender", "Date of Birth", "Nationality", "SSN", "Current Address"};
    DefaultTableModel tableModel = new DefaultTableModel(col,0);
	
	Connection con;
	Statement stmt;
	String sql;
	ResultSet rs;
	private JTextField textSearchBar;
     


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudInfoSys window = new CrudInfoSys();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void Connections(){
	
			try {
				String url = "jdbc:mysql://localhost:3306/demo";
				String root = "root";
				String pass = "";	
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url,root,pass);
				stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
	
		}

	}

	  public void find(int a){
		  int find = a;
	  
	// 	try {
	// 		String url = "jdbc:mysql://localhost:3306/demo";
	// 		String root = "root";
	// 		String pass = "";	
	// 		Class.forName("com.mysql.cj.jdbc.Driver");
	// 		con = DriverManager.getConnection(url,root,pass);
	// 		stmt = con.createStatement();
	// 		sql ="SELECT * from user WHERE id = ' " + find + "  ' ";
	// 		rs = stmt.executeQuery(sql);
	// 	 if(rs.next()){
	// 		String id,fname,mname,lname,suffix,nationality,sex,bday,address,ssn;
	// 		id =  rs.getString("id");
	// 		fname =  rs.getString("fname");
	// 		mname =  rs.getString("mname");
	// 		lname =  rs.getString("lname");
	// 		suffix =  rs.getString("suffix");
	// 		nationality =  rs.getString("nationality");
	// 		sex =  rs.getString("gender");
	// 		bday =  rs.getString("Birthdate");
	// 		address =  rs.getString("address");
	// 		ssn  =  rs.getString("ssn");

		 
		 
	// 		System.out.println("Id:" + id +
	// 		" Name: " + fname 
	// 	+" "+ mname
	// 	+" "+ lname
	// 	+" "+ suffix
	// 	+" |Nationality: "+ nationality
	// 	+" |Sex: "+ sex
	// 	+" |Birthdate: "+ bday
	// 	+" |Address: "+ address
	// 	+" |SSN: "+ ssn);
	// 	 }	
	
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// }
		  


	  }
      public void fetch(){
		try {
			String url = "jdbc:mysql://localhost:3306/demo";
			String root = "root";
			String pass = "";	
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,root,pass);
			stmt = con.createStatement();
			sql = "SELECT * from user" ;
			rs = stmt.executeQuery(sql);
	

			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_2.setBounds(10, 331, 556, 158);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 536, 136);
			panel_2.add(scrollPane);
		   
			table = new JTable();

		

			while(rs.next()){
				String id,fname,mname,lname,suffix,nationality,sex,bday,address,ssn;
				
				id =  rs.getString("id");
				fname =  rs.getString("fname");
				mname =  rs.getString("mname");
				lname =  rs.getString("lname");
				suffix =  rs.getString("suffix");
				nationality =  rs.getString("nationality");
				sex =  rs.getString("gender");
				bday =  rs.getString("Birthdate");
				address =  rs.getString("address");
				ssn  =  rs.getString("ssn");

				System.out.println("Id:" + id +
				 " Name: " + fname 
				+" "+ mname
				+" "+ lname
				+" "+ suffix
				+" |Nationality: "+ nationality
				+" |Sex: "+ sex
				+" |Birthdate: "+ bday
				+" |Address: "+ address
				+" |SSN: "+ ssn);
			String [] data = {id,fname,mname, lname, suffix, sex, bday, nationality, ssn, address};
			tableModel.addRow(data);
			 }    

		 if(table == null){
			 table = new JTable(tableModel);
              
		 }else{
			table.setModel(tableModel);

		 }
		
			scrollPane.setViewportView(table);

	} 
		catch (Exception c) {
			c.printStackTrace();
		
		}
		  
        

	  }

	public CrudInfoSys() {
		initialize();
	}
    
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {

		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.setBounds(100, 100, 592, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 556, 254);
		frame.getContentPane().add(panel);
		panel.setLayout(null);


		JLabel lblNewLabel = new JLabel("First Name\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 9, 68, 20);
		panel.add(lblNewLabel);


		JLabel lblNewLabel_1 = new JLabel("Middle Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 36, 77, 20);
		panel.add(lblNewLabel_1);


		JLabel lblNewLabel_2 = new JLabel("Family Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 59, 77, 20);
		panel.add(lblNewLabel_2);


		textFirstName = new JTextField();
		textFirstName.setBounds(90, 9, 146, 20);
		panel.add(textFirstName);
		textFirstName.setColumns(10);


		textMiddleName = new JTextField();
		textMiddleName.setColumns(10);
		textMiddleName.setBounds(90, 36, 146, 20);
		panel.add(textMiddleName);


		textFamilyName = new JTextField();
		textFamilyName.setColumns(10);
		textFamilyName.setBounds(90, 59, 146, 20);
		panel.add(textFamilyName);


		JLabel lblNewLabel_3 = new JLabel("Bio. Gender");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(246, 12, 86, 14);
		panel.add(lblNewLabel_3);



		JLabel lblNewLabel_4 = new JLabel("Date of Birth");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(246, 37, 86, 20);
		panel.add(lblNewLabel_4);


		JLabel lblNewLabel_2_1 = new JLabel("Suffix\r\n");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(10, 89, 68, 20);
		panel.add(lblNewLabel_2_1);


		JComboBox boxSuffix = new JComboBox();
		boxSuffix.setModel(new DefaultComboBoxModel(new String[] { "None.", "Jr.", "Sr." }));
		boxSuffix.setBounds(90, 89, 146, 22);
		panel.add(boxSuffix);


		JComboBox boxGender = new JComboBox();
		boxGender.setModel(new DefaultComboBoxModel(new String[] { "None.", "MALE", "FEMALE" }));
		boxGender.setBounds(342, 9, 185, 22);
		panel.add(boxGender);

		textDoB = new JTextField();
		textDoB.setBounds(342, 37, 185, 20);
		panel.add(textDoB);
		textDoB.setColumns(10);

		JLabel lblNewLabel_4_1 = new JLabel("SSN");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(246, 59, 86, 20);
		panel.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("Nationality");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_2.setBounds(246, 89, 86, 20);
		panel.add(lblNewLabel_4_2);

		textSSN = new JTextField();
		textSSN.setColumns(10);	
		textSSN.setBounds(342, 60, 185, 20);
		panel.add(textSSN);

		JLabel lblNewLabel_2_1_1 = new JLabel("Current Address");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(10, 154, 226, 20);
		panel.add(lblNewLabel_2_1_1);

		textCurrentAddress = new JTextField();
		textCurrentAddress.setBounds(122, 155, 424, 88);
		panel.add(textCurrentAddress);
		textCurrentAddress.setColumns(10);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFirstName.setText(null);
				textMiddleName.setText(null);
				textFamilyName.setText(null);
				textDoB.setText(null);
				textSSN.setText(null);
				textCurrentAddress.setText(null);
				boxSuffix.setSelectedItem("None.");
				boxGender.setSelectedItem("None.");
				boxNatl.setSelectedItem("Afghan");
			}
		});
		btnClear.setBounds(441, 120, 89, 23);
		panel.add(btnClear);
		
			JComboBox boxNatl = new JComboBox();
		boxNatl.setModel(new DefaultComboBoxModel(new String[] 	
		{"Afghan", "Albanian", "Algerian", "American", "Andorran", "Angolan", "Antiguans", "Argentinean", "Armenian", "Australian", "Austrian", "Azerbaijani", "Bahamian", "Bahraini", "Bangladeshi", "Barbadian", "Barbudans", "Batswana", "Belarusian", "Belgian", "Belizean", "Beninese", "Bhutanese", "Bolivian", "Bosnian", "Brazilian", "British", "Bruneian", "Bulgarian", "Burkinabe", "Burmese", "Burundian", "Cambodian", "Cameroonian", "Canadian", "Cape Verdean", "Central African", "Chadian", "Chilean", "Chinese", "Colombian", "Comoran", "Congolese", "Costa Rican", "Croatian", "Cuban", "Cypriot", "Czech", "Danish", "Djibouti", "Dominican", "Dutch", "East Timorese", "Ecuadorean", "Egyptian", "Emirian", "Equatorial Guinean", "Eritrean", "Estonian", "Ethiopian", "Fijian", "Filipino", "Finnish", "French", "Gabonese", "Gambian", "Georgian", "German", "Ghanaian", "Greek", "Grenadian", "Guatemalan", "Guinea-Bissauan", "Guinean", "Guyanese", "Haitian", "Herzegovinian", "Honduran", "Hungarian", "I-Kiribati", "Icelander", "Indian", "Indonesian", "Iranian", "Iraqi", "Irish", "Israeli", "Italian", "Ivorian", "Jamaican", "Japanese", "Jordanian", "Kazakhstani", "Kenyan", "Kittian and Nevisian", "Kuwaiti", "Kyrgyz", "Laotian", "Latvian", "Lebanese", "Liberian", "Libyan", "Liechtensteiner", "Lithuanian", "Luxembourger", "Macedonian", "Malagasy", "Malawian", "Malaysian", "Maldivian", "Malian", "Maltese", "Marshallese", "Mauritanian", "Mauritian", "Mexican", "Micronesian", "Moldovan", "Monacan", "Mongolian", "Moroccan", "Mosotho", "Motswana", "Mozambican", "Namibian", "Nauruan", "Nepalese", "New Zealander", "Ni-Vanuatu", "Nicaraguan", "Nigerian", "Nigerien", "North Korean", "Northern Irish", "Norwegian", "Omani", "Pakistani", "Palauan", "Panamanian", "Papua New Guinean", "Paraguayan", "Peruvian", "Polish", "Portuguese", "Qatari", "Romanian", "Russian", "Rwandan", "Saint Lucian", "Salvadoran", "Samoan", "San Marinese", "Sao Tomean", "Saudi", "Scottish", "Senegalese", "Serbian", "Seychellois", "Sierra Leonean", "Singaporean", "Slovakian", "Slovenian", "Solomon Islander", "Somali", "South African", "South Korean", "Spanish", "Sri Lankan", "Sudanese", "Surinamer", "Swazi", "Swedish", "Swiss", "Syrian", "Taiwanese", "Tajik", "Tanzanian", "Thai", "Togolese", "Tongan", "Trinidadian or Tobagonian", "Tunisian", "Turkish", "Tuvaluan", "Ugandan", "Ukrainian", "Uruguayan", "Uzbekistani", "Venezuelan", "Vietnamese", "Welsh", "Yemenite", "Zambian", "Zimbabwean"}));
		boxNatl.setMaximumRowCount(194);
		boxNatl.setBounds(342, 89, 185, 22);
		panel.add(boxNatl);
		
		textSearchBar = new JTextField();
		textSearchBar.setBounds(37, 123, 281, 20);
		panel.add(textSearchBar);
		textSearchBar.setColumns(10);
		
		JButton btnSearch = new JButton("Find");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idnum;
				
				idnum = textSearchBar.getText();
				int idnum1 = Integer.parseInt(idnum);
			    find(idnum1);
			
				try {
					String url = "jdbc:mysql://localhost:3306/demo";
					String root = "root";
					String pass = "";	
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(url,root,pass);
					stmt = con.createStatement();
					sql ="SELECT * from user WHERE id = ' " + idnum1 + "  ' ";
					rs = stmt.executeQuery(sql);
				 if(rs.next()){
					String id,fname,mname,lname,suffix,nationality,sex,bday,address,ssn;
					id =  rs.getString("id");
					fname =  rs.getString("fname");
					mname =  rs.getString("mname");
					lname =  rs.getString("lname");
					suffix =  rs.getString("suffix");
					nationality =  rs.getString("nationality");
					sex =  rs.getString("gender");
					bday =  rs.getString("Birthdate");
					address =  rs.getString("address");
					ssn  =  rs.getString("ssn");
		
				 
				 
					System.out.println("Id:" + id +
				" Name: " + fname 
				+" "+ mname
				+" "+ lname
				+" "+ suffix
				+" |Nationality: "+ nationality
				+" |Sex: "+ sex
				+" |Birthdate: "+ bday
				+" |Address: "+ address
				+" |SSN: "+ ssn);
				
				textFirstName.setText(fname);
				textMiddleName.setText(mname);
				textFamilyName.setText(lname);
				textDoB.setText(bday);
				textSSN.setText(ssn);
				textCurrentAddress.setText(address);
				boxNatl.setModel(nationality);
				boxGender.setText();
				boxSuffix.setText();
			}	
			
				} catch (Exception a) {
					a.printStackTrace();
			}
			
			}
		});
		btnSearch.setBounds(342, 120, 89, 23);
		panel.add(btnSearch);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("id");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(10, 120, 226, 20);
		panel.add(lblNewLabel_2_1_1_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 276, 556, 44);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetch();


			}
		});
		btnView.setBounds(10, 11, 125, 23);
		panel_1.add(btnView);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String 
				fName, 
				mName, 
				fmName,
				sfx,
				gender,
				Nationality,
				CurrentAddress;
				String dateOfBirth; 
				String Ssn;

				fName = textFirstName.getText();
				mName = textMiddleName.getText();
				fmName = textFamilyName.getText();
				dateOfBirth = textDoB.getText();
				Ssn = textSSN.getText();
				CurrentAddress = textCurrentAddress.getText();
				Nationality = (String) boxNatl.getSelectedItem();
				gender = (String) boxGender.getSelectedItem();
				sfx = (String) boxSuffix.getSelectedItem();
				
				try{
					String url = "jdbc:mysql://localhost:3306/demo";
			        String root = "root";
			        String pass = "";	
			        Class.forName("com.mysql.cj.jdbc.Driver");
			        con = DriverManager.getConnection(url,root,pass);
			        stmt = con.createStatement();

					sql =  "INSERT into user(fname,lname,mname,suffix,address,nationality,Birthdate,ssn,gender)" + 
					"Values('" +  fName + "', '" + fmName + "', '" + mName + "', '" + sfx + "', '" + CurrentAddress + "', '" + Nationality + "', '" + dateOfBirth + "', '" + Ssn + "', '" + gender + "')";
					stmt.executeUpdate(sql);
				   }
					catch(Exception a){
						a.printStackTrace();
				   }

				   System.out.println(fName +" " 
				   + mName+ " " 
				   + fmName + " " + sfx + " " 
				   + CurrentAddress + " " 
				   + Nationality + " " 
				   + gender + " "
				   + dateOfBirth + " "
				   + Ssn+ " ");
				   

			}
		});

		btnCreate.setBounds(145, 11, 127, 23);
		panel_1.add(btnCreate);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(282, 11, 127, 23);
		panel_1.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnDelete.setBounds(419, 11, 127, 23);
		panel_1.add(btnDelete);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 331, 556, 158);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 536, 136);
		panel_2.add(scrollPane);

	
	}
}