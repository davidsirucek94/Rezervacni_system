package Kino.RezervacniSystem;

public class Misto {

	private int number;
	private boolean isTaken = false;
	
	public Misto(int number) {
		this.number = number;
	}
	
	public void setSeatTaken() {
		isTaken = true;
	}
	
	public void setSeatEmpty() {
		isTaken = false;
	}
	
	public boolean isSeatTaken() {
		return isTaken;
	}
	
	@Override
	public String toString() {
		return String.format("[%s]", isSeatTaken() ? "❌" : String.valueOf(number));
	}
	
}
