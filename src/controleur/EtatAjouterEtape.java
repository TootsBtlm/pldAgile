package controleur;


/**
 * 
 * @author Mario
 * Repr�sente l'�tat de l'application dans lequel l'utilisateur doit ajouter une �tape, qui h�rite de la classe Etat
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
	 * Fait appel � la m�thode chargerFichierPlan de l'objet interface controleur 
	 * 
	 */
	@Override
	public void chargerFichierPlan() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'etape avant");
	}

	/**
	 * 
	 * Fait appel � la m�thode chargerFichierRequetes de l'objet interface controleur 
	 * 
	 */
	@Override
	public void chargerFichierRequetes() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'etape avant");
	}

	/**
	 * 
	 * Fait appel � la m�thode calculerItineraire de l'objet interface controleur 
	 * 
	 */
	@Override
	public void calculerItineraire() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'etape avant");
	}
	
	/**
	 * 
	 * Fait appel � la m�thode ajouterEtape de l'objet interface controleur 
	 * 
	 */
	@Override
	public void ajouterEtape() {
		this.interfaceController.ajouterEtape();
	}
	
	/**
	 * 
	 * Fait appel � la m�thode supprimerEtape de l'objet interface controleur 
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
	 * Fait appel � la m�thode validerAjouterEtape de l'objet interface controleur 
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
