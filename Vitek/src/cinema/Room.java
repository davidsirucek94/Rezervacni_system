package cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Room {
	private String uuid;
	private int roomNumber;
	private boolean isImax;
	private boolean isVip;
	private List<List<Seat>> rows;
	
	private Show currentShow = null;

	public Room(int roomNumber, int numberOfRows, int numberOfSeatsInRow, boolean isImax, boolean isVip) {
		this.roomNumber = roomNumber;
		this.isImax = isImax;
		this.isVip = isVip;
		rows = new ArrayList<>();

		if(numberOfRows == 0 ||numberOfSeatsInRow) {
			throw new RuntimeException("Cannot create empty room.");
		}

		for (int i = 0; i < numberOfRows; i++) {
			rows.add(new ArrayList<>());
			for (int j = 0; j < numberOfSeats; j++) {
				rows.get(i).add(new Seat(j));
			}
		}
	}


	public void setShow(Show show) {
		if(show == null) {
			throw new RuntimeException("Cannot set show as null, if you want to cancell show use method 'cancelShow' instead.")
		}

		if (currentShow != null){
			throw new RuntimeException("There is show already set.");
		} 

		currentShow = show;
	}

	public void cancelShow() {
		if(currentShow == null) {
			throw new RuntimeException("No show has been set.");
		}

		currentShow = null;
	}

public String getUuid(){
	return uuid;
}
	
	
	public void render() {
		System.out.println(this)
	}

	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		int rowIndex = 0;
		
		result.append(String.format("%s%sRoom %s", isVip ? "⭐ " : "", isImax ? "👓 " : "", String.valueOf(roomNumber)));
		for (List<Seat> row : rows) {
			result.append(String.format("Row %d: ", rowIndex + 1));
			for (Seat seat : row) {
				result.append(seat.toString()).append(" ");
			}

			rowIndex++;
			result.append("\n");
		}
		
		return result.toString();
	}
}
