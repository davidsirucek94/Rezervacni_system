package Kino;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Kino.ObjednaniJidla.Employee;
import Kino.ObjednaniJidla.Jidlo;
import Kino.ObjednaniJidla.MenuJidlo;
import Kino.ObjednaniJidla.PracovniPozice;
import Kino.RezervacniSystem.Film;
import Kino.RezervacniSystem.Genre;
import Kino.RezervacniSystem.Promitani;
import Kino.RezervacniSystem.Sal;

public class Administrace {

	public static void main() {

		Scanner scanner = new Scanner(System.in);

		addEmployee(scanner);

	}

	public static void addMovie(Scanner scanner) {

		List<Film> savedFilms = Storage.loadFilms();

		List<Film> films = new ArrayList<>();
		films.addAll(savedFilms);

		boolean enterNewMovie = false;
		do {
			String movieName = UserInputMethods.getNotBlankString(scanner, "Enter movie name: ");
			Genre[] genres = Genre.values();
			for (int i = 0; i < Genre.values().length; i++) {
				System.out.printf("Choice %d: %s\n", i + 1, genres[i]);
			}
			int genreChoiceIndex = UserInputMethods.getIntegerByChoice(scanner,
					"Choose movie genre. Type in the choice number: ", genres.length);
			/*
			 * do { System.out.println("Choose movie genre. Type in the choice number: ");
			 * for (int i = 0; i < Genre.values().length; i++) {
			 * System.out.printf("Choice %d: %s\n", i + 1, genres[i]); } genreChoiceIndex =
			 * Integer.parseInt(scanner.nextLine()) - 1; } while (genreChoiceIndex >=
			 * genres.length || genreChoiceIndex < 0);
			 */
			Genre chosenGenre = genres[genreChoiceIndex];
			System.out.println("Enter movie length in min: ");
			int movieLengthInMin = Integer.parseInt(scanner.nextLine().trim()); // Also could be validated for > 0
			double moviePriceInCZK = UserInputMethods.getValidDouble(scanner, "Enter movie price in CZK. ");
			films.add(new Film(movieName, chosenGenre, movieLengthInMin, moviePriceInCZK));
			enterNewMovie = UserInputMethods.getAnotherChoice(scanner, "movie");

		} while (enterNewMovie == true);

		for (int i = 0; i < films.size(); i++) {
			System.out.println(films.get(i));
		}

		Storage.save(Konstanty.MOVIES_STORAGE_PATH, films);
	}

