package Kino.RezervacniSystem;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import Kino.Konstanty;
import Kino.ObjednaniJidla.Jidlo;

public class Promitani {

	private Film film;
	private Sal sal;
	private LocalDateTime dateTime;
	private UUID id;
	private Set<Sedadlo> bookedSeats;

	public Promitani(Film film, Sal sal, LocalDateTime dateTime) {
		this.film = film;
		this.sal = sal;
		this.dateTime = dateTime;
		bookedSeats = new HashSet<>();
		id = UUID.randomUUID();
	}

	public void bookSeat(int row, int seat) {

		boolean choice = false;
		
		do {
		Sedadlo sedadlo1 = new Sedadlo(row, seat);
		if (bookedSeats.contains(sedadlo1)) {
			System.out.println("This seat is already booked.");
			choice = true;
		} else {
			bookedSeats.add(sedadlo1);
		}
	
		} while (choice == true);
		
	}

	public double getTotalPrice() {
		double koeficient = 0;
		if (sal.isImax == true) {
			koeficient = Konstanty.IMAX_EXTRA_COST_PERCENTAGE;
		} else if (sal.isVip == true) {
			koeficient = Konstanty.VIP_EXTRA_COST_PERCENTAGE;
		} else if (sal.isVip == true && sal.isImax == true) {
			koeficient = Konstanty.IMAX_PLUS_VIP_EXTRA_COST_PERCENTAGE;
		}
		return film.getPrice() + film.getPrice() * (koeficient / 100);
	}
}
