package controleur;

import modele.Intersection;
import modele.Itineraire;
import modele.Plan;

/**
 * 
 * @author Mario
 * Représente l'état de l'application suivant dans lequel le nouveau plan vient d'être chargé, qui hérite de l'état général
 * 
 */


public class EtatPlanCharge extends Etat {

	public EtatPlanCharge(InterfaceController interfaceController) {
		super(interfaceController);
		// TODO Auto-generated constructor stub
	}


	public void chargerFichierPlan() {
		
		this.interfaceController.chargerFichierPlan();
		
	}

	public void chargerFichierRequetes() {
		
		this.interfaceController.chargerFichierRequete();
		
	}

	public void calculerItineraire() {
		System.out.println("Charger d'abord un fichier de requêtes");
	}
	
	public void ajouterEtape() {
		System.out.println("Charger d'abord un fichier de requêtes");
	}
	
	public void supprimerEtape(Intersection inter) {
		System.out.println("Charger d'abord un fichier de requêtes");
	}
	
	public void feuilleDeRoute() {
		System.out.println("Charger d'abord un fichier de requêtes");
	}
	
}
