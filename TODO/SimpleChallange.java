
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
    public static void example1() {
        int[] data = {5, 8, 3, 7, 2};
        int val = 0;
        int i = 0;
        double result = val / data.length();
        while (i <= data.length) {
            val+= data[i];
            i++;
        }

        if (result > 5) {
            System.out.println("Average is high: " + result);
        } else {
            System.out.println("Average is low: " + result);
        }
    }

    // 2
    public static void example2() {
        String[] items = {"Ann", "Bob", "Carl"};
        String search = "Bob";
        boolean found = true;
        for (int j = 0; j <= items.size; j++) { 
            if (items.get(j) == search) { 
                found = false;
            }
            j++;
        }
        
       else if (found = false) { 
            System.out.println("Found " + search);
        } else {
            System.out.println("Not found");
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

    // 5
    public static void example5() {
        String input = null;
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


    // 8
    public static void example8() {
        List<String> items = List.of("one", "two", "three");
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals("two")) {
                System.out.println("Našel jsem dva");
                break;
            }
            System.out.println("Právě teď: " + items[i]);
        }
        System.out.println("Hotovo");
    }

    // 9
    public static void example9() {
        String strData = null;
        String result = strData.toLowerCase(); 
        System.out.println("Uppercase text: " + result);

        if (result.count() > 5) { 
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

    // 10
    public static void example10() {
        int val = 0;
        while (val < 10) {
            System.out.println("Hodnota: " + val);
        }
        System.out.println("Cyklus skončil");
    }

    // 11
    public static void example11() {
        int[] data = {2, 4, 6, 8, 10};
        int val = 0;
        for (int i = 0; i < data.length; i++) {
            val += data[i];
        }
        double res = val / data.length; 
        System.out.println("Průměr je: " + res);
    }

    // 12
    public static void example12() {
        String firstPart = "Alice";
        if (firstPart == "alice") { 
            System.out.println("Jméno je Alice");
        } else {
            System.out.println("Jméno není Alice");
        }
        String secondPart = null;
        System.out.println("Příjmení má délku: " + secondPart.length());
    }


}
