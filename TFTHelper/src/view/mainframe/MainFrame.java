package view.mainframe;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.solution.Solution;
import view.mainframe.panels.SolucionPanel;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	//private JScrollPane scrollGeneral;
	private SolucionPanel sP;
	
	public MainFrame(Solution s) {
		iniGUI(s);
	}
	
	private void iniGUI(Solution s) {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setSize(new Dimension(1000,500));
		setLayout (new BorderLayout());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		//scrollGeneral = new JScrollPane();
		//scrollGeneral.setVisible(true);
		//scrollGeneral.setMinimumSize(new Dimension(600,500));
		sP = new SolucionPanel(s);
		//scrollGeneral.add(sP);
		this.add(sP);
		this.setVisible(true);
		
	}
}
