package view.mainframe.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.solution.Solution;
import view.mainframe.UnitIcon;

public class SolucionPanelDetallado extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel infoLabel;
	private JLabel nombreLabel;
	private JPanel panelIconos;
	private JPanel panelLabels;
	private ArrayList<UnitIcon> iconos;
	
	public SolucionPanelDetallado(Solution s) {
		iniGUI(s);
	}
	
	private void iniGUI(Solution s) {
		iconos = new ArrayList<UnitIcon>();
		this.setLayout(new BorderLayout());
		infoLabel = new JLabel();
		nombreLabel = new JLabel();
		meteTextoInfoLabel(s);
		
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
		
		panelLabels.add(infoLabel,BorderLayout.SOUTH);
		panelLabels.add(nombreLabel,BorderLayout.CENTER);
		add(panelLabels,BorderLayout.WEST);
		
		add(panelIconos,BorderLayout.EAST);
		this.setVisible(true);
	}
	private void meteTextoInfoLabel(Solution s) {
		if(s.getNumCoin() < 5) {
			infoLabel.setText(" MUY BUENO ");
			infoLabel.setForeground(new Color(4, 194, 55));
		}
		else if(s.getNumCoin() < 10) {
			infoLabel.setText(" BUENO ");
			infoLabel.setForeground(new Color(245, 241, 34));
		}
		else if(s.getNumCoin() < 15) {
			infoLabel.setText(" MEDIO ");
			infoLabel.setForeground(new Color(255, 145, 0));
		}
		else {
			infoLabel.setText(" MALO ");
			infoLabel.setForeground(new Color(255, 42, 0));
		}
		
	}

}
