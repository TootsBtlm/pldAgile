package controleur;


import modele.Intersection;
import modele.Plan;

/**
 * 
 * @author Mario
 * Repr�sente l'�tat de l'application dans lequel l'utilisateur doit ajouter une �tape, qui h�rite de la classe Etat
 * 
 */


public class EtatAjouterEtape extends Etat{
	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatAjouterEtape(InterfaceController interfaceController) {
		super(interfaceController);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Fait appel � la m�thode chargerFichierPlan de l'objet interface controleur 
	 * 
	 */
	
	public void chargerFichierPlan() {
		
		this.interfaceController.chargerFichierPlan();
		
	}

	/**
	 * 
	 * Fait appel � la m�thode chargerFichierRequetes de l'objet interface controleur 
	 * 
	 */
	
	public void chargerFichierRequetes() {
		
		this.interfaceController.chargerFichierRequete();
		
	}

	/**
	 * 
	 * Fait appel � la m�thode calculerItineraire de l'objet interface controleur 
	 * 
	 */
	
	public void calculerItineraire() {
		
		this.interfaceController.calculerItineraire();
	
	}
	
	/**
	 * 
	 * Fait appel � la m�thode ajouterEtape de l'objet interface controleur 
	 * 
	 */
	
	public void ajouterEtape() {
		this.interfaceController.ajouterEtape();
	}
	
	/**
	 * 
	 * Fait appel � la m�thode supprimerEtape de l'objet interface controleur 
	 * 
	 */
	
	public void supprimerEtape() {
		
	}
	
	public void feuilleDeRoute() {
		
	}
	
	public void validerAjouterEtape() {
		this.interfaceController.validerAjouterEtape();
	}
	
	public void ajouterPointRecuperation() {
		interfaceController.setEtat(new EtatAjouterPointRecuperation(interfaceController));
	}

	public void ajouterPointLivraison() {
		interfaceController.setEtat(new EtatAjouterPointLivraison(interfaceController));
	}
	
	public void ajouterPointPrecedentRecuperation() {
		interfaceController.setEtat(new EtatAjouterPointPrecedentRecuperation(interfaceController));
	}

	public void ajouterPointPrecedentLivraison() {
		interfaceController.setEtat(new EtatAjouterPointPrecedentLivraison(interfaceController));
	}
}
