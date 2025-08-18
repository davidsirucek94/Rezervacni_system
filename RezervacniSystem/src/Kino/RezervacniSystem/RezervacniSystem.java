package Kino.RezervacniSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;

import Kino.Konstanty;
import Kino.Storage;
import Kino.UserInputMethods;

public class RezervacniSystem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the movie booking system.");
		List<Promitani> listOfProjections = Storage.loadProjections();
		Map<UUID, List<Promitani>> projectionsPerMovieID = new HashMap<>(); //klíč, hodnota - každý klíč (UUID) má pod sebou list promítání
		int number = 1;
		for (int i = 0; i < listOfProjections.size(); i++) {
			UUID filmUUID = listOfProjections.get(i).getFilm().getId();
			if (!projectionsPerMovieID.containsKey(filmUUID)) {
				projectionsPerMovieID.put(filmUUID, new ArrayList<>()); //pod klíčem filmUUID se mi založí prázdný list
				System.out.printf("Choice %d: %s\n", number++, listOfProjections.get(i).getFilm().getName());
			}
			projectionsPerMovieID.get(filmUUID).add(listOfProjections.get(i)); //u mapy je get pomocí klíče
			//do listu pod klíčem aktuálního filmu si přidávám aktuální promítání
			
			/*List<Promitani> movieProjections = projectionsPerMovieID.get(filmUUID); //u mapy je get pomocí klíče
			movieProjections.add(listOfProjections.get(i)); //do listu pod klíčem aktuálního filmu si přidávám aktuální promítání
			*/
		}
		System.out.println(projectionsPerMovieID);
		int movieChoice = UserInputMethods.getIntegerByChoice(scanner, "Choose a movie. Type in the choice number: ",
				projectionsPerMovieID.size());
		System.err.println(movieChoice);
		UUID chosenFilmId = listOfProjections.get(movieChoice).getFilm().getId();
		int count = 0;
		for (int i = 0; i < listOfProjections.size(); i++) {
			Promitani promitani = listOfProjections.get(i);
			if (promitani.getFilm().getId().equals(chosenFilmId)) {
				System.err.println("true");
				LocalDateTime formattedDateTime = listOfProjections.get(movieChoice).getProjectionDateTime();
				System.out.printf("Choice %d: %s\n", count + 1, formattedDateTime.format(Konstanty.FORMATTER));
				count++;
			}
		}
		int projectionChoice = UserInputMethods.getIntegerByChoice(scanner,
				"Choose a projection. Type in the choice number: ", count);
		Promitani chosenProjection = listOfProjections.get(projectionChoice);
		System.out.println(chosenProjection.getFilm().getName() + chosenProjection.getProjectionDateTime());
	}
}
