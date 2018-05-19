package fonctions;

import java.io.IOException;

import javax.swing.JFrame;

import BDContacts.Contacts;
import gui.FrameAccueil;

public class Demarrage {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//JFrame test = new FrameAccueil() ;
		//System.out.println("test git");
		
		Contacts vb = new Contacts("Val", "Bonratch", "2017854", "2541", "2551");
		try {
			Contacts.serializeObject(vb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
