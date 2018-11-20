package pl.dashboard.nbp.validators;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import pl.dashboard.nbp.interfaces.IDateValidator;

public class DateValidator implements IDateValidator {

	@Override
	public LocalDate formatValid(String date) throws DateTimeException {
		return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
	}

	@Override
	public String rangeValid(LocalDate date, LocalDate from, LocalDate to) {
		if (date.isBefore(from) || date.isAfter(to))
			throw new DateTimeException("Date out of range");
		
		return date.toString();
	}

}
