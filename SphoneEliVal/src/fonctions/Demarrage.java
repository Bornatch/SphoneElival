package fonctions;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

import javax.swing.JFrame;

import BDContacts.Contacts;
import gui.*;

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
