package view.mainframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UnitIcon extends JPanel{

	private static final long serialVersionUID = 1L;
	private String character_id;
	private JLabel icon;
	
	public UnitIcon(String character_id,boolean jugador) {
		this.character_id = character_id;
		iniGUI(jugador);
	}
	private void iniGUI(boolean jugador) {
		if(jugador)
			setMinimumSize(new Dimension(59, 59));
		else
			this.setMinimumSize(new Dimension(49, 49));
		ImageIcon img = null;
        Image image = null;
        try {
            BufferedImage myPicture = ImageIO.read(new File("resources/unitIcon/"+ character_id + ".png"));
            image = myPicture;
            if(jugador)
            	img = new ImageIcon(image.getScaledInstance(55, 55, Image.SCALE_SMOOTH));
    		else
    			img = new ImageIcon(image.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            
            icon = new JLabel(img);
            if(jugador)
            	icon.setMinimumSize(new Dimension(55, 55));
    		else
    			icon.setMinimumSize(new Dimension(45, 45));
            
            add(icon, BorderLayout.CENTER);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " " + character_id);
        }
        this.setToolTipText(character_id);
	}
}
