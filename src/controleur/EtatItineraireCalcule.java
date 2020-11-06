package controleur;


import modele.Plan;

/**
 * 
 * @author Mario
 * Représente l'état de l'application dans lequel l'itinéraire vient d'être calculé, qui hérite de l'état général
 * 
 */


public class EtatItineraireCalcule extends Etat{

	public EtatItineraireCalcule(InterfaceController interfaceController) {
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
	
}
