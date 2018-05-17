package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import BDContacts.Contacts;

@SuppressWarnings("serial")
public class FrameContacts extends FramePrincipale {

	// création du panel
	private JPanel panelCenter = new JPanel();

	// liste de contact
	List<Contacts> contactsList = new ArrayList<Contacts>();

	// Titre
	private JLabel titreLabel = new JLabel("Vos contacts");

	// Déclaration des polices
	Font titre = new Font("helvetica", Font.BOLD, 25);
	Font ssTitre = new Font("helvetica", Font.BOLD, 15);
	Font texte = new Font("helvetica", Font.BOLD, 12);

	public FrameContacts() {

		// ajout du titre
		this.add(titreLabel);
		titreLabel.setFont(titre);
		titreLabel.setBackground(Color.DARK_GRAY);
		titreLabel.setBounds(21, 105, 378, 40);

		// ajout de panel de présentation des contacts

		panelCenter.setBackground(Color.gray);
		panelCenter.setLayout(new GridLayout(0, 1, 10, 10));
		panelCenter.setBounds(21, 145, 378, 570);

		JScrollPane scrollPane = new JScrollPane(panelCenter);
		this.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBounds(21, 145, 378, 570);
		
		

	}

}
