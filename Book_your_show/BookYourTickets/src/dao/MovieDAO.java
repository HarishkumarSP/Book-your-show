package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Movie;
import utility.ConnectionManager;

public class MovieDAO {
	public void addMovie(Movie movie) throws ClassNotFoundException, SQLException {
		int id = movie.getId();
		String movie_name = movie.getMovie_name();
		int theatre_id = movie.getTheatre_id();

		// insert all the details into database
		String sql = "insert into MOVIE(id,movie_name,theatre_id)VALUES(?,?,?)";
		// CREATE STATEMENT OBJECT
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);

		st.setInt(1, id);
		st.setString(2, movie_name);
		st.setInt(3, theatre_id);

		st.executeUpdate();

		System.out.println("A new movie was inserted successfully!");

		ConnectionManager.getConnection().close();
	}

	public ArrayList<Movie> displayMovie(Movie movie) throws ClassNotFoundException, SQLException {
		ArrayList<Movie> movieDetailList = new ArrayList<>();
		String sql = "Select * from movie";
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		System.out.print("The available Movies are\n");
		while (rs.next()) {
			int id = rs.getInt("id");
			String movie_name = rs.getString("movie_name");
			int theatre_id = rs.getInt("theatre_id");
			movieDetailList.add(new Movie(id, movie_name,theatre_id));
		}
		
		return movieDetailList;
	}

	public void deleteMovie(Movie movie) throws ClassNotFoundException, SQLException {
		int movie_id = movie.getId();
		String sql = "DELETE FROM movie WHERE id=?";
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);

		ps.setInt(1, movie_id);

		ps.executeUpdate();
		
			System.out.println("A movie is deleted successfully!");
			ConnectionManager.getConnection().close();

	}

}
