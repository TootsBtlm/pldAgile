package controleur;

/**
 * 
 * @author Hexanome4103
 * Représente l'état de l'application dans lequel la liste des requêtes vient d'être chargée, qui hérite de la classe Etat
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
	 * Fait appel à la méthode chargerFichierPlan de l'objet interfaceController
	 */
	@Override
	public void chargerFichierPlan() {
		this.interfaceController.chargerFichierPlan();
	}

	/**
	 * Fait appel à la méthode chargerFichierRequete de l'objet interfaceController
	 */
	@Override
	public void chargerFichierRequetes() {
		this.interfaceController.chargerFichierRequete();
	}

	/**
	 * Fait appel à la méthode calculerItineraire de l'objet interfaceController
	 */
	@Override
	public void calculerItineraire() {
		this.interfaceController.calculerItineraire();
	}

	/**
	 * Dans l'état liste requête chargée, la méthode ajouterEtape affiche un popup indiquant qu'il faut d'abord calculer l'itinéraire
	 */
	@Override
	public void ajouterEtape() {
		interfaceController.afficherPopupErreur("Calculer d'abord l'itinéraire");
	}
	
	/**
	 * Dans l'état liste requête chargée, la méthode supprimerEtape affiche un popup indiquant qu'il faut d'abord calculer l'itinéraire
	 */
	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Calculer d'abord l'itinéraire");
	}
	
	/**
	 * Dans l'état liste requête chargée, la méthode construireFeuilleDeRoute affiche un popup indiquant qu'il faut d'abord calculer l'itinéraire
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Calculer d'abord l'itinéraire");

	}
}
