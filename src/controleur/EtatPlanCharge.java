package controleur;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import modele.Itineraire;

/**
 * 
 * @author Mario
 * Représente l'état de l'application suivant dans lequel le nouveau plan vient d'être chargé, qui hérite de l'état général
 * 
 */


public class EtatPlanCharge extends Etat {

	public void choisirFichierPlan(Canvas planCanvas, Pane requetePane, Canvas requeteCanvas) {
		super.choisirFichierPlan(planCanvas, requetePane, requeteCanvas);
	}

	public void calculerItineraire() {
		//super.calculerItineraire();
		System.out.println("Charger d'abord un plan");
	}
	
	public void choisirFichierRequetes() {
		//super.choisirFichierRequetes();
	}
}
