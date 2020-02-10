package prob3;

public class CurrencyConverter {
	private static double rate;

	public static void setRate(double r) {
		rate = r;
		
	}

	public static double toDollar(int w) {
		return w / rate;
	}

	public static double toKRW(int d) {
		return d * rate;
	}

}
