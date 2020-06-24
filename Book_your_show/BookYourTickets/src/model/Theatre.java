package model;

public class Theatre {
	private int id;
	private String name;
	private int cityId;

	public Theatre(int id, String name, int cityId) {
		super();
		this.id = id;
		this.name = name;
		this.cityId = cityId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

}