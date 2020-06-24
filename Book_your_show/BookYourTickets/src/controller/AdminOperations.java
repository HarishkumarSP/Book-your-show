package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CityDAO;
import dao.MovieDAO;
import dao.TheatreDAO;
import dao.TicketDAO;
import model.City;
import model.Movie;
import model.Theatre;
import model.Ticket;

public class AdminOperations {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String name = "admin";
	static String passwd = "admin123";
	City city = new City(0, null);
	CityDAO citydao = new CityDAO();
	TheatreDAO theatredao = new TheatreDAO();
	Theatre theatre = new Theatre(0, name, 0);
	Movie movie = new Movie(0, name, 0);
	MovieDAO moviedao = new MovieDAO();
	Ticket ticket = new Ticket(0, 0, 0, 0);
	TicketDAO ticketdao = new TicketDAO();

	ArrayList<City> cityList = new ArrayList<>();
	ArrayList<Movie> movieList = new ArrayList<>();
	ArrayList<Theatre> theatreList = new ArrayList<>();
	ArrayList<Ticket> ticketList = new ArrayList<>();

	public void adminlogin(String name, String password)
			throws ClassNotFoundException, SQLException, NumberFormatException, IOException

	{
		if (name.equals(name) && passwd.equals(password)) {
			System.out.println("---------Admin login is Successfull----------");
			crud();
		} else
			System.out.println("--------Please check your username or password admin!!!--------");
		System.out.println("Do you want to retry? \n1. Yes \n2. No");
		int option = Integer.parseInt(br.readLine());
		if (option == 1)
			Main.main(null);
		else
			Main.main(null);

	}

