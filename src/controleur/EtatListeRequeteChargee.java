package controleur;

import modele.Itineraire;
import modele.Plan;

/**
 * 
 * @author Mario
 * Représente l'éta de l'application dans lequel la liste des requêtes vient d'être chargée, qui hérite de l'état général
 * 
 */

public class EtatListeRequeteChargee extends Etat{
	
	public EtatListeRequeteChargee(InterfaceController interfaceController) {
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
		
		this.interfaceController.calculerItineraire();
	
	}

	public void ajouterEtape() {
		System.out.println("Calculer d'abord l'itinéraire");
	}
	
	public void supprimerEtape() {
		System.out.println("Charger d'abord l'itinéraire");
	}
	
	public void feuilleDeRoute() {
		System.out.println("Charger d'abord l'itinéraire");
	}
	
}
