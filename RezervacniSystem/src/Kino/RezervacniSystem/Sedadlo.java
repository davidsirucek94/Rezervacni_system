package Kino.RezervacniSystem;

import java.util.Objects;

public class Sedadlo {

	int row;
	int seatNumber;

	public Sedadlo(int row, int seatNumber) {
		this.row = row;
		this.seatNumber = seatNumber;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Sedadlo sedadlo) {
			return this.row == sedadlo.row && this.seatNumber == sedadlo.seatNumber;
		}
		return false;
	}

	// Method required to make object work properly in HashMaps and HashSets
	@Override
	public int hashCode() {
		return Objects.hash(row, seatNumber);
	}
}
