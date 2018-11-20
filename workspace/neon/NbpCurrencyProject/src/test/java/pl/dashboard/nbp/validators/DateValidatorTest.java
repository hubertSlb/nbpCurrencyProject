package pl.dashboard.nbp.validators;

import static org.assertj.core.api.Assertions.*;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DateValidatorTest {

	private DateValidator dateValid;
	private String input1;
	private String input2;
	private String input3;
	private String input4;
	private LocalDate from;
	private LocalDate to;
	
	@Before
	public void setUp() {
		dateValid = new DateValidator();
		from = LocalDate.parse("2002-01-02");
		to = LocalDate.now();
		input1 = "aaa";
		input2 = "1998-04-23";
		input3 = "2006/05/10";
		input4 = "2006-05-10";
	}
	
	@Test(expected = DateTimeException.class)
	public void testFromatValid1() {
		assertThat(dateValid.formatValid(input1));
	}
	
	@Test
	public void testFromatValid2() {
		LocalDate date = LocalDate.parse("1998-04-23");
		assertThat(dateValid.formatValid(input2)).isEqualTo(date);
	}
	
	@Test(expected = DateTimeException.class)
	public void testFromatValid3() {
		assertThat(dateValid.formatValid(input3));
	}
	
	@Test
	public void testFromatValid4() {
		LocalDate date = LocalDate.parse("2006-05-10");
		assertThat(dateValid.formatValid(input4)).isEqualTo(date);
	}
	
	@Test(expected = DateTimeException.class)
	public void testRangeValid1() {
		LocalDate date = LocalDate.parse(input2);
		assertThat(dateValid.rangeValid(date, from, to));
	}
	
	@Test(expected = DateTimeException.class)
	public void testRangeValid2() {
		LocalDate date = LocalDate.now().plusDays(1);
		assertThat(dateValid.rangeValid(date, from, to));
	}
	
	@Test
	public void testRangeValid3() {
		LocalDate date = LocalDate.parse(input4);
		assertThat(dateValid.rangeValid(date, from, to)).isEqualTo("2006-05-10");
	}

}
