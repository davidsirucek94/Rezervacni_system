package Kino.RezervacniSystem;

public class Sal {

	public final int numberOfRoom;
	public final boolean isImax; //final to nastaví v konstruktoru a dále se to nebude měnit
	public final boolean isVip;
	private Misto[][] rows; // dvojrozměrné pole

	public Sal(int numberOfRoom, int numberOfRows, int numberOfSeats, boolean isImax, boolean isVip) {
		this.numberOfRoom = numberOfRoom;
		this.isImax = isImax;
		this.isVip = isVip;
		rows = new Misto[numberOfRows][numberOfSeats];

		for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {

			for (int seatNumber = 0; seatNumber < numberOfSeats; seatNumber++) {

				rows[rowNumber][seatNumber] = new Misto(seatNumber + 1);
			}
		}
	}

	public Misto getSeat(int row, int seat) {
		return rows[row][seat];
	}

	public boolean bookSeat(int row, int seat) {
		Misto actualSeat = getSeat(row, seat);
		if (actualSeat.isSeatTaken()) {
			return false;
		}
		actualSeat.setSeatTaken();
		return true;
	}

	public int getEmptySeatCount() {
		int countEmpty = 0;
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < rows[i].length; j++) {
				if (!getSeat(i, j).isSeatTaken()) {
					countEmpty++;
				}
			}
		}
		return countEmpty;
	}

	public String display() {
		String result = "";
		for (int i = 0; i < rows.length; i++) {
			result = result + String.format("Row %d:", (i + 1));
			for (int j = 0; j < rows[i].length; j++) {
				result = result + getSeat(i, j);
			}
			result = result + "\n";
		}
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("Room number: %d, Rows: %d, Seats: %d, Imax: %b, VIP: %b", numberOfRoom, rows.length, rows[0].length, isImax, isVip);
	}
}
