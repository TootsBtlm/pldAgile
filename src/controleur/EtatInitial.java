package controleur;


/**
 * 
 * @author Hexanome4103
 * Repr�sente l'�tat initial de l'application, qui h�rite de la classe Etat
 * 
 */
public class EtatInitial extends Etat {

	/**
	 * Constructeur
	 * @param interfaceController Objet InterfaceController
	 */
	public EtatInitial(InterfaceController interfaceController) {
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
	 * Dans l'�tat initial, la m�thode chargerFichierRequetes affiche une popup indiquant qu'il faut d'abord charger un plan
	 */
	@Override
	public void chargerFichierRequetes() {
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
	}

	/**
	 * Dans l'�tat initial, la m�thode calculerItineraire affiche une popup indiquant qu'il faut d'abord charger un plan
	 */
	@Override
	public void calculerItineraire() {
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
	}
	
	/**
	 * Dans l'�tat initial, la m�thode ajouterEtape affiche une popup indiquant qu'il faut d'abord charger un plan
	 */
	@Override
	public void ajouterEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
	}
	
	/**
	 * Dans l'�tat initial, la m�thode supprimerEtape affiche une popup indiquant qu'il faut d'abord charger un plan
	 */
	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
	}
	
	/**
	 * Dans l'�tat initial, la m�thode construireFeuilleDeRoute affiche une popup indiquant qu'il faut d'abord charger un plan
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
	}
	
}
