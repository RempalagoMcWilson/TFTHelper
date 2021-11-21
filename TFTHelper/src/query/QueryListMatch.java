
package query;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.Match;

public class QueryListMatch implements Query{
	
	/*
	 * https://europe.api.riotgames.com/tft/match/v1/matches/by-puuid/
	 * 5v4L6-ExFOWdK4kqIXE8pKSfeeR60MQUbNsKtFFybSMVpfzXrfd9uSWOPRe3AGWuffCV9MqU9xitdw
	 * /ids?count=10&api_key=
	 * RGAPI-9cb5ac55-80eb-4a8e-aba6-fac16e41b07e
	 */

	@Override
	public Object doQuery(Object entrada) {
		String listMatchQuery = "https://europe.api.riotgames.com/tft/match/v1/matches/by-puuid/";
		JSONArray data_obj = null;
		String puuid = (String) entrada;
		
		try {
			String query = listMatchQuery + "" + puuid + "/ids?count="+ numPartidas + "&api_key=" + apiKey;
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
				data_obj = (JSONArray) parse.parse(inline);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data_obj;
	}
    
}
