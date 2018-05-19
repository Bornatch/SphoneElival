package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import gui.FrameImage.TraitementCancel;

@SuppressWarnings("serial")
public class FrameAddContact extends FramePrincipale {

	// création du panel
	private JPanel panelCenter = new JPanel();

	// les JLabels d'en tête
	private JLabel imageLabel = new JLabel(new ImageIcon("./icon/contact.png"));
	private JLabel nomTitreLabel = new JLabel("Noms");
	private JLabel prenomLabel = new JLabel("Prénom");
	private JLabel nomLabel = new JLabel("Nom");
	private JLabel numTitrelLabel = new JLabel("Numéros");
	private JLabel numNatelLabel = new JLabel("Privé");
	private JLabel numProLabel = new JLabel("Professionnel");

	// Champs d'insertion du texte ( sauf numéros, déclarés dans la classe)

	private JTextField prenomField = new JTextField("prénom");
	private JTextField nomField = new JTextField("nom");
	private JFormattedTextField numNatelField;
	JFormattedTextField numProField;
	
	//Les boutons : sauvegarde et retour à Contacts
	private JButton cancel = new JButton(new ImageIcon("./icon/cancel.png"));
	private JButton save = new JButton(new ImageIcon("./icon/save.png"));

	// Déclaration des polices
	Font titre = new Font("helvetica", Font.BOLD, 25);
	Font ssTitre = new Font("helvetica", Font.BOLD, 20);
	Font texte = new Font("helvetica", Font.BOLD, 14);

	public FrameAddContact() {

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
		numProLabel.setBounds(20, 290, 100, 40);

		// Ajout des textField

		panelCenter.add(prenomField);
		prenomField.setFont(texte);
		prenomField.setBounds(150, 140, 200, 25);

		panelCenter.add(nomField);
		nomField.setFont(texte);
		nomField.setBounds(150, 170, 200, 25);

		panelCenter.add(numNatelField);
		numNatelField.setFont(texte);
		numNatelField.setBounds(150, 260, 200, 25);

		panelCenter.add(numProField);
		numProField.setFont(texte);
		numProField.setBounds(150, 290, 200, 25);
		
		//Ajout des boutons
		panelCenter.add(cancel);
		cancel.setBounds(panelCenter.getWidth() / 3*2, 500, panelCenter.getWidth() / 3, 70);
		cancel.setOpaque(true);
		cancel.setContentAreaFilled(false);
		cancel.setBorderPainted(false);
		cancel.addActionListener(new TraitementCancel());
		
		panelCenter.add(save);
		save.setBounds(0, 500, panelCenter.getWidth() / 3, 70);
		save.setOpaque(true);
		save.setContentAreaFilled(false);
		save.setBorderPainted(false);
		save.addActionListener(new TraitementCancel());

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

}
