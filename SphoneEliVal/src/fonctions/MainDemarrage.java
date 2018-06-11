package fonctions;

import javax.swing.JFrame;

import gui.FrameAccueil;
import gui.FrameDemarrage;

public class MainDemarrage {

	static JFrame animInit;

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		// Animation de démarrage
		try {
			animInit = new FrameDemarrage();
			Thread.sleep(2000);
			animInit.dispose();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Affichage du luncher
		JFrame test = new FrameAccueil();

	}

}
