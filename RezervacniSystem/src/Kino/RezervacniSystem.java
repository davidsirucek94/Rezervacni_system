package Kino;

import java.util.ArrayList;
import java.util.List;

public class RezervacniSystem {

	public static void main(String[] args) {

	List<Film> films = new ArrayList<>();
	
	films.add(new Film("Avengers", Genre.SCIFI, 250)); // vytvářím instanci třídy film
	films.add(new Film("Event Horizon", Genre.HORROR, 180));
	films.add(new Film("Scary Movie", Genre.PARODY, 120));
	films.add(new Film("Liar Liar", Genre.COMEDY, 128));
	films.add(new Film("A Girl on a train", Genre.THRILLER, 90));
	
	List<Sal> rooms = new ArrayList<>();
	
	rooms.add(new Sal(1, 20, 30, false, false));
	rooms.add(new Sal(2, 25, 35, true, false));
	rooms.add(new Sal(3, 10, 15, false, true));
	rooms.add(new Sal(4, 50, 80, true, true));

	//System.out.println(rooms.get(0).seats.get(0).get(0));
	System.out.println(rooms.get(2));
	}

}
