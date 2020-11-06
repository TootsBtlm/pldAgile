package controleur;

import java.io.File;

import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modele.EnsembleRequete;
import modele.Lecteur;
import modele.Plan;
import vue.VueGraphique;
import vue.VueTextuelle;

/**
 * 
 * @author Mario
 * Représente un état général de l'application
 * 
 */

public class Etat {
	

	protected VueGraphique vue;
	
	protected InterfaceController interfaceController;
	
	
	/**
	 * @param 
	 * 
	 */
	
	public Etat(InterfaceController interfaceController) {
		this.interfaceController = interfaceController;
	}
	

	public void chargerFichierPlan() {
		
		
	}
	
	public void chargerFichierRequetes() {
		
	}
	
	public void calculerItineraire() {
		
	}
	
	
	
}
