package model.analyzer;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import model.Match;
import model.Summoner;
import model.Unit;

public class SummonerAnalyzer {
	private List<String> avgUnitList;// Lista de sus unidades más usadas
	private double avgGold_left;
	private double avgLast_round;
	private double avgLevel;
	private double avgPlacement;
	private double avgPlayers_eliminated;
	private double avgTotal_damage_to_players;

	public SummonerAnalyzer(Summoner s) {

		analyzeSummoner(s);
	}
	
	

	public void analyzeSummoner(Summoner s) {
		avgUnitList = new ArrayList();

		PriorityQueue<UnidadAux> pQ = new PriorityQueue<UnidadAux>(1, new Comparator<UnidadAux>(){
			@Override
			public int compare(UnidadAux s1, UnidadAux s2) {
				int v1 = s1.getsE().getValue();//String k1 = s1.getsE().getKey();
				int v2 = s2.getsE().getValue();//String k2 = s2.getsE().getKey();
					if(v1 < v2)
						return 1;
					else
						return -1;
			}
		});
		
		int contNumPartida = 0;
		long sumGold_left = 0, sumLast_round = 0, sumLevel = 0, sumPlacement = 0,
				sumPlayers_eliminated = 0, sumTotal_damage_to_players = 0;
		for (Match m : s.getMatchList()) {
			contNumPartida++;
			sumGold_left += m.getGold_left();
			sumLast_round += m.getLast_round();
			sumLevel += m.getLevel();
			sumPlacement += m.getPlacement();
			sumPlayers_eliminated += m.getPlayers_eliminated();
			sumTotal_damage_to_players += m.getTotal_damage_to_players();
			for(Unit u: m.getUnitList()) {
				SimpleEntry<String, Integer> sE = new SimpleEntry<String, Integer>(u.getCharacter_id(), 1);
				UnidadAux auxiliarU = new UnidadAux(sE);
				if(!pQ.contains(auxiliarU)) {
					pQ.offer(auxiliarU);
				}
				else {
					Iterator<UnidadAux> iterator = pQ.iterator();
					 while (iterator.hasNext()) {
						 UnidadAux uA = iterator.next();
						 if(uA.equals(auxiliarU)) {
							 pQ.remove(uA);
							 uA.sumaCont();
							 pQ.offer(uA);
							 break;
						 }
						 
					 }
				}
			}
		}
		
		for(int i = 0; i < 8;i++) {
			UnidadAux auxiliarU = pQ.poll();
			System.out.println(auxiliarU.getsE().getKey() + " " + auxiliarU.getsE().getValue());
			avgUnitList.add(auxiliarU.getsE().getKey());
		}
		avgGold_left = sumGold_left / contNumPartida;
		avgLast_round = sumLast_round / contNumPartida;
		avgLevel = sumLevel / contNumPartida;
		avgPlacement = sumPlacement / contNumPartida;
		avgPlayers_eliminated = sumPlayers_eliminated / contNumPartida;
		avgTotal_damage_to_players = sumTotal_damage_to_players / contNumPartida;
	}
	
	
	
	private class UnidadAux{
		SimpleEntry<String, Integer> sE;
		
		public UnidadAux(SimpleEntry<String, Integer> sE) {
			this.sE = sE;
		}
		
		public SimpleEntry<String, Integer> getsE() {
			return sE;
		}

		public void sumaCont() {
			Integer aux = sE.getValue();
			aux++;
			SimpleEntry<String, Integer> sEA = new SimpleEntry<String, Integer>(sE.getKey(), aux);
			sE = sEA;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((sE == null) ? 0 : sE.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			UnidadAux other = (UnidadAux) obj;
			String k1 = sE.getKey();
			String k2 = other.getsE().getKey();
			if(k1.equals(k2))
				return true;
			else
				return false;
		}

		private SummonerAnalyzer getEnclosingInstance() {
			return SummonerAnalyzer.this;
		}
		
	}



	@Override
	public String toString() {
		return "SummonerAnalyzer \n[avgUnitList=" + avgUnitList + ",\n avgGold_left=" + avgGold_left + ",\n avgLast_round="
				+ avgLast_round + ",\n avgLevel=" + avgLevel + ",\n avgPlacement=" + avgPlacement
				+ ",\n avgPlayers_eliminated=" + avgPlayers_eliminated + ",\n avgTotal_damage_to_players="
				+ avgTotal_damage_to_players + "]";
	}
	
	
}
