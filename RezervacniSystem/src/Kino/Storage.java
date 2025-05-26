package Kino;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import Kino.ObjednaniJidla.Employee;
import Kino.ObjednaniJidla.Objednavka;
import Kino.ObjednaniJidla.PracovniPozice;
import Kino.RezervacniSystem.Film;
import Kino.RezervacniSystem.Genre;
import Kino.RezervacniSystem.Sal;
import Kino.ObjednaniJidla.Jidlo;
import Kino.ObjednaniJidla.MenuJidlo;

public class Storage {

	private static final Map<Class<?>, Function<String[], ?>> parsers = Map.of(Film.class,
			row -> new Film(row[0], Genre.valueOf(row[1]), Integer.parseInt(row[2]), Double.parseDouble(row[3])),
			Objednavka.class,
			row -> new Objednavka(Integer.parseInt(row[0]), new Employee(row[2], PracovniPozice.CASHIER),
					Double.parseDouble(row[3])),
			Employee.class, row -> new Employee(row[0], PracovniPozice.valueOf(row[1])), 
			Sal.class, row -> new Sal(Integer.parseInt(row[0]), Integer.parseInt(row[1]), Integer.parseInt(row[2]),
					Boolean.parseBoolean(row[3]), Boolean.parseBoolean(row[4])),
			Jidlo.class, row -> new Jidlo(row[0], Double.parseDouble(row[1])),
			MenuJidlo.class, row -> {
				String[] items = row[2].split("\n");
				List<Jidlo> menuMeals = new ArrayList<>();
				for (String item : items) {
					String[] tmp = item.split(";");	
					String nazev = tmp[0];
					double cena = Double.parseDouble(tmp[1]);
					menuMeals.add(new Jidlo(nazev, cena));
				}
				
				return new MenuJidlo(row[0], Double.parseDouble(row[1]), menuMeals);
			}
			);

	public interface IStorable {
		public String toCsv();
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

	@SuppressWarnings("unchecked")
	private static <T extends IStorable> T parseItem(String[] row, Class<T> klass) {
		return (T) parsers.get(klass).apply(row);
	}

	public static <T extends IStorable> void save(String path, T item) {
		write(path, item.toCsv());
	}

	public static <T extends IStorable> void save(String path, List<T> items) {
		write(path, items.stream().map(IStorable::toCsv).collect(Collectors.joining("\n")));
	}

	private static <T extends IStorable> List<T> load(String path, Class<T> klass) {
		if (!new File(path).exists()) {
			return List.of();
		}

		return read(path).stream().map(row -> parseItem(row, klass)).collect(Collectors.toList());
	}

	public static List<Film> loadFilms(String path) {
		return load(path, Film.class);
	}

	public static List<Objednavka> loadOrders(String path) {
		return load(path, Objednavka.class);
	}

	public static List<Employee> loadEmployees(String path) {
		return load(path, Employee.class);
	}
	
	public static List<Sal> loadRooms(String path) {
		return load(path, Sal.class);
	}
	
	public static List<Jidlo> loadMeals(String path) {
		return load(path, Jidlo.class);
	}
	
	public static List<MenuJidlo> loadMenus(String path) {
		return load(path, MenuJidlo.class);
	}
}