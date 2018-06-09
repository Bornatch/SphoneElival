package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

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
 * Frame d'ajout et de modification des contacts *
 * 
 * 
 *
 */
@SuppressWarnings("serial")
public class FrameAddContact extends FramePrincipale {

	// création du panel
	private JPanel panelCenter = new JPanel();

	// les Labels d'en tête
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

	// Bouton d'image de profil
	JButton profilPic = new JButton(new ImageIcon("./icon/user.png"));
	static ImageIcon photo;

	// Les boutons : sauvegarde et retour à Contacts
	private JButton cancel = new JButton(new ImageIcon("./icon/cancel.png"));
	private JButton save = new JButton(new ImageIcon("./icon/save.png"));

	// Déclaration des polices
	Font titre = new Font("helvetica", Font.BOLD, 25);
	Font ssTitre = new Font("helvetica", Font.BOLD, 20);
	Font texte = new Font("helvetica", Font.BOLD, 14);

	public FrameAddContact() {

		// Ajout du panel dans ma frame
		this.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBackground(super.getBackground());
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

		// Ajout de l'icon du profil
		panelCenter.add(profilPic);
		profilPic.setContentAreaFilled(false);
		profilPic.setBorderPainted(false);
		profilPic.setBounds(21, 5, 150, 150);

		profilPic.addActionListener(new TraitementProfilPic());

		// Ajout des labels
		panelCenter.add(nomTitreLabel);
		nomTitreLabel.setFont(ssTitre);
		nomTitreLabel.setBounds(20, 150, 100, 40);

		panelCenter.add(prenomLabel);
		prenomLabel.setFont(texte);
		prenomLabel.setBounds(20, 190, 100, 30);

		panelCenter.add(nomLabel);
		nomLabel.setFont(texte);
		nomLabel.setBounds(20, 220, 100, 50);

		panelCenter.add(numTitrelLabel);
		numTitrelLabel.setFont(ssTitre);
		numTitrelLabel.setBounds(20, 270, 100, 40);

		panelCenter.add(numNatelLabel);
		numNatelLabel.setFont(texte);
		numNatelLabel.setBounds(20, 310, 100, 30);

		panelCenter.add(numProLabel);
		numProLabel.setFont(texte);
		numProLabel.setBounds(20, 340, 100, 50);

		panelCenter.add(diversLabel);
		diversLabel.setFont(ssTitre);
		diversLabel.setBounds(20, 390, 100, 40);

		panelCenter.add(mailLabel);
		mailLabel.setFont(texte);
		mailLabel.setBounds(20, 430, 100, 30);

		// Ajout des textField
		panelCenter.add(prenomField);
		prenomField.setFont(texte);
		prenomField.setBounds(150, 190, 200, 30);

		panelCenter.add(nomField);
		nomField.setFont(texte);
		nomField.setBounds(150, 230, 200, 30);

		panelCenter.add(numNatelField);
		numNatelField.setFont(texte);
		numNatelField.setBounds(150, 310, 200, 30);

		panelCenter.add(numProField);
		numProField.setFont(texte);
		numProField.setBounds(150, 350, 200, 30);

		panelCenter.add(mailField);
		mailField.setFont(texte);
		mailField.setBounds(150, 430, 200, 30);

		// Ajout des boutons
		panelCenter.add(cancel);
		cancel.setBounds(panelCenter.getWidth() / 3 * 2, 500, panelCenter.getWidth() / 3, 70);
		cancel.setOpaque(true);
		cancel.setContentAreaFilled(false);
		cancel.setBorderPainted(false);

		cancel.addActionListener(new TraitementCancel());

		panelCenter.add(save);
		save.setBounds(0, 500, panelCenter.getWidth() / 3, 70);
		save.setOpaque(true);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);

		save.addActionListener(new TraitementSave());

	}

	public class TraitementProfilPic implements ActionListener {
		/**
		 * comportement du bouton de l'image du profil,
		 */
		public void actionPerformed(ActionEvent e) {

			FrameGallerieProfilChooser gallerie;
			gallerie = new FrameGallerieProfilChooser();

			profilPic.setIcon(photo);
			// gallerie.setVisible(true);

			// dispose();
		}
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
			String profilPicPath = null;

			// Contacts.updateContact(contactsList, index);//appeler le meth deleteContact
			// avant de créer le nouveau

			Contacts nouveau = new Contacts(prenom, nom, numNatel, numPro, mail, photo);
			Contacts.AddContact(nouveau);

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
