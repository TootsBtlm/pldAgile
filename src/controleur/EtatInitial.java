package controleur;


/**
 * 
 * @author Hexanome4103
 * Représente l'état initial de l'application, qui hérite de la classe Etat
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
	 * Fait appel à la méthode chargerFichierPlan de l'objet interfaceController
	 */
	@Override
	public void chargerFichierPlan() {
		this.interfaceController.chargerFichierPlan();
	}

	/**
	 * Dans l'état initial, la méthode chargerFichierRequetes affiche une popup indiquant qu'il faut d'abord charger un plan
	 */
	@Override
	public void chargerFichierRequetes() {
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
	}

	/**
	 * Dans l'état initial, la méthode calculerItineraire affiche une popup indiquant qu'il faut d'abord charger un plan
	 */
	@Override
	public void calculerItineraire() {
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
	}
	
	/**
	 * Dans l'état initial, la méthode ajouterEtape affiche une popup indiquant qu'il faut d'abord charger un plan
	 */
	@Override
	public void ajouterEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
	}
	
	/**
	 * Dans l'état initial, la méthode supprimerEtape affiche une popup indiquant qu'il faut d'abord charger un plan
	 */
	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
	}
	
	/**
	 * Dans l'état initial, la méthode construireFeuilleDeRoute affiche une popup indiquant qu'il faut d'abord charger un plan
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
	}
	
}
