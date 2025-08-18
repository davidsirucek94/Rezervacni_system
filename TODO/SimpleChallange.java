
/**
 * !!!DO NOT OPEN THIS FILE IN ECLIPSE OR OTHER IDE!!!
 * 
 * I have prepared a few sample methods that you have to correct:
 *  1. Each method would deserve name based on it's purpose
 *  2. If you think that the changing return type would make more sense then do it
 *  3. We want to make our methods reusable, so think what you could improve
 *  4. There are a few logical or syntactic errors that you have to fix
 *  5. Also think about the compile time issues
 *  6. Fix everything that cames to your mind
 * 
 *  Sorry for some tasks being a bit repetitive, I have generated them using chatgpt and it was real pain in the ass because he was generating the same thing again and again and again... so I had to take a few of them and add some extra challanges for you :)
 * 
 */
public class SimpleChallange {

    // 1
    public static void AverageCalculation(double[] values) {
	values = {5.02, 8.04, 3.33, 7.335, 2.54};
        int val = 0;
        For (int i = 0; i <= data.length; i++) {
		val = val + data[i];
	}
        double result = val / data.length();

        if (result > 5) {
            System.out.println("Average is high: " + result);
        } else {
            System.out.println("Average is low: " + result);
        }
    }

class Main {
    public static void main(String[] args) {
        calculateAverage(new double [] {});
    }
    public static double calculateAverage(double[] values) {
        double sum = 0;
        for (double value : values) {
		sum = sum + value;
	}
	    if (values.length == 0) {
	        System.out.println("Jsi idiot!");
	        return -1;
	    }
        return sum / values.length;
    }
}

    // 2
    public static void example2() {
        String[] items = {"Ann", "Bob", "Carl"};
        String searchedItem = "Bob";
        boolean found = false;
        for (int j = 0; j < items.length; j++) { 
            if (items[j].equals(searchedItem)) { 
                found = true;
		break;
            }
        }
        
       if (found == true) { 
            System.out.println("Found " + searchedItem);
        } else {
            System.out.println("Not found");
        }
    }

class Main {
    public static void main(String[] args) {
        if (isValueIncluded(new String[] {"Ann", "Bob", "Carl"}, "Bob") == true) {
            System.out.println("Jop!");
        } else {
            System.out.println("Nope!");
        }
    }
    
      public static boolean isValueIncluded(String[] items, String searchedItem) {
        for (String item : items) {
            if (item.equals(searchedItem)) {
                return true;
            }
        }
        return false;
    }
}

    // 3
    public static void example3() {
        int n = 15;
        boolean isValid = true;
        for (int k = 2; k < n / 2; k--) {
            if (n % k == 0) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is not prime");
        }
    }

class Example3 {
    public static void main(String[] args) {
        int x = 13;
        boolean isPrime = true;
        for (int i = 2; i <= x / 2; i++) { // inkrementace i++
            if (x % i == 0) {
                isPrime = false;
                break; // můžeme ukončit smyčku
            }
        }
        System.out.println(x + " is prime: " + isPrime);
    }
}

class Main {
    public static void main(String[] args) {
        isPrimeNumber(15);
    }
    
     public static boolean isPrimeNumber(int n) {
        boolean isPrime = false;
        for (int k = 2; k < n / 2; k++) {
            if (n % k == 0) {
                isPrime = true;
                return isPrime;
            }
        }
        if (isPrime) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is not prime");
        }
        return isPrime;
    }
}

    // 4
    public static void example4() {
        int x = 10;
        int y = 0;
        int res = x / y;
        if (res > 5) {
            System.out.println("Result je větší než 5");
        } else {
            System.out.println("Result je menší nebo rovno 5");
        }
    }

