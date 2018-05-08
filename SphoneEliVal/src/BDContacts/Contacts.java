package BDContacts;

public class Contacts {

	private	String Nom;
	private String Prenom;
	private String numNatel;
	private String numProfessionel;
	private String Email;
	private Photos Photo;
	
	public Contacts(String nom,String prenom,String numnatel,String numprofessionel,String email) {
	
		Nom=nom;
		Prenom=prenom;
		numNatel=numnatel;
		numProfessionel=numprofessionel;
		Email=email;
		
	}
	public Contacts (Photos photo) {
		Photo=photo;
	}
	
	
}
