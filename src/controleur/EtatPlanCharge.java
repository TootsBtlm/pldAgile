package controleur;

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
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requêtes");
	}
	
	/**
	 * 
	 * Dans l'état plan chargé, la méthode ajouterEtape ne fait aucune action car aucun fichier de requêtes n'est chargé
	 * 
	 */
	@Override
	public void ajouterEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requêtes");
	}
	
	/**
	 * 
	 * Dans l'état plan chargé, la méthode supprimerEtape ne fait aucune action car aucun fichier de requêtes n'est chargé
	 * 
	 */
	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requêtes");
	}
	
	/**
	 * 
	 * Dans l'état plan chargée, la méthode construireFeuilleDeRoute ne fait aucune action car aucun itinéraire n'est calculé
	 * 
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requêtes");
	}
	
}
