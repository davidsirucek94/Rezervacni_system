package cinema
import java.util.UUID;
import java.time.LocalDateTime;

public class ReservationSystem {
	private String uuid;
	private Map<String, Show> currentShows;

public ReservationSystem(List<Show> currentShows) {
	this.currentShows= currentShows;
}
	
	public void createReservation(String username, String showUuid) {
		
	}

	public void cancelReservation(String reservationUuid) {

	}

	public List<Show> listAvailableShows() {
		return List.of();
	}
public String getUuid(){
	return uuid;
}
}
