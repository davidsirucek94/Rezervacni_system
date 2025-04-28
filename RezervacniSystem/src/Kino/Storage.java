package Kino;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import Kino.RezervacniSystem.Film;
import Kino.RezervacniSystem.Genre;

public class Storage {

	private static final Map<Class<?>, Function<String[], ?>> parsers = Map.of(Film.class,
			row -> new Film(row[0], Genre.valueOf(row[1]), Integer.parseInt(row[2]), Double.parseDouble(row[3]))
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
		if(!new File(path).exists()) {
			return List.of();
		}
		
		return read(path).stream().map(row -> parseItem(row, klass)).collect(Collectors.toList());
	}

	public static List<Film> loadFilms(String path) {
		return load(path, Film.class);
	}

}