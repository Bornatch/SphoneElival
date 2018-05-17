package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fonctions.ColorComboRenderer;

@SuppressWarnings("serial")
public class FrameSettings extends FramePrincipale {

	// création du panel
	private JPanel panelCenter = new JPanel();

	// Contenu du panel
	private JLabel general = new JLabel("Général");
	private JLabel smartphoneColor = new JLabel("Couleur du smartphone");

	private Color[] colorList = { Color.BLACK, Color.blue, Color.CYAN, Color.DARK_GRAY, Color.LIGHT_GRAY, Color.GREEN,
			Color.WHITE, Color.YELLOW };
	private JComboBox<Color> couleurs = new JComboBox<Color>(colorList);
	
	
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
		general.setBounds(0, 20, 378, 40);

		panelCenter.add(smartphoneColor);
		smartphoneColor.setFont(ssTitre);
		smartphoneColor.setBounds(0, 60, 180, 30);

		panelCenter.add(couleurs);
		couleurs.setFont(texte);
		couleurs.setRenderer(new ColorComboRenderer());
		couleurs.addActionListener(new TraitementCouleur());
		couleurs.setBounds(180, 60, 198, 30);

	}

	public class TraitementCouleur implements ActionListener {

		/**
		 * comportement de la combobox couleurs
		 * actuellement change le background du panel ...
		 */
		@SuppressWarnings("rawtypes")
		public void actionPerformed(ActionEvent e) {
			
			JComboBox cb = (JComboBox)e.getSource();
		     
            // Get the new item
            Object newItem = cb.getSelectedItem();
     

     
            if ("comboBoxEdited".equals(e.getActionCommand())) {
                panelCenter.setBackground((Color)newItem);
            } else if ("comboBoxChanged".equals(e.getActionCommand())) {
            	 panelCenter.setBackground((Color)newItem);
            }
			
			

		}

	}

}
