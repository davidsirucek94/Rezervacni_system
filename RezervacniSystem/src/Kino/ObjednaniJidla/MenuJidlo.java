package Kino.ObjednaniJidla;

import java.util.ArrayList;
import java.util.List;

import Kino.Storage.IStorable;

public class MenuJidlo implements IStorable{

	String name;
	double price;

	List<Jidlo> menuItems = new ArrayList<>();
	
	public MenuJidlo(String name, double price, List<Jidlo> items) {
		this.name = name;
		this.price = price;
		this.menuItems = items;
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

	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, Price: %.2f Kč", name, price);
	}

	@Override
	public String toCsv() {
		String mealItems = "";
		String data = name + ";" + price + ";";
		for (Jidlo item : menuItems) {
			mealItems = mealItems + item.toCsv() + "\n";
		}
		return data + mealItems;
	}
	
}
