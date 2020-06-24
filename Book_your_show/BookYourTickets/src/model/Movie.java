package model;

public class Movie {
	private int id;
	private String movie_name;
	private int theatre_id;
	
	public Movie(int id, String name, int theatre_id) {
		super();
		this.id = id;
		this.movie_name = name;
		this.theatre_id = theatre_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public int getTheatre_id() {
		return theatre_id;
	}

	public void setTheatre_id(int theatre_id) {
		this.theatre_id = theatre_id;
	}
	
	

}
