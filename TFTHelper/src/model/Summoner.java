
package model;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.analyzer.SummonerAnalyzer;
import query.Query;
import query.QueryListMatch;
import query.QueryMatch;
import query.QueryTFTSummoner;

public class Summoner {
    private ArrayList<Match> matchList;
    private String accountId;//Encrypted account ID. Max length 56 characters.
    private long profileIconId;//ID of the summoner icon associated with the summoner.
    private long revisionDate;//Date summoner was last modified specified as epoch milliseconds. The following events will update this timestamp: summoner name change, summoner level change, or profile icon change.
    private String name;
    private String id;
    private String puuid;
    private long summonerLevel;
    private SummonerAnalyzer sA;
    
    public Summoner(String name) {
    	iniSummoner(name);
    }
    private void iniSummoner(String name) {
    	matchList = new ArrayList();
    	Query qS= new QueryTFTSummoner();
    	Query qL= new QueryListMatch();
    	Query qM= new QueryMatch();
    	
    	JSONObject j = (JSONObject) qS.doQuery(name);
    	try {
    		accountId = (String) j.get("accountId");
    		profileIconId = (long) j.get("profileIconId");
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
        	matchList.add(new Match(jM, puuid));
        }
        sA = new SummonerAnalyzer(this);
    }
	@Override
	public String toString() {
		return sA.toString();/*"Summoner [matchList=" + matchList + ",\n accountId=" + accountId + ",\n profileIconId=" + profileIconId
				+ ",\n revisionDate=" + revisionDate + ",\n name=" + name + ",\n id=" + id + ",\n puuid=" + puuid
				+ ",\n summonerLevel=" + summonerLevel + "]";*/
	}
	public ArrayList<Match> getMatchList() {
		return matchList;
	}
	public String getAccountId() {
		return accountId;
	}
	public long getProfileIconId() {
		return profileIconId;
	}
	public long getRevisionDate() {
		return revisionDate;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getPuuid() {
		return puuid;
	}
	public long getSummonerLevel() {
		return summonerLevel;
	}/*
	public void setMatchList(ArrayList<Match> matchList) {
		this.matchList = matchList;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public void setProfileIconId(long profileIconId) {
		this.profileIconId = profileIconId;
	}
	public void setRevisionDate(long revisionDate) {
		this.revisionDate = revisionDate;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}
	public void setSummonerLevel(long summonerLevel) {
		this.summonerLevel = summonerLevel;
	}*/
    
    
}
