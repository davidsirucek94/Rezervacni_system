package Kino;

public class Misto {

	int number;
	boolean isTaken = false;
	
	public Misto(int number) {
		this.number = number;
		//this.isTaken = isTaken;
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
		return String.format("Seat Number: %d\nIs the seat taken: %b", number, isTaken);
	} // když budu chtít textový výstup třídy
	
}
