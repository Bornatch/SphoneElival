package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class FrameGallerie extends FramePrincipale {

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

	// // bouton d'ajout d'image
	private JButton addPic = new JButton(new ImageIcon("./icon/addPhoto2.png"));

	public FrameGallerie() {

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

		// Créer une liste des Imagesicon, le if retire le fichier thumbs
		for (int i = 0; i < fichier.length; i++) {

			// redimmensionnement de l'image
			ImageIcon origine = new ImageIcon(fichier[i].getPath());
			miniatures.add(new JButton(new ImageIcon(
					origine.getImage().getScaledInstance(panelCenter.getWidth() / 2, 150, Image.SCALE_FAST))));

			// ajout de chaque miniature
			panelScroll.add(miniatures.get(i));
			miniatures.get(i).setPreferredSize(new Dimension(150, 120));

			// Aiout du numéro d'index pour gestion des events
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

		addPic.addActionListener(new TraitementAjoutPhoto());

	}

	/**
	 * @author Bornatch comportement du bouton d'images,
	 *
	 */
	public class TraitementImage implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JFrame image = new FrameImage(fichier, Integer.parseInt(((JButton) e.getSource()).getName()));

			image.setVisible(true);

			dispose();
		}
	}

	/**
	 * @author Bornatch comportement du bouton d'ajout d'image, recherche une image
	 *         dans l'ordi grace au JFileChooser et la rajoute dans le fichier
	 *         Gallerie
	 */
	public class TraitementAjoutPhoto implements ActionListener {

		JFileChooser chooser;

		Icon redim;
		String path;
		JLabel photos;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {

			chooser = new JFileChooser();
			chooser.setCurrentDirectory(new java.io.File(".", "Gallerie"));
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

			if (chooser.showOpenDialog(panelCenter) == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				InputStream in = null;
				OutputStream out = null;
				try {

					in = new FileInputStream(file);

					// Destination
					File dst = new File("./Gallerie/" + file.getName());

					// Création d'un nouveau fichier
					dst.createNewFile();
					out = new FileOutputStream(dst);

					// Transfert
					byte[] buf = new byte[1024];
					int len;
					while ((len = in.read(buf)) > 0) {
						out.write(buf, 0, len);
					}

				} catch (FileNotFoundException e2) {

				} catch (IOException e3) {

				} finally {
					// Fermeture des flux

					try {
						in.close();
						out.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					JFrame gallerie = new FrameGallerie();
					gallerie.setVisible(true);

					dispose();
				}

			} else {
				System.out.println("Pas de fichier séléctioné ");
			}
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