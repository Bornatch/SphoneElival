package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.text.MaskFormatter;

import BDContacts.Contacts;

/**
 * Frame de modification des contacts, inspirée de FrameAddContact Récupère le
 * contenu du contact et remplis les champs(Field)
 *
 */
@SuppressWarnings("serial")
public class FrameDispContact extends FramePrincipale {

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
	private JFormattedTextField numProField;
	private JTextField mailField = new JTextField("mail");

	// Bouton d'image de profil
	static JButton profilPic = new JButton(new ImageIcon("./icon/user.png"));

	// Bouton d'affichage des propriétés avec booleen gérant l'affichage des
	// éléments de modification
	private JToggleButton edit = new JToggleButton(new ImageIcon("./icon/edit.png"));
	private Boolean editBool = false;

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
	 *            la valeur dasns la liste de contacts
	 * @param contactsList
	 *            liste passée en paramètre
	 */
	public FrameDispContact(int index, List<Contacts> contactsList) {

		// initialisation des variables constructeurs
		this.index = index;
		this.contactsList = contactsList;

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
			e.printStackTrace();
		}

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

		// Ajout de l'icon du profil
		panelCenter.add(profilPic);
		if (contactsList.get(index).getProfilPicPath() != null) {
			ImageIcon imgprofil = contactsList.get(index).getProfilPicPath();
			profilPic.setIcon(new ImageIcon(imgprofil.getImage().getScaledInstance(150, 150, Image.SCALE_FAST)));

		} else {
			profilPic.setIcon(new ImageIcon("./icon/user.png"));
		}
		profilPic.setContentAreaFilled(false);
		profilPic.setBorderPainted(false);
		profilPic.setBounds(21, 5, 150, 150);

		// gestion d'affichage selon editbool
		panelCenter.add(edit);
		edit.setBounds(245, 45,70, 70);
		edit.setOpaque(true);
		edit.setContentAreaFilled(false);
		edit.setBorderPainted(false);

		edit.addActionListener(new TraitementEdit());

		// Ajout des textField

		panelCenter.add(prenomField);
		prenomField.setFont(texte);
		prenomField.setText(contactsList.get(index).getPrenom());
		prenomField.setBounds(150, 190, 200, 30);
		prenomField.setEditable(editBool);

		panelCenter.add(nomField);
		nomField.setFont(texte);
		nomField.setText(contactsList.get(index).getNom());
		nomField.setBounds(150, 230, 200, 30);
		nomField.setEditable(editBool);

		panelCenter.add(numNatelField);
		numNatelField.setFont(texte);
		numNatelField.setText(contactsList.get(index).getNumNatel());
		numNatelField.setBounds(150, 310, 200, 30);
		numNatelField.setEditable(editBool);

		panelCenter.add(numProField);
		numProField.setFont(texte);
		numProField.setText(contactsList.get(index).getNumPro());
		numProField.setBounds(150, 350, 200, 30);
		numProField.setEditable(editBool);

		panelCenter.add(mailField);
		mailField.setFont(texte);
		mailField.setText(contactsList.get(index).getEmail());
		mailField.setBounds(150, 430, 200, 30);
		mailField.setEditable(editBool);

		// Ajout des boutons

		panelCenter.add(cancel);
		cancel.setBounds(panelCenter.getWidth() / 3, 500, panelCenter.getWidth() / 3, 70);
		cancel.setOpaque(true);
		cancel.setContentAreaFilled(false);
		cancel.setBorderPainted(false);

		cancel.addActionListener(new TraitementCancel());

		panelCenter.add(delete);
		delete.setBounds(panelCenter.getWidth() / 3 * 2, 500, panelCenter.getWidth() / 3, 70);
		delete.setOpaque(true);
		delete.setContentAreaFilled(false);
		delete.setBorderPainted(false);
		delete.setVisible(editBool);

		delete.addActionListener(new TraitementDelete());

		panelCenter.add(save);
		save.setBounds(0, 500, panelCenter.getWidth() / 3, 70);
		save.setOpaque(true);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		save.setVisible(editBool);

		save.addActionListener(new TraitementSave());

	}

	public class TraitementEdit implements ActionListener {
		/**
		 * comportement du bouton(edit),
		 */
		public void actionPerformed(ActionEvent e) {
			// changement du booléen
			editBool = !editBool;

			// changement des affichage des fiels
			prenomField.setEditable(editBool);
			nomField.setEditable(editBool);
			numNatelField.setEditable(editBool);
			numProField.setEditable(editBool);
			mailField.setEditable(editBool);

			// affichage des boutons selon editable
			save.setVisible(editBool);
			delete.setVisible(editBool);

			// ActionListener de changement de l'image de profil
			if (editBool = true)
				profilPic.addActionListener(new TraitementProfilPic());

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
				e1.printStackTrace();
			}

			dispose();
		}
	}

	public class TraitementDelete implements ActionListener {
		/**
		 * comportement du bouton(delete),
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

	public class TraitementProfilPic implements ActionListener {
		/**
		 * comportement du bouton de l'image du profil,
		 */
		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent e) {

			FrameGallerieProfilChooser gallerie;
			gallerie = new FrameGallerieProfilChooser();

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
			ImageIcon icon = (ImageIcon) profilPic.getIcon();
			profilPic.setIcon(new ImageIcon("./icon/user.png"));
			Contacts nouveau = new Contacts(prenom, nom, numNatel, numPro, mail, icon);
			Contacts.updateContact(nouveau, index);

			JFrame contacts;
			try {
				contacts = new FrameContacts();
				contacts.setVisible(true);
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				dispose();
			}

		}
	}
}
