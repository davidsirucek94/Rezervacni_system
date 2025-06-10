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
				// Seat, isSeatTaken ?
	private Map<Sedadlo, Boolean> seats;

	public Promitani(Film film, Sal sal, LocalDateTime dateTime) {
		this.film = film;
		this.sal = sal;
		this.dateTime = dateTime;
		seats = new HashMap<>();
		id = UUID.randomUUID();
	}

	public void initializeSeats() {
		// TODO implement me
		// This method will be used to initialize our seats map with all seats that will
		// be in the room of this projection, where all values will be set to false, because at the beginning all seats are free
		// hint: use seats.put to add something into map under specific key... map.put("popcorn", 300)
	}

	public void bookSeat(int row, int seat) {

		boolean choice = false;
		// TODO i changed seats from type Set to Map, make code bellow work again
		// hint: Check what Map can do and remember it's key:value
		do {
			Sedadlo sedadlo1 = new Sedadlo(row, seat);
			if (seats.contains(sedadlo1)) {
				System.out.println("This seat is already booked.");
				choice = true;
			} else {
				seats.add(sedadlo1);
			}

		} while (choice == true);

	}

	public void showRoom() {
		// TODO implement me
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
