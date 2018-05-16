package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		fondEcran.setBounds(21, 105, 378, 609);

		// ajout des boutons d'appli en transparance
		/*
		 * Pour chaque bouton : fondEcran.add(bouton); // ajout au panel
		 * bouton.setBounds(0, 60, 143, 100); // positionnement
		 * bouton.setContentAreaFilled(false) et bouton.setBorderPainted(false); // rendre fond transparent bouton.setText("Galerie") et
		 * bouton.setForeground(Color.BLACK); // nom de l'application
		 * bouton.setVerticalTextPosition(SwingConstants.BOTTOM) et bouton.setHorizontalTextPosition(SwingConstants.CENTER); // position du texte
		 * bouton.addActionListener(new TraitementGallerie()); // si existant : lancement de l'application
		 */
		fondEcran.add(images);
		images.setBounds(0, 60, fondEcran.getWidth()/3, 100);
		images.setContentAreaFilled(false);
		images.setBorderPainted(false);
		images.setText("Galerie");
		images.setForeground(Color.BLACK);
		images.setVerticalTextPosition(SwingConstants.BOTTOM);
		images.setHorizontalTextPosition(SwingConstants.CENTER);
		images.addActionListener(new TraitementGallerie());

		fondEcran.add(contacts);
		contacts.setBounds(fondEcran.getWidth()/3, 60, fondEcran.getWidth()/3, 100);
		contacts.setContentAreaFilled(false);
		contacts.setBorderPainted(false);
		contacts.setText("Contacts");
		contacts.setForeground(Color.BLACK);
		contacts.setVerticalTextPosition(SwingConstants.BOTTOM);
		contacts.setHorizontalTextPosition(SwingConstants.CENTER);

		fondEcran.add(settings);
		settings.setBounds(fondEcran.getWidth()/3*2, 60, fondEcran.getWidth()/3, 100);
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);
		settings.setText("Paramètres");
		settings.setForeground(Color.BLACK);
		settings.setVerticalTextPosition(SwingConstants.BOTTOM);
		settings.setHorizontalTextPosition(SwingConstants.CENTER);

		fondEcran.add(sons);
		sons.setBounds(0, 200, fondEcran.getWidth()/3, 100);
		sons.setContentAreaFilled(false);
		sons.setBorderPainted(false);
		sons.setText("Playlist");
		sons.setForeground(Color.BLACK);
		sons.setVerticalTextPosition(SwingConstants.BOTTOM);
		sons.setHorizontalTextPosition(SwingConstants.CENTER);

		fondEcran.add(game);
		game.setBounds(fondEcran.getWidth()/3, 200, fondEcran.getWidth()/3, 100);
		game.setContentAreaFilled(false);
		game.setBorderPainted(false);
		game.setText("Game");
		game.setForeground(Color.BLACK);
		game.setVerticalTextPosition(SwingConstants.BOTTOM);
		game.setHorizontalTextPosition(SwingConstants.CENTER);

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
