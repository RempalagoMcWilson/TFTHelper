
package query;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import util.Util;

public class QueryTFTSummoner implements Query {
	

	@Override
	public Object doQuery(Object entrada) {
		String summonerNameQuery = "https://euw1.api.riotgames.com/tft/summoner/v1/summoners/by-name/";
		JSONObject data_obj = null;
		String name = (String) entrada;
		try {
			String query = summonerNameQuery + "" + name + "?api_key=" + apiKey;
			URL url = new URL(query);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode != 200) {
				throw new RuntimeException("" + responsecode);
			} else {
				String inline = "";
				Scanner scanner = new Scanner(url.openStream());
				while (scanner.hasNext()) {
					inline += scanner.nextLine();
				}
				scanner.close();
				JSONParser parse = new JSONParser();
				data_obj = (JSONObject) parse.parse(inline);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Util.resCodeToText(e.getMessage()) + " Summoner name: " + name, "Error message", JOptionPane.ERROR_MESSAGE);
			data_obj = null;
		}
		return data_obj;
	}

}
