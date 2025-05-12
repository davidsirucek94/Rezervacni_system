package Kino;

import java.time.format.DateTimeFormatter;

public class Konstanty {

	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyy HH:mm");
	
	public static final double IMAX_EXTRA_COST_PERCENTAGE = 10;
	
	public static final double VIP_EXTRA_COST_PERCENTAGE = 15;
	
	public static final double IMAX_PLUS_VIP_EXTRA_COST_PERCENTAGE = 25;
	
	public static final double NOT_SET_PRICE_VALUE = -1;
	
	// Storage
	public static final String MOVIES_STORAGE_PATH = "./movies.csv";
	
	//static ta věc nepatří instanci, ale patří třídě
	//konstanta má final, aby mi ji nikdo nezměnil
}
