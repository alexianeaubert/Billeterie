package billeterie;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Formulaire extends JDialog {
	
	private PopUpInfo zInfo = new PopUpInfo();
	  private boolean sendData;
	  private JLabel titreLabel, nomLabel, prenomLabel, sexeLabel, concertLabel, placeLabel, mailLabel;
	  private JRadioButton tranche1, tranche2;
	  private JComboBox sexe, concert;
	  private JTextField nom, prenom, mail;

	  public Formulaire(JFrame parent, String title, boolean modal){
		    super(parent, title, modal);
		    this.setSize(650, 500);
		    this.setLocationRelativeTo(null);
		    this.setResizable(false);
		    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		    this.initComponent();
		  
	  }

	  public PopUpInfo showFormulaire(){
	    this.sendData = false;
	    this.setVisible(true);      
	    return this.zInfo;      
	  }
	
	  private void initComponent(){
		  
		JPanel panTitre = new JPanel(); 
		panTitre.setBackground(Color.white);
		panTitre.setPreferredSize(new Dimension(100, 50));
		titreLabel = new JLabel("Formulaire de réservation");
		Font police = new Font("Tahoma", Font.BOLD, 20);
		titreLabel.setFont(police);
		panTitre.add(titreLabel);
		
		  
		JPanel panNom = new JPanel();
	    panNom.setBackground(Color.white);
	    panNom.setPreferredSize(new Dimension(248, 60));
	    nom = new JTextField();
	    nom.setPreferredSize(new Dimension(100, 25));
	    panNom.setBorder(BorderFactory.createTitledBorder("Nom"));
	    nomLabel = new JLabel("Saisir un nom :");
	    panNom.add(nomLabel);
	    panNom.add(nom);
	    
	    JPanel panPrenom = new JPanel();
	    panPrenom.setBackground(Color.white);
	    panPrenom.setPreferredSize(new Dimension(248, 60));
	    prenom = new JTextField();
	    prenom.setPreferredSize(new Dimension(100, 25));
	    panPrenom.setBorder(BorderFactory.createTitledBorder("Prenom"));
	    prenomLabel = new JLabel("Saisir un prenom :");
	    panPrenom.add(prenomLabel);
	    panPrenom.add(prenom);
	    
	    JPanel panMail = new JPanel();
	    panMail.setBackground(Color.white);
	    panMail.setPreferredSize(new Dimension(500, 60));
	    mail = new JTextField();
	    mail.setPreferredSize(new Dimension(200, 25));
	    panMail.setBorder(BorderFactory.createTitledBorder("Adresse Email"));
	    mailLabel = new JLabel("Saisir un mail :");
	    panMail.add(mailLabel);
	    panMail.add(mail);
	    
	    JPanel panSexe = new JPanel();
	    panSexe.setBackground(Color.white);
	    panSexe.setPreferredSize(new Dimension(500, 60));
	    panSexe.setBorder(BorderFactory.createTitledBorder("Civilité"));
	    sexe = new JComboBox();
	    sexe.addItem("-");
	    sexe.addItem("Monsieur");
	    sexe.addItem("Madame");
	    sexeLabel = new JLabel("Civilité : ");
	    panSexe.add(sexeLabel);
	    panSexe.add(sexe);
	    
	    JPanel panConcert = new JPanel();
	    panConcert.setBackground(Color.white);
	    panConcert.setPreferredSize(new Dimension(500, 60));
	    panConcert.setBorder(BorderFactory.createTitledBorder("Les artistes"));
	    concert = new JComboBox();
	    concert.addItem("-");
	    concert.addItem("Red Hot Chili Peppers");
	    concert.addItem("Beyonce");
	    concert.addItem("Justin Timberlake");
	    concert.addItem("U2");
	    concertLabel = new JLabel("Concerts :");
	    panConcert.add(concertLabel);
	    panConcert.add(concert);
	    
	    JPanel panPlace = new JPanel();
	    panPlace.setBackground(Color.white);
	    panPlace.setBorder(BorderFactory.createTitledBorder("Places Disponibles"));
	    panPlace.setPreferredSize(new Dimension(500, 60));
	    tranche1 = new JRadioButton("Assis");
	    tranche1.setSelected(true);
	    tranche1.setActionCommand("Assis");
	    tranche2 = new JRadioButton("Debout");
	    tranche2.setActionCommand("Debout");
	    ButtonGroup bg = new ButtonGroup();
	    bg.add(tranche1);
	    bg.add(tranche2);
	    panPlace.add(tranche1);
	    panPlace.add(tranche2);
	  
	  	JPanel content = new JPanel();
	    content.setBackground(Color.WHITE);
	    content.add(panSexe);
	    content.add(panNom);
	    content.add(panPrenom);
	    content.add(panMail);
	    content.add(panConcert);
	    content.add(panPlace);
	    
	    JPanel control = new JPanel();
	    JButton okBouton = new JButton("Valider");
	    
	    
	    okBouton.addActionListener(new ActionListener(){
	    	
	      public void actionPerformed(ActionEvent arg0) {    
	    	  
	        zInfo = new PopUpInfo(nom.getText(), prenom.getText(), mail.getText(), (String)sexe.getSelectedItem(), (String)concert.getSelectedItem(), getPlace());
	        setVisible(false);
	        

	        if(bg.getSelection().getActionCommand() == "Assis") {
	        		String tranche1 = "place assise";
	        		
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
			      
			      Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			      stm.executeUpdate("INSERT INTO billet (nom, prenom, email, groupe, sexe, typeplace) VALUES('"+nom.getText()+"','"+prenom.getText()+"','"+mail.getText()+"','"+concert.getSelectedItem()+"','"+sexe.getSelectedItem()+"','"+tranche1+"')");
			      System.out.println("Info envoyées dans la base de données.");
			      
			         
			    } catch (Exception e) {
			    		System.out.println("Attention, il y a un problème pour joindre la base de données de la Billeterie.");
			    		e.printStackTrace();
			    }
			
	      }else {
	    	  	String tranche2 = "place debout";
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
				      
				      Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				      stm.executeUpdate("INSERT INTO billet (nom, prenom, email, groupe, sexe, typeplace) VALUES('"+nom.getText()+"','"+prenom.getText()+"','"+mail.getText()+"','"+concert.getSelectedItem()+"','"+sexe.getSelectedItem()+"','"+tranche2+"')");
				      System.out.println("Info envoyées dans la base de données.");
				      
				         
				    } catch (Exception e) {
				    		System.out.println("Attention, il y a un problème pour joindre la base de données de la Billeterie.");
				    		e.printStackTrace();
				    }
	      	}
	        
	        
	      }
	     
	      public String getPlace(){
		        return (tranche1.isSelected()) ? tranche1.getText() : 
		               (tranche2.isSelected()) ? tranche2.getText() : 
		                tranche1.getText();  
		      }
	      
	    });
	      
	      JButton cancelBouton = new JButton("Annuler");
	      cancelBouton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent arg0) {
	          setVisible(false);
	        }      
	      });
	     
	      control.add(okBouton);
	      control.add(cancelBouton);

	      this.getContentPane().add(panTitre, BorderLayout.NORTH);
	      this.getContentPane().add(content, BorderLayout.CENTER);
	      this.getContentPane().add(control, BorderLayout.SOUTH);
	    }  
	      
	      
}
