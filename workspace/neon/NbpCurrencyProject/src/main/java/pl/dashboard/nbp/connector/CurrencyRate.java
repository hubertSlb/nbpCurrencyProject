package pl.dashboard.nbp.connector;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import pl.dashboard.nbp.entities.Table;

public class CurrencyRate {
	
	private static final Logger LOGGER = LogManager.getLogger(CurrencyRate.class);
	private static final List<String> currencyCodes = Arrays.asList("EUR", "CHF", "USD", "GBP");
	
	public static void getRates(String[] input) {
		CurrencyData currencyData = new CurrencyData(input);
		currencyData.process();
		printRates(currencyData);
	}
	
	private static void printRates(CurrencyData currencyData) {
		try {
			Table table = currencyData.getCurrencyTable().get();
			System.out.println("Data: " + table.getEffectiveDate() + "\nWaluta = kupno; sprzeda¿");
			
			table.getRates().orElseThrow(IllegalStateException::new).stream()
			.filter(e -> currencyCodes.contains(e.getCode()))
			.forEach(e -> System.out.printf(e.getCode() + " = %.4f; %.4f\n", e.getBid(), e.getAsk()));
			
		} catch (NoSuchElementException | IllegalStateException e) {
			System.err.println("Brak danych dla podanego parametru daty.");
			LOGGER.info(e.getMessage());
		}
	}

}
