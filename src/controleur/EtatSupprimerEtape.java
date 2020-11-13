package controleur;

/**
 * 
 * @author Hexanome4103
 * Représente l'état de l'application dans lequel l'utilisateur doit supprimer une etape, qui hérite de la classe Etat
 * 
 */

public class EtatSupprimerEtape extends Etat{

	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatSupprimerEtape(InterfaceController interfaceController) {
		super(interfaceController);
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
	 * Dans l'état initial, la méthode chargerFichierRequetes ne fait aucune action car aucun plan n'est chargé
	 * 
	 */
	@Override
	public void chargerFichierRequetes() {
		this.interfaceController.chargerFichierRequete();
	}


	/**
	 * 
	 * Dans l'état initial, la méthode calculerItineraire ne fait aucune action car aucun plan n'est chargé
	 * 
	 */
	@Override
	public void calculerItineraire() {
		this.interfaceController.calculerItineraire();
	}
	
	/**
	 * 
	 * Dans l'état supprimer étape, la méthode ajouterEtape ne fait aucune action car l'utilisateur n'a qu'une seule action possible
	 * 
	 */
	@Override
	public void ajouterEtape() {
		this.interfaceController.ajouterEtape();
	}
	
	/**
	 * 
	 * Dans l'état supprimer étape, la méthode supprimerEtape fait appel à la méthode supprimerEtape de l'interface controleur
	 * 
	 */
	@Override
	public void supprimerEtape() {
		this.interfaceController.setEtat(new EtatSupprimerEtape(this.interfaceController));
	}
	
	/**
	 * 
	 * Dans l'état supprimer étape, la méthode construireFeuilleDeRoute ne fait aucune action car l'utilisateur n'a qu'une seule action possible
	 * 
	 */
	@Override
	public void construireFeuilleDeRoute() {
		this.interfaceController.construireFeuilleDeRoute();
	}
	
}
