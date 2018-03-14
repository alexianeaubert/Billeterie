package billeterie;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class ZDialog extends JDialog {
	
	private ZDialogInfo zInfo = new ZDialogInfo();
	  private boolean sendData;
	  private JLabel nomLabel, prenomLabel, sexeLabel, concertLabel, placeLabel, mailLabel;
	  private JRadioButton tranche1, tranche2;
	  private JComboBox sexe, concert;
	  private JTextField nom, prenom, mail;
//	  private JLabel titre = new JLabel("Billeterie en ligne");

	  public ZDialog(JFrame parent, String title, boolean modal){
		    super(parent, title, modal);
		    this.setSize(600, 500);
		    this.setLocationRelativeTo(null);
		    this.setResizable(false);
		    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		    this.initComponent();
		  
	  }

	  public ZDialogInfo showZDialog(){
	    this.sendData = false;
	    this.setVisible(true);      
	    return this.zInfo;      
	  }
	
	  private void initComponent(){
		  
		JPanel panNom = new JPanel();
	    panNom.setBackground(Color.white);
	    panNom.setPreferredSize(new Dimension(220, 100));
	    nom = new JTextField();
	    nom.setPreferredSize(new Dimension(100, 25));
	    panNom.setBorder(BorderFactory.createTitledBorder("Nom"));
	    nomLabel = new JLabel("Saisir un nom :");
	    panNom.add(nomLabel);
	    panNom.add(nom);
	    
	    JPanel panPrenom = new JPanel();
	    panPrenom.setBackground(Color.white);
	    panPrenom.setPreferredSize(new Dimension(220, 100));
	    prenom = new JTextField();
	    prenom.setPreferredSize(new Dimension(100, 25));
	    panPrenom.setBorder(BorderFactory.createTitledBorder("Prenom"));
	    prenomLabel = new JLabel("Saisir un prenom :");
	    panPrenom.add(prenomLabel);
	    panPrenom.add(prenom);
	    
	    JPanel panMail = new JPanel();
	    panMail.setBackground(Color.white);
	    panMail.setPreferredSize(new Dimension(220, 100));
	    mail = new JTextField();
	    mail.setPreferredSize(new Dimension(100, 25));
	    panMail.setBorder(BorderFactory.createTitledBorder("Adresse Email"));
	    mailLabel = new JLabel("Saisir un mail :");
	    panMail.add(mailLabel);
	    panMail.add(mail);
	    
	    JPanel panSexe = new JPanel();
	    panSexe.setBackground(Color.white);
	    panSexe.setPreferredSize(new Dimension(220, 100));
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
	    panConcert.setPreferredSize(new Dimension(440, 60));
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
	    panPlace.setPreferredSize(new Dimension(440, 60));
	    tranche1 = new JRadioButton("Assis");
	    tranche1.setSelected(true);
	    tranche2 = new JRadioButton("Debout");
	    ButtonGroup bg = new ButtonGroup();
	    bg.add(tranche1);
	    bg.add(tranche2);
	    panPlace.add(tranche1);
	    panPlace.add(tranche2);
	  
	  	JPanel content = new JPanel();
	    content.setBackground(Color.white);
	    content.add(panSexe);
	    content.add(panNom);
	    content.add(panMail);
	    content.add(panPrenom);
	    content.add(panConcert);
	    content.add(panPlace);
	    
	    JPanel control = new JPanel();
	    JButton okBouton = new JButton("Valider");
	    
	    okBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {        
	        zInfo = new ZDialogInfo(nom.getText(), prenom.getText(), mail.getText(), (String)sexe.getSelectedItem(), (String)concert.getSelectedItem(), getPlace());
	        setVisible(false);
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

	      
	      this.getContentPane().add(content, BorderLayout.CENTER);
	      this.getContentPane().add(control, BorderLayout.SOUTH);
	    }  
	      
	      
}
