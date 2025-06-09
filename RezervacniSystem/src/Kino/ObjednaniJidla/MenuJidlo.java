package Kino.ObjednaniJidla;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import Kino.Storage.IStorable;

public class MenuJidlo implements IStorable {

	String name;
	double price;
	private UUID id;

	List<Jidlo> menuItems = new ArrayList<>();

	public MenuJidlo(String name, double price, List<Jidlo> items) {
		this(UUID.randomUUID(), name, price, items);
	}

	public MenuJidlo(UUID id, String name, double price, List<Jidlo> items) {
		this.name = name;
		this.price = price;
		this.menuItems = items;
		this.id = id;
	}

	public void addMeal(Jidlo jidlo) {
		menuItems.add(jidlo);
	}

	public String getNazev() {
		return name;
	}

	public double getCena() {
		return price;
	}

	public void prettyPrint() {
		System.out.printf("Menu name: %s\n", name);
		System.out.println("---------------");
		System.out.println("Menu contains:");
		for (int i = 0; i < menuItems.size(); i++) {
			System.out.println(menuItems.get(i).getNazev());
		}
		System.out.println("---------------");
		System.out.printf("Price: %.2f Kč\n", price);
		System.out.println();

	}

	public static MenuJidlo fromCsv(String[] row, Map<UUID, Jidlo> mapaJidel) {

		String[] itemIds = row[3].split(",");
		List<Jidlo> menuMeals = new ArrayList<>();
		for (String itemId : itemIds) {
			UUID id = UUID.fromString(itemId); // jako parsování
			Jidlo meal = mapaJidel.get(id); // dávám klíč id a get mi vrací jeho hodnotu
			menuMeals.add(meal);
		}
		return new MenuJidlo(UUID.fromString(row[0]), row[1], Double.parseDouble(row[2]), menuMeals);
	}

	@Override
	public String toString() {
		return String.format("Name: %s, Price: %.2f Kč", name, price);
	}

	@Override
	public String toCsv() {
		String mealItemIds = "";
		String data = id + ";" + name + ";" + price + ";";
		for (Jidlo item : menuItems) {
			mealItemIds = mealItemIds + item.getId() + ",";
		}
		return data + mealItemIds;
	}

	@Override
	public UUID getId() {
		return id;
	}

}
