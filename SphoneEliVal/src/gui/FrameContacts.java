
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import BDContacts.Contacts;
import gui.FrameAccueil.TraitementGallerie;

@SuppressWarnings("serial")
public class FrameContacts extends FramePrincipale {

	// création du panel
	private JPanel panelCenter = new JPanel();

	// liste de contact
	private List<Contacts> contactsList = new ArrayList<Contacts>();

	// Titre
	private JLabel titreLabel = new JLabel("Vos contacts");
	
	//bouton nouveau contact
	private JButton addContact = new JButton(new ImageIcon("./icon/addContact.png"));

	// Déclaration des polices
	Font titre = new Font("helvetica", Font.BOLD, 25);
	Font ssTitre = new Font("helvetica", Font.BOLD, 15);
	Font texte = new Font("helvetica", Font.BOLD, 12);

	public FrameContacts() throws IOException {

		// ajout du titre
		this.add(titreLabel);
		titreLabel.setFont(titre);
		titreLabel.setBackground(Color.DARK_GRAY);
		titreLabel.setBounds(21, 105, 278, 64);
		
		//Ajout du bouton nouveau contact
		this.add(addContact);
		addContact.setBounds(299, 105, 100, 100);
		addContact.setContentAreaFilled(false);
		addContact.setBorderPainted(false);
		addContact.setText("Ajouter");
		
		addContact.setVerticalTextPosition(SwingConstants.BOTTOM);
		addContact.setHorizontalTextPosition(SwingConstants.CENTER);
		
		addContact.addActionListener(new TraitementAddContact());

		// ajout de panel de présentation des contacts

		panelCenter.setBackground(Color.blue);
		panelCenter.setLayout(new GridLayout(0, 1, 10, 10));
		panelCenter.setBounds(21, 205, 378, 570);

		JScrollPane scrollPane = new JScrollPane(panelCenter);
		this.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBounds(21, 205, 378, 570);
		
		//Ajout des contacts
//	contactsList = Contacts.deserializeContacts();
		
//	for (Contacts contact : contactsList) {
//		panelCenter.add(new JLabel(contact.getNom()+" "+contact.getPrenom()));
//		System.out.println(contact.getNom()+" "+contact.getPrenom());
//		System.out.println("bonjour");
//		}
		
//	System.out.println("au Revoir");

	}
	
	public class TraitementAddContact implements ActionListener {
		/**
		 * comportement du bouton d'ajout de contact,
		 */
		public void actionPerformed(ActionEvent e) {

			JFrame addContact = new FrameAddContact();
			addContact.setVisible(true);
			
			

			dispose();
		}
	}

}

