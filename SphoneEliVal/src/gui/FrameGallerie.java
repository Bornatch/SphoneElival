package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gui.FrameImage.TraitementCancel;

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

//	// bouton d'ajout d'image
//	private JButton cancel = new JButton(new ImageIcon("./icon/addPhoto2.png"));
//	static BufferedImage image;

	public FrameGallerie() {

		// ajout du panel de présentation des images

		panelCenter.setBackground(super.getBackground());
		panelCenter.setLayout(new GridLayout(0, 3, 10, 10));
		panelCenter.setBounds(21, 105, 378, 610);

		// mise du panel dans un scrollpane
		JScrollPane scrollPane = new JScrollPane(panelCenter);
		this.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBounds(21, 105, 378, 510);

		// Créer une liste des Imagesicon, le -1 retire le fichier thumbs
		for (int i = 0; i < fichier.length - 1; i++) {

			// redimmensionnement de l'image
			ImageIcon origine = new ImageIcon(fichier[i].getPath());
			miniatures.add(new JButton(new ImageIcon(
					origine.getImage().getScaledInstance(panelCenter.getWidth() / 3, 100, Image.SCALE_FAST))));

			// ajout de chaque miniature
			panelCenter.add(miniatures.get(i));
			miniatures.get(i).setPreferredSize(new Dimension(100, 100));

			// Ajout du numéro d'index pour gestion des events
			miniatures.get(i).setName("" + i);
			miniatures.get(i).addActionListener(new TraitementImage());

		}

//		// photo ajout
//		panelCenter.add(cancel);
//		cancel.setBounds(panelCenter.getWidth() / 3, 539, panelCenter.getWidth() / 3, 70);
//		cancel.setOpaque(true);
//		cancel.setContentAreaFilled(false);
//		cancel.setBorderPainted(false);
//		cancel.addActionListener(new TraitementAjoutPhoto());

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

//	public class TraitementAjoutPhoto implements ActionListener {
//		/**
//		 * comportement du bouton d'images,
//		 */
//		
//		JFileChooser chooser;
//		
//		Icon redim;
//		String path;
//		JLabel photos;
//		
//		
//		public void actionPerformed(ActionEvent e) {
//			int result;
//			chooser = new JFileChooser();
//			chooser.setCurrentDirectory(new java.io.File(".", "imagesGalerie"));
//			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//
//			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//				File file = chooser.getSelectedFile();
//				try {
//					FrameGallerie.image = ImageIO.read(file);
//					this.path = file.getAbsolutePath();
//					photos = new JLabel();
//					photos.setBounds(100, 10, FrameGallerie.scale(FrameGallerie.image, 25).getWidth(null),
//							FrameGallerie.scale(FrameGallerie.image, 25).getHeight(null));
//
//					photos.setIcon(new ImageIcon(FrameGallerie.scale(FrameGallerie.image, 25)));
//					photos.setIcon(new ImageIcon(image));
//					miniatures.add(new JButton(photos));
//
//				} catch (Exception e2) {
//					// TODO: handle exception
//				}
//
//				System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
//			} else {
//				System.out.println("Pas de fichier séléctioné ");
//			}
//		}
//	}
//
//	public static BufferedImage read(File input) throws IOException {
//		return image;
//	}
//
//	public static BufferedImage scale(BufferedImage img, double scaleValue) {
//		AffineTransform tx = new AffineTransform();
//		tx.scale(scaleValue, scaleValue);
//		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
//		BufferedImage imgNew = new BufferedImage((int) (img.getWidth() * scaleValue),
//				(int) (img.getHeight() * scaleValue), img.getType());
//		return op.filter(img, imgNew);
//	}

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