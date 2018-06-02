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

	private static final long serialVersionUID = 1L;

	// outils du constructeur

	private String Nom;
	private String Prenom;
	private String numNatel;
	private String Email;
	private Photos Photo;
	private String numProfessionel;
	private Contacts nouveau;


	/**
	 * Constructors
	 * 
	 */

	// outils de traitement des donn�es
	private static File dossier = new File("./DataContact/");
	private static File[] fichier = dossier.listFiles();
	private static List<Contacts> contactsList = new ArrayList<Contacts>();

	/**
	 * Constructeur, A appeler lors du click sur bouton enregistre de nouveau
	 * contact
	 */

	public Contacts(String prenom, String nom, String numnatel, String numprofessionel, String email) { // du click sur

		Nom = nom;
		Prenom = prenom;
		numNatel = numnatel;
		numProfessionel = numprofessionel;
		Email = email;

	}

	public Contacts(String Prenom, String numNatel, String Email) {
		this.Prenom = Prenom;
		this.numNatel = numNatel;
		this.Email = Email;

		AddContact(this);
	}

	/**
	 * Methodes
	 *
	 */
	public String ToString() {
		return Nom + " " + Prenom;

	}

	
	public void AddContact(Contacts nouveau) { // Methode pour add contacts serialiser et afficher list contact
		contactsList.add(nouveau);

		try {
			serializeObject(nouveau);
		} catch (IOException e) {

			e.printStackTrace();
		}

		afficherList();

	}

	public void afficherList() { // affiche la liste
		for (int i = 0; i < contactsList.size(); i++) {
			Contacts temp = (Contacts) contactsList.get(i);
			// System.out.println(temp.getPrenom()+" "+temp.getNom());//autre fa�on
			// d'afficher

			System.out.println(temp);// Affichage avec la meth ToString modifi�
		}

	}

	public Contacts(Photos photo) {
		Photo = photo;

	}

	public void modifierContact() {

	}

	public void supprimerContact() {

	}

	/**
	 * 
	 * Methode pour enregistrer un objet dans un nouveau fichier .ser ouvrir un lien
	 * vers le fichier le fich va �tre cr�e chemin � controler
	 * 
	 * Methodes pour s�rialiser et d�serialis� une list
	 *
	 * 
	 */

	public static void serializeObject(Contacts c) throws IOException {

		FileOutputStream fichier = new FileOutputStream("./DataContact/" + c.Nom + c.Prenom + ".ser");

		BufferedOutputStream bfichier = new BufferedOutputStream(fichier);

		ObjectOutputStream obfichier = new ObjectOutputStream(bfichier);
		obfichier.writeObject(c);
	}

	//test
	

	/**
	 * Instancie la liste de contacts en d�s�rialisant les fichiers
	 */
	public static void readObjectToList() {

		ObjectInputStream objIn = null;

		for (int i = 0; i < fichier.length; i++) {
			try {
				objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichier[i])));
				contactsList.add((Contacts) objIn.readObject());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					objIn.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

		setContactsList(contactsList);

	}


	 /**
	 * Meth pour d�s�rializer les contacts, cr�e une liste de contacts
	 *
	 */
	 public static List<Contacts> deserializeContacts() throws IOException {
	
	 // liste de r�ception des contacts
	 List<Contacts> mesContacts = new ArrayList<Contacts>();
	
	 // Fichiers � d�s�rializer
	 File dossier = new File("./DataContact/");
	 File[] fichier = dossier.listFiles();
	
	 // Cr�ation et ouverture des stream de lecture
	 FileInputStream fileIn = null;
	 BufferedInputStream buffIn = null;
	 ObjectInputStream objIn = null;
	
	 for (int i = 0; i < fichier.length; i++) {
	 try {
	 fileIn = new FileInputStream(fichier[i]);
	 buffIn = new BufferedInputStream(fileIn);
	 objIn = new ObjectInputStream(buffIn);
	
	 // lecture du contact et affectation � la liste
	 Contacts contact = (Contacts) objIn.readObject();
	 mesContacts.add(contact);
	
	 } catch (Exception e) {
	
	 }
	
	 }
	
	 // fermeture des stream
	 fileIn.close();
	 buffIn.close();
	 objIn.close();
	
	 return mesContacts;
	
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

	// public HashMap getListecontacts() {
	// return listecontacts;
	// }
	//
	// public void setListecontacts(HashMap listecontacts) {
	// this.listecontacts = listecontacts;
	// }
	//
	/**
	 * Methode d'envoie de la liste de contacts
	 * 
	 * @return la liste de contacts mise � jour
	 */
	public static List<Contacts> getContactsList() {
		readObjectToList();
		return contactsList;
	}

	public static void setContactsList(List<Contacts> contactsList) {
		contactsList = contactsList;
	}

}
// /**
// * Meth pour d�s�rializer les contacts, cr�e une liste de contacts
// *
// */
// public static List<Contacts> deserializeContacts() throws IOException {
//
// // liste de r�ception des contacts
// List<Contacts> mesContacts = new ArrayList<Contacts>();
//
// // Fichiers � d�s�rializer
// File dossier = new File("./DataContact/");
// File[] fichier = dossier.listFiles();
//
// // Cr�ation et ouverture des stream de lecture
// FileInputStream fileIn = null;
// BufferedInputStream buffIn = null;
// ObjectInputStream objIn = null;
//
// for (int i = 0; i < fichier.length; i++) {
// try {
// fileIn = new FileInputStream(fichier[i]);
// buffIn = new BufferedInputStream(fileIn);
// objIn = new ObjectInputStream(buffIn);
//
// // lecture du contact et affectation � la liste
// Contacts contact = (Contacts) objIn.readObject();
// mesContacts.add(contact);
//
// } catch (Exception e) {
//
// }
//
// }
//
// // fermeture des stream
// fileIn.close();
// buffIn.close();
// objIn.close();
//
// return mesContacts;
//
// }
//
// public static Contacts deserializeUnContacts(int index) throws IOException {
//
// // liste de r�ception des contacts
// List<Contacts> mesContacts = new ArrayList<Contacts>();
//
// // Fichiers � d�s�rializer
// File dossier = new File("./DataContact/");
// File[] fichier = dossier.listFiles();
// for (int i = 0; i < fichier.length; i++) {
// System.out.println(fichier[i]);
// }
//
// // Cr�ation et ouverture des stream de lecture
// FileInputStream fileIn = null;
// BufferedInputStream buffIn = null;
// ObjectInputStream objIn = null;
// Contacts contact = null;
//
// try {
// fileIn = new FileInputStream(fichier[index]);
// buffIn = new BufferedInputStream(fileIn);
// objIn = new ObjectInputStream(buffIn);
// contact = (Contacts) objIn.readObject();
// System.out.println("Bonjour de deserializerUnContact");
// System.out.println(contact);
// mesContacts.add(contact);
// // lecture du contact et affectation � la liste
//
//
// } catch (Exception e) {
//
// }
//
// // fermeture des stream
// fileIn.close();
// buffIn.close();
// objIn.close();
//
// return contact;
//
// }