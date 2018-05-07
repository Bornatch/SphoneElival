package gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FrameAccueil extends FramePrincipale {
	
	//choix d'image pour le fond d'�cran (panelCenter)
	private JLabel fondEcran = new JLabel(new ImageIcon("./Gallerie/fndEcran1.jpg"));
	
	//cr�ation des boutons d'application
	private JButton images = new JButton(new ImageIcon("./icon/photos.jpg"));
	private JButton contacts = new JButton(new ImageIcon("./icon/contacts.jpg"));
	private JButton settings = new JButton(new ImageIcon("./icon/settings.jpg"));
	
	
	public FrameAccueil() {
		
		//cr�ation du panel central (�cran)
		this.add(fondEcran, BorderLayout.CENTER);
		fondEcran.setLayout(null);
		fondEcran.setBounds(20, 40, 440, 700);
		
		//ajout des boutons
		
		
		
		
	}

}
