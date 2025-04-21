package Kino.ObjednaniJidla;

public class Employee {

	private String name;
	private PracovniPozice position;

	public Employee(String name, PracovniPozice position) {
		this.name = name;
		this.position = position;
	}

	public String getEmployeeName() {
		return name;
	}

	public PracovniPozice getEmployeePosition() {
		return position;
	}

	public boolean canEmployeeRunKasa() {
		if (position == PracovniPozice.CLEANINGLADY) {
			return false;
		}
		return true;
	
	// return position != PracovniPozice.CLEANINGLADY;
	}
}
