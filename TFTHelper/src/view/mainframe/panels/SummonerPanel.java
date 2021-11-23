package view.mainframe.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Summoner;
import view.mainframe.UnitIcon;

public class SummonerPanel extends JPanel{

	private JLabel nombreLabel;
	private JLabel summonerLevelLabel;
	private JLabel avgGold_leftLabel;
	private JLabel avgLast_roundLabel;
	private JLabel avgLevelLabel;
	private JLabel avgPlacementLabel;
	private JLabel avgPlayers_eliminatedLabel;
	private JLabel avgTotal_damage_to_playersLabel;
	private ArrayList<UnitIcon> iconos;
	
	private JPanel iconosPanel;
	private JPanel infoPanel;
	private JPanel nombrePanel;
	
	public SummonerPanel(Summoner s) {
		
		iniGUI(s);
	}
	
	private void iniGUI(Summoner s) {
		iconos = new ArrayList<UnitIcon>();
		setLayout(new BorderLayout());
		
		nombreLabel = new JLabel();
		summonerLevelLabel = new JLabel();
		avgGold_leftLabel = new JLabel();
		avgLast_roundLabel = new JLabel();
		avgLevelLabel = new JLabel();
		avgPlacementLabel = new JLabel();
		avgPlayers_eliminatedLabel = new JLabel();
		avgTotal_damage_to_playersLabel = new JLabel();
		
		nombreLabel.setText(s.getName());
		nombreLabel.setFont(new Font("",Font.BOLD, 15));
		summonerLevelLabel.setText(" lvl " + s.getSummonerLevel());
		
		avgGold_leftLabel.setText("Average gold left after participant was eliminated: " + s.getSA().getAvgGold_left());
		avgLast_roundLabel.setText("Average round the participant was eliminated in: " + s.getSA().getAvgLast_round());
		avgLevelLabel.setText("Average Little Legend level: " + s.getSA().getAvgLevel());
		avgPlacementLabel.setText("Average placement upon elimination: " + s.getSA().getAvgPlacement());
		avgPlayers_eliminatedLabel.setText("Average number of players the participant eliminated: " + s.getSA().getAvgPlayers_eliminated());
		avgTotal_damage_to_playersLabel.setText("Average damage the participant dealt to other players: " + s.getSA().getAvgTotal_damage_to_players());
		
		iconosPanel = new JPanel();
		infoPanel = new JPanel();
		nombrePanel = new JPanel();
		
		infoPanel.setLayout(new GridLayout (3,2));
		nombrePanel.setLayout(new FlowLayout());
		iconosPanel.setLayout(new GridLayout (1,8));
		
		nombrePanel.add(nombreLabel);
		nombrePanel.add(summonerLevelLabel);
		
		infoPanel.add(avgGold_leftLabel);
		infoPanel.add(avgLast_roundLabel);
		infoPanel.add(avgLevelLabel);
		infoPanel.add(avgPlacementLabel);
		infoPanel.add(avgPlayers_eliminatedLabel);
		infoPanel.add(avgTotal_damage_to_playersLabel);
		
		for(String nIconos : s.getSA().getAvgUnitList()) {
			iconos.add(new UnitIcon(nIconos,true));
		}
		for(UnitIcon nI :iconos) {
			iconosPanel.add(nI);
		}
		
		add(nombrePanel, BorderLayout.PAGE_START);
		add(iconosPanel, BorderLayout.CENTER);
		add(infoPanel, BorderLayout.PAGE_END);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
