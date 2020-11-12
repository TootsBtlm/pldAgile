package controleur;


import modele.Intersection;
import modele.Plan;

/**
 * 
 * @author Mario
 * Représente l'état de l'application dans lequel l'itinéraire vient d'être calculé, qui hérite de la classe Etat
 * 
 */


public class EtatItineraireCalcule extends Etat{
	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatItineraireCalcule(InterfaceController interfaceController) {
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
	 * Dans l'état itinéraire calculé, la méthode ajouterEtape ne fait aucune action 
	 * 
	 */
	public void ajouterEtape() {
		interfaceController.ajouterEtape();
	}

	/**
	 * 
	 * Dans l'état itinéraire calculé, la méthode supprimerEtape ne fait aucune action 
	 * 
	 */
	public void supprimerEtape() {
		interfaceController.setEtat(new EtatSupprimerEtape(interfaceController));
	}

	/**
	 * 
	 * Fait appel à la méthode feuilleDeRoute de l'objet interface controleur 
	 * 
	 */
	public void construireFeuilleDeRoute() {
		this.interfaceController.construireFeuilleDeRoute();
	}

}
