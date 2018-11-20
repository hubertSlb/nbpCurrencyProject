package pl.dashboard.nbp;

import pl.dashboard.nbp.connector.CurrencyRate;

public class MainClass {

	public static void main(String[] args) {
		
		CurrencyRate.getRates(args);

	}

}
