package cinema;
import java.util.UUID;

public class Seat {

	private String uuid;
	private int number;
	private boolean isTaken = false;
	
	public Seat(int number) {
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
	
public String getUuid(){
	return uuid;
}

	@Override
	public String toString() {
		return String.format("[%s]", isTaken ? "❌" : String.valueOf(currentSeat.number));
	}

	
	
}
