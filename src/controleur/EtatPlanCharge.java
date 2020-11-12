package controleur;

import modele.Intersection;
import modele.Itineraire;
import modele.Plan;

/**
 * 
 * @author Mario
 * Représente l'état de l'application suivant dans lequel le nouveau plan vient d'être chargé, qui hérite de la classe Etat
 * 
 */


public class EtatPlanCharge extends Etat {
	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatPlanCharge(InterfaceController interfaceController) {
		super(interfaceController);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Fait appel à la méthode chargerFichierPlan de l'objet interface controleur 
	 * 
	 */
	@Override
	public void chargerFichierPlan() {
		
		this.interfaceController.chargerFichierPlan();
		
	}

	/**
	 * 
	 * Fait appel à la méthode chargerFichierRequete de l'objet interface controleur 
	 * 
	 */
	@Override
	public void chargerFichierRequetes() {
		
		this.interfaceController.chargerFichierRequete();
		
	}

	/**
	 * 
	 * Dans l'état plan chargé, la méthode calculerItineraire ne fait aucune action car aucun fichier de requêtes n'est chargé
	 * 
	 */
	@Override
	public void calculerItineraire() {
		System.out.println("Charger d'abord un fichier de requêtes");
	}
	
	/**
	 * 
	 * Dans l'état plan chargé, la méthode ajouterEtape ne fait aucune action car aucun fichier de requêtes n'est chargé
	 * 
	 */
	@Override
	public void ajouterEtape() {
		System.out.println("Charger d'abord un fichier de requêtes");
	}
	
	/**
	 * 
	 * Dans l'état plan chargé, la méthode supprimerEtape ne fait aucune action car aucun fichier de requêtes n'est chargé
	 * 
	 */
	@Override
	public void supprimerEtape(Intersection inter) {
		System.out.println("Charger d'abord un fichier de requêtes");
	}
	
	/**
	 * 
	 * Dans l'état liste requête chargée, la méthode construireFeuilleDeRoute ne fait aucune action car aucun itinéraire n'est calculé
	 * 
	 */
	@Override
	public void construireFeuilleDeRoute() {
		System.out.println("Charger d'abord l'itinéraire");
	}
	
}
