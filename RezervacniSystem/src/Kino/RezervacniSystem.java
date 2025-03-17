package Kino;

import java.time.LocalDateTime;

public class RezervacniSystem {

	public static void main(String[] args) {
	
	Film movieOne = new Film("Avengers", Genre.SCIFI, 250); // vytvářím instanci třídy film
	new Film("Event Horizon", Genre.HORROR, 180);
	new Film("Scary Movie", Genre.PARODY, 120);
	new Film("Liar Liar", Genre.COMEDY, 128);
	new Film("A Girl on a train", Genre.THRILLER, 90);
		
	Sal salOne = new Sal(1, 20, 30, false, false);
	new Sal(2, 25, 35, true, false);
	new Sal(3, 10, 15, false, true);
	new Sal(4, 50, 80, true, true);
	
	Promitani promitaniOne = new Promitani(movieOne, salOne, LocalDateTime.of(2025, 3, 17, 20, 00));
	
	Rezervace rezervaceOne = new Rezervace("David", "dasi", promitaniOne);
	rezervaceOne.showCinemaRoom();

	//System.out.println(rooms.get(0).seats.get(0).get(0));
	//System.out.println(rooms.get(2));
	}

}
