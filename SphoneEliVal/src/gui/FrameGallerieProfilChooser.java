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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gui.FrameGallerie.TraitementImage;

public class FrameGallerieProfilChooser extends FramePrincipale {

	// création du panel
	private JPanel panelCenter = new JPanel();
	private JPanel panelScroll = new JPanel();
	private JPanel panelAdd = new JPanel();

	// objet dossier
	private File dossier = new File("./Gallerie/");
	File[] fichier = dossier.listFiles();
	String index;

	// liste de boutons adaptable selon nombre de photos
	List<JButton> miniatures = new ArrayList<JButton>();

	// // bouton d'ajout d'image
	private JButton addPic = new JButton(new ImageIcon("./icon/addPhoto2.png"));
	// static BufferedImage image;

	public FrameGallerieProfilChooser() {

		// ajout du panel de présentation des images

		panelCenter.setBackground(super.getBackground());
		panelCenter.setLayout(null);
		panelCenter.setBounds(21, 105, 378, 610);
		this.add(panelCenter);

		panelScroll.setBackground(super.getBackground());
		panelScroll.setLayout(new GridLayout(0, 2, 15, 15));
		panelScroll.setBounds(10, 10, 378, 510);

		panelAdd.setBackground(super.getBackground());
		panelAdd.setLayout(null);
		panelAdd.setBounds(0, 530, 378, 100);

		// mise du ScrollPane dans le component Panel
		JScrollPane scrollPane = new JScrollPane(panelScroll);
		panelCenter.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBounds(10, 10, 358, 510);

		// Créer une liste des Imagesicon, le -1 retire le fichier thumbs
		for (int i = 0; i < fichier.length - 1; i++) {

			// redimmensionnement de l'image
			ImageIcon origine = new ImageIcon(fichier[i].getPath());
			miniatures.add(new JButton(new ImageIcon(
					origine.getImage().getScaledInstance(panelCenter.getWidth() / 2, 150, Image.SCALE_FAST))));

			// ajout de chaque miniature
			panelScroll.add(miniatures.get(i));
			miniatures.get(i).setPreferredSize(new Dimension(150, 120));

			// Ajout du numéro d'index pour gestion des events
			miniatures.get(i).setName("" + i);
			miniatures.get(i).addActionListener(new TraitementImage());

		}

		// Ajout du bouton pour insérer des photos depuis la mémoire de l'ordi
		panelCenter.add(panelAdd);
		panelAdd.add(addPic);
		addPic.setBounds(panelCenter.getWidth() / 3, 0, panelCenter.getWidth() / 3, 70);
		addPic.setContentAreaFilled(false);
		addPic.setBorderPainted(false);
		addPic.setForeground(Color.BLACK);

		// addPic.addActionListener(new TraitementAjoutPhoto());

	}

	public class TraitementImage implements ActionListener {
		/**
		 * comportement du bouton d'images,
		 */
		public void actionPerformed(ActionEvent e) {

			int index = Integer.parseInt(((JButton) e.getSource()).getName());
			try {
				FrameAddContact.photo = new ImageIcon(fichier[index].getPath());
				FrameDispContact.photo = new ImageIcon(fichier[index].getPath());
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane fail = new JOptionPane("Erreur lors de la sélection");
			}
			

			dispose();
		}
	}

}
