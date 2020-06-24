package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Ticket;
import utility.ConnectionManager;

public class TicketDAO {
	public void addTicket(Ticket ticket) throws ClassNotFoundException, SQLException {
		int id = ticket.getId();
		int movie_id = ticket.getMovie_id();
		int ticketCount = ticket.getNoOfTicket();
		int amount = ticket.getAmount();
		
		// insert all the details into database
		String sql = "insert into TICKET(id,movie_id,ticketCount,amount)VALUES(?,?,?,?)";
		// CREATE STATEMENT OBJECT
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);

		st.setInt(1, id);
		st.setInt(2, movie_id);
		st.setInt(3, ticketCount);
		st.setInt(4, amount);

		st.executeUpdate();

		ConnectionManager.getConnection().close();

	}

	public ArrayList<Ticket> displayTicket(Ticket ticket) throws ClassNotFoundException, SQLException {
		ArrayList<Ticket> ticketDetailList = new ArrayList<>();
		String sql = "Select * from ticket";
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		System.out.print("The ticket details are\n");
		while (rs.next()) {
			int id = rs.getInt("id");
			int name = rs.getInt("movie_id");
			int totalTicket = rs.getInt("ticketCount");
			int amount = rs.getInt("amount");
			
//			System.out.println(id + "\t" + name);
			ticketDetailList.add(new Ticket(id,name,totalTicket,amount));
		}
		return ticketDetailList;
	}

	public void deleteTicket(Ticket ticket) throws ClassNotFoundException, SQLException {
		int ticket_id = ticket.getId();
		String sql = "DELETE FROM ticket WHERE id=?";
		PreparedStatement ps = ConnectionManager.getConnection().prepareStatement(sql);

		ps.setInt(1, ticket_id);
		ps.executeUpdate();
		System.out.println("Deleted Successfully");
		ConnectionManager.getConnection().close();
		
	}
	}


