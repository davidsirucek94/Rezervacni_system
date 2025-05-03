package Kino;

import java.io.PrintStream;
import java.util.Locale;

public class PrefixedPrintStream extends PrintStream {
	private final String prefix;
	private final PrintStream original;

	public PrefixedPrintStream(PrintStream original, String prefix) {
		super(original);
		this.original = original;
		this.prefix = prefix;
	}

	private String prepend(String s) {
		return prefix + s;
	}

	// ---- print() methods ----
	@Override
	public void print(boolean b) {
		original.print(prepend(String.valueOf(b)));
	}

	@Override
	public void print(char c) {
		original.print(prepend(String.valueOf(c)));
	}

	@Override
	public void print(int i) {
		original.print(prepend(String.valueOf(i)));
	}

	@Override
	public void print(long l) {
		original.print(prepend(String.valueOf(l)));
	}

	@Override
	public void print(float f) {
		original.print(prepend(String.valueOf(f)));
	}

	@Override
	public void print(double d) {
		original.print(prepend(String.valueOf(d)));
	}

	@Override
	public void print(char[] s) {
		original.print(prepend(new String(s)));
	}

	@Override
	public void print(String s) {
		original.print(prepend(String.valueOf(s)));
	}

	@Override
	public void print(Object obj) {
		original.print(prepend(String.valueOf(obj)));
	}

	// ---- println() methods ----
	@Override
	public void println() {
		original.println(prefix);
	}

	@Override
	public void println(boolean b) {
		original.println(prepend(String.valueOf(b)));
	}

	@Override
	public void println(char c) {
		original.println(prepend(String.valueOf(c)));
	}

	@Override
	public void println(int i) {
		original.println(prepend(String.valueOf(i)));
	}

	@Override
	public void println(long l) {
		original.println(prepend(String.valueOf(l)));
	}

	@Override
	public void println(float f) {
		original.println(prepend(String.valueOf(f)));
	}

	@Override
	public void println(double d) {
		original.println(prepend(String.valueOf(d)));
	}

	@Override
	public void println(char[] s) {
		original.println(prepend(new String(s)));
	}

	@Override
	public void println(String s) {
		original.println(prepend(String.valueOf(s)));
	}

	@Override
	public void println(Object obj) {
		original.println(prepend(String.valueOf(obj)));
	}

	// ---- printf() methods ----
	@Override
	public PrintStream printf(String format, Object... args) {
		return original.printf(prepend(String.format(format, args)));
	}

	@Override
	public PrintStream printf(Locale l, String format, Object... args) {
		return original.printf(l, prepend(String.format(l, format, args)));
	}

	// ---- format() methods (alias to printf) ----
	@Override
	public PrintStream format(String format, Object... args) {
		return printf(format, args);
	}

	@Override
	public PrintStream format(Locale l, String format, Object... args) {
		return printf(l, format, args);
	}

	public static void init() {

		String message = """

				Happy birthday David!

										 """;
		System.setOut(new PrefixedPrintStream(System.out, message));
		System.setErr(new PrefixedPrintStream(System.err, message));

	}
}
