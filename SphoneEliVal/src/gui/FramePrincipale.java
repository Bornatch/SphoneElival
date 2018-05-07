package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class FramePrincipale extends JFrame {

	private JPanel panelNorth = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JPanel panelEast = new JPanel();
	private JPanel panelWest = new JPanel();

	// private JLabel afficheHeure = new JLabel();

	private JButton boutonMenu = new JButton("");
	private JButton boutonExit = new JButton("");

	// private SimpleDateFormat heure;

	public FramePrincipale() {

		// base du smartphone
		this.setTitle("Smartphone");
		this.setSize(480, 800);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setLayout(null);

		// Ajout de des panels

		this.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setBackground(Color.BLACK);
		panelNorth.setBounds(0, 0, 480, 40);

		this.add(panelEast, BorderLayout.EAST);
		panelEast.setBackground(Color.BLACK);
		panelEast.setBounds(460, 40, 20, 700);

		this.add(panelWest, BorderLayout.WEST);
		panelWest.setBackground(Color.BLACK);
		panelWest.setBounds(0, 40, 20, 700);

		this.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setBackground(Color.BLACK);
		panelSouth.setBounds(0, 740, 480, 60);

		// Ajout des boutons du Smartphones

		boutonExit.addActionListener(new TraitementExit());
		panelNorth.add(boutonExit);

		boutonMenu.addActionListener(new TraitementMenu());
		panelSouth.add(boutonMenu);

		// fin de smartphone
		this.setLayout(null);
		this.setVisible(true);

	}

	// public JLabel getAfficheHeure() {
	// return afficheHeure;
	// }
	//
	// public void setAfficheHeure(JLabel afficheHeure) {
	// this.afficheHeure = afficheHeure;
	// }

	public class TraitementExit implements ActionListener {
		/**
		 * comportement de base du bouton exit posssibilité de donner le choix ( Exit,
		 * Veille, Redémarrer) redémarrage avec Runtime.getRuntime().exec("java -jar
		 * MonProg.jar");
		 */
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	public class TraitementMenu implements ActionListener {
		/**
		 * comportement du bouton menu, instancie une nouvelle frame acceuil et ferme la
		 * fenêtre actuelle possibilité : rendre la calsse abstraite et ajouter si
		 * besoin un confirmation de retour (pour sauvegarde ou autre )
		 */
		public void actionPerformed(ActionEvent e) {

			JFrame accueil = new FrameAccueil();
			accueil.setVisible(true);

			dispose();
		}
	}

	// public SimpleDateFormat getHeure() {
	// return heure;
	// }
	//
	// public void setHeure(SimpleDateFormat heure) {
	// this.heure = heure;
	// }

}
