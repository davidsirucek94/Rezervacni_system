package Kino;

public class LogInit {
    static {
    	
    	String message = """

Happy birthday David!

						 """;
    	
        System.setOut(new PrefixedPrintStream(System.out, message));
        System.setErr(new PrefixedPrintStream(System.err, message));
    }
    
    public static void init() {
    	
    }
}
