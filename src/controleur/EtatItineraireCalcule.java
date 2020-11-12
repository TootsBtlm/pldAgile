package controleur;


import modele.Intersection;
import modele.Plan;

/**
 * 
 * @author Mario
 * Repr�sente l'�tat de l'application dans lequel l'itin�raire vient d'�tre calcul�, qui h�rite de la classe Etat
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
	 * Fait appel � la m�thode chargerFichierPlan de l'objet interface controleur 
	 * 
	 */
	public void chargerFichierPlan() {
		this.interfaceController.chargerFichierPlan();
	}

	/**
	 * 
	 * Fait appel � la m�thode chargerFichierRequete de l'objet interface controleur 
	 * 
	 */
	public void chargerFichierRequetes() {

		this.interfaceController.chargerFichierRequete();

	}

	/**
	 * 
	 * Fait appel � la m�thode calculerItineraire de l'objet interface controleur 
	 * 
	 */
	public void calculerItineraire() {

		this.interfaceController.calculerItineraire();

	}

	/**
	 * 
	 * Dans l'�tat itin�raire calcul�, la m�thode ajouterEtape ne fait aucune action 
	 * 
	 */
	public void ajouterEtape() {
		interfaceController.ajouterEtape();
	}

	/**
	 * 
	 * Dans l'�tat itin�raire calcul�, la m�thode supprimerEtape ne fait aucune action 
	 * 
	 */
	public void supprimerEtape() {
		interfaceController.setEtat(new EtatSupprimerEtape(interfaceController));
	}

	/**
	 * 
	 * Fait appel � la m�thode feuilleDeRoute de l'objet interface controleur 
	 * 
	 */
	public void construireFeuilleDeRoute() {
		this.interfaceController.construireFeuilleDeRoute();
	}

}
