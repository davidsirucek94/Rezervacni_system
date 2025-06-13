package Kino.RezervacniSystem;

import Kino.Storage.IStorable;
import java.util.UUID;

public class Film implements IStorable {

	private String name;
	private Genre genre;
	private int lengthInMin;
	private double price;
	private UUID id;

	public Film(String name, Genre genre, int lengthInMin, double price) {
		this(UUID.randomUUID(), name, genre, lengthInMin, price);
	} // tento this volá druhý konstruktor, aby mu předal parametry

	public Film(UUID id, String name, Genre genre, int lengthInMin, double price) {
		this.name = name;
		this.genre = genre;
		this.lengthInMin = lengthInMin;
		this.price = price;
		this.id = id;
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

	public static Film fromCsv(String[] row) {
		return new Film(UUID.fromString(row[0]), row[1], Genre.valueOf(row[2]), Integer.parseInt(row[3]), Double.parseDouble(row[4]));
	}

	@Override
	public String toString() {
		return String.format("Film: %s, Genre: %s, Lenght: %d min", name, genre, lengthInMin);
	}

	@Override
	public String toCsv() {
		return id + ";" + name + ";" + genre + ";" + lengthInMin + ";" + price;
	}

	@Override
	public UUID getId() {
		return id;
	}
}
