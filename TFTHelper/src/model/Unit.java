package model;

import java.util.ArrayList;

public class Unit {
	/*
	 *  {
                        "character_id": "TFT6_Singed",
                        "items": [
                            77,
                            56,
                            55
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 3
                    },
	 */
	private String character_id;
	private ArrayList<Integer> items;
	private String name;
	private int rarity;
	private int tier;
	public Unit(String character_id, ArrayList<Integer> items, String name, int rarity, int tier) {
		this.character_id = character_id;
		this.items = items;
		this.name = name;
		this.rarity = rarity;
		this.tier = tier;
	}
	public String getCharacter_id() {
		return character_id;
	}
	public void setCharacter_id(String character_id) {
		this.character_id = character_id;
	}
	public ArrayList<Integer> getItems() {
		return items;
	}
	public void setItems(ArrayList<Integer> items) {
		this.items = items;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRarity() {
		return rarity;
	}
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
	public int getTier() {
		return tier;
	}
	public void setTier(int tier) {
		this.tier = tier;
	}
}
