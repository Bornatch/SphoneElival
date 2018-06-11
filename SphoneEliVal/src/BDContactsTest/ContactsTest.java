package BDContactsTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import BDContacts.Contacts;

class ContactsTest {

	@Test
	void testContacts() { //Methode ok
		 Contacts c=new Contacts("Eli","Bitschnau","0781254565","0782540210","test@hevs.ch", null);
		 
		 //Lors de l'instantiation le contructeur test déjà que les paramètres soient en String, test implicite
		 // System.out.println("++++"+c);
		 
		 assertNotNull("L'objet n'existe pas",c);//si l'objet n'existe pas 
		 
	}
	
	
	@Test
	void testafficherList() {
		
		Contacts c =new Contacts ("Eli","Bitschnau","0781254565","0782540210","test@hevs.ch",null);
		ArrayList<Contacts> contactsList = new ArrayList<Contacts>();
		
		for (int i = 0; i < 5; i++) { //Remplir la list
			contactsList.add(c);
		}
		assertNotNull("La liste est vide",c);
		//fail("Not yet implemented");
	}
	
}
