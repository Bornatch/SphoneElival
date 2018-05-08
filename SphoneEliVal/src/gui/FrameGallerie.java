package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FrameGallerie extends FramePrincipale {
	
	private JPanel panelCenter = new JPanel();

	private File dossier = new File("./Gallerie/");
	private int index;
	List<JButton> miniatures = new ArrayList<JButton>();
	
	File[] liste = dossier.listFiles();

	public FrameGallerie() {
		
		// Créer une liste des images, le -1 retire le fichier thumbs
		
		
		for (int i = 0; i < liste.length - 1; i++) {
			 miniatures.add(new JButton(new ImageIcon(liste[i].getPath())));
		
			System.out.println(liste[i].getPath());
	}
		
		

		this.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBackground(Color.DARK_GRAY);
		panelCenter.setLayout(new GridLayout(liste.length/3,3,10,10));
		panelCenter.setBounds(20, 40, 440, 700);

		for (int i = 0; i < miniatures.size(); i++) {
			
			panelCenter.add(miniatures.get(i));
		}

	}

}
