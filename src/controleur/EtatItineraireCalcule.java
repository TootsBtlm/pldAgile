package controleur;


import modele.Intersection;
import modele.Plan;

/**
 * 
 * @author Mario
 * Représente l'état de l'application dans lequel l'itinéraire vient d'être calculé, qui hérite de la classe Etat
 * 
 */


public class EtatItineraireCalcule extends Etat{
	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatItineraireCalcule(InterfaceController interfaceController) {
		super(interfaceController);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Fait appel à la méthode chargerFichierPlan de l'objet interface controleur 
	 * 
	 */
	public void chargerFichierPlan() {
		
		this.interfaceController.chargerFichierPlan();
		
	}

	
	public void chargerFichierRequetes() {
		
		this.interfaceController.chargerFichierRequete();
		
	}

	public void calculerItineraire() {
		
		this.interfaceController.calculerItineraire();
	
	}
	
	public void ajouterEtape() {
		this.interfaceController.ajouterEtape();
	}
	
	public void supprimerEtape(Intersection inter) {
		this.interfaceController.supprimerEtape(inter);
	}
	
	public void feuilleDeRoute() {
		
	}
	
}
