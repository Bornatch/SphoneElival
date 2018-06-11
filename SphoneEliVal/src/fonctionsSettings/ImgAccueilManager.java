package fonctionsSettings;

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

import javax.swing.ImageIcon;

/**
 * Classe de gestion de l'image du fond d'écran de l'acceuil du Smartphone via
 * sauvegarde dans fichier temp
 * 
 * @author Bornatch
 *
 */

public abstract class ImgAccueilManager implements Serializable {
	private static final long serialVersionUID = -7148233319040958114L;

	static ImageIcon newImageFnd;

	static File stock = new File("./icon/temp", "fndEcran.ser");

	/**
	 * Sérialize une ImageIcon
	 * 
	 * @param c l'image à conserver
	 * 
	 */
	public static void stockImg(ImageIcon c) {

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
	 * Desérialize un objet ImageIcon
	 */
	public static void destockImg() {

		ObjectInputStream objIn = null;

		try {
			objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(stock)));
			newImageFnd = (ImageIcon) objIn.readObject();

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

		setNewimageFnd(newImageFnd);

	}

	/**
	 * méthode de mise à jour et de renvoie de la couleur de FramePrincipale
	 * 
	 * @return la couleur lue dans le fichier settings.ser
	 */
	public static ImageIcon getNewImageFnd() {
		destockImg();
		return newImageFnd;
	}

	public static void setNewimageFnd(ImageIcon newImageFnd) {
		ImgAccueilManager.newImageFnd = newImageFnd;
	}

}
