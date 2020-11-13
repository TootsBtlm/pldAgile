package controleur;

/**
 * 
 * @author Hexanome4103
 * Représente l'état de l'application suivant dans lequel le nouveau plan vient d'être chargé, qui hérite de la classe Etat
 * 
 */
public class EtatPlanCharge extends Etat {
	/**
	 * Constructeur
	 * @param interfaceController Objet InterfaceController
	 */
	public EtatPlanCharge(InterfaceController interfaceController) {
		super(interfaceController);
	}

	/**
	 * Fait appel à la méthode chargerFichierPlan de l'objet interfaceController
	 */
	@Override
	public void chargerFichierPlan() {
		this.interfaceController.chargerFichierPlan();
	}

	/**
	 * Fait appel à la méthode chargerFichierRequete de l'objet interfaceController
	 */
	@Override
	public void chargerFichierRequetes() {
		this.interfaceController.chargerFichierRequete();
	}

	/**
	 * Dans l'état plan chargé, la méthode calculerItineraire affiche une popup indiquant qu'il faut d'abord charger un fichier de requêtes
	 */
	@Override
	public void calculerItineraire() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requêtes");
	}
	
	/**
	 * Dans l'état plan chargé, la méthode ajouterEtape affiche une popup indiquant qu'il faut d'abord charger un fichier de requêtes
	 */
	@Override
	public void ajouterEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requêtes");
	}
	
	/**
	 * Dans l'état plan chargé, la méthode supprimerEtape affiche une popup indiquant qu'il faut d'abord charger un fichier de requêtes
	 */
	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requêtes");
	}
	
	/**
	 * Dans l'état plan chargé, la méthode construireFeuilleDeRoute affiche une popup indiquant qu'il faut d'abord charger un fichier de requêtes
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requêtes");
	}
}
