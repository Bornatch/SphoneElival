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
	private Contacts nouveau ;

	       ArrayList <Contacts>listeContactsEcriture;
	static ArrayList <Contacts>listeContactsLecture;
	
	/**
	 *Constructors
	 *	 	
	 * */

	public Contacts(String prenom, String nom, String numnatel, String numprofessionel, String email) {																										// du click sur
																								
		Nom = nom;
		Prenom = prenom;
		numNatel = numnatel;
		numProfessionel = numprofessionel;
		Email = email;	
		
		//listeContactsEcriture=new ArrayList<Contacts>(); A voir
	}
	
	public Contacts (String Prenom,String numNatel,String Email) {
		this.Prenom=Prenom;
		this.numNatel=numNatel;
		this.Email=Email;
		
		AddContact(this); 
	}
	/**
	 * Methodes
	 *
	 */
	public String ToString() {
		return Prenom+" "+Nom;
	}

	
	public void AddContact(Contacts nouveau) {		//Methode pour add contacts serialiser et afficher list contact
		listeContactsEcriture.add(nouveau) ;
		 
          try {
			serializeObject(nouveau);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
          
          afficherList();
          
	}    
	  
	public void afficherList() {                          //affiche la liste
		for (int i=0;i< listeContactsEcriture.size();i++) {
		Contacts temp= (Contacts) listeContactsEcriture.get(i);
			//System.out.println(temp.getPrenom()+" "+temp.getNom());//autre fa�on d'afficher
		
			System.out.println(temp);//Affichage avec la meth ToString modifi�
		}
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
	 * Methodes pour s�rialiser et d�serialis� une list
	 *
	 */
	
	public static void serializeObject(Contacts contact) throws IOException { //s�rialisation de la liste
		//ouvrir unlien vers le fichier
		//le fich va �tre creer
		FileOutputStream fichier=new FileOutputStream ("./Datacontact/"+contact.getNom()+contact.getPrenom()+".ser");
		
		BufferedOutputStream bfichier=new BufferedOutputStream(fichier);
		
		ObjectOutputStream obfichier=new ObjectOutputStream(bfichier);
		obfichier.writeObject(contact);
		obfichier.close();
		
	}
	public static void deserializedObject(String f) throws IOException, ClassNotFoundException{// d�serialisation de la liste
		
	listeContactsLecture=new ArrayList<Contacts>();
		
	FileInputStream fichier=new FileInputStream (f);
	BufferedInputStream bfichier=new BufferedInputStream(fichier);
	ObjectInputStream obfichier=new ObjectInputStream(bfichier);
	
	listeContactsLecture=(ArrayList<Contacts>)obfichier.readObject();
	
	//Personne moi=(Personne)obfichier.readObject();autre possibilit� pour afficher l'objet
	//obfichier.readObject(); c'est la m�me chose
	//System.out.println("Voci l'objet"+obfichier.readObject());//autre possibilit� pour afficher 
	//                                                                            l'objet via la meth ToString
	for(Contacts c:listeContactsLecture) {
		System.out.println(c);
	}
		
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