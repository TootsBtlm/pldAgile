package controleur;


/**
 * 
 * @author Hexanome4103
 * Repr�sente l'�tat de l'application dans lequel l'utilisateur doit ajouter une �tape, qui h�rite de la classe Etat
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
	 * M�thode surcharg�e pour afficher une popup d'erreur
	 */
	@Override
	public void chargerFichierPlan() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'etape avant");
	}

	/**
	 * M�thode surcharg�e pour afficher une popup d'erreur
	 */
	@Override
	public void chargerFichierRequetes() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'etape avant");
	}

	/**
	 * M�thode surcharg�e pour afficher une popup d'erreur
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
	 * M�thode surcharg�e pour afficher une popup d'erreur
	 */
	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Terminer l'ajout d'etape avant");
	}
	
	/**
	 * M�thode surcharg�e pour afficher une popup d'erreur
	 */
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
	
	/**
	 * M�thode permettant de changer l'�tat de l'interfaceController en EtatAjouterPointRecuperation
	 */
	@Override
	public void ajouterPointRecuperation() {
		interfaceController.setEtat(new EtatAjouterPointRecuperation(interfaceController));
	}

	/**
	 * M�thode permettant de changer l'�tat de l'interfaceController en EtatAjouterPointLivraison
	 */
	@Override
	public void ajouterPointLivraison() {
		interfaceController.setEtat(new EtatAjouterPointLivraison(interfaceController));
	}
	
	/**
	 * M�thode permettant de changer l'�tat de l'interfaceController en EtatAjouterPointPrecedentRecuperation
	 */
	@Override
	public void ajouterPointPrecedentRecuperation() {
		interfaceController.setEtat(new EtatAjouterPointPrecedentRecuperation(interfaceController));
	}

	/**
	 * M�thode permettant de changer l'�tat de l'interfaceController en EtatAjouterPointPrecedentLivraison
	 */
	@Override
	public void ajouterPointPrecedentLivraison() {
		interfaceController.setEtat(new EtatAjouterPointPrecedentLivraison(interfaceController));
	}
}
