package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.UserInputs;
import utility.ConnectionManager;

public class UserDAO {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void displayCity() throws ClassNotFoundException, SQLException {
		String sql = "Select * from city";
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		System.out.format("%-20s%-20s%n", "CITY ID", "CITY NAME");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("city_name");
			System.out.format("%-20s%-20s%n", id, name);
		}

	}

	public void displayTheatre(UserInputs userinputs) throws SQLException, ClassNotFoundException {
		int city_id = userinputs.getCity_id();
		Statement st = ConnectionManager.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM theatre");
		System.out.format("%-20s%-20s%n", "ID", "THEATRE NAME");
		int temp = 1;
		while (rs.next()) {
			if (city_id == (rs.getInt("city_id"))) {
				int id = rs.getInt("id");
				String theatre_name = rs.getString("theatre_name");
				System.out.format("%-20s%-20s%n", id, theatre_name);
				temp = 0;
			}
		}
		if (temp == 1)
			System.out.println("No theatre found in the given city id");
	}

	public void displayMovie(UserInputs userinputs) throws ClassNotFoundException, SQLException {
		int theatre_id = userinputs.getTheatre_id();
		Statement st = ConnectionManager.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM movie");
		System.out.format("%-20s%-20s%n", "MOVIE ID", "MOVIE NAME");
		int temp = 1;
		while (rs.next()) {
			if (theatre_id == (rs.getInt("theatre_id"))) {
				int id = rs.getInt("id");
				String movie_name = rs.getString("movie_name");
				System.out.format("%-20s%-20s%n", id, movie_name);
				temp = 0;
			}
		}
		if (temp == 1)
			System.out.println("No movie found in the given theatre id");

	}

	public void displayTicket(UserInputs userinputs)
			throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		int movie_id = userinputs.getMovie_id();
		Statement st = ConnectionManager.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM ticket");
		System.out.format("%-20s%-20s%-20s%n", "TICKET ID", "TOTAL TICKET", "AMOUNT");
		int temp = 1;
		while (rs.next()) {
			if (movie_id == (rs.getInt("movie_id"))) {
				int id = rs.getInt("id");
				int ticketCount = rs.getInt("ticketCount");
				int amount = rs.getInt("amount");
				System.out.format("%-20s%-20s%-20s%n", id, ticketCount, amount);
				System.out.println("How many tickets do you want to book?");
				int count = Integer.parseInt(br.readLine());
				if (count <= ticketCount) {
					int total = ticketCount - count;
					int cur_id = movie_id;
					String sql = "UPDATE ticket SET ticketCount = ? where movie_id = ?";
					// CREATE STATEMENT OBJECT
					PreparedStatement st1 = ConnectionManager.getConnection().prepareStatement(sql);
					st1.setInt(1, total);
					st1.setInt(2, cur_id);
					st1.executeUpdate();
					System.out.println("Successfully booked!");
				} else {
					System.out.println("Ticket not available");
				}
				temp = 0;
			}
		}
		if (temp == 1)
			System.out.println("No movie found in the given theatre id");

	}
}
