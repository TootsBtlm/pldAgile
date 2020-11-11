package controleur;


import modele.Intersection;
import modele.Itineraire;
import modele.Plan;
import vue.VueGraphique;

/**
 * 
 * @author Mario et Jean-Jacques
 * Représente l'état initial de l'application, qui hérite de la classe Etat
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
	 * Fait appel à la méthode chargerFichierPlan de l'objet interface controleur 
	 * 
	 */
	public void chargerFichierPlan() {
		
		this.interfaceController.chargerFichierPlan();
		
	}

	/**
	 * 
	 * Dans l'état initial, la méthode chargerFichierRequetes ne fait aucune action car aucun plan n'est chargé
	 * 
	 */
	public void chargerFichierRequetes() {
		System.out.println("Charger d'abord un plan");
	}

	/**
	 * 
	 * Dans l'état initial, la méthode calculerItineraire ne fait aucune action car aucun plan n'est chargé
	 * 
	 */
	public void calculerItineraire() {
		System.out.println("Charger d'abord un plan");
	}
	
	/**
	 * 
	 * Dans l'état initial, la méthode ajouterEtape ne fait aucune action car aucun plan n'est chargé
	 * 
	 */
	public void ajouterEtape() {
		System.out.println("Charger d'abord un plan");
	}
	
	/**
	 * 
	 * Dans l'état initial, la méthode supprimerEtape ne fait aucune action car aucun plan n'est chargé
	 * 
	 */
	public void supprimerEtape(Intersection inter) {
		System.out.println("Charger d'abord un plan");
	}
	
	/**
	 * 
	 * Dans l'état initial, la méthode feuilleDeRoute ne fait aucune action car aucun plan n'est chargé
	 * 
	 */
	public void feuilleDeRoute() {
		System.out.println("Charger d'abord un plan");
	}
	
}
