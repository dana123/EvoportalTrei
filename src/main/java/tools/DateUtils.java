package tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.google.protobuf.TextFormat.ParseException;

public class DateUtils {
	public static int calculateDuration(String initialDateString,
			   String finalDateString) throws ParseException, java.text.ParseException {
		
			  // formatarea datei
			  DateFormat formatter;
			  formatter = new SimpleDateFormat("dd/MM/yyyy");
			  Date startDate = (Date) formatter.parse(initialDateString);
			  Date endDate = (Date) formatter.parse(finalDateString);
			  
			  //Preluarea datei
			  Calendar startCal = Calendar.getInstance();
			  startCal.setTime(startDate);

			  Calendar endCal = Calendar.getInstance();
			  endCal.setTime(endDate);

			  int workDays = 0;

			  if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			   startCal.setTime(endDate);
			   endCal.setTime(startDate);
			  }

			  do {
			   startCal.add(Calendar.DAY_OF_MONTH, 1);
			   if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
			     && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
			    workDays++;
			   }
			   
			  } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis());
			  System.out.println("Total business days: "+ workDays);
			  return workDays;

			 }
}
