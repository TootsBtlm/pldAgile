package controleur;


import modele.Itineraire;
import modele.Plan;
import vue.VueGraphique;

/**
 * 
 * @author Mario
 * Représente l'état initial de l'application, qui hérite de l'état général
 * 
 */

public class EtatInitial extends Etat {

	public EtatInitial(InterfaceController interfaceController) {
		super(interfaceController);
	}

	public void chargerFichierPlan() {
		
		this.interfaceController.chargerFichierPlan();
		
	}

	
	public void chargerFichierRequetes() {
		System.out.println("Charger d'abord un plan");
	}

	public void calculerItineraire() {
		System.out.println("Charger d'abord un plan");
	}
	
}
