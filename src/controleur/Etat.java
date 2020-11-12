package controleur;

import java.io.File;

import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modele.EnsembleRequete;
import modele.Intersection;
import modele.Lecteur;
import modele.Plan;
import vue.VueGraphique;
import vue.VueTextuelle;

/**
 * 
 * @author Mario
 * Repr�sente la classe m�re de tous les �tats
 * 
 */

public abstract class Etat {
	

	protected VueGraphique vue;
	
	protected InterfaceController interfaceController;
	
	
	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	
	public Etat(InterfaceController interfaceController) {
		this.interfaceController = interfaceController;
	}
	
	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void chargerFichierPlan() {
		
	}
	
	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void chargerFichierRequetes() {
		
	}
	
	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void calculerItineraire() {
		
	}
	
	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void ajouterEtape() {
		
	}
	
	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void supprimerEtape(Intersection inter) {
		
	}
	
	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void validerAjouterEtape() {
		
	}
	
	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void feuilleDeRoute() {
		
	}

	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void ajouterPointRecuperation() {
		
	}
	
}
