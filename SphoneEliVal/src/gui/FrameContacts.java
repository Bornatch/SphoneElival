
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BDContacts.Contacts;
import gui.FrameGallerie.TraitementImage;

/**
 * Affichage de contacts et bouton d'ajout
 * @author Bornatch
 *
 */
@SuppressWarnings("serial")
public class FrameContacts extends FramePrincipale {

	// création du panel
	private JPanel panelCenter = new JPanel();
	private JScrollPane scrollPane;
	private JList jList;

	// liste de contact
	private List<Contacts> contactsList; 
	private List<String> contactsListToString = new ArrayList<String>();

	// liste de boutons adaptable selon nombre de photos
	List<JButton> miniatures = new ArrayList<JButton>();

	// Titre
	private JLabel titreLabel = new JLabel("Vos contacts");

	// bouton nouveau contact
	private JButton addContact = new JButton(new ImageIcon("./icon/addContact.png"));

	// Déclaration des polices
	Font titre = new Font("helvetica", Font.BOLD, 25);
	Font ssTitre = new Font("helvetica", Font.BOLD, 15);
	Font liste = new Font("helvetica", Font.BOLD, 20);

	public FrameContacts() throws IOException {
		
		// ajout du titre
		this.add(titreLabel);
		titreLabel.setFont(titre);
		titreLabel.setBackground(Color.DARK_GRAY);
		titreLabel.setBounds(51, 125, 278, 64);
		titreLabel.setBackground(super.getBackground());

		// Ajout du bouton nouveau contact
		this.add(addContact);
		addContact.setBounds(299, 105, 100, 100);
		addContact.setContentAreaFilled(false);
		addContact.setBorderPainted(false);
		addContact.setText("Ajouter");
		addContact.setVerticalTextPosition(SwingConstants.BOTTOM);
		addContact.setHorizontalTextPosition(SwingConstants.CENTER);

		addContact.addActionListener(new TraitementAddContact());

		// ajout de panel de présentation des contacts

		panelCenter.setBackground(super.getBackground());
		panelCenter.setLayout(new GridLayout(0, 1, 10, 10));
		panelCenter.setBounds(21, 205, 378, 570);

		// Création du contenu avec la JList
		contactsList = Contacts.deserializeContacts();

		for (Iterator iterator = contactsList.iterator(); iterator.hasNext();) {
			Contacts contacts = (Contacts) iterator.next();
			contactsListToString.add(contacts.ToString());
		}

		// Affichege de la jlist de contact
		jList = new JList(contactsListToString.toArray());
		jList.setBorder(new EmptyBorder(10, 10, 10, 10));
		jList.setFont(liste);
		//jList.setCellRenderer(new ContactListRenderer());
		panelCenter.add(jList);

		jList.addListSelectionListener(new TraitementList());

		// mise du panel dans un scrollPane
		scrollPane = new JScrollPane(panelCenter);
		this.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBounds(21, 205, 378, 570);

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

	public class TraitementList implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {

			// récupération de l'indice de la liste
			int index = e.getFirstIndex();
			JFrame displayContact = new FrameDispContact(index, contactsList);
			displayContact.setVisible(true);
			
			contactsList.remove(index);
          
		}

	}

}
