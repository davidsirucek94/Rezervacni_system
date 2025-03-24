package Kino;

import java.time.LocalDateTime;

public class Promitani {

	Film film;
	Sal sal;
	LocalDateTime dateTime;
	
	public Promitani(Film film, Sal sal, LocalDateTime dateTime) {
		this.film = film;
		this.sal = sal;
		this.dateTime = dateTime;
	}
	
	public boolean isThisSeatTaken(int row, int seat) {
		return sal.getSeat(row, seat).isSeatTaken();
	}
	
	
	
}
