package controleur;

import modele.Itineraire;
import modele.Plan;

/**
 * 
 * @author Mario
 * Repr�sente l'�ta de l'application dans lequel la liste des requ�tes vient d'�tre charg�e, qui h�rite de l'�tat g�n�ral
 * 
 */

public class EtatListeRequeteChargee extends Etat{
	
	public EtatListeRequeteChargee(InterfaceController interfaceController) {
		super(interfaceController);
		// TODO Auto-generated constructor stub
	}


	public void choisirFichierPlan() {
		

		
	}

	
	public void calculerItineraire() {
		//super.calculerItineraire();
		//Itineraire itineraire = plan.getMatriceCout(this.ensembleRequete);
		//this.vueGraphique.drawItineraire(this.plan, this.planCanvas, itineraire);
	}

	public void choisirFichierRequetes() {
		//super.choisirFichierRequetes();
	}

}
