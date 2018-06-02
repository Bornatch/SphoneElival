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

/**
 * @author Elizabeth
 *
 */
public class Contacts implements Serializable {

	private static final long serialVersionUID = 1L;

	// outils du constructeur

	private String Nom;
	private String Prenom;
	private String numNatel;
	private String Email;
	private Photos Photo;
	private String numProfessionel;

	HashMap listecontacts;// Dictionnaire, list de contacts à voir

	// outils de traitement des données
	private static File dossier = new File("./DataContact/");
	private static File[] fichier = dossier.listFiles();
	private static List<Contacts> contactsList = new ArrayList<Contacts>();

	/**
	 * Constructeur, A appeler lors du click sur bouton enregistre de nouveau
	 * contact
	 * 
	 * @param nom
	 * @param prenom
	 * @param numnatel
	 * @param numprofessionel
	 * @param email
	 */
	public Contacts(String nom, String prenom, String numnatel, String numprofessionel, String email) {

		this.Nom = nom;
		this.Prenom = prenom;
		this.numNatel = numnatel;
		this.numProfessionel = numprofessionel;
		this.Email = email;

		listecontacts = new HashMap<String, Contacts>();

	}

	public String creerCle(Contacts c) { // Meth qui cree une clé pour la gestion de contacts en mayuscules.
		String temp;
		temp = (c.getPrenom().charAt(0) + c.getNom());

		return temp.toUpperCase();
	}

	public void AddContact(Contacts c) {
		// // Contacts c=new Contacts (); //on doit appeller le constructeur String
		// // Nom,String Prenom,String numNatel,String numProfessionel,String Email
		//
		// String clé = creerCle(c);
		// if (listecontacts.get(clé) == null) {
		// listecontacts.put(clé, c);
		//
		// // System.out.println(listecontacts.get(clé)+" existe dejà");
		// } else
		// modifierContact();

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
	 * Methode pour enregistrer un objet dans un nouveau fichier .ser ouvrir un lien
	 * vers le fichier le fich va être crée chemin à controler
	 */
	public static void serializeObject(Contacts c) throws IOException {

		FileOutputStream fichier = new FileOutputStream("./DataContact/" + c.Nom + c.Prenom + ".ser");

		BufferedOutputStream bfichier = new BufferedOutputStream(fichier);

		ObjectOutputStream obfichier = new ObjectOutputStream(bfichier);
		obfichier.writeObject(c);
		obfichier.close();

	}

	/**
	 * Instancie la liste de contacts en désérialisant les fichiers
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

	public HashMap getListecontacts() {
		return listecontacts;
	}

	public void setListecontacts(HashMap listecontacts) {
		this.listecontacts = listecontacts;
	}

	/**
	 * Methode d'envoie de la liste de contacts
	 * @return la liste de contacts mise à jour
	 */
	public static List<Contacts> getContactsList() {
		readObjectToList();
		return contactsList;
	}

	public static void setContactsList(List<Contacts> contactsList) {
		Contacts.contactsList = contactsList;
	}

}