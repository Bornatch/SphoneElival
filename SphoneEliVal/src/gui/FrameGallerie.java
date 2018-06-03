package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
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

@SuppressWarnings("serial")
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

		// ajout du panel de présentation des images

		panelCenter.setBackground(super.getBackground());
		panelCenter.setLayout(new GridLayout(0, 3, 10, 10));
		panelCenter.setBounds(21, 105, 378, 610);

		// mise du panel dans un scrollpane 
		JScrollPane scrollPane = new JScrollPane(panelCenter);
		this.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBounds(21, 105, 378, 610);

		// Créer une liste des Imagesicon, le -1 retire le fichier thumbs
		for (int i = 0; i < fichier.length - 1; i++) {
			
			//redimmensionnement de l'image
			ImageIcon origine = new ImageIcon(fichier[i].getPath());
			miniatures.add(new JButton(new ImageIcon(
					origine.getImage().getScaledInstance(panelCenter.getWidth() / 3, 100, Image.SCALE_FAST))));
			
			//ajout de chaque miniature
			panelCenter.add(miniatures.get(i));			
			miniatures.get(i).setPreferredSize(new Dimension(100, 100));
			
			//Ajout du numéro d'index pour gestion des events
			miniatures.get(i).setName("" + i);
			miniatures.get(i).addActionListener(new TraitementImage());

		}

	}

	public class TraitementImage implements ActionListener {
		/**
		 * comportement du bouton d'images,
		 */
		public void actionPerformed(ActionEvent e) {

			JFrame image = new FrameImage(fichier, Integer.parseInt(((JButton) e.getSource()).getName()));

			image.setVisible(true);

			dispose();
		}
	}

}

/*
 * //ImageIcon ajustee = ajuste(origine, extension); // découpage de l'extension
 * du fichier String chemin = fichier[i].getPath(); int taille =
 * chemin.length(); String extension = chemin.substring(taille - 3);
 * System.out.println(extension);
 * 
 * private ImageIcon ajuste(ImageIcon imageIcon, String extension) { ImageIcon
 * origine = imageIcon;
 * 
 * // getScaledinstance pas valable avec les gif if (extension.equals("gif"))
 * return origine;
 * 
 * ImageIcon ajustee;
 * 
 * if (origine.getIconHeight() < 1000) { // test si format paysage ajustee = new
 * ImageIcon(origine.getImage().getScaledInstance((origine.getIconWidth() * 100)
 * / 1000, (origine.getIconWidth() * 100) / 1000, Image.SCALE_SMOOTH)); } else {
 * ajustee = new
 * ImageIcon(origine.getImage().getScaledInstance((origine.getIconWidth() ),
 * (origine.getIconWidth()), 2)); }
 * 
 * return ajustee; }
 */