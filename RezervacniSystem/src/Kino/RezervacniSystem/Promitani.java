package Kino.RezervacniSystem;

import java.time.LocalDateTime;

public class Promitani {

	private Film film;
	private Sal sal;
	private LocalDateTime dateTime;
	private double cena;
	
	public Promitani(Film film, Sal sal, double cena, LocalDateTime dateTime) {
		this.film = film;
		this.sal = sal;
		this.cena = cena;
		this.dateTime = dateTime;
	}
	
	
	
}
