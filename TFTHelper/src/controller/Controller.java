package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import model.Summoner;
import model.solution.Solution;
import view.mainframe.MainFrame;

public class Controller {
	ArrayList<Summoner> summonersList;
	ArrayList<Solution> solutionsList;
	
	public Controller() {
		solutionsList = new ArrayList<Solution>();
		JSONObject data_obj;
		try {
			InputStream in = new FileInputStream(new File("resources/solutions.json"));
			String inline = "";
			Scanner scanner = new Scanner(in);
			while (scanner.hasNext()) {
				inline += scanner.nextLine();
			}
			scanner.close();
			JSONParser parse = new JSONParser();
			data_obj = (JSONObject) parse.parse(inline);
			JSONArray jSA = (JSONArray) data_obj.get("solutions");
    		Iterator<JSONObject> iteratorU = jSA.iterator();
    		while (iteratorU.hasNext()) {
    			JSONObject jS = (JSONObject) iteratorU.next();
    			solutionsList.add(new Solution(jS));
    		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void meteSummoners(ArrayList<String> nombresSummoners) {
		/*summonersList = new ArrayList<Summoner>();
		for(String n: nombresSummoners) {
			summonersList.add(new Summoner(n));
		}
		for(Summoner s : summonersList) {
			System.out.println(s);
		}*/
		
		new MainFrame(solutionsList.get(0));
	}

}
