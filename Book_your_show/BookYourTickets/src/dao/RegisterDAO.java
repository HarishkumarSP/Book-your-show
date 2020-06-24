package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Register;
import utility.ConnectionManager;

public class RegisterDAO {
	public void addUser(Register reg) throws ClassNotFoundException, SQLException {
		String firstname = reg.getFirstName();
		String lastname = reg.getLastName();
		String username = reg.getUserName();
		String password = reg.getPassword();
		String emailId = reg.getEmailId();
		long mobileNo = reg.getMobileNo();

		// ConnectionManager cm = new ConnectionManager();
		// insert all the details into database
		String sql = "insert into REGISTRATION(FIRSTNAME,LASTNAME,USERNAME,PASSWORD,EMAIL,MOBILENO)VALUES(?,?,?,?,?,?)";
		// CREATE STATEMENT OBJECT
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);

		st.setString(1, firstname);
		st.setString(2, lastname);
		st.setString(3, username);
		st.setString(4, password);
		st.setString(5, emailId);
		st.setLong(6, mobileNo);

		st.executeUpdate();

		ConnectionManager.getConnection().close();

	}
}
