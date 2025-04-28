package Kino.RezervacniSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Kino.Konstanty;
import Kino.Storage;

public class Administrace {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		List<Film> films = new ArrayList<>();
		
		// Vitek: Use this to load stored movies
		// films.addAll(Storage.loadFilms(Konstanty.MOVIES_STORAGE_PATH));
	
		boolean enterNewMovie = false;
		do {
			System.out.println("Enter movie name: ");
			String movieName = scanner.nextLine();
			int genreChoiceIndex;
			Genre[] genres = Genre.values();
			do {
				System.out.println("Choose movie genre. Type in the choice number: ");
				for (int i = 0; i < Genre.values().length; i++) {
					System.out.printf("Choice %d: %s\n", i + 1, genres[i]);
				}
				genreChoiceIndex = Integer.parseInt(scanner.nextLine()) - 1;
			} while (genreChoiceIndex >= genres.length || genreChoiceIndex < 0);
			Genre chosenGenre = genres[genreChoiceIndex];
			System.out.println("Enter movie length in min: ");
			int movieLengthInMin = Integer.parseInt(scanner.nextLine().trim());
			System.out.println("Enter movie price in CZK. Use dots, NOT commas! ");
			double moviePriceInCZK = Double.parseDouble(scanner.nextLine().replace(",", ".").trim());
			films.add(new Film(movieName, chosenGenre, movieLengthInMin, moviePriceInCZK));
			System.out.println("Do you wish to enter another movie? Enter Yes/No.");
			String choice = scanner.nextLine().toLowerCase().trim();
			enterNewMovie = choice.equals("yes");

		} while (enterNewMovie == true);
		
		
		// Vitek: Use this to store your movies
		// Storage.save(Konstanty.MOVIES_STORAGE_PATH, films);

		for (int i = 0; i < films.size(); i++) {
			System.out.println(films.get(i));
		}

		scanner.close();
	}

}

//udělat metodu setUpFilms a tu metodu použít místo kódu v rezervačním systému
