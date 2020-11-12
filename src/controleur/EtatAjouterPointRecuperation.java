package controleur;


import modele.Intersection;
import modele.Plan;

/**
 * 
 * @author Mario
 * Représente l'état de l'application dans lequel l'utilisateur doit ajouter une étape, qui hérite de l'état général
 * 
 */


public class EtatAjouterPointRecuperation extends Etat{

	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatAjouterPointRecuperation(InterfaceController interfaceController) {
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
	 * Fait appel à la méthode chargerFichierRequetes de l'objet interface controleur 
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
	 * Fait appel à la méthode ajouterEtape de l'objet interface controleur 
	 * 
	 */
	@Override
	public void ajouterEtape() {
	}
	
	/**
	 * 
	 * Fait appel à la méthode supprimerEtape de l'objet interface controleur 
	 * 
	 */
	@Override
	public void supprimerEtape(Intersection inter) {
	}
	
	/**
	 * 
	 * Fait appel à la méthode construireFeuilleDeRoute de l'objet interface controleur 
	 * 
	 */
	@Override
	public void construireFeuilleDeRoute() {
		
	}
	
	/**
	 * 
	 * Fait appel à la méthode validerAjouterEtape de l'objet interface controleur 
	 * 
	 */
	@Override
	public void validerAjouterEtape() {
		interfaceController.validerAjouterEtape();
	}
	
	/**
	 * 
	 * Dans l'état initial, la méthode ajouterPointRecuperation ne fait aucune action 
	 * 
	 */
	@Override
	public void ajouterPointRecuperation() {
	}
	
}
