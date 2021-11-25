package view.mainframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import controller.Controller;
import model.Summoner;
import model.solution.Solution;
import view.mainframe.panels.SolucionPanel;
import view.mainframe.panels.SummonerPanel;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private SolucionPanel sP;
	private ArrayList<SummonerPanel> lSP;
	private JButton abrirTodasSoluciones;
	private Controller ctrl;
	
	public MainFrame(Solution s, ArrayList<Summoner> summonersList, Controller ctrl) {
		this.ctrl = ctrl;
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
		abrirTodasSoluciones = new JButton();
		
		abrirTodasSolucionesListener();
		abrirTodasSoluciones.setText("SEE ALL SOLUTIONS");
		JTabbedPane tabbedPane = new JTabbedPane();
		for(Summoner su : summonersList) {
			SummonerPanel aux = new SummonerPanel(su);
			lSP.add(aux);
			tabbedPane.addTab(su.getName(), aux);
		}
		
		this.add(sP,BorderLayout.NORTH);
		add(abrirTodasSoluciones, BorderLayout.CENTER);
		this.add(tabbedPane,BorderLayout.SOUTH);
		this.setVisible(true);
		
	}
	
	private void abrirTodasSolucionesListener() {
		abrirTodasSoluciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	new AllSolutionsFrame(ctrl.getSolutionsPQ());
            }
        });
	}
}