class Main {
    public static void main(String[] args) {
        example4();
    }
     public static void example4() {
        int x = 10;
        int y = 6;
        double res = 0;
        if (y != 0) {
            res = (double) x / (double) y;
            System.out.println(res);
        } else {
            System.out.println("Nulou dělit nejde!!");
            return;
        }
        if (res > 5) {
            System.out.println("Result je větší než 5");
        } else {
            System.out.println("Result je menší nebo rovno 5");
        }
    }
}

    // 5
    public static void example5() {
        String input = null; //null mi zabírá paměť ale nemá hodnotu, uvozovky by si něco zabraly (analogie byt)
        int length = input.length();
        if (length > 3) {
            System.out.println("Délka větší než 3");
        } else if {
            System.out.println("Délka menší nebo rovna 3");
        }
        String test += "Test";
        if ("test" == test) {
            System.out.println("Strings jsou stejné");
        }
    }

class Main {
    public static void main(String[] args) {
        example5();
    }
    
     public static void example5() {
        String input = null; //null mi zabírá paměť ale nemá hodnotu, uvozovky by si něco zabraly (analogie byt)
        int length = input.length();
        if (length > 3) {
            System.out.println("Délka větší než 3");
        } else {
            System.out.println("Délka menší nebo rovna 3");
        }
        String test = "";
        test = test + "Test";
        if ("test" == test) {
            System.out.println("Strings jsou stejné");
        }
    }
}


    // 6
    public static void example6() {
        List<String> items = List.of("one", "two", "three");
        for (int i = 0; i < items.size(); i++) { //list nemá definovanou délku jako pole, takže používám METODU size()
            if (items.get(i).equals("two")) {
                System.out.println("Našel jsem dva");
                break;
            }
            System.out.println("Právě teď: " + items[i]);
        }
        System.out.println("Hotovo");
    }

import java.util.List;
import java.util.ArrayList;
class Main {
    public static void main(String[] args) {
        example6();
    }
      public static void example6() {
        List<String> items = new ArrayList<>(List.of("one", "three"));
        items.add(null);
        items.add("two");
        for (int i = 0; i < items.size(); i++) { //list nemá definovanou délku jako pole, takže používám METODU size()
            if ((items.get(i) != null) && (items.get(i).equals("two"))) {
                System.out.println("Našel jsem dva");
                break;
            }
            System.out.println("Právě teď: " + items.get(i));
        }
        System.out.println("Hotovo");
    }
}

    // 7
    public static void example7() {
        String strData = null;
        String result = strData.toUpperCase(); 
        System.out.println("Uppercase text: " + result);

        if (result.length() > 5) { 
            System.out.println("Délka je větší než 5");
        } else {
            System.out.println("Délka je 5 nebo méně");
        }

        String extraCheck = "test";
        if (extraCheck.equals(strData)) {
            System.out.println("Strings jsou stejné");
        } else {
            System.out.println("Strings nejsou stejné");
        }
    }

        public static void compareStrings() {
        String strData = "tEst";
        String result = strData.toUpperCase(); 
        System.out.println("Uppercase text: " + result);

        if (result.length() > 5) { 
            System.out.println("Délka je větší než 5");
        } else {
            System.out.println("Délka je 5 nebo méně");
        }

        String extraCheck = "test";
        if (extraCheck.toLowerCase().equals(strData.toLowerCase())) {
            System.out.println("Strings jsou stejné");
        } else {
            System.out.println("Strings nejsou stejné");
        }
    }

    // 8
    public static void example8() {
        int val = 0;
        while (val < 10) {
            System.out.println("Hodnota: " + val);
	    val++;
        }
        System.out.println("Cyklus skončil");
    }

    // 9
    public static void example9() {
        int[] data = {2, 4, 6, 8, 10};
        int val = 0;
        for (int i = 0; i < data.length; i++) {
            val += data[i];
        }
        double res = val / data.length; 
        System.out.println("Průměr je: " + res);
    }

public static void countAverageValue(int[] data) {
        int val = 0;
        for (int digit : data) {
            val += digit;
        }
        double res = val / (double)data.length; 
        System.out.println("Průměr je: " + res);
    }

    // 10
    public static void example10(String firstName) {
	if (firstName.toLowerCase().equals("alice") {    
	    return true;	    
        } else {
	    return false;
    }

    public static void main(String[] args) {
       if (isAlice("david") == true) {
           System.out.println("ahoj");
       }
    }
    public static boolean isAlice(String firstName) {
	return firstName.toLowerCase().equals("alice");
    }

}
