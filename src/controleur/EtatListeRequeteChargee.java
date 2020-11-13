package controleur;

/**
 * 
 * @author Hexanome4103
 * Représente l'état de l'application dans lequel la liste des requêtes vient d'être chargée, qui hérite de la classe Etat
 * 
 */

public class EtatListeRequeteChargee extends Etat{
	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatListeRequeteChargee(InterfaceController interfaceController) {
		super(interfaceController);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Fait appel à la méthode chargerFichierPlan de l'objet interface controleur 
	 * 
	 */
	@Override
	public void chargerFichierPlan() {
		
		this.interfaceController.chargerFichierPlan();
		
	}

	/**
	 * 
	 * Fait appel à la méthode chargerFichierRequete de l'objet interface controleur 
	 * 
	 */
	@Override
	public void chargerFichierRequetes() {
		
		this.interfaceController.chargerFichierRequete();
		
	}

	/**
	 * 
	 * Fait appel à la méthode calculerItineraire de l'objet interface controleur 
	 * 
	 */
	@Override
	public void calculerItineraire() {
		
		this.interfaceController.calculerItineraire();
	
	}

	/**
	 * 
	 * Dans l'état liste requête chargée, la méthode ajouterEtape ne fait aucune action car aucun itinéraire n'est calculé
	 * 
	 */
	@Override
	public void ajouterEtape() {
		interfaceController.afficherPopupErreur("Calculer d'abord l'itinéraire");
	}
	
	/**
	 * 
	 * Dans l'état liste requête chargée, la méthode supprimerEtape ne fait aucune action car aucun itinéraire n'est calculé
	 * 
	 */

		

	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Calculer d'abord l'itinéraire");
		System.out.println("Calculer d'abord l'itinéraire");
	}
	
	/**
	 * Dans l'état liste requête chargée, la méthode construireFeuilleDeRoute ne fait aucune action car aucun itinéraire n'est calculé
	 * 
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Calculer d'abord l'itinéraire");

	}
	
}
