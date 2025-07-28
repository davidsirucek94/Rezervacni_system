package Kino.ObjednaniJidla;

import java.util.UUID;

import Kino.Konstanty;
import Kino.Storage.IStorable;

public class Jidlo implements IStorable {

	private String nazev;
	private double cena;
	private UUID id;

	public Jidlo(String nazev, double cena) {
		this(UUID.randomUUID(), nazev, cena); //volá spodní konstruktor
	}
	
	public Jidlo(UUID id, String nazev, double cena) {
		this.nazev = nazev;
		this.cena = cena;
		this.id = id;
	}

	public String getNazev() {
		return nazev;
	}
	
	public double getCena() {
		return cena;
	}
	
	public static Jidlo fromCsv(String[] row) {
		return new Jidlo (UUID.fromString(row[0]), row[1], Double.parseDouble(row[2]));
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
		return id + ";" + nazev + ";" + cena;
	}

	@Override
	public UUID getId() {
		return id;
	}
	
}
