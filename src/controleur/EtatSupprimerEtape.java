package controleur;

/**
 * 
 * @author Hexanome4103
 * Repr�sente l'�tat de l'application dans lequel l'utilisateur doit supprimer une etape, qui h�rite de la classe Etat
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
	 * Fait appel � la m�thode chargerFichierPlan de l'objet interface controleur 
	 * 
	 */
	@Override
	public void chargerFichierPlan() {
		
		this.interfaceController.chargerFichierPlan();
		
	}

	/**
	 * 
	 * Dans l'�tat initial, la m�thode chargerFichierRequetes ne fait aucune action car aucun plan n'est charg�
	 * 
	 */
	@Override
	public void chargerFichierRequetes() {
		this.interfaceController.chargerFichierRequete();
	}


	/**
	 * 
	 * Dans l'�tat initial, la m�thode calculerItineraire ne fait aucune action car aucun plan n'est charg�
	 * 
	 */
	@Override
	public void calculerItineraire() {
		this.interfaceController.calculerItineraire();
	}
	
	/**
	 * 
	 * Dans l'�tat supprimer �tape, la m�thode ajouterEtape ne fait aucune action car l'utilisateur n'a qu'une seule action possible
	 * 
	 */
	@Override
	public void ajouterEtape() {
		this.interfaceController.ajouterEtape();
	}
	
	/**
	 * 
	 * Dans l'�tat supprimer �tape, la m�thode supprimerEtape fait appel � la m�thode supprimerEtape de l'interface controleur
	 * 
	 */
	@Override
	public void supprimerEtape() {
		this.interfaceController.setEtat(new EtatSupprimerEtape(this.interfaceController));
	}
	
	/**
	 * 
	 * Dans l'�tat supprimer �tape, la m�thode construireFeuilleDeRoute ne fait aucune action car l'utilisateur n'a qu'une seule action possible
	 * 
	 */
	@Override
	public void construireFeuilleDeRoute() {
		this.interfaceController.construireFeuilleDeRoute();
	}
	
}
