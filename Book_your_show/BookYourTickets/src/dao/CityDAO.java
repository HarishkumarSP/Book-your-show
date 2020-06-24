package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.City;
import utility.ConnectionManager;

public class CityDAO {
	public void addCity(City city) throws ClassNotFoundException, SQLException {
		int id = city.getId();
		String name = city.getName();

		// insert all the details into database
		String sql = "insert into CITY(id,city_name)VALUES(?,?)";
		// CREATE STATEMENT OBJECT
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);

		st.setInt(1, id);
		st.setString(2, name);

		st.executeUpdate();
		System.out.println("A new city was inserted successfully!");

		ConnectionManager.getConnection().close();
	}

	public ArrayList<City> displayCity(City city) throws ClassNotFoundException, SQLException {
		ArrayList<City> cityDetailList = new ArrayList<>();
		String sql = "Select * from city";
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		System.out.print("The available cities are\n");
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("city_name");
//			System.out.println(id + "\t" + name);
			cityDetailList.add(new City(id, name));
		}
		return cityDetailList;
	}

	public void deletecity(City city) throws SQLException, ClassNotFoundException {
		int city_id = city.getId();
		String sql = "DELETE FROM city WHERE id=?";
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);

		ps.setInt(1, city_id);
		ps.executeUpdate();
		System.out.println("Deleted Successfully");
		ConnectionManager.getConnection().close();

	}

}
