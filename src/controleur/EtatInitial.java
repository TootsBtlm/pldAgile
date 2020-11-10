package controleur;


import modele.Itineraire;
import modele.Plan;
import vue.VueGraphique;

/**
 * 
 * @author Mario et Jean-Jacques
 * Repr�sente l'�tat initial de l'application, qui h�rite de la classe �tat
 * 
 */

public class EtatInitial extends Etat {

	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatInitial(InterfaceController interfaceController) {
		super(interfaceController);
	}
	/**
	 * 
	 * Fait appel � chargerFichierPlan de l'objet interface controleur 
	 * 
	 */
	public void chargerFichierPlan() {
		
		this.interfaceController.chargerFichierPlan();
		
	}

	
	public void chargerFichierRequetes() {
		System.out.println("Charger d'abord un plan");
	}

	public void calculerItineraire() {
		System.out.println("Charger d'abord un plan");
	}
	
	public void ajouterEtape() {
		System.out.println("Charger d'abord un plan");
	}
	
	public void supprimerEtape() {
		System.out.println("Charger d'abord un plan");
	}
	
}