	public static void addEmployee(Scanner scanner) {

		List<Employee> savedEmployees = Storage.loadEmployees();

		List<Employee> employees = new ArrayList<>();
		employees.addAll(savedEmployees);

		boolean enterNewEmployee = false;

		do {
			String employeeName = UserInputMethods.getNotBlankString(scanner, "Enter employee name: ");
			PracovniPozice[] workPosition = PracovniPozice.values();
			for (int i = 0; i < PracovniPozice.values().length; i++) {
				System.out.printf("Choice %d: %s\n", i + 1, workPosition[i]);
			}
			int workPositionChoiceIndex = UserInputMethods.getIntegerByChoice(scanner, "Choose employee`s position. Type in the choice number: ", workPosition.length);
			/*
			do {
				System.out.println("Choose employee`s position. Type in the choice number: ");
				for (int i = 0; i < PracovniPozice.values().length; i++) {
					System.out.printf("Choice %d: %s\n", i + 1, workPosition[i]);
				}
				workPositionChoiceIndex = Integer.parseInt(scanner.nextLine()) - 1;
			} while (workPositionChoiceIndex >= workPosition.length || workPositionChoiceIndex < 0);
			*/
			PracovniPozice chosenPosition = workPosition[workPositionChoiceIndex];
			Employee employee = new Employee(employeeName, chosenPosition);
			employees.add(employee);
			enterNewEmployee = UserInputMethods.getAnotherChoice(scanner, "employee");

		} while (enterNewEmployee == true);

		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i));
		}

		Storage.save(Konstanty.EMPLOYEES_STORAGE_PATH, employees);
	}

	public static void addRoom(Scanner scanner) {

		List<Sal> savedRooms = Storage.loadRooms();

		List<Sal> projectionRooms = new ArrayList<>();
		projectionRooms.addAll(savedRooms);

		boolean enterNewProjectionRoom = false;

		Set<Integer> numbersOfExistingRooms = new HashSet<>();

		do {
			System.out.println("Enter number of room: ");
			boolean validNumberOfRooms = true;
			int numberOfRoom;
			do {
				numberOfRoom = Integer.parseInt(scanner.nextLine());
				if (numberOfRoom <= 0) {
					System.out.println("Wrong number of a room. Please, enter it again: ");
					validNumberOfRooms = false;
					continue;
				} else {
					validNumberOfRooms = true;
				}

				if (numbersOfExistingRooms.contains(numberOfRoom)) {
					System.out.println("Wrong number of a room - it already exists. Please, enter another number: ");
					validNumberOfRooms = false;
				} else {
					validNumberOfRooms = true;
				}

			} while (validNumberOfRooms == false);

			int numberOfRows = UserInputMethods.getNumberGreaterThanZero(scanner, "Enter number of rows: ");

			int numberOfSeats = UserInputMethods.getNumberGreaterThanZero(scanner, "Enter number of seats: ");

			boolean isImax = UserInputMethods.getBooleanInput(scanner, "Is the room Imax?");

			boolean isVIP = UserInputMethods.getBooleanInput(scanner, "Is the room VIP?");

			Sal sal = new Sal(numberOfRoom, numberOfRows, numberOfSeats, isImax, isVIP);
			projectionRooms.add(sal);
			enterNewProjectionRoom = UserInputMethods.getAnotherChoice(scanner, "room");

		} while (enterNewProjectionRoom == true);

		Storage.save(Konstanty.ROOMS_STORAGE_PATH, projectionRooms);
	}

	public static List<Jidlo> addMeal(Scanner scanner) {

		return addMeal(scanner, true); // přetížení metody addMeal

	}

	public static List<Jidlo> addMeal(Scanner scanner, boolean askForPrice) {

		List<Jidlo> savedMeals = Storage.loadMeals();

		List<Jidlo> meals = new ArrayList<>();
		meals.addAll(savedMeals);

		boolean enterNewMeal = false;
		boolean error = false;

		Set<String> nazvyJidel = new HashSet<>();
		for (Jidlo meal : meals) {
			String nazevJidla = meal.getNazev();
			nazvyJidel.add(nazevJidla);
		}

		do {
			String mealName = UserInputMethods.getNotBlankString(scanner, "Enter meal name: ");

			if (nazvyJidel.contains(mealName)) {
				System.out.println("This meal already exists! Try again.");
				error = true;
				continue;
			}

			double mealPrice = Konstanty.NOT_SET_PRICE_VALUE;

			if (askForPrice == true) {
				mealPrice = UserInputMethods.getValidDouble(scanner, "Enter meal price: ");
			}

			Jidlo meal = new Jidlo(mealName, mealPrice);
			meals.add(meal);
			enterNewMeal = UserInputMethods.getAnotherChoice(scanner, "meal");

		} while (enterNewMeal == true || error == true);

		Storage.save(Konstanty.MEALS_STORAGE_PATH, meals);

		return meals;
	}

	public static void addMealMenu(Scanner scanner) {

		List<Jidlo> savedMeals = Storage.loadMeals();
		List<MenuJidlo> menus = new ArrayList<>();

		boolean enterNewMenu = false;

		do {
			List<Jidlo> chosenMeals = new ArrayList<>();
			String menuName = UserInputMethods.getNotBlankString(scanner, "Enter the menu name:");
			double menuPrice = UserInputMethods.getValidDouble(scanner, "Enter the menu price:");

			int cislo = 0;
			for (Jidlo meal : savedMeals) {
				System.out.println((cislo + 1) + ") " + meal.getNazev());
				cislo++;
			}

			System.out.println(
					"Choose from the list of meals above. Enter the meal numbers and separate them by commas.");

			String usersInput = scanner.nextLine().trim();
			String[] usersNumberChoices = usersInput.split(",");

			for (int i = 0; i < usersNumberChoices.length; i++) {
				int numberChoices = Integer.parseInt(usersNumberChoices[i].trim()) - 1;
				chosenMeals.add(savedMeals.get(numberChoices));
			}

			MenuJidlo menu = new MenuJidlo(menuName, menuPrice, chosenMeals);
			menus.add(menu);

			enterNewMenu = UserInputMethods.getAnotherChoice(scanner, "menu");
			menu.prettyPrint();
		} while (enterNewMenu == true);

		Storage.save(Konstanty.MEALMENUS_STORAGE_PATH, menus);

	}

	public static void addProjection(Scanner scanner) {
		List<Promitani> savedProjections = Storage.loadProjections();
		List<Film> savedFilms = Storage.loadFilms();
		List<Sal> savedRooms = Storage.loadRooms();
		List<Promitani> projections = new ArrayList<>();
		projections.addAll(savedProjections);

		boolean enterNewProjection = false;

		do {
			int cisloFilmu = 0;

			for (Film film : savedFilms) {
				System.out.println((cisloFilmu + 1) + ") " + film.getName());
				cisloFilmu++;
			}

			int movieChoice = UserInputMethods.getIntegerByChoice(scanner, "Choose a movie. Enter the movie number:",
					savedFilms.size());

			int cisloSalu = 0;

			for (Sal sal : savedRooms) {
				System.out.println((cisloSalu + 1) + ") " + sal.numberOfRoom);
				cisloSalu++;
			}

			int roomChoice = UserInputMethods.getIntegerByChoice(scanner, "Choose a room. Enter the room number:",
					savedRooms.size());

			LocalDateTime dateTime = null;
			do {
				try {
					String dateTimeString = UserInputMethods.getNotBlankString(scanner,
							String.format("Enter date and time (%s)", Konstanty.DATE_TIME_FORMAT));
					dateTime = LocalDateTime.parse(dateTimeString, Konstanty.FORMATTER);
					if (dateTime.isBefore(LocalDateTime.now())) {
						System.out.println("You have to enter an upcoming date and time! Try again.");
						dateTime = null;
						continue;
					}
				} catch (Exception e) {
					System.out.println("You have entered a wrong date/time format. Try again.");
				}
			} while (dateTime == null);

			projections.add(new Promitani(savedFilms.get(movieChoice), savedRooms.get(roomChoice), dateTime));

			enterNewProjection = UserInputMethods.getAnotherChoice(scanner, "projection");

		} while (enterNewProjection == true);

		Storage.save(Konstanty.PROJECTIONS_STORAGE_PATH, projections);
	}
}