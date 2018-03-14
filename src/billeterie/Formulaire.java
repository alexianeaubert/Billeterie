package billeterie;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Formulaire extends JFrame {
	private JButton bouton = new JButton("Formulaire de réservation");
	
	 public void paintComponent(Graphics g) {
	        g.drawString("Vous allez être dirigé sur le formulaire de réservation de vos billets.", 10, 20);
	      } 
	    
	
	 public Formulaire(){      
		    this.setTitle("Bienvenue !");
		    this.setSize(500, 200);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);      
		    this.getContentPane().setLayout(new FlowLayout());
		    this.getContentPane().add(bouton);
		    
		    bouton.addActionListener(new ActionListener() {
		    	
		      public void actionPerformed(ActionEvent arg0) {
		    	  
		        ZDialog zd = new ZDialog(null, "Billeterie", true);
		        ZDialogInfo zInfo = zd.showZDialog(); 
		        JOptionPane jop = new JOptionPane();
		        jop.showMessageDialog(null, zInfo.toString(), "Informations Billets", JOptionPane.INFORMATION_MESSAGE);
		        
		      }         
		      
		   });      
		    
		    this.setVisible(true);      
		  }
	  }
	
	
	
	
	
	/*private JPanel container = new JPanel();
	private JTextField jtf = new JTextField("Nom de famille");
	private JTextField jtf1 = new JTextField("Prenom");
	private JTextField jtf2 = new JTextField("@");
	  private JLabel label = new JLabel("Nom");
	  private JLabel label1 = new JLabel("Prenom");
	  private JLabel label2 = new JLabel("Adresse mail");
	  private JButton bouton = new JButton("Valider");

	  public Formulaire(){
	    this.setTitle("Animation");
	    this.setSize(300, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    container.setBackground(Color.white);
	    container.setLayout(new BorderLayout());
	    
	    JPanel top = new JPanel();
	    Font police = new Font("Arial", Font.BOLD, 14);
	    
	    jtf.setFont(police);
	    jtf.setPreferredSize(new Dimension(150, 30));
	    jtf.setForeground(Color.BLUE);
	    
	    jtf1.setFont(police);
	    jtf1.setPreferredSize(new Dimension(150, 30));
	    jtf1.setForeground(Color.BLUE);
	    
	    jtf2.setFont(police);
	    jtf2.setPreferredSize(new Dimension(150, 30));
	    jtf2.setForeground(Color.BLUE);
	    
	    
	    top.add(label);
	    top.add(jtf);
	    top.add(label1);
	    top.add(jtf1);
	    top.add(label2);
	    top.add(jtf2);
	    container.add(top, BorderLayout.NORTH);
	    this.setContentPane(container);
	    this.setVisible(true);
*/
	    

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	private JPanel pan = new JPanel();
	private JButton bouton = new JButton("Valider");
	//private Bouton bouton;
	
	
	
	  public Formulaire() {
		  
	
		    this.setTitle("Ma premiere fenetre Java");
		    this.setSize(800, 800);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		    //Methode qui positionne mon formulaire
		    this.setLocation(600, 100);
		   
		    pan.add(bouton);
		    this.setContentPane(pan);

		    

		    this.setVisible(true);
	  }
*/




////On d�finit le layout � utiliser sur le content pane
//
//this.setLayout(new BorderLayout());
//
////On ajoute le bouton au content pane de la JFrame
////Au centre
//this.getContentPane().add(new JButton("CENTER"), BorderLayout.CENTER);
//
////Au nord
//this.getContentPane().add(new JButton("NORTH"), BorderLayout.NORTH);
//
////Au sud
//this.getContentPane().add(new JButton("SOUTH"), BorderLayout.SOUTH);
//
////� l'ouest
//this.getContentPane().add(new JButton("WEST"), BorderLayout.WEST);
//
////� l'est
//this.getContentPane().add(new JButton("EAST"), BorderLayout.EAST);