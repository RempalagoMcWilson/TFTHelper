package controller;

import java.util.ArrayList;

import model.Summoner;

public class Controller {
	ArrayList<Summoner> summonersList;

	public void meteSummoners(ArrayList<String> nombresSummoners) {
		summonersList = new ArrayList<Summoner>();
		for(String n: nombresSummoners) {
			summonersList.add(new Summoner(n));
		}
		for(Summoner s : summonersList) {
			System.out.println(s);
		}
	}

}
