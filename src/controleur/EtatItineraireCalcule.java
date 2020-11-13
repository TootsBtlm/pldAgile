package controleur;


/**
 * 
 * @author Hexanome4103
 * Représente l'état de l'application dans lequel l'itinéraire vient d'être calculé, qui hérite de la classe Etat
 * 
 */


public class EtatItineraireCalcule extends Etat{
	/**
	 * Constructeur
	 * @param interfaceController Objet InterfaceController
	 */
	public EtatItineraireCalcule(InterfaceController interfaceController) {
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
	 * Fait appel à la méthode ajouterEtape de l'objet interfaceController
	 */
	@Override
	public void ajouterEtape() {
		interfaceController.ajouterEtape();
	}

	/**
	 * Dans l'état itinéraire calculé, la méthode supprimerEtape change l'état d'interfaceController
	 */
	@Override	
	public void supprimerEtape() {
		interfaceController.setEtat(new EtatSupprimerEtape(interfaceController));
	}

	/**
	 * Fait appel à la méthode construireFeuilleDeRoute de l'objet interfaceController
	 */		
	@Override
	public void construireFeuilleDeRoute() {
		this.interfaceController.construireFeuilleDeRoute();
	}
}
