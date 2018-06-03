package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fonctions.ColorComboRenderer;
import fonctions.ColorManagerBord;
import fonctions.ColorManagerMenu;
import fonctions.ImgAccueilManager;
import fonctions.ImgComboRenderer;

@SuppressWarnings("serial")
public class FrameSettings extends FramePrincipale {

	// création du panel
	private JPanel panelCenter = new JPanel();

	// Les Labels de texte
	private JLabel general = new JLabel("Général");
	private JLabel bordLabel = new JLabel("<html>Couleur du <br> smartphone<html>");
	private JLabel menulabel = new JLabel("<html>Couleur des menus<br> du smartphone<html>");
	private JLabel imgFndLabel = new JLabel("<html>Fond d'écran<br> du smartphone<html>");

	// la combobox de choix de couleurs des bordures
	private Color[] colorList = { Color.BLACK, Color.blue, Color.CYAN, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.GREEN,
			Color.WHITE, Color.YELLOW };
	private JComboBox<Color> bordCombo = new JComboBox<Color>(colorList);

	// la combobox de choix de couleur du fond des menus
	private Color[] colorListMenu = { Color.BLACK, Color.blue, Color.CYAN, Color.DARK_GRAY, Color.LIGHT_GRAY,
			Color.pink, Color.WHITE, Color.orange };
	private JComboBox<Color> menuCombo = new JComboBox<Color>(colorListMenu);

	// la combobox de choix d'image du fond d'écran d'accueil
	private ImageIcon[] imgFndChoix = { new ImageIcon("./Gallerie/fndEcran1.jpg"), new ImageIcon("./Gallerie/img1.jpg"),
			new ImageIcon("./Gallerie/img2.jpg"), new ImageIcon("./Gallerie/img3.jpg"),
			new ImageIcon("./Gallerie/img4.jpg"), new ImageIcon("./Gallerie/img5.jpg") };
	private JComboBox<ImageIcon> imgFndCombo = new JComboBox<ImageIcon>(imgFndChoix);

	// boutons de validation
	private JButton valide = new JButton("Valider");

	// Déclaration des polices
	Font titre = new Font("helvetica", Font.BOLD, 25);
	Font ssTitre = new Font("helvetica", Font.BOLD, 15);
	Font texte = new Font("helvetica", Font.BOLD, 12);

	@SuppressWarnings("unchecked")
	public FrameSettings() {

		// Ajout du panel dans ma frame

		this.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(null);
		panelCenter.setBounds(21, 105, 378, 609);
		panelCenter.setBackground(super.getBackground());

		// ajout du titre
		panelCenter.add(general);
		general.setFont(titre);
		general.setBackground(Color.DARK_GRAY);
		general.setBounds(20, 20, 378, 40);

		// FOND ECRAN ACCUEIL
		// Ajout du label de choix de l'image
		panelCenter.add(imgFndLabel);
		imgFndLabel.setFont(ssTitre);
		imgFndLabel.setBounds(20, 70, 180, 50);

		// Ajout du combobox des couleurs d'image de fond d'écan
		panelCenter.add(imgFndCombo);
		imgFndCombo.setFont(texte);
		imgFndCombo.setRenderer(new ImgComboRenderer());
		imgFndCombo.addActionListener(new TraitementImageAccueil());
		imgFndCombo.setBounds(180, 70, 178, 50);

		// MENU BACKGROUND
		// Ajout du label de choix de couleur de backgroud
		panelCenter.add(menulabel);
		menulabel.setFont(ssTitre);
		menulabel.setBounds(20, 140, 180, 50);

		// Ajout du combobox des couleurs de bordure
		panelCenter.add(menuCombo);
		menuCombo.setFont(texte);
		menuCombo.setRenderer(new ColorComboRenderer());
		menuCombo.addActionListener(new TraitementCouleurMenu());
		menuCombo.setBounds(180, 140, 178, 50);

		// BORDURE
		// Ajout du label de choix de couleur des bordures
		panelCenter.add(bordLabel);
		bordLabel.setFont(ssTitre);
		bordLabel.setBounds(20, 210, 180, 50);

		// Ajout du combobox des couleurs de bordure
		panelCenter.add(bordCombo);
		bordCombo.setFont(texte);
		bordCombo.setRenderer(new ColorComboRenderer());
		bordCombo.addActionListener(new TraitementCouleur());
		bordCombo.setBounds(180, 210, 178, 50);

		// Ajout du bouton de validation
		panelCenter.add(valide);
		valide.setFont(texte);
		valide.setBounds(150, 280, 78, 20);

		valide.addActionListener(new TraitementSettings());

	}

	public class TraitementImageAccueil implements ActionListener {

		/**
		 * comportement de la combobox couleurs de background des menus
		 */
		@SuppressWarnings("rawtypes")
		public void actionPerformed(ActionEvent e) {

			JComboBox cb = (JComboBox) e.getSource();

			// Get the new item
			Object newItem = cb.getSelectedItem();

			if ("comboBoxEdited".equals(e.getActionCommand())) {
				// panelCenter.setBackground((Color) newItem);

			} else if ("comboBoxChanged".equals(e.getActionCommand())) {
				// panelCenter.setBackground((Color) newItem);
				ImgAccueilManager.stockImg((ImageIcon) newItem);
				ImgAccueilManager.destockImg();

			}

		}

	}

	public class TraitementCouleurMenu implements ActionListener {

		/**
		 * comportement de la combobox couleurs de background des menus
		 */
		@SuppressWarnings("rawtypes")
		public void actionPerformed(ActionEvent e) {

			JComboBox cb = (JComboBox) e.getSource();

			// Get the new item
			Object newItem = cb.getSelectedItem();

			if ("comboBoxEdited".equals(e.getActionCommand())) {
				// panelCenter.setBackground((Color) newItem);

			} else if ("comboBoxChanged".equals(e.getActionCommand())) {
				// panelCenter.setBackground((Color) newItem);
				ColorManagerMenu.stockColor((Color) newItem);
				ColorManagerMenu.destockColor();

			}

		}

	}

	public class TraitementCouleur implements ActionListener {

		/**
		 * comportement de la combobox couleurs des borduress
		 */
		@SuppressWarnings("rawtypes")
		public void actionPerformed(ActionEvent e) {

			JComboBox cb = (JComboBox) e.getSource();

			// Get the new item
			Object newItem = cb.getSelectedItem();

			if ("comboBoxEdited".equals(e.getActionCommand())) {
				// panelCenter.setBackground((Color) newItem);

			} else if ("comboBoxChanged".equals(e.getActionCommand())) {
				// panelCenter.setBackground((Color) newItem);
				ColorManagerBord.stockColor((Color) newItem);
				ColorManagerBord.destockColor();

			}

		}

	}

	public class TraitementSettings implements ActionListener {
		/**
		 * comportement du bouton gallerie,
		 */
		public void actionPerformed(ActionEvent e) {

			JFrame parametres = new FrameSettings();
			parametres.setVisible(true);

			dispose();
		}
	}

}
