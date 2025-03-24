package cinema
import java.time.LocalDateTime;

public class ReservationSystem {
	private List<Show> shows;
	private List<Movie> movies;
	private List<Rooms> rooms;

	private Movie pickedMovie = null;
	private Reservation currentReservation = null;
	

	public ReservationSystem(List<Show> shows, List<Room> rooms, List<Movie> movies) {
		this.shows = shows;
		this.movies = movies;
		this.rooms = rooms;
	}


	public void createReservation(Scanner scanner) {
		pickedMovie(scanner);
		pickedShow(scanner);
		currentReservation = new Reservation(show);

		do  {
			seatsCount = Integer.parseInt(scanner.nextLine());
		} while(seatsCount < 1 || seatsCount > show.getRoom().getCountOfFreeSeats()); 
	}


	private Movie pickMovie(Scanner scanner) {
		System.out.println("Pick a movie.");
		for (int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			System.out.println(String.format("%d. %s (%s, %d minutes)\n%s\n", i + 1, movie.getTitle(), movie.getDescription(), movie.getGenre(), movie.getDurationInMinutes()));
			System.out.println("\n");
		}

		int pickedMovieIndex = Integer.parseInt(scanner.nextLine()) - 1;

		return movies.get(pickedMovieIndex);
	}

	private void pickShow(Scanner scanner) {
		if(this.pickedMovie == null) {
			throw new RuntimeException("Movie must be picked first.");
		}

		System.out.println("Pick show.");
		List<Show> showsWithPickedMovie = new ArrayList<>();

		for (Show show : shows) {
			if (show.canBeReserved() && Objects.equals(this.pickedMovie.getTitle(), show.getMovieTitle())) {
				showsWithPickedMovie.add(show);
			}
		}

		if(showsWithPickedMovie.isEmpty()) {
			System.out.println("All shows are fully reserved at this time.");
		}

		for (int i = 0; i <  showsWithPickedMovie.size(); i++){
			Show show = showsWithPickedMovie.get(i);
			System.out.println(String.format("%d. %s (%s)"), i + 1, show.getFormattedShowTime(), show.getRoomNumber());
		}

		int pickedShowIndex =  Integer.parseInt(scanner.nextLine());

		this.pickedShow =  showsWithPickedMovie.get(pickedShowIndex);
	}
	
	private takeSeat(Scanner scanner, int row){
		boolean taken = false;
		do {
			System.out.println(this.show.displayRoom());
			taken = show.takeSeat(row, number);
		} while(!taken)
	}




}
