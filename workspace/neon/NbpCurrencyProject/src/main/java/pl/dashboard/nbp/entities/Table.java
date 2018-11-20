package pl.dashboard.nbp.entities;

import java.util.List;
import java.util.Optional;

public class Table {
	
	private String table;
	private String no;
	private String tradingDate;
	private String effectiveDate;
	private List<Currency> rates;
	
	public Table() {
		
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getTradingDate() {
		return tradingDate;
	}

	public void setTradingDate(String tradingDate) {
		this.tradingDate = tradingDate;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Optional<List<Currency>> getRates() {
		return Optional.ofNullable(rates);
	}

	public void setRates(List<Currency> rates) {
		this.rates = rates;
	}

}
