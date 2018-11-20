package pl.dashboard.nbp.connector;

import java.time.LocalDate;

import pl.dashboard.nbp.validators.DateValidator;

public class DateChecker extends DateValidator {
	
	private static final LocalDate fromDate = LocalDate.parse("2002-01-02");
	private static final LocalDate toDate = LocalDate.now();
	private String date;
	
	public DateChecker(String date) {
		this.date = date;
	}
	
	public String check() {
		return rangeValid(formatValid(date), fromDate, toDate);
	}

}
