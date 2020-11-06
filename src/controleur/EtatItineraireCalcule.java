package controleur;


import modele.Plan;

/**
 * 
 * @author Mario
 * Repr�sente l'�tat de l'application dans lequel l'itin�raire vient d'�tre calcul�, qui h�rite de l'�tat g�n�ral
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
