
package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Match {
	
	private List<Unit> unitList;
	private long gold_left;
	private long last_round;
	private long level;
	private long placement;
	private long players_eliminated;
	private long total_damage_to_players;
	
	public Match(JSONObject jM, String puuid) {
		unitList = new ArrayList<Unit>();
		try {
			JSONObject jInfo = (JSONObject) jM.get("info");
			JSONArray jA = (JSONArray) jInfo.get("participants");
			Iterator<JSONObject> iterator = jA.iterator();
			
	        while (iterator.hasNext()) {
	        	JSONObject jPart = (JSONObject) iterator.next();
	        	String puuidIt = (String) jPart.get("puuid");
	        	if(puuidIt.equals(puuid)) {
	        		gold_left = (long) jPart.get("gold_left");
	        		last_round = (long) jPart.get("last_round");
	        		level = (long) jPart.get("level");
	        		placement = (long) jPart.get("placement");
	        		players_eliminated = (long) jPart.get("players_eliminated");
	        		total_damage_to_players = (long) jPart.get("total_damage_to_players");
	        		JSONArray jUA = (JSONArray) jPart.get("units");
	        		Iterator<JSONObject> iteratorU = jUA.iterator();
	        		while (iteratorU.hasNext()) {
	        			JSONObject jUnit = (JSONObject) iteratorU.next();
	        			unitList.add(new Unit(jUnit));
	        		}
	        	}
	        	
	        }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Match [unitList=" + unitList + ",\n gold_left=" + gold_left + ",\n last_round=" + last_round + ",\n level="
				+ level + ",\n placement=" + placement + ",\n players_eliminated=" + players_eliminated
				+ ",\n total_damage_to_players=" + total_damage_to_players + "]";
	}

	public List<Unit> getUnitList() {
		return unitList;
	}

	public long getGold_left() {
		return gold_left;
	}

	public long getLast_round() {
		return last_round;
	}

	public long getLevel() {
		return level;
	}

	public long getPlacement() {
		return placement;
	}

	public long getPlayers_eliminated() {
		return players_eliminated;
	}

	public long getTotal_damage_to_players() {
		return total_damage_to_players;
	}
/*
	public void setUnitList(List<Unit> unitList) {
		this.unitList = unitList;
	}

	public void setGold_left(long gold_left) {
		this.gold_left = gold_left;
	}

	public void setLast_round(long last_round) {
		this.last_round = last_round;
	}

	public void setLevel(long level) {
		this.level = level;
	}

	public void setPlacement(long placement) {
		this.placement = placement;
	}

	public void setPlayers_eliminated(long players_eliminated) {
		this.players_eliminated = players_eliminated;
	}

	public void setTotal_damage_to_players(long total_damage_to_players) {
		this.total_damage_to_players = total_damage_to_players;
	}*/
	
	
    
}
