package BDContactsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BDContacts.Contacts;

class ContactsTest {

	@Test
	void testContacts() {
		
		 Contacts c=new Contacts("Eli","Bitschnau","0781254565","0782540210","test@hevs.com");
		 assertNull(c,"L'objet n'existe pas");
		 //System.out.println("");
		 assertNotNull(c);
		
		//fail("Not yet implemented");
	}

	@Test
	void testAddContact() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateContact() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteContact() {
		fail("Not yet implemented");
	}

}
