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
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Contacts implements Serializable {

	private static final long serialVersionUID = 1L;

	// outils de traitement des données
	private static File dossier = new File("./DataContact/");
	private static File[] fichiers;
	private static List<Contacts> contactsList = new ArrayList<Contacts>();

	// outils du constructeur

	private String Nom;
	private String Prenom;
	private String numNatel;
	private String Email;
	// private Photos Photo;
	private String numProfessionel;
	private String profilPicPath;
	
	// variable index du contact selectionné
    private  int Index ;
    
	public int getIndex() {
		return Index;
	}

	public void setIndex(int index) {
		Index = index;
	}

	/**
	 * Constructeur de contacts, utilisé par la frameAddContact btn save
	 * 
	 * @param prenom
	 * @param nom
	 * @param numnatel
	 * @param numprofessionel
	 * @param email
	 */
	public Contacts(String prenom, String nom, String numnatel, String numprofessionel, String email) {

		this.Nom = nom;
		this.Prenom = prenom;
		this.numNatel = numnatel;
		this.numProfessionel = numprofessionel;
		this.Email = email;

	}

	/**
	 * @return la chaine de string nom prénom
	 */
	public String ToString() {
		return Nom + " " + Prenom;

	}

	/**
	 * @param contact
	 */
	public static void AddContact(Contacts nouveau) {

		serializeObject(nouveau);

	}

	public void afficherList() { // affiche la liste
		for (int i = 0; i < contactsList.size(); i++) {
			Contacts temp = (Contacts) contactsList.get(i);
			System.out.println(temp.getPrenom()+" "+temp.getNom());  //autre façon d'afficher

			System.out.println(temp);// Affichage avec la meth ToString modifié
		}

	}

	/**
	 * méthode de modification d'un contact renvoi la methode deleteContact puis
	 * addContact
	 * 
	 * @param contact
	 * @param index
	 */
	public static void updateContact(Contacts c, int index) {
		System.out.println("entre dans update");
		deleteContact(index);
		//System.out.println(index);
		AddContact(c);
	}

	/**
	 * Suppression du contact à l'index de fichiers[]
	 * 
	 * @param index
	 */
	public static void deleteContact(int index) {


		//fichiers = dossier.listFiles();
		System.out.println(fichiers[index].getName());
		//fichiers[index].delete();
		// contactsList.remove(index);
		Path path = fichiers[index].toPath();
		
		try {
		    Files.delete(path);
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", path);
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", path);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}
		

	}

	/**
	 * Méthode pour sérialiser un contact en créant un fichier et en k'ahjoutant
	 * daand dossier DataContact
	 * 
	 * @param contact
	 */
	public static void serializeObject(Contacts nouveau) {

		FileOutputStream fichier = null;
		BufferedOutputStream bfichier = null;
		ObjectOutputStream obfichier = null;
		try {
			fichier = new FileOutputStream("./DataContact/" + nouveau.Nom + nouveau.Prenom + ".ser");

			bfichier = new BufferedOutputStream(fichier);
			obfichier = new ObjectOutputStream(bfichier);
			obfichier.writeObject(nouveau);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				obfichier.close();
				bfichier.close();
				fichier.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Meth pour sérialiser le fichier après delete et modif
	 *
	 */
	
	public static void serializeObjectFile(File f) {

		FileOutputStream fichier = null;
		BufferedOutputStream bfichier = null;
		ObjectOutputStream obfichier = null;
		try {
			fichier = new FileOutputStream("./DataContact/" + f.getClass()+".ser");

			bfichier = new BufferedOutputStream(fichier);
			obfichier = new ObjectOutputStream(bfichier);
			obfichier.writeObject(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				obfichier.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

	/**
	 * Instancie la liste de contacts en désérialisant les fichiers
	 */
	public void readObjectToList() {

		ObjectInputStream objIn = null;
		fichiers = dossier.listFiles();

		for (int i = 0; i < fichiers.length; i++) {
			try {
				objIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fichiers[i])));
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
	 * Meth pour désérializer les contacts, crée une liste de contacts
	* 
	*/
	public static List<Contacts> deserializeContacts() throws IOException {

		// liste de réception des contacts
		List<Contacts> mesContacts = new ArrayList<Contacts>();
		

		// Création et ouverture des stream de lecture
		FileInputStream fileIn = null;
		BufferedInputStream buffIn = null;
		ObjectInputStream objIn = null;
		// System.out.println(fichiers.length);
		fichiers = dossier.listFiles();

		for (int i = 0; i < fichiers.length; i++) {
			try {
				fileIn = new FileInputStream(fichiers[i]);
				buffIn = new BufferedInputStream(fileIn);
				objIn = new ObjectInputStream(buffIn);

				// lecture du contact et affectation à la liste
				Contacts contact = (Contacts) objIn.readObject();
				mesContacts.add(contact);

			} catch (Exception e) {

			} finally {
				try {                // fermeture des streams
					fileIn.close();
					buffIn.close();
					objIn.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		}

		
		

		System.out.println("num des contacts : " + mesContacts.size());
		return mesContacts;

	}

	/**
	 * Getters et setters
	 */
	public String getNumNatel() {
		return numNatel;
	}

	public void setNumNatel(String numNatel) {
		this.numNatel = numNatel;
	}

	public String getNumPro() {
		return numProfessionel;
	}

	public void setNumPro(String numProfessionel) {
		this.numProfessionel = numProfessionel;
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

	/**
	 * Methode d'envoie de la liste de contacts
	 * 
	 * @return la liste de contacts mise à jour
	 */
	public List<Contacts> getContactsList() {
		readObjectToList();
		return contactsList;
	}

	public void setContactsList(List<Contacts> contactsList) {
		this.contactsList = contactsList;
	}

}
// /**
// * Meth pour désérializer les contacts, crée une liste de contacts
// *
// */
// public static List<Contacts> deserializeContacts() throws IOException {
//
// // liste de réception des contacts
// List<Contacts> mesContacts = new ArrayList<Contacts>();
//
// // Fichiers à désérializer
// File dossier = new File("./DataContact/");
// File[] fichier = dossier.listFiles();
//
// // Création et ouverture des stream de lecture
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
// // lecture du contact et affectation à la liste
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
// // liste de réception des contacts
// List<Contacts> mesContacts = new ArrayList<Contacts>();
//
// // Fichiers à désérializer
// File dossier = new File("./DataContact/");
// File[] fichier = dossier.listFiles();
// for (int i = 0; i < fichier.length; i++) {
// System.out.println(fichier[i]);
// }
//
// // Création et ouverture des stream de lecture
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
// // lecture du contact et affectation à la liste
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