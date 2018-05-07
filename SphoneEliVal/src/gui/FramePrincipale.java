package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramePrincipale extends JFrame {

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
		panelNorth.add(boutonExit);

		this.add(panelEast, BorderLayout.EAST);
		panelEast.setBackground(Color.BLACK);
		panelEast.setBounds(460, 40, 20, 700);

		this.add(panelWest, BorderLayout.WEST);
		panelWest.setBackground(Color.BLACK);
		panelWest.setBounds(0, 40, 20, 700);

		this.add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setBackground(Color.BLACK);
		panelSouth.setBounds(0, 740, 480, 60);
		panelSouth.add(boutonMenu);

		// Ajout des boutons du Smartphones
		// ExitButton bt = new ExitButton();
		// this.add(bt);

		// MenuButton mb = new MenuButton();
		// this.add(mb);

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

	public JButton getBoutonMenu() {
		return boutonMenu;
	}

	public void setBoutonMenu(JButton boutonMenu) {
		this.boutonMenu = boutonMenu;
	}

	public JButton getBoutonExit() {
		return boutonExit;
	}

	public void setBoutonExit(JButton boutonExit) {
		this.boutonExit = boutonExit;
	}

	// public SimpleDateFormat getHeure() {
	// return heure;
	// }
	//
	// public void setHeure(SimpleDateFormat heure) {
	// this.heure = heure;
	// }

}
