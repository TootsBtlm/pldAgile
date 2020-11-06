package controleur;

import modele.Plan;

/**
 * 
 * @author Mario
 * Représente l'état de l'application dans lequel l'utilisateur doit supprimer une etape, qui hérite de l'état général
 * 
 */

public class EtatSupprimerEtape extends Etat{


	public EtatSupprimerEtape(InterfaceController interfaceController) {
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
