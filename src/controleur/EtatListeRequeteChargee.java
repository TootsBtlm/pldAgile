package controleur;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import modele.Itineraire;

/**
 * 
 * @author Mario
 * Repr�sente l'�ta de l'application dans lequel la liste des requ�tes vient d'�tre charg�e, qui h�rite de l'�tat g�n�ral
 * 
 */

public class EtatListeRequeteChargee extends Etat{
	
	public void choisirFichierPlan(Canvas planCanvas, Pane requetePane, Canvas requeteCanvas) {
		super.choisirFichierPlan(planCanvas, requetePane, requeteCanvas);
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
