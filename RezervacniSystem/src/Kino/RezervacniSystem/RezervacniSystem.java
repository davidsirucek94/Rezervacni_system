package Kino.RezervacniSystem;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

import Kino.Storage;
import Kino.UserInputMethods;

public class RezervacniSystem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the movie booking system.");
		List<Promitani> listOfProjections = Storage.loadProjections();
		Set<UUID> alreadyPrintedFilms = new HashSet<>();
		for (int i = 0; i < listOfProjections.size(); i++) {
			UUID filmUUID = listOfProjections.get(i).getFilm().getId();
			if (!alreadyPrintedFilms.contains(filmUUID)) {
				alreadyPrintedFilms.add(filmUUID);
				System.out.printf("Choice %d: %s\n", i + 1, listOfProjections.get(i).getFilm().getName());
			}
		}
		int movieChoice = UserInputMethods.getIntegerByChoice(scanner, "Choose a movie. Type in the choice number: ",
				alreadyPrintedFilms.size());
		UUID chosenFilmId = listOfProjections.get(movieChoice).getFilm().getId();
		int count = 0;
		for (int i = 0; i < listOfProjections.size(); i++) {
			Promitani promitani = listOfProjections.get(i);
			if (promitani.getFilm().getId().equals(chosenFilmId)) {
				System.out.printf("Choice %d: %s\n", count + 1, listOfProjections.get(movieChoice).getProjectionDateTime());
				count++;
			}
		}
		System.out.println(count);
		int projectionChoice = UserInputMethods.getIntegerByChoice(scanner,
				"Choose a projection. Type in the choice number: ", count);
	}
}
