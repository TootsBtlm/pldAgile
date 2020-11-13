package controleur;

/**
 * 
 * @author Hexanome4103
 * Représente l'état de l'application dans lequel l'utilisateur doit ajouter un point précédent le nouveau point de livraison, qui hérite de l'état général
 * 
 */
public class EtatAjouterPointPrecedentLivraison extends Etat{

	/**
	 * Constructeur
	 * @param interfaceController Objet InterfaceController
	 */
	public EtatAjouterPointPrecedentLivraison(InterfaceController interfaceController) {
		super(interfaceController);
	}
	
	/**
	 * Méthode surchargée pour afficher une popup d'erreur indiquant que l'utilisateur doit terminer l'ajout d'étape
	 */
	@Override
	public void chargerFichierPlan() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}

	/**
	 * Méthode surchargée pour afficher une popup d'erreur indiquant que l'utilisateur doit terminer l'ajout d'étape
	 */
	@Override
	public void chargerFichierRequetes() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}

	/**
	 * Méthode surchargée pour afficher une popup d'erreur indiquant que l'utilisateur doit terminer l'ajout d'étape
	 */
	@Override
	public void calculerItineraire() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}
	
	/**
	 * Méthode surchargée pour afficher une popup d'erreur indiquant que l'utilisateur doit terminer l'ajout d'étape
	 */
	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}
	
	/**
	 * Méthode surchargée pour afficher une popup d'erreur indiquant que l'utilisateur doit terminer l'ajout d'étape
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}
	
	/**
	 * Méthode permettant d'appeler la méthode validerAjouterEtape d'interfaceController
	 */
	@Override
	public void validerAjouterEtape() {
		interfaceController.validerAjouterEtape();
	}
}