package model.solution;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Solution {

	private String name;
	private ArrayList<String> units;
	private int numCoin;
	
	public Solution(JSONObject j) {
		numCoin = 0;
		units = new ArrayList<String>();
		try {
			name = (String) j.get("name");
			//System.out.println(name);
			JSONArray jUA = (JSONArray) j.get("units");
			//System.out.println(jUA);
    		Iterator<JSONObject> iteratorU = jUA.iterator();
    		while (iteratorU.hasNext()) {
    			JSONObject jU = (JSONObject) iteratorU.next();
    			units.add((String)jU.get("character_id"));
    		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getNumCoin() {
		return numCoin;
	}
	public void increaseNumCoin() {
		numCoin++;
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getUnits() {
		return units;
	}
	public boolean contains(String st) {
		for(String str: units) {
			if(str.equals(st))
				return true;
		}
		return false;
	}
}
