package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fonctions.ColorComboRenderer;
import fonctions.ColorManager;

@SuppressWarnings("serial")
public class FrameSettings extends FramePrincipale {

	// création du panel
	private JPanel panelCenter = new JPanel();

	// Les Labels de texte
	private JLabel general = new JLabel("Général");
	private JLabel smartphoneColor = new JLabel("<html>Couleur du <br> smartphone<html>");

	//la combobox de choix de couleurs
	private Color[] colorList = { Color.BLACK, Color.blue, Color.CYAN, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.GREEN,
			Color.WHITE, Color.YELLOW };
	private JComboBox<Color> couleurs = new JComboBox<Color>(colorList);

	//bouton de validation
	private JButton valide = new JButton("Valider");

	// Déclaration des polices
	Font titre = new Font("helvetica", Font.BOLD, 25);
	Font ssTitre = new Font("helvetica", Font.BOLD, 15);
	Font texte = new Font("helvetica", Font.BOLD, 12);

	@SuppressWarnings("unchecked")
	public FrameSettings() {

		// Ajout du panel dans ma frame
		this.add(panelCenter, BorderLayout.CENTER);
		// panelCenter.setBackground(Color.gray);
		panelCenter.setLayout(null);
		panelCenter.setBounds(21, 105, 378, 609);

		// ajout du titre

		panelCenter.add(general);
		general.setFont(titre);
		general.setBackground(Color.DARK_GRAY);
		general.setBounds(20, 20, 378, 40);

		// Ajout du label de choix
		panelCenter.add(smartphoneColor);
		smartphoneColor.setFont(ssTitre);
		smartphoneColor.setBounds(20, 70, 180, 50);

		// Ajout du combobox des couleurs
		panelCenter.add(couleurs);
		couleurs.setFont(texte);
		couleurs.setRenderer(new ColorComboRenderer());
		couleurs.addActionListener(new TraitementCouleur());
		couleurs.setBounds(180, 70, 178, 50);

		// Ajout du bouton de validation
		panelCenter.add(valide);
		valide.setFont(texte);
		valide.setBounds(150, 140, 78, 20);

		valide.addActionListener(new TraitementSettings());

	}

	public class TraitementCouleur implements ActionListener {

		/**
		 * comportement de la combobox couleurs actuellement change le background du
		 * panel ...
		 */
		@SuppressWarnings("rawtypes")
		public void actionPerformed(ActionEvent e) {

			JComboBox cb = (JComboBox) e.getSource();

			// Get the new item
			Object newItem = cb.getSelectedItem();

			if ("comboBoxEdited".equals(e.getActionCommand())) {
				// panelCenter.setBackground((Color) newItem);

			} else if ("comboBoxChanged".equals(e.getActionCommand())) {
				//panelCenter.setBackground((Color) newItem);
				ColorManager.stockColor((Color) newItem);
				ColorManager.destockColor();

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
