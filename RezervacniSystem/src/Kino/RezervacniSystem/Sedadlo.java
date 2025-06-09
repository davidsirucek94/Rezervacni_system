package Kino.RezervacniSystem;

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
	
}
