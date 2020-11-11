package controleur;


import modele.Intersection;
import modele.Itineraire;
import modele.Plan;
import vue.VueGraphique;

/**
 * 
 * @author Mario et Jean-Jacques
 * Représente l'état initial de l'application, qui hérite de la classe état
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
	 * Fait appel à chargerFichierPlan de l'objet interface controleur 
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
	
	public void supprimerEtape(Intersection inter) {
		System.out.println("Charger d'abord un plan");
	}
	
	public void feuilleDeRoute() {
		System.out.println("Charger d'abord un plan");
	}
	
}
