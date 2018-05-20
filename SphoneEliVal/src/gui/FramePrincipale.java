package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fonctions.ColorManager;

/*
 * Architecture principale du projet, mère de toutes les frames appelées.
 */

@SuppressWarnings("serial")
public abstract class FramePrincipale extends JFrame {

	// Création des panels

	private JPanel panelNorth = new JPanel();
	private JPanel panelSouth = new JPanel();
	private JPanel panelEast = new JPanel();
	private JPanel panelWest = new JPanel();

	// couleur du smartphone
	private Color bord = ColorManager.getNewColor();

	// création des boutons
	private JButton boutonMenu = new JButton();
	private JButton boutonExit = new JButton();

	// création du label des services
	private JPanel panelService = new JPanel();
	private JLabel labelHeure = new JLabel();
	private SimpleDateFormat heure;
	private JLabel labelDate = new JLabel();
	private SimpleDateFormat date;

	// création du label du titre du SmartPhone
	private JLabel labelTitre = new JLabel();

	// constructeur de la Frame modèle

	public FramePrincipale() {

		// base du smartphone
		this.setTitle("Smartphone");
		this.setSize(420, 798);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setLayout(null);
		this.setVisible(true);

		// Ajout de des panels

		this.add(panelNorth, BorderLayout.NORTH);
		panelNorth.setBackground(bord);
		panelNorth.setLayout(null);
		panelNorth.setBounds(0, 0, 420, 105);

		this.add(panelEast, BorderLayout.EAST);
		panelEast.setBackground(bord);
		panelEast.setBounds(399, 105, 21, 609);

		this.add(panelWest, BorderLayout.WEST);
		panelWest.setBackground(bord);
		panelWest.setBounds(0, 105, 21, 609);

		this.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setBackground(bord);
		panelSouth.setLayout(null);
		panelSouth.setBounds(0, 714, 420, 84);

		// Ajout des boutons du Smartphones dans les panels appropriés, voir détails des
		// fonctions dans FrameAccueil

		// adapte l'image à la couleur du smartphone (variable bord)
		if (bord.equals(Color.BLACK)||bord.equals(Color.blue)||bord.equals(Color.DARK_GRAY)) {
			boutonExit.setIcon(new ImageIcon("./icon/powerW.png"));
			boutonMenu.setIcon(new ImageIcon("./icon/homeW.png"));
		} else {
			boutonExit.setIcon(new ImageIcon("./icon/power.png"));
			boutonMenu.setIcon(new ImageIcon("./icon/home.png"));
		}

		panelNorth.add(boutonExit);
		boutonExit.setBounds(365, 10, 34, 34);
		boutonExit.setContentAreaFilled(false);
		boutonExit.setBorderPainted(false);

		boutonExit.addActionListener(new TraitementExit());

		panelSouth.add(boutonMenu);
		boutonMenu.setBounds(panelSouth.getWidth() / 2 - 17, panelSouth.getHeight() / 2 - 17, 34, 34);
		boutonMenu.setContentAreaFilled(false);
		boutonMenu.setBorderPainted(false);

		boutonMenu.addActionListener(new TraitementMenu());

		// ajout du titre du smartphone
		panelNorth.add(labelTitre);
		labelTitre.setText("EliVal");
		labelTitre.setFont(new Font("helvetica", Font.BOLD, 25));
		labelTitre.setBounds(180, 20, 400, 30);

		// ajout du panel de service dans panelnorth,
		panelNorth.add(panelService);
		panelService.setBounds(21, 80, 378, 25);
		panelService.setBackground(Color.GRAY);

		// avec Jlabel date et JLabel heure ( si possible batterie, etc. )
		date = new SimpleDateFormat("dd MMMM YYYY");
		panelService.add(labelDate);
		labelDate.setText(date.format(new Date()));
		labelDate.setFont(new Font("helvetica", Font.BOLD, 12));

		heure = new SimpleDateFormat("HH:mm");
		panelService.add(labelHeure);
		labelHeure.setText(heure.format(new Date()));
		labelHeure.setFont(new Font("helvetica", Font.BOLD, 12));

	}
	
//	public Color getBord() {
//		return bord;
//	}
//
//	public static void setBord() {
//		bord =  ColorManager.getNewColor();
//	}
//
//	

	public class TraitementExit implements ActionListener {
		/**
		 * comportement de base du bouton exit possibilité de donner le choix ( Exit,
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

}
