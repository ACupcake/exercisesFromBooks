public class SmartDate {
	private final int month;
	private final int day;
	private final int year;

	public static void main(String[] args) {
		// month / day / year
		Main alo = new Main(7, 12, 2020);

		System.out.println(alo.dayOfTheWeek());

	}
	public SmartDate(int m, int d, int y) {
		if(!isValidDate(m, d, y))
			throw new RuntimeException("Ilegal date!");
		month = m;
		day = d;
		year = y;
	}
	public boolean isValidDate(int m, int d, int y) {
		int[] maxDaysMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(m < 0 || d < 0 || y < 0 || m > 12)
			return false;
		if(m == 2 && !ehBissexto(y) && d > 29)
			return false;
		if(d > maxDaysMonth[m - 1])
			return false;
		return true;
	}
	public String dayOfTheWeek() {
		//algorithm from https://www.wikihow.com/Calculate-the-Day-of-the-Week

		String[] weekDay = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		int[] monthMagicNumber = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
		int[] weekMagicNumber =  {1, 2, 3, 4, 5, 6, 7};

		int week = day + monthMagicNumber[month - 1];

		while(week > 6)	week -= 7;

		int lastDigitsYear = year % 100;
		int yearNextMultipleOf28 = 28;
		int next = yearNextMultipleOf28;

		for(int i = 1; next < lastDigitsYear; i++)
			next = yearNextMultipleOf28 * i;
		yearNextMultipleOf28 = next - 28;

		int magicNumber = (int)(lastDigitsYear / 4) + (lastDigitsYear - yearNextMultipleOf28);

		magicNumber += week;

		while(magicNumber > 7)
			magicNumber -= 7;

		if(magicNumber == 0)	return weekDay[6];
		else					return weekDay[magicNumber - 1];
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