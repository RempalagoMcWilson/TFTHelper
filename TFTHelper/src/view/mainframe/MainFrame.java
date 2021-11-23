package view.mainframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import model.Summoner;
import model.solution.Solution;
import view.mainframe.panels.SolucionPanel;
import view.mainframe.panels.SummonerPanel;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private SolucionPanel sP;
	private ArrayList<SummonerPanel> lSP;
	
	public MainFrame(Solution s, ArrayList<Summoner> summonersList) {
		iniGUI(s,summonersList);
	}
	
	private void iniGUI(Solution s, ArrayList<Summoner> summonersList) {
		lSP = new ArrayList<SummonerPanel>();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(700,300));
		setLayout (new BorderLayout());
		//this.setResizable(false);
		this.setLocationRelativeTo(null);
		sP = new SolucionPanel(s);
		JTabbedPane tabbedPane = new JTabbedPane();
		for(Summoner su : summonersList) {
			SummonerPanel aux = new SummonerPanel(su);
			lSP.add(aux);
			tabbedPane.addTab(su.getName(), aux);
		}
		
		this.add(sP,BorderLayout.NORTH);
		this.add(tabbedPane,BorderLayout.CENTER);
		this.setVisible(true);
		
	}
}
