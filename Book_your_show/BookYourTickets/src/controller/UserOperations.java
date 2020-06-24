package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import dao.CityDAO;
import dao.LoginDAO;
import dao.MovieDAO;
import dao.TheatreDAO;
import dao.UserDAO;
import model.Login;
import model.UserInputs;

public class UserOperations {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	CityDAO citydao = new CityDAO();
	TheatreDAO theatredao = new TheatreDAO();
	MovieDAO moviedao = new MovieDAO();
	LoginDAO logindao = new LoginDAO();
	Login login = new Login();
	UserDAO userdao = new UserDAO();
	UserInputs userinputs = new UserInputs();
	public void user() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {

		String username, password;
		System.out.println("--------------Welcome to login system----------");
		System.out.println("Enter your username");
		username = br.readLine();
		System.out.println("Enter your password");
		password = br.readLine();
		login.setUsername(username);
		login.setPassword(password);
		boolean checkLogin = logindao.checkLogin(login);
		if (checkLogin) {
			System.out.println("Do you want to book a movie ticket? 1. Yes 2. No");
			int op = Integer.parseInt(br.readLine());
			if (op == 1) {
				bookTicket();
			} else
				System.out.println("Please check your login details");
				Main.main(null);
		}
	}

	private void bookTicket() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		System.out.println("Here's a City details");
		userdao.displayCity();
		System.out.println("Choose your city using id");
		int city_id = Integer.parseInt(br.readLine());
		userinputs.setCity_id(city_id);
		System.out.println("Here comes the Theatres available from the selected city");
		userdao.displayTheatre(userinputs);
		System.out.println("Choose your theatre using id");
		int theatre_id = Integer.parseInt(br.readLine());
		userinputs.setTheatre_id(theatre_id);
		System.out.println("Here comes the movie list available from the selected theatre");
		userdao.displayMovie(userinputs);
		System.out.println("Type your movie id");
		int movie_id = Integer.parseInt(br.readLine());
		userinputs.setMovie_id(movie_id);
		System.out.println("Here comes the ticket details from the selected theatre");
		userdao.displayTicket(userinputs);
//		System.out.println("How many tickets do you want to book?");
//		int ticketCount = Integer.parseInt(br.readLine());
//		userinputs.setNoOfTicket(ticketCount);
		//userdao.bookTicket(userinputs);
	}

}
