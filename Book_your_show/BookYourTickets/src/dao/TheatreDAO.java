package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Theatre;
import utility.ConnectionManager;

public class TheatreDAO {
	public void addTheatre(Theatre theatre) throws ClassNotFoundException, SQLException {
		int id = theatre.getId();
		String name = theatre.getName();
		int cityId = theatre.getCityId();

		// insert all the details into database
		String sql = "insert into THEATRE(id,theatre_name,city_id)VALUES(?,?,?)";
		// CREATE STATEMENT OBJECT
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);

		st.setInt(1, id);
		st.setString(2, name);
		st.setInt(3, cityId);

		st.executeUpdate();
		System.out.println("A new theatre was inserted successfully!");

		ConnectionManager.getConnection().close();
	}

	public ArrayList<Theatre> displayTheatre(Theatre theatre) throws ClassNotFoundException, SQLException {
		ArrayList<Theatre> theatreDetailList = new ArrayList<>();
		String sql = "Select * from theatre";
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		System.out.print("The available cities are\n");
		while (rs.next()) {
			int id = rs.getInt("id");
			String theatre_name = rs.getString("theatre_name");
			int city_id = rs.getInt("city_id");
//					System.out.println(id + "\t" + name);
			theatreDetailList.add(new Theatre(id, theatre_name, city_id));
		}
		return theatreDetailList;
	}

	public void deleteTheatre(Theatre theatre) throws ClassNotFoundException, SQLException {
		int id = theatre.getId();
		String sql = "DELETE FROM theatre WHERE id=?";
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);

		ps.setLong(1, id);

		ps.executeUpdate();

		System.out.println("A Theatre is deleted successfully!");
		ConnectionManager.getConnection().close();

	}


}
