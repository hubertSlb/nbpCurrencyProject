package pl.dashboard.nbp.connector;

import java.time.DateTimeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pl.dashboard.nbp.validators.ArgsValidator;

public class InputChecker {
	
	private static final Logger LOGGER = LogManager.getLogger(InputChecker.class);
	
	public static String inputValid(String[] input) {
		String date = "";
		try {
			ArgsValidator argsValid = new ArgsValidator(input);
			DateChecker dateCheck = new DateChecker(argsValid.inputValid());
			date = dateCheck.check();
		} catch (IllegalArgumentException | DateTimeException e) {
			System.err.println("!!! B³êdne dane wejœciowe. Niepoprawny format daty lub data poza zakresem.\n"
					+ "Przyk³ad poprawnej daty oraz pocz¹tek zakresu to: 2002-01-02\n");
			LOGGER.info(e.getMessage());
		}
		return date;
	}

}
