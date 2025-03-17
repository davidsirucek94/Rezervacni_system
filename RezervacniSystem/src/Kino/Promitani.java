package Kino;

import java.time.LocalDateTime;

public class Promitani {

	Film film;
	Sal sal;
	LocalDateTime dateTime;
	
	public void isThisSeatTaken(int row, int seat) {
		
		sal.seats.get(row).get(seat);
	}
	
}
