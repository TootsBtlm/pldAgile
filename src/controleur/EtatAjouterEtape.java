package controleur;


/**
 * 
 * @author Hexanome4103
 * Représente l'état de l'application dans lequel l'utilisateur doit ajouter une étape, qui hérite de la classe Etat
 * 
 */
public class EtatAjouterEtape extends Etat{
	
	/**
	 * Constructeur
	 * @param interfaceController Objet InterfaceController
	 */
	public EtatAjouterEtape(InterfaceController interfaceController) {
		super(interfaceController);
	}

	/**
	 * Méthode surchargée pour afficher une popup d'erreur
	 */
	@Override
	public void chargerFichierPlan() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'etape avant");
	}

	/**
	 * Méthode surchargée pour afficher une popup d'erreur
	 */
	@Override
	public void chargerFichierRequetes() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'etape avant");
	}

	/**
	 * Méthode surchargée pour afficher une popup d'erreur
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
	 * Méthode surchargée pour afficher une popup d'erreur
	 */
	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'etape avant");
	}
	
	/**
	 * Méthode surchargée pour afficher une popup d'erreur
	 */
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
	
	/**
	 * Méthode permettant de changer l'état de l'interfaceController en EtatAjouterPointRecuperation
	 */
	@Override
	public void ajouterPointRecuperation() {
		interfaceController.setEtat(new EtatAjouterPointRecuperation(interfaceController));
	}

	/**
	 * Méthode permettant de changer l'état de l'interfaceController en EtatAjouterPointLivraison
	 */
	@Override
	public void ajouterPointLivraison() {
		interfaceController.setEtat(new EtatAjouterPointLivraison(interfaceController));
	}
	
	/**
	 * Méthode permettant de changer l'état de l'interfaceController en EtatAjouterPointPrecedentRecuperation
	 */
	@Override
	public void ajouterPointPrecedentRecuperation() {
		interfaceController.setEtat(new EtatAjouterPointPrecedentRecuperation(interfaceController));
	}

	/**
	 * Méthode permettant de changer l'état de l'interfaceController en EtatAjouterPointPrecedentLivraison
	 */
	@Override
	public void ajouterPointPrecedentLivraison() {
		interfaceController.setEtat(new EtatAjouterPointPrecedentLivraison(interfaceController));
	}
}
