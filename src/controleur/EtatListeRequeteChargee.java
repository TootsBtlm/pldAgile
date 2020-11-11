package controleur;

import modele.Intersection;
import modele.Itineraire;
import modele.Plan;

/**
 * 
 * @author Mario
 * Représente l'état de l'application dans lequel la liste des requêtes vient d'être chargée, qui hérite de la classe Etat
 * 
 */

public class EtatListeRequeteChargee extends Etat{
	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatListeRequeteChargee(InterfaceController interfaceController) {
		super(interfaceController);
		// TODO Auto-generated constructor stub
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
	 * Fait appel à la méthode chargerFichierRequete de l'objet interface controleur 
	 * 
	 */
	public void chargerFichierRequetes() {
		
		this.interfaceController.chargerFichierRequete();
		
	}

	/**
	 * 
	 * Fait appel à la méthode calculerItineraire de l'objet interface controleur 
	 * 
	 */
	public void calculerItineraire() {
		
		this.interfaceController.calculerItineraire();
	
	}

	/**
	 * 
	 * Dans l'état liste requête chargée, la méthode ajouterEtape ne fait aucune action car aucun itinéraire n'est calculé
	 * 
	 */
	public void ajouterEtape() {
		System.out.println("Calculer d'abord l'itinéraire");
	}
	
	/**
	 * 
	 * Dans l'état liste requête chargée, la méthode supprimerEtape ne fait aucune action car aucun itinéraire n'est calculé
	 * 
	 */
	public void supprimerEtape(Intersection inter) {
		System.out.println("Charger d'abord l'itinéraire");
	}
	
	/**
	 * 
	 * Dans l'état liste requête chargée, la méthode feuilleDeRoute ne fait aucune action car aucun itinéraire n'est calculé
	 * 
	 */
	public void feuilleDeRoute() {
		System.out.println("Charger d'abord l'itinéraire");
	}
	
}
