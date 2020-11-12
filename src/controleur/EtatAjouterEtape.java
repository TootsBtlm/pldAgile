package controleur;


/**
 * 
 * @author Mario
 * Représente l'état de l'application dans lequel l'utilisateur doit ajouter une étape, qui hérite de la classe Etat
 * 
 */


public class EtatAjouterEtape extends Etat{
	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatAjouterEtape(InterfaceController interfaceController) {
		super(interfaceController);
	}

	/**
	 * 
	 * Fait appel à la méthode chargerFichierPlan de l'objet interface controleur 
	 * 
	 */
	@Override
	public void chargerFichierPlan() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'etape avant");
	}

	/**
	 * 
	 * Fait appel à la méthode chargerFichierRequetes de l'objet interface controleur 
	 * 
	 */
	@Override
	public void chargerFichierRequetes() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'etape avant");
	}

	/**
	 * 
	 * Fait appel à la méthode calculerItineraire de l'objet interface controleur 
	 * 
	 */
	@Override
	public void calculerItineraire() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'etape avant");
	}
	
	/**
	 * 
	 * Fait appel à la méthode ajouterEtape de l'objet interface controleur 
	 * 
	 */
	@Override
	public void ajouterEtape() {
		this.interfaceController.ajouterEtape();
	}
	
	/**
	 * 
	 * Fait appel à la méthode supprimerEtape de l'objet interface controleur 
	 * 
	 */

	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'etape avant");
	}
	
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'etape avant");
	}
	
	/**
	 * 
	 * Fait appel à la méthode validerAjouterEtape de l'objet interface controleur 
	 * 
	 */
	@Override
	public void validerAjouterEtape() {
		this.interfaceController.validerAjouterEtape();
	}
	
	@Override
	public void ajouterPointRecuperation() {
		interfaceController.setEtat(new EtatAjouterPointRecuperation(interfaceController));
	}

	@Override
	public void ajouterPointLivraison() {
		interfaceController.setEtat(new EtatAjouterPointLivraison(interfaceController));
	}
	
	@Override
	public void ajouterPointPrecedentRecuperation() {
		interfaceController.setEtat(new EtatAjouterPointPrecedentRecuperation(interfaceController));
	}

	@Override
	public void ajouterPointPrecedentLivraison() {
		interfaceController.setEtat(new EtatAjouterPointPrecedentLivraison(interfaceController));
	}
}
