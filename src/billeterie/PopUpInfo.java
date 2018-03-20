package billeterie;

public class PopUpInfo {
	  private static String nom, prenom, sexe, concert, place, mail;
	
	  public PopUpInfo(){}
	  
	  public static String getNom() {
		  return nom;
	  }
	  
	  public static String getPrenom() {
		  return prenom;
	  }
	  
	  public static String getSexe() {
		  return sexe;
	  }
	  
	  public static String getConcert() {
		  return concert;
	  }
	  
	  public static String getPlace() {
		  return place;
	  }
	  
	  public static String getMail() {
		  return mail;
	  }
	  

	  
	  public PopUpInfo(String nom, String prenom, String mail, String sexe, String concert, String place){
	    this.nom = nom;
	    this.prenom = prenom;
	    this.sexe = sexe;
	    this.concert = concert;
	    this.place = place;
	    this.mail = mail;
	  }
	
	  public String toString(){
	    String str;
	    if(this.nom != null || this.prenom != null || this.mail != null || this.sexe != null || this.concert != null || this.place != null){
	      str = "Récapitulatif des informations :"+"\n";
	      str += "Civilité : " + this.sexe + "\n";
	      str += "Nom : " + this.nom + "\n";
	      str += "Prenom : "+ this.prenom + "\n";
	      str += "Adresse email : "+ this.mail + "\n";
	      str += "Concert : " + this.concert + "\n";
	      str += "Place : " + this.place + "\n";
	    }
	    else{
	      str = "Aucune information rempli !";
	    }
	    return str;
	  }
	}

