package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameImage extends FramePrincipale {

	// panel d'affichage des images
	private JLabel imageSelect;

	// panel d'affichage des boutons
	private JPanel navigation = new JPanel();

	Icon image;
	
	int i;

	private JButton next = new JButton(new ImageIcon("./icon/next.png"));
	private JButton cancel = new JButton(new ImageIcon("./icon/cancel.png"));
	private JButton back = new JButton(new ImageIcon("./icon/back.png"));

	public FrameImage(Icon icon) {

		this.image = icon;
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
		navigation.add(back);
		back.setBounds(0, 0, 143, 100);
		back.setOpaque(true);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);

		navigation.add(cancel);
		cancel.setBounds(143, 0, 142, 100);
		cancel.setOpaque(true);
		cancel.setContentAreaFilled(false);
		cancel.setBorderPainted(false);

		navigation.add(next);
		next.setBounds(285, 0, 143, 100);
		next.setOpaque(true);
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);

	}

	public FrameImage(File[] fichier, int i) {
		File[] listeNom =fichier;
		this.i=i;
		this.image = new ImageIcon(listeNom[i].getPath());
		System.out.println(listeNom[i].getPath());
		
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
		navigation.add(back);
		back.setBounds(0, 0, 143, 100);
		back.setOpaque(true);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);

		navigation.add(cancel);
		cancel.setBounds(143, 0, 142, 100);
		cancel.setOpaque(true);
		cancel.setContentAreaFilled(false);
		cancel.setBorderPainted(false);

		navigation.add(next);
		next.setBounds(285, 0, 143, 100);
		next.setOpaque(true);
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);
	}

}
