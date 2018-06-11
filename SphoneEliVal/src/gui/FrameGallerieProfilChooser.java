package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class FrameGallerieProfilChooser extends FramePrincipale {

	// création du panel
	private JPanel panelCenter = new JPanel();
	private JPanel panelScroll = new JPanel();
	private JPanel panelAdd = new JPanel();

	// objet dossier
	private File dossier = new File("./Gallerie/");

	// liste des fichiers sans le thumbs.db
	File[] fichier = dossier.listFiles(new FileFilter() {
		@Override
		public boolean accept(File file) {
			return !file.isHidden();
		}
	});
	String index;

	// liste de boutons adaptable selon nombre de photos
	List<JButton> miniatures = new ArrayList<JButton>();

	public FrameGallerieProfilChooser() {

		// ajout du panel de présentation des images

		panelCenter.setBackground(super.getBackground());
		panelCenter.setLayout(null);
		panelCenter.setBounds(21, 105, 378, 610);
		this.add(panelCenter);

		panelScroll.setBackground(super.getBackground());
		panelScroll.setLayout(new GridLayout(0, 2, 15, 15));
		panelScroll.setBounds(10, 10, 378, 600);

		panelAdd.setBackground(super.getBackground());
		panelAdd.setLayout(null);
		panelAdd.setBounds(0, 530, 378, 100);

		// mise du ScrollPane dans le component Panel
		JScrollPane scrollPane = new JScrollPane(panelScroll);
		panelCenter.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBounds(10, 10, 358, 590);

		// Créer une liste des Imagesicon, le if retire le fichier thumbs
		for (int i = 0; i < fichier.length; i++) {

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

	}

	public class TraitementImage implements ActionListener {
		/**
		 * comportement du bouton d'images,
		 */
		public void actionPerformed(ActionEvent e) {

			int index = Integer.parseInt(((JButton) e.getSource()).getName());
			try {

				ImageIcon imgprofil = new ImageIcon(fichier[index].getPath());
				FrameAddContact.profilPic
						.setIcon(new ImageIcon(imgprofil.getImage().getScaledInstance(150, 150, Image.SCALE_FAST)));
				FrameDispContact.profilPic
						.setIcon(new ImageIcon(imgprofil.getImage().getScaledInstance(150, 150, Image.SCALE_FAST)));

			} catch (Exception e2) {
				JOptionPane fail = new JOptionPane("Erreur lors de la sélection");
			} finally {
				dispose();
			}

		}
	}

}
