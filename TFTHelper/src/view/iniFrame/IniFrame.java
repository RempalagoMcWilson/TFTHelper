package view.iniFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import controller.Controller;

public class IniFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton okB;
	private JTextArea summonersTA;
	private JLabel infoLabel;
	private Controller ctrl;

	public IniFrame(Controller ctrl) {
		this.ctrl = ctrl;
		iniGUI();
	}
	
	private void iniGUI() {
		setSize(new Dimension(500,300));
		setLayout (new BorderLayout());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		okB = new JButton();
		okB.setText("OK");
		okBListener();
		summonersTA = new JTextArea();
		infoLabel = new JLabel();
		infoLabel.setText("Introduzca los nombres de los 7 rivales separados por comas.");
		add(infoLabel,BorderLayout.NORTH);
		add(okB, BorderLayout.PAGE_END);
		add(summonersTA, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	
	private void okBListener() {
        okB.addActionListener(new ActionListener() {//Paco,lucia,mario,fRanCisco34,juanma,marcelo,Pepe
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	ArrayList<String> nombresSummoners = new ArrayList<String>();
            	String nombres = summonersTA.getText();
            	int puntUltPos = 0;
            	for(int i = 0; i < nombres.length(); i++) {
            		if(nombres.charAt(i) == ',') {
            			nombresSummoners.add(nombres.substring(puntUltPos, i));
            			puntUltPos = i+1;
            		}
            		else if(i == nombres.length() - 1) {
            			nombresSummoners.add(nombres.substring(puntUltPos, i+1));
            		}
            	}
            	/*if(nombresSummoners.size() != 7) {
            		JOptionPane.showMessageDialog(null, "El numero de rivales debe de ser 7", "Error message", JOptionPane.ERROR_MESSAGE);
            	}*/
            	ctrl.meteSummoners(nombresSummoners);
            }
        });
	}
}
