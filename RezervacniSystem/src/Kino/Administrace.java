package Kino;

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
import Kino.RezervacniSystem.Sal;

public class Administrace {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		addMealMenu(scanner);
		/*
		 * System.out.
		 * println("Welcome to the administration system! What do you want do to?");
		 * System.out.print(""" 1 - Add a new movie. 2 - Add a new employee. 3 - Add a
		 * room. 4 - Add a new meal. 5 - Add a new meal menu. """);
		 * 
		 */

		// TODO move me into correct package - Administrace is used for ObjednaniJidla
		// and also for RezervacniSystem which are two different packages and
		// both of them are using this class so it shouldn't be included inside of any
		// of these two packages but somewhere else in more global space

		// TODO: There are two large blocks that are really similar, try to identify
		// them and try to create some reusable solution to simplify it.
	}

	public static void addMovie(Scanner scanner) {

		List<Film> savedFilms = Storage.loadFilms(Konstanty.MOVIES_STORAGE_PATH);

		List<Film> films = new ArrayList<>();
		films.addAll(savedFilms);

		boolean enterNewMovie = false;
		do {
			String movieName = UserInputMethods.getNotBlankString(scanner, "Enter movie name: ");
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
			int movieLengthInMin = Integer.parseInt(scanner.nextLine().trim()); // Also could be validated for > 0
			double moviePriceInCZK = UserInputMethods.getValidNumber(scanner, "Enter movie price in CZK. ");
			films.add(new Film(movieName, chosenGenre, movieLengthInMin, moviePriceInCZK));
			enterNewMovie = UserInputMethods.getAnotherChoice(scanner, "movie");

		} while (enterNewMovie == true);

		for (int i = 0; i < films.size(); i++) {
			System.out.println(films.get(i));
		}

		Storage.save(Konstanty.MOVIES_STORAGE_PATH, films);
	}

	public static void addEmployee(Scanner scanner) {

		List<Employee> savedEmployees = Storage.loadEmployees(Konstanty.EMPLOYEES_STORAGE_PATH);

		List<Employee> employees = new ArrayList<>();
		employees.addAll(savedEmployees);

		boolean enterNewEmployee = false;

		do {
			String employeeName = UserInputMethods.getNotBlankString(scanner, "Enter employee name: ");
			int workPositionChoiceIndex;
			PracovniPozice[] workPosition = PracovniPozice.values();
			do {
				System.out.println("Choose employee`s position. Type in the choice number: ");
				for (int i = 0; i < PracovniPozice.values().length; i++) {
					System.out.printf("Choice %d: %s\n", i + 1, workPosition[i]);
				}
				workPositionChoiceIndex = Integer.parseInt(scanner.nextLine()) - 1;
			} while (workPositionChoiceIndex >= workPosition.length || workPositionChoiceIndex < 0);
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

	public static void addRoom(Scanner scanner, List<Sal> existingRooms) {

		List<Sal> savedRooms = Storage.loadRooms(Konstanty.ROOMS_STORAGE_PATH);

		List<Sal> projectionRooms = new ArrayList<>();
		projectionRooms.addAll(savedRooms);

		boolean enterNewProjectionRoom = false;

		Set<Integer> numbersOfExistingRooms = new HashSet<>();
		for (Sal room : existingRooms) {
			numbersOfExistingRooms.add(room.numberOfRoom);
		}

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

		for (int i = 0; i < projectionRooms.size(); i++) {
			System.out.println(projectionRooms.get(i));
		}

		Storage.save(Konstanty.ROOMS_STORAGE_PATH, projectionRooms);
	}

	public static List<Jidlo> addMeal(Scanner scanner) {

		return addMeal(scanner, true); // přetížení metody addMeal

	}

	public static List<Jidlo> addMeal(Scanner scanner, boolean askForPrice) {

		List<Jidlo> savedMeals = Storage.loadMeals(Konstanty.MEALS_STORAGE_PATH);

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
				mealPrice = UserInputMethods.getValidNumber(scanner, "Enter meal price: ");
			}

			Jidlo meal = new Jidlo(mealName, mealPrice);
			meals.add(meal);
			enterNewMeal = UserInputMethods.getAnotherChoice(scanner, "meal");

		} while (enterNewMeal == true || error == true);

		Storage.save(Konstanty.MEALS_STORAGE_PATH, meals);

		return meals;
	}

	public static void addMealMenu(Scanner scanner) {

		List<Jidlo> savedMeals = Storage.loadMeals(Konstanty.MEALS_STORAGE_PATH);
		List<MenuJidlo> menus = new ArrayList<>();

		boolean enterNewMenu = false;

		do {
			List<Jidlo> chosenMeals = new ArrayList<>();
			String menuName = UserInputMethods.getNotBlankString(scanner, "Enter the menu name:");
			double menuPrice = UserInputMethods.getValidNumber(scanner, "Enter the menu price:");

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

	public static void addProjection() {
		
	}
}