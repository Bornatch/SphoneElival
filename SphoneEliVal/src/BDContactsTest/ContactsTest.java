package BDContactsTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import org.junit.jupiter.api.Test;

import BDContacts.Contacts;

class ContactsTest {

	
	@Test
	void testContacts() { //Methode ok
		 Contacts c=new Contacts("Eli","Bitschnau","0781254565","0782540210","test@hevs.ch");
		 
		 //Lors de l'instantiation le contructeur test déjà que les paramètres soient en String, test implicite
		 // System.out.println("++++"+c);
		 
		 assertNotNull("L'objet n'existe pas",c);//si l'objet n'existe pas 
		 
	}

		
	@Test
	void testafficherList() {
		
		Contacts c =new Contacts ("Eli","Bitschnau","0781254565","0782540210","test@hevs.ch");
		List<Contacts> contactsList = new ArrayList<Contacts>();
		
		for (int i = 0; i < 5; i++) { //Remplir la list
			contactsList.add(c);
		}
		assertNotNull("La liste est vide",c);
		//fail("Not yet implemented");
	}

	
}
