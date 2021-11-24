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
import model.analyzer.SolutionAnalyzer;
import model.solution.Solution;
import view.mainframe.MainFrame;

public class Controller {
	ArrayList<Summoner> summonersList;
	ArrayList<Solution> solutionsList;
	
	public Controller() {
		solutionsList = new ArrayList<Solution>();
		iniSolutionsList();
	}

	public void meteSummoners(ArrayList<String> nombresSummoners) {
		summonersList = new ArrayList<Summoner>();
		for(String n: nombresSummoners) {
			summonersList.add(new Summoner(n));
		}
		SolutionAnalyzer aux =  new SolutionAnalyzer(solutionsList,summonersList);
		new MainFrame(aux.getBestSolution(),summonersList);
	}

	private void iniSolutionsList() {
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
	/*VERSION JSON
	 * 
	 * JSONObject data_obj;
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
	 */
	
	
	/*try { VERSION HTMLUNIT NO FUNCIONA JAVASCRIP BIEN AQUI
    WebClient webClient = new WebClient(BrowserVersion.CHROME);
    //webClient.setCssErrorHandler(new SilentCssErrorHandler());
   // webClient.setAjaxController(new NicelyResynchronizingAjaxController());
    webClient.getOptions().setThrowExceptionOnScriptError(false);
    webClient.getOptions().setCssEnabled(true);
    //webClient.getOptions().setRedirectEnabled(false);
    //webClient.getOptions().setAppletEnabled(false);
    webClient.getOptions().setJavaScriptEnabled(true);
    //webClient.getOptions().setPopupBlockerEnabled(true);
    //webClient.getOptions().setTimeout(100000);
    //webClient.waitForBackgroundJavaScriptStartingBefore(1_000);

    HtmlPage page = webClient.getPage("https://tftactics.gg/tierlist/team-comps");
    webClient.waitForBackgroundJavaScript(10_000);
    System.out.println(page.asXml());//page.asNormalizedText()
    webClient.close();
} catch(Exception e) {
    e.printStackTrace();
}*/
	
	/*VERSION JSOUP (NO SIRVE)
	 * String teamRank= ".";String teamNameA = ".";
	System.out.println("Empezamos");
	try {
		Document doc = Jsoup.connect("https://tftactics.gg/tierlist/team-comps").get();
		System.out.println(doc);
		Elements els1 = doc.body().getElementsByClass("characters-list");
		
		for(Element e : els1) {
			System.out.println("primer bucle");
			Elements eAux1 = e.getElementsByClass("team-portrait");
			for(Element e2 : eAux1) {
				System.out.println("segundo");
				Elements teamName = e2.getElementsByClass("team-name");
				for(Element e3 : teamName) {
					if(e3.hasClass("team-rank tone"))
						teamRank = e3.text();//("team-rank tone");
					if(e3.hasClass("team-name-elipsis"))
						teamNameA = e3.text();
				}
				System.out.println(teamRank + " " + teamNameA);
				Elements teamCharacters = e2.getElementsByClass("team-characters");
				for(Element e3 : teamCharacters) {
					String teamCh = e3.attr("href");;//("team-rank tone");
					System.out.println(teamCh);
				}
			}
		}	
	}
	catch(Exception e) {
		e.printStackTrace();
	}*/
}
