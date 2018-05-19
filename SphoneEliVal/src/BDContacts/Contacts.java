package BDContacts;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Contacts implements Serializable {

	private String Nom;
	private String Prenom;
	private String numNatel;
	private String Email;
	private Photos Photo;
	private String numProfessionel;

	HashMap listecontacts;// Dictionnaire, list de contacts à voir

	public Contacts(String nom, String prenom, String numnatel, String numprofessionel, String email) {// A appeler lors
																										// du click sur
																										// bouton add

		Nom = nom;
		Prenom = prenom;
		numNatel = numnatel;
		numProfessionel = numprofessionel;
		Email = email;

		listecontacts = new HashMap<String, Contacts>();
	}

	public String creerCle(Contacts c) { // Meth qui cree une clé pour la gestion de contacts en mayuscules.
		String temp;
		temp = (c.getPrenom().charAt(0) + c.getNom());

		return temp.toUpperCase();
	}

	public void AddContact(Contacts c) {
		// Contacts c=new Contacts (); //on doit appeller le constructeur String
		// Nom,String Prenom,String numNatel,String numProfessionel,String Email

		String clé = creerCle(c);
		if (listecontacts.get(clé) == null) {
			listecontacts.put(clé, c);

			// System.out.println(listecontacts.get(clé)+" existe dejà");
		} else
			modifierContact();

	}

	public Contacts(Photos photo) {
		Photo = photo;

	}

	public void modifierContact() {

	}

	public void supprimerContact() {

	}  
	//

	/**
	 * Meth pour enregistrer un objet dans un fichier
	 *
	 */
	private static void serializeObject(Contacts c) throws IOException {
		// ouvrir un lien vers le fichier
		// le fich va être crée
		// chemin à controler
		FileOutputStream fichier = new FileOutputStream(
				"/Users/elizabeth/git/Projet_2018/SphoneEliVal/src/BDContacts/ListContacts/contacts.ser");

		BufferedOutputStream bfichier = new BufferedOutputStream(fichier);

		ObjectOutputStream obfichier = new ObjectOutputStream(bfichier);
		obfichier.writeObject(c);
		obfichier.close();

	}

	/**
	 * Getters and setters
	 */
	public String getNumNatel() {
		return numNatel;
	}

	public void setNumNatel(String numNatel) {
		this.numNatel = numNatel;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

}