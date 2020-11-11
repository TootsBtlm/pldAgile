package controleur;

import modele.Intersection;
import modele.Plan;

/**
 * 
 * @author Mario
 * Repr�sente l'�tat de l'application dans lequel l'utilisateur doit supprimer une etape, qui h�rite de la classe Etat
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
	 * Dans l'�tat supprimer �tape, la m�thode chargerFichierPlan ne fait aucune action car l'utilisateur n'a qu'une seule action possible
	 * 
	 */
	public void chargerFichierPlan() {
		
	}

	/**
	 * 
	 * Dans l'�tat supprimer �tape, la m�thode chargerFichierRequetes ne fait aucune action car l'utilisateur n'a qu'une seule action possible
	 * 
	 */
	public void chargerFichierRequetes() {
		
	}

	/**
	 * 
	 * Dans l'�tat supprimer �tape, la m�thode calculerItineraire ne fait aucune action car l'utilisateur n'a qu'une seule action possible
	 * 
	 */
	public void calculerItineraire() {
	
	}
	
	/**
	 * 
	 * Dans l'�tat supprimer �tape, la m�thode ajouterEtape ne fait aucune action car l'utilisateur n'a qu'une seule action possible
	 * 
	 */
	public void ajouterEtape() {
		
	}
	
	public void supprimerEtape(Intersection inter) {
		this.interfaceController.supprimerEtape(inter);
	}
	
	/**
	 * 
	 * Dans l'�tat supprimer �tape, la m�thode feuilleDeRoute ne fait aucune action car l'utilisateur n'a qu'une seule action possible
	 * 
	 */
	public void feuilleDeRoute() {
		
	}
	
}
