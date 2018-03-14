package billeterie;

public class ZDialogInfo {
	  private String nom, prenom, sexe, concert, place, mail;
//	  sexe, age, cheveux, taille;
	
	  public ZDialogInfo(){}
	  
	  public ZDialogInfo(String nom, String prenom, String mail, String sexe, String concert, String place){
//		  String age, String cheveux, String taille)
	    this.nom = nom;
	    this.prenom = prenom;
	    this.sexe = sexe;
	    this.concert = concert;
	    this.place = place;
	    this.mail = mail;
//	    this.age = age;
//	    this.cheveux = cheveux;
//	    this.taille = taille;
	  }
	
	  public String toString(){
	    String str;
	    if(this.nom != null && this.prenom != null && this.mail != null && this.sexe != null && this.concert != null && this.place != null){
//	    	&& this.taille != null && this.age != null && this.cheveux != null
	      str = "Récapitulatif des informations :"+"\n";
	      str += "Civilité : " + this.sexe + "\n";
	      str += "Nom : " + this.nom + "\n";
	      str += "Prenom : "+ this.prenom + "\n";
	      str += "Adresse email : "+ this.mail + "\n";
	      str += "Concert : " + this.concert + "\n";
	      str += "Place : " + this.place + "\n";
//	      str += "Age : " + this.age + "\n";
//	      str += "Cheveux : " + this.cheveux + "\n";
//	      str += "Taille : " + this.taille + "\n";
	    }
	    else{
	      str = "Aucune information !";
	    }
	    return str;
	  }
	}

