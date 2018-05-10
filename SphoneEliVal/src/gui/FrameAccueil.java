package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameAccueil extends FramePrincipale {

	// choix d'image pour le fond d'écran (panelCenter)
	private JLabel fondEcran = new JLabel(new ImageIcon("./Gallerie/fndEcran1.jpg"));

	// création des boutons d'application
	private JButton images = new JButton(new ImageIcon("./icon/photos.png"));
	private JButton contacts = new JButton(new ImageIcon("./icon/contacts.png"));
	private JButton settings = new JButton(new ImageIcon("./icon/settings.png"));
	private JButton sons = new JButton(new ImageIcon("./icon/sons.png"));
	private JButton game = new JButton(new ImageIcon("./icon/game.png"));

	public FrameAccueil() {

		// création du panel central (écran)
		this.add(fondEcran, BorderLayout.CENTER);
		fondEcran.setLayout(null);
		fondEcran.setBounds(20, 40, 440, 700);

		// ajout des boutons d'appli en transparance
		fondEcran.add(images);
		images.setBounds(0, 60, 143, 100);
		images.setOpaque(false);
		images.setContentAreaFilled(false);
		images.setBorderPainted(false);
		
		images.addActionListener(new TraitementGallerie());

		fondEcran.add(contacts);
		contacts.setBounds(143, 60, 142, 100);
		contacts.setOpaque(true);
		contacts.setContentAreaFilled(false);
		contacts.setBorderPainted(false);

		fondEcran.add(settings);
		settings.setBounds(285, 60, 143, 100);
		settings.setOpaque(true);
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);
		
		fondEcran.add(sons);
		sons.setBounds(0, 200, 143, 100);
		sons.setOpaque(true);
		sons.setContentAreaFilled(false);
		sons.setBorderPainted(false);

		fondEcran.add(game);
		game.setBounds(143, 200, 143, 100);
		game.setOpaque(true);
		game.setContentAreaFilled(false);
		game.setBorderPainted(false);


	}
	
	public class TraitementGallerie implements ActionListener {
		/**
		 * comportement du bouton gallerie, 
		 */
		public void actionPerformed(ActionEvent e) {

			JFrame gallerie = new FrameGallerie();
			gallerie.setVisible(true);

			dispose();
		}
	}

}
