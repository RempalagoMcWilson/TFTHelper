package model.solution;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Solution {

	String name;
	ArrayList<String> units;
	
	public Solution(JSONObject j) {
		units = new ArrayList<String>();
		try {
			name = (String) j.get("name");
			JSONArray jUA = (JSONArray) j.get("units");
    		Iterator<String> iteratorU = jUA.iterator();
    		while (iteratorU.hasNext()) {
    			units.add((String) iteratorU.next());
    		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getUnits() {
		return units;
	}
}
