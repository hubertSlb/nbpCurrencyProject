package pl.dashboard.nbp.connector;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import pl.dashboard.nbp.entities.Table;

public class CurrencyData {
	
	private static final Logger LOGGER = LogManager.getLogger(CurrencyData.class);
	private Table currencyTable;
	private String[] input;
	
	public CurrencyData(String[] input) {
		this.input = input;
	}
	
	public void process() {
		Connector connector = new Connector();
		connector.connect(InputChecker.inputValid(input));
		connector.getJsonData().ifPresent(this::setTable);
	}
	
	private void setTable(String json) {
		try {
			Table[] arr = new Gson().fromJson(json, Table[].class);
			Optional.ofNullable(arr).ifPresent(a -> setCurrencyTable(a[0]));
		} catch (JsonSyntaxException | NoSuchElementException e) {
			System.err.println("B³¹d pobrania danych z serwisu.");
			LOGGER.info(e.getMessage());
		}
	}

	public Optional<Table> getCurrencyTable() {
		return Optional.ofNullable(currencyTable);
	}

	public void setCurrencyTable(Table currencyTable) {
		this.currencyTable = currencyTable;
	}

}
