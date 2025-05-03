package Kino.RezervacniSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Kino.Konstanty;
import Kino.LogInit;
import Kino.Storage;

public class Administrace {
	static {
		LogInit.init();
	}


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
	
	/* 
	 * Programming is about trying not to repeat your self, so during the implementation of these functions try to make your work as easy as you can.
	 * You don't have to push it hard, but when you are done, try to look at the implementation of each method and try to find
	 * repetitive functionality and what are the variable parts that are changing
	 * 
	 * There shouldn't be problem to save things but it would be a bit worse to load them, you can try to modify the storage 
	 * otherwise we can implement it together on our lesson.
	 * 
	 * To do saving and loading data more simple, create constants for your file paths inside Konstanty, it will make your code more clean and your paths will be defined at single place
	 * */
	
	public static void addMovie() {
		//TODO implement me 
		// Function should walk user through creating a new Film and save it. 
	}
	
	public static void addProjection() {
		//TODO implement me
		// Function should walk user through creating a new Promitani and save it.
	}
	
	public static void addEmployee() {
		//TODO implement me
		// Function should walk user through creating a new Employee and save it.
	}
	
	public static void addRoom() {
		//TODO implement me
		// Function should walk user through creating a new Sal and save it.
	}
	
	public static void addMeal() {
		//TODO implement me
		// Function should walk user through creating a new Jidlo and save it.
	}
	
	public static void addMealMenu() {
		//TODO implement me
		// Function should walk user through creating a new MenuJidlo and save it.
	}
	
	// Add another if you can think of some
	
	
	

}

//udělat metodu setUpFilms a tu metodu použít místo kódu v rezervačním systému
