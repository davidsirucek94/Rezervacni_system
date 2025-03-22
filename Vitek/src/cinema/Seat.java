package cinema;

public class Seat {

	private int number;
	private boolean isTaken = false;
	
	public Seat(int number) {
		this.number = number;
	}
	
	public void setTaken() {
		isTaken = true;
	}
	
	public void setEmpty() {
		isTaken = false;
	}
	
	public boolean getIsTaken() {
		return isTaken;
	}

	@Override
	public String toString() {
		return String.format("[%s]", isTaken ? "❌" : String.valueOf(currentSeat.number));
	}

	
	
}
