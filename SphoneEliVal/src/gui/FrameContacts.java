
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BDContacts.Contacts;
import gui.FrameGallerie.TraitementImage;

@SuppressWarnings("serial")
public class FrameContacts extends FramePrincipale implements ListSelectionListener {

	// création du panel
	private JPanel panelCenter = new JPanel();
	private JScrollPane scrollPane;
	private JList jList = new JList();

	// liste de contact
	private List<Contacts> contactsList = new ArrayList<Contacts>();
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
	Font texte = new Font("helvetica", Font.BOLD, 12);

	public FrameContacts() throws IOException {

		// ajout du titre
		this.add(titreLabel);
		titreLabel.setFont(titre);
		titreLabel.setBackground(Color.DARK_GRAY);
		titreLabel.setBounds(21, 105, 278, 64);

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

		// panelCenter.setBackground(Color.blue);
		panelCenter.setLayout(new GridLayout(0, 1, 10, 10));
		panelCenter.setBounds(21, 205, 378, 570);

		scrollPane = new JScrollPane(panelCenter);
		this.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBounds(21, 205, 378, 570);
		
		
		
		
//		// Créer une liste des Imagesicon, le -1 retire le fichier thumbs
//				for (int i = 0; i < contactsList.size() ; i++) {
//					
//					//redimmensionnement de l'image
//					
//					//miniatures.add(new JButton(contactsList.get(i)));
//					
//					//ajout de chaque miniature
//					panelCenter.add(miniatures.get(i));			
//					miniatures.get(i).setPreferredSize(new Dimension(100, 100));
//					
//					//Ajout du numéro d'index pour gestion des events
//					miniatures.get(i).setName("" + i);
//					miniatures.get(i).addActionListener(new TraitementImage());
//
//				}

//		// Création des String de contacts pour la Jlist
//		try {
//			 contactsList = Contacts.deserializeContacts();
//			for (Iterator iterator = contactsList.iterator(); iterator.hasNext();) {
//				Contacts type = (Contacts) iterator.next();
//				contactsListToString.add(type.ToString());
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// Ajout des contacts dans la JList
//		jList = new JList( contactsListToString.toArray());
//		jList.setFont(ssTitre);
//		jList.(new TraitementList());
//		panelCenter.add(jList);
//		



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
	
	public class TraitementList implements ListSelectionListener{
		
		public void actionPerformed(ListSelectionEvent e) {
			System.out.println(e.getSource());
			System.out.println(e.getValueIsAdjusting());
			System.out.println(e.getFirstIndex());
			
		}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
	
	}

}
