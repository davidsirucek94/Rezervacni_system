package Kino.RezervacniSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rezervace {

	String jmeno;
	String email;
	Promitani promitani;
	List<SouradniceMist> rezervovanaMista = new ArrayList<>();
	
	public Rezervace(String jmeno, String email, Promitani promitani) {
		this.jmeno = jmeno;
		this.email = email;
		this.promitani = promitani;
	}
	
	public void showCinemaRoom() {
	//	System.out.println(promitani.sal.toString());
	}
	
	public void enterRowAndSeat() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter row and seat number divided by a comma (1,2):");
		String[] enteredData = scanner.nextLine().split(",");
		int row = Integer.parseInt(enteredData[0]);
		int seat = Integer.parseInt(enteredData[1]);
		/*if(promitani.isThisSeatTaken(row, seat)) {
			System.out.println("This seat is taken! Choose another one.");
		} else {
			rezervovanaMista.add(new SouradniceMist(row, seat));
			promitani.sal.getSeat(row, seat).setSeatTaken();
		}*/
		scanner.close();
	}
	
}
