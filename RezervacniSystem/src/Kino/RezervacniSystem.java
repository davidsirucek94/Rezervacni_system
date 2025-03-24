package Kino;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RezervacniSystem {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
		
		
	//Film movieOne = new Film("Avengers", Genre.SCIFI, 250); // vytvářím instanci třídy film
	//Film movieTwo = new Film("Event Horizon", Genre.HORROR, 180);
	//Film movieThree = new Film("Scary Movie", Genre.PARODY, 120);
	//Film movieFour = new Film("Liar Liar", Genre.COMEDY, 128);
	//Film movieFive = new Film("A Girl on a train", Genre.THRILLER, 90);
		
	List<Film> films = new ArrayList<>();
	films.add(new Film("Avengers", Genre.SCIFI, 250));
	films.add(new Film("Event Horizon", Genre.HORROR, 180));
	
	System.out.println("Hello! Choose your movie. Type in the number of the movie: ");
	
	for (int i = 0; i < films.size(); i++) {
		System.out.printf("Choice %d: %s \n", i + 1, films.get(i));
	}
	
	int usersChoice = Integer.parseInt(scanner.nextLine());
	Film chosenFilm = films.get(usersChoice);
	
	Sal salOne = new Sal(1, 20, 30, false, false);
	//Sal salTwo = new Sal(2, 25, 35, true, false);
	//Sal salThree = new Sal(3, 10, 15, false, true);
	//Sal salFour = new Sal(4, 50, 80, true, true);
	
	/*
	Promitani promitaniOne = new Promitani(movieOne, salOne, LocalDateTime.of(2025, 3, 17, 20, 00));
	
	Rezervace rezervaceOne = new Rezervace("David", "dasi", promitaniOne);
	rezervaceOne.showCinemaRoom();

	//System.out.println(rooms.get(0).seats.get(0).get(0));
	//System.out.println(rooms.get(2));
	
	 */
	scanner.close();

	}
}
