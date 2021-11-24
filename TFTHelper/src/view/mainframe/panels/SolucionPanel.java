package view.mainframe.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.solution.Solution;
import view.mainframe.UnitIcon;

public class SolucionPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel infoLabel;
	private JLabel nombreLabel;
	private JPanel panelIconos;
	private JPanel panelLabels;
	private ArrayList<UnitIcon> iconos;
	
	public SolucionPanel(Solution s) {
		iniGUI(s);
	}
	
	private void iniGUI(Solution s) {
		iconos = new ArrayList<UnitIcon>();
		this.setLayout(new BorderLayout());
		infoLabel = new JLabel();
		nombreLabel = new JLabel();
		infoLabel.setText(" In this match you should play ");
		
		nombreLabel.setText(" " + s.getName());
		nombreLabel.setFont(new Font("",Font.BOLD, 20));
		panelIconos =new JPanel();
		panelLabels = new JPanel();
		panelLabels.setLayout(new BorderLayout());
		panelIconos.setLayout(new GridLayout (1,8));
		for(String nIconos : s.getUnits()) {
			iconos.add(new UnitIcon(nIconos,false));
		}
		for(UnitIcon nI :iconos) {
			panelIconos.add(nI);
		}
		
		panelLabels.add(infoLabel,BorderLayout.NORTH);
		panelLabels.add(nombreLabel,BorderLayout.CENTER);
		add(panelLabels,BorderLayout.WEST);
		
		add(panelIconos,BorderLayout.EAST);
		this.setVisible(true);
	}
}
