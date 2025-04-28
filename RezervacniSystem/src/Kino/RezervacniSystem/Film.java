package Kino.RezervacniSystem;

public class Film {

	private String name;
	private Genre genre;
	private int lengthInMin;
	private double price;

	public Film(String name, Genre genre, int lengthInMin, double price) {
		this.name = name;
		this.genre = genre;
		this.lengthInMin = lengthInMin;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Genre getGenre() {
		return genre;
	}

	public int getLengthInMin() {
		return lengthInMin;
	}
	
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return String.format("Film: %s, Genre: %s, Lenght: %d min", name, genre, lengthInMin);
	}
}
