package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import BDContacts.Contacts;

/**
 * Frame de modification des contacts, inspirée de FrameAddContact
 * 
 * @author Bornatch
 *
 */
@SuppressWarnings("serial")
public class FrameDispContact extends FramePrincipale {

	// création du panel
	private JPanel panelCenter = new JPanel();

	// les Labels d'en tête
	private JLabel imageLabel = new JLabel(new ImageIcon("./icon/contact.png"));
	private JLabel nomTitreLabel = new JLabel("Noms");
	private JLabel prenomLabel = new JLabel("Prénom");
	private JLabel nomLabel = new JLabel("Nom");
	private JLabel numTitrelLabel = new JLabel("Numéros");
	private JLabel numNatelLabel = new JLabel("Privé");
	private JLabel numProLabel = new JLabel("Professionnel");
	private JLabel diversLabel = new JLabel("Autres");
	private JLabel mailLabel = new JLabel("E-mail");

	// Champs d'insertion du texte ( sauf numéros, déclarés dans la classe)

	private JTextField prenomField = new JTextField("prénom");
	private JTextField nomField = new JTextField("nom");
	private JFormattedTextField numNatelField;
	JFormattedTextField numProField;
	private JTextField mailField = new JTextField("mail");

	// Les boutons : sauvegarde et retour à Contacts
	private JButton cancel = new JButton(new ImageIcon("./icon/cancel.png"));
	private JButton save = new JButton(new ImageIcon("./icon/save.png"));
	private JButton delete = new JButton(new ImageIcon("./icon/trash.png"));

	// Déclaration des polices
	Font titre = new Font("helvetica", Font.BOLD, 25);
	Font ssTitre = new Font("helvetica", Font.BOLD, 20);
	Font texte = new Font("helvetica", Font.BOLD, 14);

	// variable de constructeur
	private int index;
	private List<Contacts> contactsList;

	/**
	 * @param index
	 * @param contactsList
	 */
	public FrameDispContact(int index, List<Contacts> contactsList) {

		// initiaalisation des variables constructeurs
		this.index = index;
		this.contactsList = contactsList;

		// Ajout du panel dans ma frame
		this.add(panelCenter, BorderLayout.CENTER);
		// panelCenter.setBackground(Color.gray);
		panelCenter.setLayout(null);
		panelCenter.setBounds(21, 105, 378, 609);

		// Champs d'insertion des numéros formatés
		MaskFormatter tel;
		try {
			tel = new MaskFormatter("### ### ## ##");
			numNatelField = new JFormattedTextField(tel);
			numProField = new JFormattedTextField(tel);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Ajout des labels

		panelCenter.add(imageLabel);
		imageLabel.setBounds(21, 21, 100, 100);

		panelCenter.add(nomTitreLabel);
		nomTitreLabel.setFont(ssTitre);
		nomTitreLabel.setBounds(20, 100, 100, 40);

		panelCenter.add(prenomLabel);
		prenomLabel.setFont(texte);
		prenomLabel.setBounds(20, 140, 100, 30);

		panelCenter.add(nomLabel);
		nomLabel.setFont(texte);
		nomLabel.setBounds(20, 170, 100, 50);

		panelCenter.add(numTitrelLabel);
		numTitrelLabel.setFont(ssTitre);
		numTitrelLabel.setBounds(20, 220, 100, 40);

		panelCenter.add(numNatelLabel);
		numNatelLabel.setFont(texte);
		numNatelLabel.setBounds(20, 260, 100, 30);

		panelCenter.add(numProLabel);
		numProLabel.setFont(texte);
		numProLabel.setBounds(20, 290, 100, 50);

		panelCenter.add(diversLabel);
		diversLabel.setFont(ssTitre);
		diversLabel.setBounds(20, 340, 100, 40);

		panelCenter.add(mailLabel);
		mailLabel.setFont(texte);
		mailLabel.setBounds(20, 380, 100, 30);

		// Ajout des textField

		panelCenter.add(prenomField);
		prenomField.setFont(texte);
		prenomField.setText(contactsList.get(index).getPrenom());
		prenomField.setBounds(150, 140, 200, 25);

		panelCenter.add(nomField);
		nomField.setFont(texte);
		nomField.setText(contactsList.get(index).getNom());
		nomField.setBounds(150, 170, 200, 25);

		panelCenter.add(numNatelField);
		numNatelField.setFont(texte);
		numNatelField.setText(contactsList.get(index).getNumNatel());
		numNatelField.setBounds(150, 260, 200, 25);

		panelCenter.add(numProField);
		numProField.setFont(texte);
		numProField.setText(contactsList.get(index).getNumPro());
		numProField.setBounds(150, 290, 200, 25);

		panelCenter.add(mailField);
		mailField.setFont(texte);
		mailField.setText(contactsList.get(index).getEmail());
		mailField.setBounds(150, 380, 200, 25);

		// Ajout des boutons
		panelCenter.add(cancel);
		cancel.setBounds(panelCenter.getWidth() / 3 * 2, 500, panelCenter.getWidth() / 3, 70);
		cancel.setOpaque(true);
		cancel.setContentAreaFilled(false);
		cancel.setBorderPainted(false);
		cancel.addActionListener(new TraitementCancel());
		
		panelCenter.add(delete);
		delete.setBounds(panelCenter.getWidth() / 3, 500, panelCenter.getWidth() / 3, 70);
		delete.setOpaque(true);
		delete.setContentAreaFilled(false);
		delete.setBorderPainted(false);
		delete.addActionListener(new TraitementDelete());

		panelCenter.add(save);
		save.setBounds(0, 500, panelCenter.getWidth() / 3, 70);
		save.setOpaque(true);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		save.addActionListener(new TraitementSave());

	}

	public class TraitementCancel implements ActionListener {
		/**
		 * comportement du bouton retour (cancel),
		 */
		public void actionPerformed(ActionEvent e) {

			JFrame contacts;
			try {
				contacts = new FrameContacts();
				contacts.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			dispose();
		}
	}
	
	public class TraitementDelete implements ActionListener {
		/**
		 * comportement du bouton retour (cancel),
		 */
		public void actionPerformed(ActionEvent e) {

			Contacts.deleteContact(index);
			
			JFrame contacts;
			try {
				contacts = new FrameContacts();
				contacts.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			dispose();
		}
	}

	public class TraitementSave implements ActionListener {
		/**
		 * comportement du bouton save
		 */
		public void actionPerformed(ActionEvent e) {

			String nom = nomField.getText();
			String prenom = prenomField.getText();
			String numNatel = numNatelField.getText();
			String numPro = numProField.getText();
			String mail = mailField.getText();

			Contacts nouveau = new Contacts(nom, prenom, numNatel, numPro, mail);
			Contacts.updateContact(nouveau, index);

			JFrame contacts;
			try {
				contacts = new FrameContacts();
				contacts.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			dispose();

		}
	}

}
