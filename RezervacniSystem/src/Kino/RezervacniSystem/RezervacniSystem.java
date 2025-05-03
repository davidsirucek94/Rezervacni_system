package Kino.RezervacniSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Kino.LogInit;

public class RezervacniSystem {
	
	static {
		LogInit.init();
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		List<Film> films = new ArrayList<>(); //sem budu přiřazovat výsledek metody setUpFilms
		films.add(new Film("Avengers", Genre.SCIFI, 250, 300));
		films.add(new Film("Event Horizon", Genre.HORROR, 180, 150));
		films.add(new Film("Scary Movie", Genre.PARODY, 120, 200));
		films.add(new Film("Liar Liar", Genre.COMEDY, 128, 220));
		films.add(new Film("A Girl on a train", Genre.THRILLER, 90, 500));

		System.out.println("Hello! Choose your movie. Type in the number of the movie: ");

		for (int i = 0; i < films.size(); i++) {
			System.out.printf("Choice %d: %s \n", i, films.get(i));
		}

		int usersChoice = Integer.parseInt(scanner.nextLine());
		Film chosenFilm = films.get(usersChoice);
		
		List<Promitani> promitani = new ArrayList<>();

		Sal salOne = new Sal(1, 20, 30, false, false);
		Sal salTwo = new Sal(2, 25, 35, true, false);
		Sal salThree = new Sal(3, 10, 15, false, true);
		Sal salFour = new Sal(4, 50, 80, true, true);

		Promitani promitaniOne = new Promitani(films.get(usersChoice), salOne, LocalDateTime.of(2025, 3, 17, 20, 00));
		scanner.close();

	}
}
