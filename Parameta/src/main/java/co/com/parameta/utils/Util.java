package co.com.parameta.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Util {

	public static int getYears(Date date) {
		LocalDate newDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period age = Period.between(newDate, LocalDate.now());
		return age.getYears();
	}

	public static int getmonths(Date date) {
		LocalDate newDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period age = Period.between(newDate, LocalDate.now());
		return age.getMonths();
	}

	public static int getDays(Date date) {
		LocalDate newDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period age = Period.between(newDate, LocalDate.now());
		return age.getDays();
	}
}
