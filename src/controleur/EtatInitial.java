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

	public void choisirFichierPlan() {
		
		this.interfaceController.choisirFichierPlan();
		
	}


	public void calculerItineraire() {
		//super.calculerItineraire();
		System.out.println("Charger d'abord un plan");
	}
	
	public void choisirFichierRequetes() {
		//super.choisirFichierRequetes();
	}
	
}
