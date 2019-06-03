enum WeekDay {	
	SUNDAY(false),
	MONDAY(true),
	TUESDAY(true),
	WEDNESDAY(true),
	THURSDAY(true),
	FRIDAY(true),
	SATURDAY(false);
	
	private static final WeekDay[] days = WeekDay.values();
	
	boolean workday;
	
	WeekDay(boolean workday) {
		this.workday = workday;
	}
	
	public boolean isWorkday() { return workday; }
	
	public WeekDay plus(int numDays) {
		return days[(ordinal() + numDays) % days.length];
	}
	
	public static WeekDay of(int day) {
		return days[day - 1];
	}
}

public class Enums {
	
	public static void main(String[] args) {
		WeekDay wday = WeekDay.MONDAY;
		System.out.println(wday);
		
		System.out.println("----");
		
		WeekDay[] days = WeekDay.values();
		for (WeekDay wd : days) {
			System.out.println(wd);
		}
		
		System.out.println("----");
		
		printIsWorkDay(wday);
		
		System.out.println("----");

		WeekDay thursday = WeekDay.of(2).plus(3);
		System.out.println(thursday);
	}
	
	private static void printIsWorkDay(WeekDay day) {
		/*
		switch (day) {
			case SUNDAY:
			case SATURDAY:
				System.out.println(":: weekend ::");
				break;
			default:
				System.out.println(":: workday ::");
				break;
		}
		*/
		if (day.isWorkday()) {
			System.out.println(":: workday ::");
		} else {
			System.out.println(":: weekend ::");
		}
	}
}
