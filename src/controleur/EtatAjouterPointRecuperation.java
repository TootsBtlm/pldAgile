package controleur;

/**
 * 
 * @author Mario
 * Représente l'état de l'application dans lequel l'utilisateur doit ajouter une étape, qui hérite de l'état général
 * 
 */


public class EtatAjouterPointRecuperation extends Etat{

	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatAjouterPointRecuperation(InterfaceController interfaceController) {
		super(interfaceController);
	}

	/**
	 * 
	 * Fait appel à la méthode chargerFichierPlan de l'objet interface controleur 
	 * 
	 */
	@Override
	public void chargerFichierPlan() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}

	/**
	 * 
	 * Fait appel à la méthode chargerFichierRequetes de l'objet interface controleur 
	 * 
	 */
	@Override
	public void chargerFichierRequetes() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}

	/**
	 * 
	 * Fait appel à la méthode calculerItineraire de l'objet interface controleur 
	 * 
	 */
	@Override
	public void calculerItineraire() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}
	
	/**
	 * 
	 * Fait appel à la méthode ajouterEtape de l'objet interface controleur 
	 * 
	 */
	@Override
	public void ajouterEtape() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}
	
	/**
	 * 
	 * Fait appel à la méthode supprimerEtape de l'objet interface controleur 
	 * 
	 */
	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}
	
	/**
	 * 
	 * Fait appel à la méthode construireFeuilleDeRoute de l'objet interface controleur 
	 * 
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}
	
	/**
	 * 
	 * Fait appel à la méthode validerAjouterEtape de l'objet interface controleur 
	 * 
	 */
	@Override
	public void validerAjouterEtape() {
		interfaceController.validerAjouterEtape();
	}
}
