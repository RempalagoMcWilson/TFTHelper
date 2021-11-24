package model.analyzer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import model.Summoner;
import model.solution.Solution;

public class SolutionAnalyzer {
	
	PriorityQueue<Solution> pQ;

	public SolutionAnalyzer(ArrayList<Solution> solutionsList, ArrayList<Summoner> summonersList) {
		analyze(solutionsList, summonersList);
	}

	private void analyze(ArrayList<Solution> solutionsList, ArrayList<Summoner> summonersList) {
		pQ = new PriorityQueue<Solution>(1, new Comparator<Solution>(){
			@Override
			public int compare(Solution s1, Solution s2) {
				if(s1.getNumCoin() < s2.getNumCoin())
					return -1;
				else
					return 1;
			}
		});
		
		for(Solution s : solutionsList) {
			for(Summoner su: summonersList) {
				for(String st : su.getSA().getAvgUnitList()) {
					if(s.contains(st)) {
						s.increaseNumCoin();
					}
				}
			}
		}
		
		
		for(Solution s : solutionsList) {
			pQ.add(s);
		}
		
	}
	
	public Solution getBestSolution() {
		return pQ.peek();
	}

	
}
