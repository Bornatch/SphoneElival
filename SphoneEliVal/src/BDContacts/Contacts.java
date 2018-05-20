package BDContacts;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.ObjIntConsumer;

public class Contacts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Nom;
	private String Prenom;
	private String numNatel;
	private String Email;
	private Photos Photo;
	private String numProfessionel;

	HashMap listecontacts;// Dictionnaire, list de contacts � voir

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

	public String creerCle(Contacts c) { // Meth qui cree une cl� pour la gestion de contacts en mayuscules.
		String temp;
		temp = (c.getPrenom().charAt(0) + c.getNom());

		return temp.toUpperCase();
	}

	public void AddContact(Contacts c) {
//		// Contacts c=new Contacts (); //on doit appeller le constructeur String
//		// Nom,String Prenom,String numNatel,String numProfessionel,String Email
//
//		String cl� = creerCle(c);
//		if (listecontacts.get(cl�) == null) {
//			listecontacts.put(cl�, c);
//
//			// System.out.println(listecontacts.get(cl�)+" existe dej�");
//		} else
//			modifierContact();
		
		

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
	 * Methode pour enregistrer un objet dans un fichier
	 *
	 */
	public static void serializeObject(Contacts c) throws IOException {
		// ouvrir un lien vers le fichier
		// le fich va �tre cr�e
		// chemin � controler
		FileOutputStream fichier = new FileOutputStream("./DataContact/" + c.Nom + c.Prenom + ".ser");

		BufferedOutputStream bfichier = new BufferedOutputStream(fichier);

		ObjectOutputStream obfichier = new ObjectOutputStream(bfichier);
		obfichier.writeObject(c);
		obfichier.close();

	}

//	/**
//	 * Meth pour d�s�rializer les contacts, cr�e une liste de contacts
//	 *
//	 */
//	public static List<Contacts> deserializeContacts() throws IOException {
//
//		// liste de r�ception des contacts
//		List<Contacts> mesContacts = new ArrayList<Contacts>();
//
//		// Fichiers � d�s�rializer
//		File dossier = new File("./DataContact/");
//		File[] fichier = dossier.listFiles();
//
//		// Cr�ation et ouverture des stream de lecture
//		FileInputStream fileIn = null;
//		BufferedInputStream buffIn = null;
//		ObjectInputStream objIn = null;
//
//		for (int i = 0; i < fichier.length; i++) {
//			try {
//				fileIn = new FileInputStream(fichier[i]);
//				buffIn = new BufferedInputStream(fileIn);
//				objIn = new ObjectInputStream(buffIn);
//
//				// lecture du contact et affectation � la liste
//				Contacts contact = (Contacts) objIn.readObject();
//				mesContacts.add(contact);
//
//			} catch (Exception e) {
//
//			}
//
//		}
//
//		// fermeture des stream
//		fileIn.close();
//		buffIn.close();
//		objIn.close();
//
//		return mesContacts;
//
//	}
//
//	public static Contacts deserializeUnContacts(int index) throws IOException {
//
//		// liste de r�ception des contacts
//		List<Contacts> mesContacts = new ArrayList<Contacts>();
//
//		// Fichiers � d�s�rializer
//		File dossier = new File("./DataContact/");
//		File[] fichier = dossier.listFiles();
//		for (int i = 0; i < fichier.length; i++) {
//			System.out.println(fichier[i]);
//		}
//
//		// Cr�ation et ouverture des stream de lecture
//		FileInputStream fileIn = null;
//		BufferedInputStream buffIn = null;
//		ObjectInputStream objIn = null;
//		Contacts contact = null;
//
//		try {
//			fileIn = new FileInputStream(fichier[index]);
//			buffIn = new BufferedInputStream(fileIn);
//			objIn = new ObjectInputStream(buffIn);
//contact = (Contacts) objIn.readObject();
//			System.out.println("Bonjour de deserializerUnContact");
//			System.out.println(contact);
//			mesContacts.add(contact);
//			// lecture du contact et affectation � la liste
//			
//
//		} catch (Exception e) {
//
//		}
//
//		// fermeture des stream
//		fileIn.close();
//		buffIn.close();
//		objIn.close();
//
//		return contact;
//
//	}

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