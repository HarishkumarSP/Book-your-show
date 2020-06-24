package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import dao.RegisterDAO;
import model.Register;

public class UserRegister {
	RegisterDAO regdao = new RegisterDAO();
	UserOperations userlog = new UserOperations();
	public void register() throws IOException, ClassNotFoundException, SQLException {
		Register reg = new Register();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
		System.out.println(" Enter your firstName => ");
		String firstname = br.readLine();
		System.out.println(" Enter your lastName => ");
		String lastname = br.readLine();
		System.out.println(" Enter your userName => ");
		String username = br.readLine();
		System.out.println(" Enter your password => ");
		String password = br.readLine();
		System.out.println(" Enter your emailId => ");
		String emailId = br.readLine();
		System.out.println(" Enter your  mobileNo => ");
		long mobileNo = Long.parseLong(br.readLine());
		reg.setFirstName(firstname);
		reg.setLastName(lastname);
		reg.setUserName(username);
		reg.setPassword(password);
		reg.setEmailId(emailId);
		reg.setMobileNo(mobileNo);
		regdao.addUser(reg);
		System.out.println("Your successfully registered");
		System.out.println("Do you want to add user details? 1. Yes 2. No");
		int op = Integer.parseInt(br.readLine());
		if(op == 1)
			continue;
		else
			break;
		}
		//userlog.user();

	}
}
