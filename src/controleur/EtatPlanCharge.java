package controleur;

import modele.Intersection;
import modele.Itineraire;
import modele.Plan;

/**
 * 
 * @author Mario
 * Repr�sente l'�tat de l'application suivant dans lequel le nouveau plan vient d'�tre charg�, qui h�rite de la classe Etat
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
	 * Dans l'�tat plan charg�, la m�thode calculerItineraire ne fait aucune action car aucun fichier de requ�tes n'est charg�
	 * 
	 */
	public void calculerItineraire() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requ�tes");
	}
	
	/**
	 * 
	 * Dans l'�tat plan charg�, la m�thode ajouterEtape ne fait aucune action car aucun fichier de requ�tes n'est charg�
	 * 
	 */
	public void ajouterEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requ�tes");
	}
	
	/**
	 * 
	 * Dans l'�tat plan charg�, la m�thode supprimerEtape ne fait aucune action car aucun fichier de requ�tes n'est charg�
	 * 
	 */
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requ�tes");
	}
	
	/**
	 * 
	 * Dans l'�tat initial, la m�thode feuilleDeRoute ne fait aucune action car aucun plan n'est charg�
	 * 
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requ�tes");
		System.out.println("Charger d'abord un plan");
	}
	
}