	public void crud() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {

		while (true) {
			System.out.println("------------------Please select your operations--------------");
			System.out.println("1.City Operations");
			System.out.println("2.Theatre Operations");
			System.out.println("3.Movie Operations");
			System.out.println("4.Ticket operations");
			System.out.println("5.Logout");
			int operations;

			operations = Integer.parseInt(br.readLine());

			switch (operations) {
			case 1:
				while (true) {
					System.out.println(
							"Which operation do you want to perform? \n1. Adding city \n2. View the existing cities \n3. Delete the cities \n4. Exit");
					int op = Integer.parseInt(br.readLine());
					switch (op) {
					case 1:
						addCity();
						break;
					case 2:
						displayCity();
						break;
					case 3:
						deleteCity();
						break;
					case 4:
						break;
					default:
						System.out.println("Check your option please");
					}
					if (op == 4)
						break;
					System.out.println("Do you want to continue to edit city table? 1. Yes 2. No");
					int ch = Integer.parseInt(br.readLine());
					if (ch == 1)
						continue;
					else
						break;
				}
				break;
			case 2:
				while (true) {
					System.out.println(
							"Which operation do u want to perform? \n1. Adding theatre \n2. View the existing theatres \n3. Deleting theatre \n4. Exit");
					int op = Integer.parseInt(br.readLine());
					switch (op) {
					case 1:
						addTheatre();
						break;
					case 2:
						displayTheatre();
						break;
					case 3:
						System.out.println("Enter the ID of theatre that to be deleted");
						int id = Integer.parseInt(br.readLine());
						theatre.setId(id);
						theatredao.deleteTheatre(theatre);
						break;
					case 4:
						break;
					default:
						System.out.println("Check your option please");
					}
					if (op == 4)
						break;
					System.out.println("Do you want to continue to edit theatre table? 1. Yes 2. No");
					int ch = Integer.parseInt(br.readLine());
					if (ch == 1)
						continue;
					else
						break;
				}
				break;
			case 3:
				while (true) {
					System.out.println(
							"Which operation do u want to perform? \n1. Adding Movie \n2. View the existing movies list \n3.Deleting the movie \n4.Exit");
					int op = Integer.parseInt(br.readLine());
					switch (op) {
					case 1:
						addMovie();
						break;
					case 2:
						displayMovie();
						break;
					case 3:
						System.out.println("Enter the ID of movie that to be deleted");
						int id = Integer.parseInt(br.readLine());
						movie.setId(id);
						moviedao.deleteMovie(movie);
						break;
					case 4:
						break;
					default:
						System.out.println("Check your option please");
					}
					if (op == 4)
						break;
					System.out.println("Do you want to continue to movie city table? 1. Yes 2. No");
					int ch = Integer.parseInt(br.readLine());
					if (ch == 1)
						continue;
					else
						break;
				}
				break;
			case 4:
				while (true) {
					System.out.println(
							"Which operation do u want to perform? \n1. Adding the ticket \n2. View the existing ticket list  \n3.Deleting the tickets \n4.Exit");
					int op = Integer.parseInt(br.readLine());
					switch (op) {
					case 1:
						addTicket();
						break;
					case 2:
						displayTicket();
						break;
					case 3:
						System.out.println("Enter the ID of ticket that to be deleted");
						int id = Integer.parseInt(br.readLine());
						ticket.setId(id);
						ticketdao.deleteTicket(ticket);
						break;
					case 4:
						break;
					default:
						System.out.println("Check your option please");
					}
					if (op == 4)
						break;
					System.out.println("Do you want to continue to edit ticket table? 1. Yes 2. No");
					int ch = Integer.parseInt(br.readLine());
					if (ch == 1)
						continue;
					else
						break;
				}
				break;
			case 5:
				Main.main(null);
				break;
			default:
				System.out.println("---------Please enter your correct option admin!!!-------");
				crud();
				// options = true;
				break;
			}

			System.out.println("Do you want to continue? 1. Yes 2. No");
			int option = Integer.parseInt(br.readLine());
			if (option == 1)
				continue;
			else
				break;
		}

	}
	public void addCity() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a city id name");
		int id = Integer.parseInt(br.readLine());
		System.out.println("Enter a city name");
		String name = br.readLine();
		city.setId(id);
		city.setName(name);
		citydao.addCity(city);
		System.out.println("------------City is sucessfully added!!!--------");
	}

	public void deleteCity() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		System.out.println("Enter the ID of city that to be deleted");
		int id = Integer.parseInt(br.readLine());
		city.setId(id);
		citydao.deletecity(city);

	}

	public void displayCity() throws ClassNotFoundException, SQLException {
		cityList = citydao.displayCity(city);
		System.out.format("%-20s%-20s%n", "CITY ID", "CITY NAME");
		for (City city : cityList) {

			System.out.format("%-20s%-20s%n", city.getId(), city.getName());
		}

	}

	public void addTheatre() throws ClassNotFoundException, SQLException, IOException {
		TheatreDAO theatredao = new TheatreDAO();
		// Scanner sc = new Scanner(System.in);
		System.out.println("Enter the theatre id");
		int id = Integer.parseInt(br.readLine());
		System.out.println("Enter the theatre name");
		String name = br.readLine();
		System.out.println("Enter the city id");
		int cityId = Integer.parseInt(br.readLine());
		theatre.setId(id);
		theatre.setName(name);
		theatre.setCityId(cityId);
		theatredao.addTheatre(theatre);
		System.out.println("-------------Theatre is sucessfully added-----------------");
	}

	public void displayTheatre() throws ClassNotFoundException, SQLException {
		theatreList = theatredao.displayTheatre(theatre);
		System.out.format("%-20s%-20s%-20s%n", "ID", "THEATRE NAME", "CITY ID");
		for (Theatre theatre : theatreList) {

			System.out.format("%-20s%-20s%-20s%n", theatre.getId(), theatre.getName(), theatre.getCityId());
		}

	}

	public void addMovie() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		MovieDAO moviedao = new MovieDAO();
		// Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = Integer.parseInt(br.readLine());
		System.out.println("Enter the movie name");
		String name = br.readLine();
		System.out.println("Enter the theatre id");
		int theatre_id = Integer.parseInt(br.readLine());
		movie.setId(id);
		movie.setMovie_name(name);
		movie.setTheatre_id(theatre_id);
		moviedao.addMovie(movie);
		System.out.println("-------------Theatre is sucessfully added-----------------");
	}

	public void displayMovie() throws ClassNotFoundException, SQLException {
		movieList = moviedao.displayMovie(movie);
		System.out.format("%-20s%-20s%-20s%n", "MOVIE ID", "MOVIE NAME", "THEATRE ID");
		for (Movie movie : movieList) {

			System.out.format("%-20s%-20s%-20s%n", movie.getId(), movie.getMovie_name(), movie.getTheatre_id());
		}

	}

	public void addTicket() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		TicketDAO ticketdao = new TicketDAO();
		System.out.println("Enter the  id");
		int id = Integer.parseInt(br.readLine());
		System.out.println("Enter the movie id");
		int movie_id = Integer.parseInt(br.readLine());
		System.out.println("Enter the tickets available");
		int noOfTicket = Integer.parseInt(br.readLine());
		System.out.println("Enter the amount");
		int amount = Integer.parseInt(br.readLine());
		ticket.setId(id);
		ticket.setMovie_id(movie_id);
		ticket.setNoOfTicket(noOfTicket);
		ticket.setAmount(amount);
		ticketdao.addTicket(ticket);
		System.out.println("-------------Ticket is sucessfully added-----------------");

	}

	public void displayTicket() throws ClassNotFoundException, SQLException {
		ticketList = ticketdao.displayTicket(ticket);
		System.out.format("%-20s%-20s%-20s%-20s%n", "TICKET ID", "MOVIE ID", "TOTAL TICKET", "AMOUNT");
		for (Ticket ticket : ticketList) {

			System.out.format("%-20s%-20s%-20s%-20s%n", ticket.getId(), ticket.getMovie_id(), ticket.getNoOfTicket(),
					ticket.getAmount());
		}

	}
}
