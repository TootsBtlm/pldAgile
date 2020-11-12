package controleur;

import modele.Intersection;
import modele.Plan;

/**
 * 
 * @author Mario
 * Représente l'état de l'application dans lequel la feuille de route vient d'être générée, qui hérite de la classe Etat
 * 
 */

public class EtatFeuilleDeRoute extends Etat{
	
	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatFeuilleDeRoute(InterfaceController interfaceController) {
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
	 * Fait appel à la méthode chargerFichierRequetes de l'objet interface controleur 
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
	 * Dans l'état de la feuille de route générée, la méthode ajouterEtape ne fait aucune action 
	 * 
	 */
	public void ajouterEtape() {
		
	}
	
	/**
	 * 
	 * Dans l'état de la feuille de route générée, la méthode supprimerEtape ne fait aucune action 
	 * 
	 */
	public void supprimerEtape(Intersection inter) {
		
	}
	
	/**
	 * 
	 * Fait appel à la méthode construireFeuilleDeRoute de l'objet interface controleur 
	 * 
	 */
	public void construireFeuilleDeRoute() {
		System.out.println("test2");
		this.interfaceController.construireFeuilleDeRoute();
	}
	
}
