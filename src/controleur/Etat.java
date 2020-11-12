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
 * Représente la classe mère de tous les états
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
	 * Méthode surchargée sur chacune des classes filles de Etat
	 * 
	 */
	public void chargerFichierPlan() {
		
	}
	
	/**
	 * 
	 * Méthode surchargée sur chacune des classes filles de Etat
	 * 
	 */
	public void chargerFichierRequetes() {
		
	}
	
	/**
	 * 
	 * Méthode surchargée sur chacune des classes filles de Etat
	 * 
	 */
	public void calculerItineraire() {
		
	}
	
	/**
	 * 
	 * Méthode surchargée sur chacune des classes filles de Etat
	 * 
	 */
	public void ajouterEtape() {
		
	}
	
	/**
	 * 
	 * Méthode surchargée sur chacune des classes filles de Etat
	 * 
	 */
	public void supprimerEtape(Intersection inter) {
		
	}
	
	/**
	 * 
	 * Méthode surchargée sur chacune des classes filles de Etat
	 * 
	 */
	public void validerAjouterEtape() {
		
	}
	
	/**
	 * 
	 * Méthode surchargée sur chacune des classes filles de Etat
	 * 
	 */
	public void feuilleDeRoute() {
		
	}

	/**
	 * 
	 * Méthode surchargée sur chacune des classes filles de Etat
	 * 
	 */
	public void ajouterPointRecuperation() {
		
	}
	
}
