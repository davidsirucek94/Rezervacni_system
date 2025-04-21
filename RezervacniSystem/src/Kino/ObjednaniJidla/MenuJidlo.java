package Kino.ObjednaniJidla;

import java.util.ArrayList;
import java.util.List;

public class MenuJidlo {

	String name;
	double price;
	
	List<Jidlo> menuChoices = new ArrayList<>();
	
	public MenuJidlo(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public void addMeal(Jidlo jidlo) {
		menuChoices.add(jidlo);
	}
	
	public String getNazev() {
		return name;
	}
	
	public double getCena() {
		return price;
	}
	
	@Override
	public String toString() {
		return String.format("Name: %s, Price: %.2f Kč", name, price);
	}
	
}
