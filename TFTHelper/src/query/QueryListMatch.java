
package query;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import util.Util;

public class QueryListMatch implements Query{
	
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
				throw new RuntimeException("" + responsecode);
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
			JOptionPane.showMessageDialog(null, Util.resCodeToText(e.getMessage()), "Error message", JOptionPane.ERROR_MESSAGE);
			data_obj = null;
		}
		return data_obj;
	}
    
}
