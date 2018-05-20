package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class FrameDemarrage extends FramePrincipale {

	// Cr�ation Image anim�e de d�marrage
	private JLabel animInit = new JLabel(new ImageIcon("./Gallerie/gif1.gif"));

	// Cr�ation du texte
	private JLabel bienvenue = new JLabel("Bienvenue");

	// D�claration des polices
	Font titre = new Font("helvetica", Font.BOLD, 40);

	public FrameDemarrage() {

		// cr�ation du panel central (�cran)
		this.add(animInit, BorderLayout.CENTER);
		animInit.setLayout(null);
		animInit.setBounds(21, 105, 378, 609);

		// Ajout du texte
		animInit.add(bienvenue);
		bienvenue.setFont(titre);
		bienvenue.setHorizontalAlignment(SwingConstants.CENTER);

		// animation d'oppacit� du texte d'accueil
		try {
			for (int i = 0; i < 256; i++) {

				bienvenue.setBounds(0, i + 25, 378, 50);
				bienvenue.setForeground(new Color(255, 255, 255, i));
				Thread.sleep(8);

			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
