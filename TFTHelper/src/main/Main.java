package main;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

    public static void main(String[] args) {
        String apiKey = "RGAPI-9cb5ac55-80eb-4a8e-aba6-fac16e41b07e";
        String summonerNameQuery = "https://euw1.api.riotgames.com/tft/summoner/v1/summoners/by-name/";
        String summonerName = "LenguaSalvaje";
        String query = "";
        try {
            query = summonerNameQuery + "" + summonerName + "?api_key=" + apiKey;
            URL url = new URL(query);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                System.out.println(inline);
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);
                

                String id  = (String) data_obj.get("id");
                String puuid  = (String) data_obj.get("puuid");
                System.out.println(id);
                System.out.println(puuid);
                /*
                //Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();
                

                //Get the required object from the above created object
                JSONObject obj = (JSONObject) data_obj.get("Global");

                //Get the required data using its key
                System.out.println(obj.get("TotalRecovered"));

                JSONArray arr = (JSONArray) data_obj.get("Countries");

                for (int i = 0; i < arr.size(); i++) {

                    JSONObject new_obj = (JSONObject) arr.get(i);

                    if (new_obj.get("Slug").equals("albania")) {
                        System.out.println("Total Recovered: " + new_obj.get("TotalRecovered"));
                        break;
                    }
                }*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
