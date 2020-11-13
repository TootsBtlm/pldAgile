package controleur;

/**
 * 
 * @author Hexanome4103
 * Repr�sente l'�tat de l'application dans lequel l'utilisateur doit ajouter une �tape, qui h�rite de l'�tat g�n�ral
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
	 * M�thode surcharg�e pour afficher une popup d'erreur
	 */
	@Override
	public void chargerFichierPlan() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'�tape d'abord");
	}

	/**
	 * M�thode surcharg�e pour afficher une popup d'erreur
	 */
	@Override
	public void chargerFichierRequetes() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'�tape d'abord");
	}

	/**
	 * M�thode surcharg�e pour afficher une popup d'erreur
	 */
	@Override
	public void calculerItineraire() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'�tape d'abord");
	}

	/**
	 * M�thode surcharg�e pour afficher une popup d'erreur
	 */
	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'�tape d'abord");
	}

	/**
	 * M�thode surcharg�e pour afficher une popup d'erreur
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'�tape d'abord");
	}

	/**
	 * M�thode permettant de lancer la m�thode validerAjouterEtape de interfaceController
	 */
	@Override
	public void validerAjouterEtape() {
		interfaceController.validerAjouterEtape();
	}
}
