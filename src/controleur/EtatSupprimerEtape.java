package controleur;

import modele.Intersection;
import modele.Plan;

/**
 * 
 * @author Mario
 * Représente l'état de l'application dans lequel l'utilisateur doit supprimer une etape, qui hérite de la classe Etat
 * 
 */

public class EtatSupprimerEtape extends Etat{

	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatSupprimerEtape(InterfaceController interfaceController) {
		super(interfaceController);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Dans l'état supprimer étape, la méthode chargerFichierPlan ne fait aucune action car l'utilisateur n'a qu'une seule action possible
	 * 
	 */
	public void chargerFichierPlan() {
		
	}

	/**
	 * 
	 * Dans l'état supprimer étape, la méthode chargerFichierRequetes ne fait aucune action car l'utilisateur n'a qu'une seule action possible
	 * 
	 */
	public void chargerFichierRequetes() {
		
	}

	/**
	 * 
	 * Dans l'état supprimer étape, la méthode calculerItineraire ne fait aucune action car l'utilisateur n'a qu'une seule action possible
	 * 
	 */
	public void calculerItineraire() {
	
	}
	
	/**
	 * 
	 * Dans l'état supprimer étape, la méthode ajouterEtape ne fait aucune action car l'utilisateur n'a qu'une seule action possible
	 * 
	 */
	public void ajouterEtape() {
		
	}
	
	public void supprimerEtape(Intersection inter) {
		this.interfaceController.supprimerEtape(inter);
	}
	
	/**
	 * 
	 * Dans l'état supprimer étape, la méthode feuilleDeRoute ne fait aucune action car l'utilisateur n'a qu'une seule action possible
	 * 
	 */
	public void feuilleDeRoute() {
		
	}
	
}
