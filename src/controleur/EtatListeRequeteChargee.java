package controleur;

import modele.Intersection;
import modele.Itineraire;
import modele.Plan;

/**
 * 
 * @author Mario
 * Repr�sente l'�tat de l'application dans lequel la liste des requ�tes vient d'�tre charg�e, qui h�rite de la classe Etat
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
	 * Dans l'�tat liste requ�te charg�e, la m�thode ajouterEtape ne fait aucune action car aucun itin�raire n'est calcul�
	 * 
	 */
	public void ajouterEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord l'itin�raire");
	}
	
	/**
	 * 
	 * Dans l'�tat liste requ�te charg�e, la m�thode supprimerEtape ne fait aucune action car aucun itin�raire n'est calcul�
	 * 
	 */
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord l'itin�raire");
	}
	
	/**
	 * 
	 * Dans l'�tat initial, la m�thode feuilleDeRoute ne fait aucune action car aucun plan n'est charg�
	 * 
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Charger d'abord l'itin�raire");
	}
	
}
