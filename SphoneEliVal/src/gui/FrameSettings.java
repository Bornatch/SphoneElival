package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameSettings extends FramePrincipale {

	// création du panel
	private JPanel panelCenter = new JPanel();
	
	
	private JLabel general = new JLabel("Général");
	private JLabel smartphoneColor = new JLabel("Couleur du smartphone");
	private JComboBox<Color> couleurs = new JComboBox<Color>();

	public FrameSettings() {
		
		
		
		this.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBackground(Color.gray);
		panelCenter.setLayout(null);
		panelCenter.setBounds(21, 105, 378, 609);
		
		Font titre = new Font("helvetica", Font.BOLD, 25);
		Font ssTitre= new Font("helvetica",Font.BOLD,15);
		Font texte = new Font("helvetica",Font.BOLD,12);
		
		panelCenter.add(general);
		general.setFont(titre);
		general.setBackground(Color.DARK_GRAY);
		general.setBounds(0, 20, 378, 40);
		
		panelCenter.add(smartphoneColor);
		smartphoneColor.setFont(ssTitre);
		smartphoneColor.setBounds(0, 50, 200, 30);
		
		panelCenter.add(couleurs);
		couleurs.setFont(texte);
		smartphoneColor.setBounds(200, 50, 178, 30);

	}

}
