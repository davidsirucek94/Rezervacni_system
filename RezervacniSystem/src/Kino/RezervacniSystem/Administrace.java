package Kino.RezervacniSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import Kino.Konstanty;
import Kino.Storage;
import Kino.ObjednaniJidla.Employee;
import Kino.ObjednaniJidla.Jidlo;
import Kino.ObjednaniJidla.MenuJidlo;
import Kino.ObjednaniJidla.PracovniPozice;

public class Administrace {

	public static void main(String[] args) {

		// TODO move me into correct package - Administrace is used for ObjednaniJidla and also for RezervacniSystem which are two different packages and 
		// both of them are using this class so it shouldn't be included inside of any of these two packages but somewhere else in more global space
		Scanner scanner = new Scanner(System.in);

		// TODO: There are two large blocks that are really similar, try to identify them and try to create some reusable solution to simplify it.

		addMealMenu(scanner);
	}

	public static void addMovie(Scanner scanner) {

		List<Film> films = new ArrayList<>();

		boolean enterNewMovie = false;
		do {
			String movieName = getNotBlankString(scanner, "Enter movie name: ");
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
			double moviePriceInCZK = getValidNumber(scanner, "Enter movie price in CZK. ");
			films.add(new Film(movieName, chosenGenre, movieLengthInMin, moviePriceInCZK));
			enterNewMovie = getAnotherChoice(scanner, "movie");

		} while (enterNewMovie == true);

		for (int i = 0; i < films.size(); i++) {
			System.out.println(films.get(i));
		}
	}
	
	public static void addEmployee(Scanner scanner) {

		List<Employee> employees = new ArrayList<>();

		boolean enterNewEmployee = false;

		do {
			String employeeName = getNotBlankString(scanner, "Enter employee name: ");
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
			enterNewEmployee = getAnotherChoice(scanner, "employee");

		} while (enterNewEmployee == true);

		for (int i = 0; i < employees.size(); i++) {
			System.out.println(employees.get(i));
		}
	}

	public static void addRoom(Scanner scanner, List<Sal> existingRooms) {

		List<Sal> projectionRooms = new ArrayList<>();

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

			int numberOfRows = getNumberGreaterThanZero(scanner, "Enter number of rows: ");

			int numberOfSeats = getNumberGreaterThanZero(scanner, "Enter number of seats: ");

			boolean isImax = getBooleanInput(scanner, "Is the room Imax?");

			boolean isVIP = getBooleanInput(scanner, "Is the room VIP?");

			Sal sal = new Sal(numberOfRoom, numberOfRows, numberOfSeats, isImax, isVIP);
			projectionRooms.add(sal);
			enterNewProjectionRoom = getAnotherChoice(scanner, "room");

		} while (enterNewProjectionRoom == true);

		for (int i = 0; i < projectionRooms.size(); i++) {
			System.out.println(projectionRooms.get(i));
		}
	}

	/**
	 * This is the way how you can add comment to your method and it will show up, when you hover over it with your mouse
	 * 
	 * @param scanner - This is how you can describe your parameters
	 */
	public static List<Jidlo> getMeals(Scanner scanner) {

		return getMeals(scanner, true); // přetížení metody addMeal

	}

	public static List<Jidlo> getMeals(Scanner scanner, boolean askForPrice) {

		List<Jidlo> meals = new ArrayList<>();

		boolean enterNewMeal = false;

		do {
			String mealName = getNotBlankString(scanner, "Enter meal name: ");

			double mealPrice = Konstanty.NOT_SET_PRICE_VALUE;

			if (askForPrice == true) {
				mealPrice = getValidNumber(scanner, "Enter meal price: ");
			}

			Jidlo meal = new Jidlo(mealName, mealPrice);
			meals.add(meal);
			enterNewMeal = getAnotherChoice(scanner, "meal");

		} while (enterNewMeal == true);

		return meals;
	}

	public static void addMealMenu(Scanner scanner) {

		List<MenuJidlo> menus = new ArrayList<>();

		boolean enterNewMenu = false;

		do {
			String menuName = getNotBlankString(scanner, "Enter menu name: ");

			double menuPrice = getValidNumber(scanner, "Enter menu price: ");

			List<Jidlo> meals = getMeals(scanner, false);

			MenuJidlo menu = new MenuJidlo(menuName, menuPrice, meals);
			menus.add(menu);
			enterNewMenu = getAnotherChoice(scanner, "menu");

		} while (enterNewMenu == true);

		for (int i = 0; i < menus.size(); i++) {
			menus.get(i).prettyPrint();
		}

	}
	

	public static void addProjection() {
		// TODO implement me
		// Function should walk user through creating a new Promitani and save it.
	}

	public static int getNumberGreaterThanZero(Scanner scanner, String promptMessage) {
		System.out.println(promptMessage);
		boolean validNumber = true;
		int number;
		do {
			number = Integer.parseInt(scanner.nextLine());
			if (number <= 0) {
				System.out.println("Wrong number of a rows. Please, enter it again: ");
				validNumber = false;
				continue;
			} else {
				validNumber = true;
			}

		} while (validNumber == false);
		return number;
	}

	public static boolean getBooleanInput(Scanner scanner, String promptMessage) {
		System.out.println(promptMessage + " Enter yes/no: ");
		String question = scanner.nextLine().toLowerCase().trim();
		return question.equals("yes");
	}

	public static String getNotBlankString(Scanner scanner, String promptMessage) {
		String value;
		do {
			System.out.println(promptMessage);
			value = scanner.nextLine();
			if (value.isBlank()) {
				System.out.println("You entered an empty String. Please enter it again.");
			}
		} while (value.isBlank());
		return value;
	}

	public static double getValidNumber(Scanner scanner, String promptMessage) {
		double value;
		boolean isValid = true;
		do {
			System.out.println(promptMessage);
			try {
				value = Double.parseDouble(scanner.nextLine().replace(",", ".").trim());
				isValid = true; // pokud je hodnota neplatná, na tento řádek ani nedojde (vyskočí výjimka)
			} // zkus to udělat, a když padne výjimka, tak jdi do catch
			catch (Exception E) {
				System.out.println("You have entered an invalid number. Try again.");
				value = -1;
				isValid = false;
			}
		} while (isValid == false);
		return value;
	}

	public static boolean getAnotherChoice(Scanner scanner, String objectName) {
		System.out.printf("Do you wish to enter another %s? Enter Yes/No.\n", objectName);
		String choice = scanner.nextLine().toLowerCase().trim();
		return choice.equals("yes");
	}

}

//udělat metodu setUpFilms a tu metodu použít místo kódu v rezervačním systému
