package cinema;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reservation {
	private Show show;
	private List<Seat> seats = null;

	public Reservation(Show show) {
		this.show = show;
		this.seats = new ArrayList<>();
	}


	public void addSeat(Seat seat) {
		seats.add(seat);
	}

	public void removeSeat() {
		seats.remove(seat);
	}

}
