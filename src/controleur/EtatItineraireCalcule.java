package controleur;


/**
 * 
 * @author Hexanome4103
 * Repr�sente l'�tat de l'application dans lequel l'itin�raire vient d'�tre calcul�, qui h�rite de la classe Etat
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
	 * Fait appel � la m�thode ajouterEtape de l'objet interfaceController
	 */
	@Override
	public void ajouterEtape() {
		interfaceController.ajouterEtape();
	}

	/**
	 * Dans l'�tat itin�raire calcul�, la m�thode supprimerEtape change l'�tat d'interfaceController
	 */
	@Override	
	public void supprimerEtape() {
		interfaceController.setEtat(new EtatSupprimerEtape(interfaceController));
	}

	/**
	 * Fait appel � la m�thode construireFeuilleDeRoute de l'objet interfaceController
	 */		
	@Override
	public void construireFeuilleDeRoute() {
		this.interfaceController.construireFeuilleDeRoute();
	}
}
