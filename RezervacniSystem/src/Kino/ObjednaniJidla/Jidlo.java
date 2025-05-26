package Kino.ObjednaniJidla;

import Kino.Konstanty;
import Kino.Storage.IStorable;

public class Jidlo implements IStorable {

	private String nazev;
	private double cena;

	public Jidlo(String nazev, double cena) {
		this.nazev = nazev;
		this.cena = cena;
	}

	public String getNazev() {
		return nazev;
	}
	
	public double getCena() {
		return cena;
	}
	
	@Override
	public String toString() {
		if (cena == Konstanty.NOT_SET_PRICE_VALUE) {
			return String.format("Name: %s", nazev);
		}
		return String.format("Name: %s, Price: %.2f Kč", nazev, cena);
	}

	@Override
	public String toCsv() {
		return nazev + ";" + cena;
	}
	
}
