package fonctionsSettings;

import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Classe de gestion de la couleur du Smartphone via sauvegarde dans fichier
 * temp
 * 
 * @author Bornatch
 *
 */

public abstract class ColorManagerBord implements Serializable {	
	private static final long serialVersionUID = -7148233319040958114L;

	static Color newColor;

	static File stock = new File("./icon/temp", "couleurBord.ser");

	/**
	 * Sérialize un objet couleur
	 * 
	 * @param c couleur reçue du combobox
	 * 
	 */
	public static void stockColor(Color c) {

		ObjectOutputStream objOut = null;

		try {
			objOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(stock, false)));
			objOut.writeObject(c);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				objOut.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	/**
	 * Desérialize un objet couleur
	 */
	public static void destockColor() {

		ObjectInputStream objIn = null;

		try {
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(stock)));
			newColor = (Color) objIn.readObject();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			try {
				objIn.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		setNewColor(newColor);

	}

	/**
	 * méthode de mise à jour et de renvoie de la couleur de FramePrincipale
	 * 
	 * @return la couleur lue dans le fichier settings.ser
	 */
	public static Color getNewColor() {
		destockColor();
		return newColor;
	}

	public static void setNewColor(Color newColor) {
		ColorManagerBord.newColor = newColor;
	}

}
