package view.mainframe;

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
	
	public UnitIcon(String character_id) {
		this.character_id = character_id;
		iniGUI();
	}
	private void iniGUI() {
		this.setMaximumSize(new Dimension(49, 49));
		this.setLayout(null);
		ImageIcon img = null;
        Image image = null;
        try {
            BufferedImage myPicture = ImageIO.read(new File("resources/unitIcon/"+ character_id + ".png"));
            image = myPicture;
            img = new ImageIcon(image.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
            icon = new JLabel(img);
            icon.setBounds(2, 2, 45, 45);
            add(icon);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}
}
