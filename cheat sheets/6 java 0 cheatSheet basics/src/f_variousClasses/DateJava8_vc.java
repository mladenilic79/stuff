package f_variousClasses;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateJava8_vc {
	
	/*
	new java time api classes:
	
    Instant � represents a point in time (timestamp)
    LocalDate � represents a date (year, month, day)
    LocalDateTime � same as LocalDate, but includes time with nanosecond precision
    OffsetDateTime � same as LocalDateTime, but with time zone offset
    LocalTime � time with nanosecond precision and without date information
    ZonedDateTime � same as OffsetDateTime, but includes a time zone ID
    OffsetLocalTime � same as LocalTime, but with time zone offset
    MonthDay � month and day, without year or time
    YearMonth � month and year, without day or time
    Duration � amount of time represented in seconds, minutes and hours. Has nanosecond precision
    Period � amount of time represented in days, months and years
	 */
	
	// some examples
	
	// get current time
	ZonedDateTime now = ZonedDateTime.now();
	
	// representing specific time
	LocalDate birthDay = LocalDate.of(1990, Month.DECEMBER, 15);

	// extracting specific fields
	Month month = LocalDateTime.now().getMonth();
	
	// adding and subtracting time
	LocalDateTime fiveHoursBefore = LocalDateTime.now().minusHours(5);
	
	// time zone conversion
	ZonedDateTime centralEastern = LocalDateTime.now().atZone(ZoneId.of("CET"));
	
	// Getting time span between two points in time
	LocalDateTime now1 = LocalDateTime.now();
	LocalDateTime hourLater = LocalDateTime.now().plusHours(1);
	Duration span = Duration.between(now1, hourLater);
	
	// time formating & parsing
	LocalDate now2 = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	String formattedDate = now2.format(formatter);
	LocalDate parsedDate = LocalDate.parse(formattedDate, formatter);
	
	// number of days in a month
	int daysInMonth = YearMonth.of(1990, 2).lengthOfMonth();

}
