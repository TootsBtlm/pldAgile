package controleur;

/**
 * 
 * @author Hexanome4103
 * Repr�sente l'�tat de l'application suivant dans lequel le nouveau plan vient d'�tre charg�, qui h�rite de la classe Etat
 * 
 */
public class EtatPlanCharge extends Etat {
	/**
	 * Constructeur
	 * @param interfaceController Objet InterfaceController
	 */
	public EtatPlanCharge(InterfaceController interfaceController) {
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
	 * Dans l'�tat plan charg�, la m�thode calculerItineraire affiche une popup indiquant qu'il faut d'abord charger un fichier de requ�tes
	 */
	@Override
	public void calculerItineraire() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requ�tes");
	}
	
	/**
	 * Dans l'�tat plan charg�, la m�thode ajouterEtape affiche une popup indiquant qu'il faut d'abord charger un fichier de requ�tes
	 */
	@Override
	public void ajouterEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requ�tes");
	}
	
	/**
	 * Dans l'�tat plan charg�, la m�thode supprimerEtape affiche une popup indiquant qu'il faut d'abord charger un fichier de requ�tes
	 */
	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requ�tes");
	}
	
	/**
	 * Dans l'�tat plan charg�, la m�thode construireFeuilleDeRoute affiche une popup indiquant qu'il faut d'abord charger un fichier de requ�tes
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Charger d'abord un fichier de requ�tes");
	}
}
