package Kino;

import java.util.ArrayList;
import java.util.List;

public class Sal {

	int numberOfSeats;
	int numberOfRows;
	int numberOfRoom;
	boolean isImax;
	boolean isVip;
	List<List<Misto>> seats; // seznam řad a v každé řadě je místo

	public Sal(int numberOfRoom, int numberOfRows, int numberOfSeats, boolean isImax, boolean isVip) {
		this.numberOfRoom = numberOfRoom;
		this.numberOfRows = numberOfRows;
		this.numberOfSeats = numberOfSeats;
		this.isImax = isImax;
		this.isVip = isVip;

		seats = new ArrayList<>(); //prázdný sál

		for (int i = 0; i < numberOfRows; i++) {

			seats.add(new ArrayList<>()); //přidáváme List (sedadla) do Listu (řad)

			for (int j = 0; j < numberOfSeats; j++) {

				List<Misto> currentRow = seats.get(i); // podívej se do listů a dej mi nějaký z těch vnitřních

				currentRow.add(new Misto(j + 1)); // vyrábím si místo - konstruktor
			}
		}
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < seats.size(); i++) {
			result = result + String.format("Row %d:", (i + 1));
			for (int j = 0; j < seats.get(i).size(); j++) {
				Misto currentSeat = seats.get(i).get(j);
				result = result + String.format("[%s]", currentSeat.isTaken ? "❌" : String.valueOf(currentSeat.number));
			}
			result = result + "\n";
		}
		return result;
	}
	// pokračovat na třídě promítání a rezervace
}
