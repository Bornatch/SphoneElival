package fonctions;

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

/**
 * Classe de gestion de la couleur du Smartphone via sauvegarde dans fichier
 * temp
 * 
 * @author Bornatch
 *
 */

public abstract class ColorManager {

	static Color newColor;

	static File stock = new File("./icon/temp", "settings.ser");

	/**
	 * S�rialize un objet couleur
	 * 
	 * @param c
	 *            couleur re�ue du combobox
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
	 * Des�rialize un objet couleur
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
	 * m�thode de mise � jour et de renvoie de la couleur de FramePrincipale
	 * 
	 * @return la nouvelle couleur
	 */
	public static Color getNewColor() {
		destockColor();
		return newColor;
	}

	public static void setNewColor(Color newColor) {
		ColorManager.newColor = newColor;
	}

}
