package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameImage extends FramePrincipale {

	// panel d'affichage des images
	private JLabel imageSelect;

	// panel d'affichage des boutons
	private JPanel navigation = new JPanel();

	Icon image;
	File[] fichier;

	int index;

	private JButton next = new JButton(new ImageIcon("./icon/next.png"));
	private JButton cancel = new JButton(new ImageIcon("./icon/cancel.png"));
	private JButton back = new JButton(new ImageIcon("./icon/back.png"));

	public FrameImage(File[] fichier, int index) {
		this.fichier = fichier;
		this.index = index;
		this.image = new ImageIcon(fichier[index].getPath());
		
		//test
		System.out.println(fichier[index].getPath());

		imageSelect = new JLabel(image);

		// panel d'affichage des images sur partie haute
		this.add(imageSelect, BorderLayout.CENTER);
		imageSelect.setBounds(20, 40, 440, 600);

		// panel d'affichage des boutons de navigation
		this.add(navigation, BorderLayout.CENTER);
		navigation.setLayout(null);
		navigation.setBounds(20, 640, 440, 100);
		navigation.setBackground(Color.DARK_GRAY);

		// ajout du boutons de navigation
		if (index < fichier.length - 2) { // suppression de Thumbs
			navigation.add(next);
			next.setBounds(285, 0, 143, 100);
			next.setOpaque(true);
			next.setContentAreaFilled(false);
			next.setBorderPainted(false);
			next.addActionListener(new TraitementNext());
		}
		if (index != 0) {
			navigation.add(back);
			back.setBounds(0, 0, 143, 100);
			back.setOpaque(true);
			back.setContentAreaFilled(false);
			back.setBorderPainted(false);
			back.addActionListener(new TraitementBack());
		}

		navigation.add(cancel);
		cancel.setBounds(143, 0, 142, 100);
		cancel.setOpaque(true);
		cancel.setContentAreaFilled(false);
		cancel.setBorderPainted(false);
		cancel.addActionListener(new TraitementCancel());

	}

	public class TraitementNext implements ActionListener {
		/**
		 * comportement du bouton suivant (next),
		 */
		public void actionPerformed(ActionEvent e) {

			JFrame image = new FrameImage(fichier, index + 1);
			image.setVisible(true);

			dispose();
		}
	}

	public class TraitementBack implements ActionListener {
		/**
		 * comportement du bouton précédent (back),
		 */
		public void actionPerformed(ActionEvent e) {

			JFrame image = new FrameImage(fichier, index - 1);
			image.setVisible(true);

			dispose();
		}
	}

	public class TraitementCancel implements ActionListener {
		/**
		 * comportement du bouton retour (cancel),
		 */
		public void actionPerformed(ActionEvent e) {

			JFrame gallerie = new FrameGallerie();
			gallerie.setVisible(true);

			dispose();

		}
	}

}

// public FrameImage(Icon icon) {
//
// this.image = icon;
// imageSelect = new JLabel(image);
//
// // panel d'affichage des images sur partie haute
// this.add(imageSelect, BorderLayout.CENTER);
// imageSelect.setBounds(20, 40, 440, 600);
//
// // panel d'affichage des boutons de navigation
// this.add(navigation, BorderLayout.CENTER);
// navigation.setLayout(null);
// navigation.setBounds(20, 640, 440, 100);
// navigation.setBackground(Color.DARK_GRAY);
//
// // ajout du boutons de navigation
// navigation.add(back);
// back.setBounds(0, 0, 143, 100);
// back.setOpaque(true);
// back.setContentAreaFilled(false);
// back.setBorderPainted(false);
//
// navigation.add(cancel);
// cancel.setBounds(143, 0, 142, 100);
// cancel.setOpaque(true);
// cancel.setContentAreaFilled(false);
// cancel.setBorderPainted(false);
//
// navigation.add(next);
// next.setBounds(285, 0, 143, 100);
// next.setOpaque(true);
// next.setContentAreaFilled(false);
// next.setBorderPainted(false);
//
// }
