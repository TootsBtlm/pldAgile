package controleur;

/**
 * 
 * @author Hexanome4103
 * Repr�sente l'�tat de l'application dans lequel l'utilisateur doit ajouter un point pr�c�dent le nouveau point de livraison, qui h�rite de l'�tat g�n�ral
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
	 * M�thode surcharg�e pour afficher une popup d'erreur indiquant que l'utilisateur doit terminer l'ajout d'�tape
	 */
	@Override
	public void chargerFichierPlan() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'�tape d'abord");
	}

	/**
	 * M�thode surcharg�e pour afficher une popup d'erreur indiquant que l'utilisateur doit terminer l'ajout d'�tape
	 */
	@Override
	public void chargerFichierRequetes() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'�tape d'abord");
	}

	/**
	 * M�thode surcharg�e pour afficher une popup d'erreur indiquant que l'utilisateur doit terminer l'ajout d'�tape
	 */
	@Override
	public void calculerItineraire() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'�tape d'abord");
	}
	
	/**
	 * M�thode surcharg�e pour afficher une popup d'erreur indiquant que l'utilisateur doit terminer l'ajout d'�tape
	 */
	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'�tape d'abord");
	}
	
	/**
	 * M�thode surcharg�e pour afficher une popup d'erreur indiquant que l'utilisateur doit terminer l'ajout d'�tape
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'�tape d'abord");
	}
	
	/**
	 * M�thode permettant d'appeler la m�thode validerAjouterEtape d'interfaceController
	 */
	@Override
	public void validerAjouterEtape() {
		interfaceController.validerAjouterEtape();
	}
}