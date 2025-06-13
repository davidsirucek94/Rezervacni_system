package Kino.RezervacniSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import Kino.Konstanty;
import Kino.Storage.IStorable;
import Kino.ObjednaniJidla.Jidlo;

public class Promitani implements IStorable {

	private Film film;
	private Sal sal;
	private LocalDateTime dateTime;
	private UUID id;
	// Seat, isSeatTaken ?
	private Map<Sedadlo, Boolean> seats;

	public Promitani(Film film, Sal sal, LocalDateTime dateTime) {
		this(UUID.randomUUID(), film, sal, dateTime);
	}

	
	public Promitani(UUID id, Film film, Sal sal, LocalDateTime dateTime) {
		this.film = film;
		this.sal = sal;
		this.dateTime = dateTime;
		seats = new HashMap<>();
		id = UUID.randomUUID();
		initializeSeats();
	}

	public void initializeSeats() {

		seats = new HashMap<>();

		for (int r = 1; r <= sal.numberOfRows; r++) {
			for (int s = 1; s <= sal.numberOfSeats; s++) {
				seats.put(new Sedadlo(r, s), false);
			}
		}
	}

	public boolean bookSeat(int row, int seat) {

		Sedadlo sedadlo = new Sedadlo(row, seat);
		if (seats.get(sedadlo) == true) { // vrací true
			System.out.println("This seat is already booked. Choose another one.");
			return false;
		} else {
			seats.put(sedadlo, true);
			System.out.println("Your seat has been successfully booked.");
			return true;
		}
	}

	public void showRoom() {

		for (int r = 1; r <= sal.numberOfRows; r++) {
			System.out.printf("%d: ", r);
			for (int s = 1; s <= sal.numberOfSeats; s++) {
				if (seats.get(new Sedadlo(r, s)) == true) {
					System.out.printf("(X)");
				} else {
					System.out.printf("(%d)", s);
				}
			}
			System.out.println();
		}
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
	
	public static Promitani fromCsv(String[] row, Map<UUID, Film> mapaFilmu) {
	//UUID id = UUID.fromString(mapaFilmu.get(row[1]));
		UUID filmId = UUID.fromString(row[1]);
		mapaFilmu.get(filmId);
		
		//return new Promitani(UUID.fromString(row[0]), film.(row[0]), Integer.parseInt(row[1]), Integer.parseInt(row[2]));
	}
	
	@Override 
	public String toCsv() {
		return id + ";" + film.getId() + ";" + sal.getId() + ";" + dateTime + ";" + seats;
	}
	
	@Override
	public UUID getId() {
		return id;
	}
}