package Kino.RezervacniSystem;

import java.time.LocalDateTime;

import Kino.Konstanty;

public class Promitani {

	private Film film;
	private Sal sal;
	private LocalDateTime dateTime;

	public Promitani(Film film, Sal sal, LocalDateTime dateTime) {
		this.film = film;
		this.sal = sal;
		this.dateTime = dateTime;
	}

	public void bookSeat(int row, int seat) {
		sal.bookSeat(row, seat);
		boolean seatFree = sal.bookSeat(row, seat);
		if (seatFree == false) {
			System.out.println("Your seat cannot be booked - already taken.");
		} else {
			System.out.println("Your seat has been booked.");
		}
	}

	public boolean areSeatsAvailable() {
		return sal.getEmptySeatCount() > 0;
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
