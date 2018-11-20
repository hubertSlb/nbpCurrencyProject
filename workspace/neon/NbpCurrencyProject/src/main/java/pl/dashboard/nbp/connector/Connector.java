package pl.dashboard.nbp.connector;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connector {
	
	private static final Logger LOGGER = LogManager.getLogger(Connector.class);
	private static final String LINK = "http://api.nbp.pl/api/exchangerates/tables/C/";
	private static final String LINK_FORMAT = "?format=json";
	private String jsonData;
	
	@SuppressWarnings("resource")
	public void connect(String date) {
		HttpURLConnection conn = null;
		try {
			URL url = new URL(fixLink(date));
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("charset", "utf-8");
			conn.connect();
			checkCode(conn.getResponseCode(), new Scanner(conn.getInputStream(), "UTF-8")
					.useDelimiter("\\Z").next());
			
		} catch (IOException e) {
			LOGGER.info(e.getMessage());
		} finally {
			if (conn != null)
				try {
					conn.disconnect();
				} catch (Exception e) {
					LOGGER.info(e.getMessage());
				}
		}
	}
	
	private void checkCode(int code, String json) {
		switch (code) {
		case HttpURLConnection.HTTP_OK:
		case HttpURLConnection.HTTP_CREATED:
			setJsonData(json);
			break;
		default:
			setJsonData("");
			break;
		}
	}
	
	private String fixLink(String date) {
		String result = "";
		if (date != null && !date.isEmpty()) {
			StringBuilder sb = new StringBuilder(LINK);
			sb.append(date).append(LINK_FORMAT);
			result = sb.toString();
		}
		return result;
	}
	
	private void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	
	public Optional<String> getJsonData() {
		return Optional.ofNullable(jsonData);
	}

}
