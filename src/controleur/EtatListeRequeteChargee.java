package controleur;

/**
 * 
 * @author Hexanome4103
 * Repr�sente l'�tat de l'application dans lequel la liste des requ�tes vient d'�tre charg�e, qui h�rite de la classe Etat
 * 
 */

public class EtatListeRequeteChargee extends Etat{
	/**
	 * Constructeur
	 * @param interfaceController Objet InterfaceController
	 */
	public EtatListeRequeteChargee(InterfaceController interfaceController) {
		super(interfaceController);
	}

	/**
	 * Fait appel � la m�thode chargerFichierPlan de l'objet interfaceController
	 */
	@Override
	public void chargerFichierPlan() {
		this.interfaceController.chargerFichierPlan();
	}

	/**
	 * Fait appel � la m�thode chargerFichierRequete de l'objet interfaceController
	 */
	@Override
	public void chargerFichierRequetes() {
		this.interfaceController.chargerFichierRequete();
	}

	/**
	 * Fait appel � la m�thode calculerItineraire de l'objet interfaceController
	 */
	@Override
	public void calculerItineraire() {
		this.interfaceController.calculerItineraire();
	}

	/**
	 * Dans l'�tat liste requ�te charg�e, la m�thode ajouterEtape affiche un popup indiquant qu'il faut d'abord calculer l'itin�raire
	 */
	@Override
	public void ajouterEtape() {
		interfaceController.afficherPopupErreur("Calculer d'abord l'itin�raire");
	}
	
	/**
	 * Dans l'�tat liste requ�te charg�e, la m�thode supprimerEtape affiche un popup indiquant qu'il faut d'abord calculer l'itin�raire
	 */
	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Calculer d'abord l'itin�raire");
	}
	
	/**
	 * Dans l'�tat liste requ�te charg�e, la m�thode construireFeuilleDeRoute affiche un popup indiquant qu'il faut d'abord calculer l'itin�raire
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Calculer d'abord l'itin�raire");

	}
}
