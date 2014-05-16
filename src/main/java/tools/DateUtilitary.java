package tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

public class DateUtilitary {

	public static void checkWeekendRequest(String initialDateString,
			String endDateString) throws ParseException {

		// DateFormat formatter;
		// formatter = new SimpleDateFormat("yyyy/MM/dd");

		SimpleDateFormat mdyFormat = new SimpleDateFormat("MM/dd/yyyy");

		Date startD = mdyFormat.parse(initialDateString);
		Date endD = mdyFormat.parse(endDateString);

		System.out.println(startD);
		System.out.println(mdyFormat.format(startD));
		System.out.println(endD);
		System.out.println(mdyFormat.format(endD));

		LocalDate startDate = new LocalDate(startD);
		LocalDate endDate = new LocalDate(endD);
		// LocalDate endDate = new LocalDate(2014, 5, 5);

		int sDay = startDate.dayOfWeek().get(); // gets the day of the week as
												// integer
		int eDay = endDate.dayOfWeek().get();

		// CHECK FOR START DATE
		if (DateTimeConstants.SUNDAY == sDay) {
			System.out.println("Start Date it's a Sunday!");

		} else if (DateTimeConstants.SATURDAY == sDay) {
			System.out.println("Start Date It's a Saturday");
		}

		else {
			System.out.println(" It is another day");
		}

		// CHECK FOR END DATE
		if (DateTimeConstants.SUNDAY == eDay) {
			System.out.println("End Date It's a Sunday!");

		} else if (DateTimeConstants.SATURDAY == eDay) {
			System.out.println("End Date It's a Saturday");
		}

		else {
			System.out.println("It is another day");
		}

	}

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		DateUtilitary.checkWeekendRequest("5/17/2014", "5/16/2014");

	}
}
