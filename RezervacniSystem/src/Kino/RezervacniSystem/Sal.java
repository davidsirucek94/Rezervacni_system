package Kino.RezervacniSystem;

import java.util.UUID;

import Kino.Storage.IStorable;

public class Sal implements IStorable {

	public final int numberOfRoom;
	public final boolean isImax; // final to nastaví v konstruktoru a dále se to nebude měnit
	public final boolean isVip;
	public final int numberOfRows;
	public final int numberOfSeats;
	private UUID id;

	// private Misto[][] rows; // dvojrozměrné pole

	public Sal(int numberOfRoom, int numberOfRows, int numberOfSeats, boolean isImax, boolean isVip) {
		this(UUID.randomUUID(), numberOfRoom, numberOfRows, numberOfSeats, isImax, isVip);
	}

	
	public Sal(UUID id, int numberOfRoom, int numberOfRows, int numberOfSeats, boolean isImax, boolean isVip) {
		this.numberOfRoom = numberOfRoom;
		this.isImax = isImax;
		this.isVip = isVip;
		this.numberOfRows = numberOfRows;
		this.numberOfSeats = numberOfSeats;
		this.id = id;
		// rows = new Misto[numberOfRows][numberOfSeats];

		for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {

			for (int seatNumber = 0; seatNumber < numberOfSeats; seatNumber++) {
			}
		}
	}

	public static Sal fromCsv(String[] row) {
		return new Sal(UUID.fromString(row[0]), Integer.parseInt(row[1]), Integer.parseInt(row[2]), Integer.parseInt(row[3]),
				Boolean.parseBoolean(row[4]), Boolean.parseBoolean(row[5]));
	}

	@Override 
	public String toCsv() {
		return id + ";" + numberOfRoom + ";" + numberOfRows + ";" + numberOfSeats + ";" + isImax + ";" + isVip;
	}

	@Override
	public UUID getId() {
		return id;
	}
}
