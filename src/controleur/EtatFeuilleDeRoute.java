package controleur;

import modele.Intersection;
import modele.Plan;

/**
 * 
 * @author Mario
 * Repr�sente l'�tat de l'application dans lequel la feuille de route vient d'�tre g�n�r�e, qui h�rite de la classe Etat
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
	 * Fait appel � la m�thode chargerFichierPlan de l'objet interface controleur 
	 * 
	 */
	public void chargerFichierPlan() {
		
		this.interfaceController.chargerFichierPlan();
		
	}

	/**
	 * 
	 * Fait appel � la m�thode chargerFichierRequetes de l'objet interface controleur 
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
	 * Dans l'�tat de la feuille de route g�n�r�e, la m�thode ajouterEtape ne fait aucune action 
	 * 
	 */
	public void ajouterEtape() {
		
	}
	
	/**
	 * 
	 * Dans l'�tat de la feuille de route g�n�r�e, la m�thode supprimerEtape ne fait aucune action 
	 * 
	 */
	public void supprimerEtape(Intersection inter) {
		
	}
	
	/**
	 * 
	 * Fait appel � la m�thode construireFeuilleDeRoute de l'objet interface controleur 
	 * 
	 */
	public void construireFeuilleDeRoute() {
		System.out.println("test2");
		this.interfaceController.construireFeuilleDeRoute();
	}
	
}
