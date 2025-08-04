package Kino.ObjednaniJidla;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Kino.Storage;

public class ObjednaniJidla {

	public static void main() {	

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the meal booking system! What do you want do to?");
		System.out.print("""
				1 - Order a meal.
				""");

		Employee employee1 = new Employee("Jan Příhoda", PracovniPozice.CASHIER);

		Objednavka objednavka = new Objednavka(20, employee1, 200);
		//Storage.save("./order.csv", objednavka);
		var orders = Storage.loadOrders("./order.csv");
		System.out.println(orders);
		List<Jidlo> seznamJidel = new ArrayList<>();
		Jidlo popcorn = new Jidlo("Slaný popcorn", 200.50);
		Jidlo nachos = new Jidlo("Nachos", 186.70);
		Jidlo hotdog = new Jidlo("Hot Dog", 129.90);
		seznamJidel.add(popcorn);
		seznamJidel.add(nachos);
		seznamJidel.add(hotdog);
				
		MenuJidlo menu1 = new MenuJidlo("Menu 1", 399.90, List.of());
		menu1.addMeal(hotdog);
		menu1.addMeal(popcorn);
		
		MenuJidlo menu2 = new MenuJidlo("Menu 2", 499.90, List.of());
		menu2.addMeal(hotdog);
		menu2.addMeal(nachos);
		
		List<MenuJidlo> jidlaMenu = new ArrayList<>();
		jidlaMenu.add(menu1);
		jidlaMenu.add(menu2);

		Employee employee2 = new Employee("Valentina García Coronado", PracovniPozice.MANAGER);
		Employee employee3 = new Employee("David Širůček", PracovniPozice.CLEANINGLADY);

		Kasa kasa1 = new Kasa(1, scanner, seznamJidel, jidlaMenu);

		kasa1.assignEmployee(employee1);

		kasa1.getObjednavka();

		kasa1.printListOfOrders();

		scanner.close();
	}

}
