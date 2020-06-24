package model;

public class Ticket {
	private int id;
	private int movie_id;
	private int noOfTicket;
	private int amount;
	
	public Ticket(int id, int movieName, int noOfTicket, int amount) {
		super();
		this.id = id;
		//this.userid = userid;
		this.movie_id = movieName;
		this.noOfTicket = noOfTicket;
		this.amount = amount;
	}

	public int getNoOfTicket() {
		return noOfTicket;
	}

	public void setNoOfTicket(int noOfTicket) {
		this.noOfTicket = noOfTicket;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
