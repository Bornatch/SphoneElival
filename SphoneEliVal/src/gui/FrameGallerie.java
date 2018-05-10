package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FrameGallerie extends FramePrincipale {

	// création du panel
	private JPanel panelCenter = new JPanel();

	// objet dossier
	private File dossier = new File("./Gallerie/");
	File[] fichier = dossier.listFiles();
	String index;

	// liste de boutons adaptable selon nombre de photos
	List<JButton> miniatures = new ArrayList<JButton>();

	public FrameGallerie() {

		// ajout de panel de présentation des images

		// this.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBackground(Color.DARK_GRAY);
		panelCenter.setLayout(new GridLayout(0, 3, 10, 10));
		// panelCenter.setLayout(new FlowLayout());
		// panelCenter.setLayout(new GridBagLayout());
		panelCenter.setBounds(20, 40, 440, fichier.length / 3 * 100);

		// Créer une liste des Imagesicon, le -2 retire le fichier thumbs
		for (int i = 0; i < fichier.length - 1; i++) {
			miniatures.add(new JButton(new ImageIcon(fichier[i].getPath())));
			panelCenter.add(miniatures.get(i));
			miniatures.get(i).setName("" + i);
			miniatures.get(i).setPreferredSize(new Dimension(100, 100));
			miniatures.get(i).addActionListener(new TraitementImage());
			// System.out.println(liste[i].getPath());
		}

		JScrollPane scrollPane = new JScrollPane(panelCenter);
		this.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBounds(20, 40, 440, 700);

	}

	public class TraitementImage implements ActionListener {
		/**
		 * comportement du bouton d'images,
		 */
		public void actionPerformed(ActionEvent e) {

			// JFrame image = new FrameImage(((JButton)e.getSource()).getIcon());
			JFrame image = new FrameImage(fichier, Integer.parseInt(((JButton) e.getSource()).getName()));

			image.setVisible(true);

			dispose();
		}
	}

}
