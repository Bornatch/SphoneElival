package fonctions;

import java.awt.image.ImageFilter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.*;

public class Demarrage {

	static JFrame animInit;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Animation de démarrage
		try {
			animInit = new FrameDemarrage();
			Thread.sleep(2000);
			animInit.dispose();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JFrame test = new FrameAccueil();

	}

}
