package com.flight.reservation.flightreservation.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	static DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    
	public static LocalDateTime stringToDate(String date) {
	    final String str1 = date + " 12:00:00";
		 return LocalDateTime.parse(str1,  formatter);
	       
	}

 
}
