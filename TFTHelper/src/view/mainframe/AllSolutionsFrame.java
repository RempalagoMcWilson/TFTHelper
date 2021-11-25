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
	
	public AllSolutionsFrame(Object[] objects) {
		iniGUI(objects);
	}

	private void iniGUI(Object[] objects) {
		sPA = new ArrayList<SolucionPanelDetallado>();
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(700,400));
		setLayout (new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		for(Object s : objects) {
			SolucionPanelDetallado aux = new SolucionPanelDetallado((Solution)s);
			sPA.add(aux);
			add(aux);
		}
		this.setVisible(true);
		setLocationRelativeTo(null);
		
	}
	
	

}
