package billeterie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PopUp extends JFrame {
	private JButton bouton = new JButton("Formulaire de réservation");
	private JPanel container = new JPanel();
	private JLabel label = new JLabel("Bienvenue !");
	private JLabel label1 = new JLabel("Vous allez être dirigé sur le formulaire de réservation de vos billets.");
	
	    
	
	 public PopUp(){      
		    this.setTitle("Billeterie");
		    this.setSize(600, 200);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null); 
		    
		    container.setBackground(Color.white);
		    container.setLayout(new BorderLayout());
		    container.add(bouton, BorderLayout.SOUTH);
		    container.add(label, BorderLayout.NORTH);
		    container.add(label1, BorderLayout.CENTER);
		    
		    Font police = new Font("Tahoma", Font.BOLD, 20);
		    label.setFont(police);
		    label.setHorizontalAlignment(JLabel.CENTER);
		    label1.setHorizontalAlignment(JLabel.CENTER);
		    
		    this.setContentPane(container);
		    
		   
		    bouton.addActionListener(new ActionListener() {
		    	
		      public void actionPerformed(ActionEvent arg0) {
		    	  
		        Formulaire zd = new Formulaire(null, "Billeterie", true);
		        PopUpInfo zInfo = zd.showFormulaire(); 
		        JOptionPane jop = new JOptionPane();
		        jop.showMessageDialog(null, zInfo.toString(), "Informations Billets", JOptionPane.INFORMATION_MESSAGE);
		        
		      }         
		      
		   });      
		    
		    this.setVisible(true);      
		  }
	  }
	
	
	