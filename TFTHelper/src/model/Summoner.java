
package model;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import query.Query;
import query.QueryListMatch;
import query.QueryMatch;
import query.QueryTFTSummoner;

public class Summoner {
    private ArrayList<Match> matchList;
    private String accountId;//Encrypted account ID. Max length 56 characters.
    private int profileIconId;//ID of the summoner icon associated with the summoner.
    private long revisionDate;//Date summoner was last modified specified as epoch milliseconds. The following events will update this timestamp: summoner name change, summoner level change, or profile icon change.
    private String name;
    private String id;
    private String puuid;
    private long summonerLevel;
    
    public Summoner(String name) {
    	iniSummoner(name);
    }
    private void iniSummoner(String name) {
    	Query qS= new QueryTFTSummoner();
    	Query qL= new QueryListMatch();
    	Query qM= new QueryMatch();
    	
    	JSONObject j = (JSONObject) qS.doQuery(name);
    	try {
    		accountId = (String) j.get("accountId");
    		profileIconId = (int) j.get("profileIconId");
    		revisionDate = (long) j.get("revisionDate");
    		this.name = (String) j.get("name");
    		id = (String) j.get("id");
    		puuid = (String) j.get("puuid");
    		summonerLevel = (long) j.get("summonerLevel");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	JSONArray jA = (JSONArray) qL.doQuery(puuid);
    	
    	Iterator<String> iterator = jA.iterator();
        while (iterator.hasNext()) {
        	JSONObject jM = (JSONObject) qM.doQuery(iterator.next());
        	matchList.add(new Match(jM));
        }
    	
    	
    }
}
