package model;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class Unit {
	private String character_id;
	private List<Long> items;
	private String name;
	private long rarity;
	private long tier;
	
	public Unit(JSONObject j) {
		items = new ArrayList<Long>();
		try {
			character_id = (String) j.get("character_id");
			//items = (List) j.get("items");
			name = (String) j.get("name");
			rarity = (long) j.get("rarity");
			tier = (long) j.get("tier");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public String getCharacter_id() {
		return character_id;
	}


	public List<Long> getItems() {
		return items;
	}


	public String getName() {
		return name;
	}


	public long getRarity() {
		return rarity;
	}


	public long getTier() {
		return tier;
	}

/*
	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}


	public void setItems(List<Long> items) {
		this.items = items;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setRarity(long rarity) {
		this.rarity = rarity;
	}


	public void setTier(long tier) {
		this.tier = tier;
	}*/


	@Override
	public String toString() {
		return "Unit [character_id=" + character_id + ",\n items=" + items + ",\n name=" + name + ",\n rarity=" + rarity
				+ ",\n tier=" + tier + "]";
	}
	
	
}
