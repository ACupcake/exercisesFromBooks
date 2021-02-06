public class SmartDate {
	private final int month;
	private final int day;
	private final int year;

	public SmartDate(int m, int d, int y) {
		if(!isValidDate(m, d, y))
			throw new RuntimeException("Ilegal date!");
		month = m;
		day = d;
		year = y;
	}
	public boolean isValidDate(int month, int day, int year) {
		int maxDaysMonth[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(m < 0 || d < 0 || y < 0 || m > 12)
			return false;
		if(m == 2 && !ehBissexto(y) && d > 29)
			return false;
		if(day > maxDaysMonth[month - 1])
			return false;
		return true;
	}
	public boolean ehBissexto(int y) {
		if((y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0)))
			return true;
		return false;
	}
	public int month() {
		return month;
	}
	public int day() {
		return day;
	}
	public int year() {
		return day;
	}
	public String toString() {
		return month() + "/" + day() + "/" + year();
	}
}