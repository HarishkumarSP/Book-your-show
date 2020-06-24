package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

	public static void main(
			String[] args)
			throws NumberFormatException, IOException, ClassNotFoundException, SQLException {

		System.out.println("---------------------------------------------------------");
		System.out.println("-----------------Book your show--------------------------");
		System.out.println("---------------------------------------------------------");
		while (true) {
			System.out.println("Please choose your operation");
			System.out.println("1.Admin operation");
			System.out.println("2.Registration");
			System.out.println("3.UserLogin");
			int operations;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			operations = Integer.parseInt(br.readLine());
			switch (operations) {
			case 1:
				AdminOperations admin = new AdminOperations();
				System.out.println("Enter your AdminName");
				String username = br.readLine();
				System.out.println("Enter your Password");
				String password = br.readLine();
				admin.adminlogin(username, password);
				admin.crud();
				break;
			case 2:
				UserRegister register = new UserRegister();
				register.register();

				break;
			case 3:
				UserOperations userlog = new UserOperations();
				userlog.user();

				break;
			default:
				System.out.println("!!!---------Please enter your correct operation-------!!!");
				Main.main(null);
				break;
			}
			// System.out.println("Do you want to continue? 1. Yes 2. No");
			// int option = Integer.parseInt(br.readLine());
			// if (option == 1)
			// continue;
			// else
			// break;
		}

	}

}
