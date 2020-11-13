package controleur;

/**
 * 
 * @author Hexanome4103
 * Représente l'état de l'application dans lequel l'utilisateur doit ajouter une étape, qui hérite de l'état général
 * 
 */

public class EtatAjouterPointLivraison extends Etat{

	/**
	 * Constructeur de EtatAjouterPointLivraison
	 * @param interfaceController Objet InterfaceController
	 */
	public EtatAjouterPointLivraison(InterfaceController interfaceController) {
		super(interfaceController);
	}
	
	/**
	 * Méthode surchargée pour afficher une popup d'erreur
	 */
	@Override
	public void chargerFichierPlan() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}

	/**
	 * Méthode surchargée pour afficher une popup d'erreur
	 */
	@Override
	public void chargerFichierRequetes() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}

	/**
	 * Méthode surchargée pour afficher une popup d'erreur
	 */
	@Override
	public void calculerItineraire() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}

	/**
	 * Méthode surchargée pour afficher une popup d'erreur
	 */
	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}

	/**
	 * Méthode surchargée pour afficher une popup d'erreur
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'étape d'abord");
	}

	/**
	 * Méthode permettant de lancer la méthode validerAjouterEtape de interfaceController
	 */
	@Override
	public void validerAjouterEtape() {
		interfaceController.validerAjouterEtape();
	}
}
