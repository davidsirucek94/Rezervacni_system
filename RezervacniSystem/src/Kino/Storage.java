package Kino;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import Kino.ObjednaniJidla.Employee;
import Kino.ObjednaniJidla.Objednavka;
import Kino.ObjednaniJidla.PracovniPozice;
import Kino.RezervacniSystem.Film;
import Kino.RezervacniSystem.Genre;
import Kino.RezervacniSystem.Promitani;
import Kino.RezervacniSystem.Sal;
import Kino.ObjednaniJidla.Jidlo;
import Kino.ObjednaniJidla.MenuJidlo;

public class Storage {

	public interface IStorable { //interface je záruka, že třída bude obsahovat ty konkrétní metody.
		public String toCsv();
		public UUID getId();
	}

	private static void write(String path, String content) {
		try {
			Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
			System.out.println("Zápis byl úspěšný.");
		} catch (IOException e) {
			System.err.println("Chyba při zápisu do souboru: " + e.getMessage());
		}
	}

	private static List<String[]> read(String path) {
		try {
			return Files.readAllLines(Paths.get(path)).stream().map(row -> row.split(";")).toList();
		} catch (IOException e) {
			System.err.println("Chyba při čtení ze souboru: " + e.getMessage());
			return null;
		}
	}

	public static <T extends IStorable> void save(String path, T item) {
		write(path, item.toCsv());
	}

	public static <T extends IStorable> void save(String path, List<T> items) {
		write(path, items.stream().map(IStorable::toCsv).collect(Collectors.joining("\n")));
	}

	private static <T extends IStorable> List<T> load(String path, Function<String[], T> function) {
		if (!new File(path).exists()) {
			return List.of();
		}
		
		return read(path).stream().map(row -> function.apply(row)).collect(Collectors.toList());
	}

	public static List<Film> loadFilms() {
		return load(Konstanty.MOVIES_STORAGE_PATH, row -> Film.fromCsv(row));
	}

	public static List<Objednavka> loadOrders(String path) {
		return load(path, row -> Objednavka.fromCsv(row));
	}

	public static List<Employee> loadEmployees() {
		return load(Konstanty.EMPLOYEES_STORAGE_PATH, row -> Employee.fromCsv(row));
	}

	public static List<Sal> loadRooms() {
		return load(Konstanty.ROOMS_STORAGE_PATH, row -> Sal.fromCsv(row));
	}

	public static List<Jidlo> loadMeals() {
		return load(Konstanty.MEALS_STORAGE_PATH, row -> Jidlo.fromCsv(row));
	}

	public static List<MenuJidlo> loadMenus() {
		List<Jidlo> meals = loadMeals();
		Map<UUID, Jidlo> mealsMap = new HashMap<>(); //na základě ID hledám hodnotu (u listu musím procházet celý list)
		for (Jidlo meal : meals) {
			mealsMap.put(meal.getId(), meal);
		}
		return load(Konstanty.MEALMENUS_STORAGE_PATH, row -> MenuJidlo.fromCsv(row, mealsMap));
	}
	
	public static List<Promitani> loadProjections() {
		List<Film> films = loadFilms();
		Map<UUID, Film> filmsMap = new HashMap<>();
		for (Film film : films) {
			filmsMap.put(film.getId(), film);
		}
		List<Sal> saly = loadRooms();
		Map<UUID, Sal> salyMap = new HashMap<>();
		for (Sal sal : saly) {
			salyMap.put(sal.getId(), sal);
		}

		return load(Konstanty.PROJECTIONS_STORAGE_PATH, row -> Promitani.fromCsv(row, filmsMap, salyMap));
	}
	
}