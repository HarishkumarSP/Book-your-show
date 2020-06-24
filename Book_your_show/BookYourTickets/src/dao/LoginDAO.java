package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Login;
import utility.ConnectionManager;

public class LoginDAO {

	public boolean checkLogin(Login login) throws ClassNotFoundException, SQLException {
		String username = login.getUsername();
		String password = login.getPassword();
		Statement st = ConnectionManager.getConnection().createStatement();
		ResultSet rs =  st.executeQuery("SELECT * FROM REGISTRATION");
		while(rs.next())
		{
			if (username.equals(rs.getString("USERNAME")) && password.equals(rs.getString("PASSWORD")))
			{
				System.out.println("------------Welcome to booking your tickets-------------");
				System.out.println("Your sucessfully logged in");
				return true;
			}
		}
		return false;
		
	}

}
