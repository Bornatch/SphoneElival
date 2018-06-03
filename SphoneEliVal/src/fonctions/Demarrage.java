package fonctions;

import java.awt.image.ImageFilter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.FrameAccueil;

public class Demarrage {

	static JFrame animInit;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Animation de démarrage
		// try {
		// animInit = new FrameDemarrage();
		// Thread.sleep(2000);
		// animInit.dispose();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//

		JFrame test = new FrameAccueil();
		
		//ImgAccueilManager.stockImg(new ImageIcon());

//		try {
//			// Exemple pour agrandir
//			BufferedImage img = ImageIO.read(new File("c:/j.png"));
//			BufferedImage imgnew = ImageRedim.scale(img, 10);
//			ImageIO.write(imgnew, "png", new File("c:/jgrand.png"));
//
//			// Exemple de reduction
//			BufferedImage imag = ImageIO.read(new File("c:/j.png"));
//			BufferedImage imagnew = ImageRedim.scale(img, 0.5);
//			ImageIO.write(imagnew, "png", new File("c:/jpetit.png"));
//		} catch (IOException ex) {
//			Logger.getLogger(ImageRedim.class.getName()).log(Level.SEVERE, null, ex);
//		}

		// Contacts vb = new Contacts("Bornatici", "Valentin", "2017854", "2541",
		// "2551");
		// try {
		// Contacts.serializeObject(vb);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// System.out.println("test1");
		//
		// try (InputStream file = new FileInputStream("./DataContact/ValBonratch.ser");
		// InputStream buffer = new BufferedInputStream(file);
		// ObjectInput input = new ObjectInputStream(buffer);) {
		// // deserialize the List
		// Contacts contact = (Contacts) input.readObject();
		// // display its data
		//
		// System.out.println(contact.getNom()+" "+contact.getPrenom());
		//
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

}
