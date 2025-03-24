package Kino;

public class Film {

	private String name;
	private Genre genre;
	private int lengthInMin;

	public Film(String name, Genre genre, int lengthInMin) {
		this.name = name;
		this.genre = genre;
		this.lengthInMin = lengthInMin;
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
	
	/*
	public Film(String name, int lengthInMin) {
		this.name = name;
		this.genre = Genre.COMEDY;
		this.lengthInMin = lengthInMin;
	}
	*/

	@Override
	public String toString() {
		return String.format("Film: %s, Genre: %s, Lenght: %d min", name, genre, lengthInMin);
	}
}
