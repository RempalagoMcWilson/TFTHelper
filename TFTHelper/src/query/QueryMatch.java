
package query;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class QueryMatch implements Query{

	@Override
	public Object doQuery(Object entrada) {
		String summonerNameQuery = "https://europe.api.riotgames.com/tft/match/v1/matches/";
		JSONObject data_obj = null;
		String idPartida = (String) entrada;
		try {
			String query = summonerNameQuery + "" + idPartida + "?api_key=" + apiKey;
			URL url = new URL(query);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responsecode);
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
			e.printStackTrace();
		}
		return data_obj;
	}
    
}
