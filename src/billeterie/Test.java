package billeterie;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] main) {

		Formulaire form = new Formulaire();
		
		//pont qui existe entre la BDD et appli = Build path
		//exception faite au cas où le mot de passe de fonctionnerait pas
		
		  try {
		      Class.forName("org.postgresql.Driver");
		      System.out.println("Driver O.K.");

		      //correspond à l'adresse de la base de données
		      String url = "jdbc:postgresql://localhost:5432/Billeterie";
		      String user = "postgres";
		      String passwd = "marion";

		      //permet la communication entre la BDD et l'appli.
		      Connection conn = DriverManager.getConnection(url, user, passwd);
		      System.out.println("Connexion effective !");
		      
		      
		         
		    } catch (Exception e) {
		      e.printStackTrace();
		    }  
		
		
	}

}
