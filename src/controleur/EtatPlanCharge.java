package controleur;

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


	public void choisirFichierPlan() {
		
	
		
	}

	public void choisirFichierRequetes() {
		
		this.interfaceController.chargerFichierRequete();
	
	}
	
	public void calculerItineraire() {
		//super.calculerItineraire();
		System.out.println("Charger d'abord un plan");
	}
	
	
}
