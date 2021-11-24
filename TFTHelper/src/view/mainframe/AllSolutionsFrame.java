package view.mainframe;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import model.solution.Solution;
import view.mainframe.panels.SolucionPanelDetallado;

public class AllSolutionsFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private ArrayList<SolucionPanelDetallado> sPA;
	
	public AllSolutionsFrame(ArrayList<Solution> solutionsList) {
		iniGUI(solutionsList);
	}

	private void iniGUI(ArrayList<Solution> solutionsList) {
		sPA = new ArrayList<SolucionPanelDetallado>();
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(700,400));
		setLayout (new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		for(Solution s : solutionsList) {
			SolucionPanelDetallado aux = new SolucionPanelDetallado(s);
			sPA.add(aux);
			add(aux);
		}
		
		this.setVisible(true);
		setLocationRelativeTo(null);
		
	}
	
	

}
