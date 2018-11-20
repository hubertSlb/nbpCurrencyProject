package pl.dashboard.nbp.interfaces;

import java.time.DateTimeException;
import java.time.LocalDate;

public interface IDateValidator {
	
	LocalDate formatValid(String date) throws DateTimeException;
	String rangeValid(LocalDate date, LocalDate from, LocalDate to);

}
