package controleur;


import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import modele.Itineraire;
import modele.Plan;
import vue.VueGraphique;

/**
 * 
 * @author Mario
 * Repr�sente l'�tat initial de l'application, qui h�rite de l'�tat g�n�ral
 * 
 */

public class EtatInitial extends Etat {

	public VueGraphique choisirFichierPlan(Canvas planCanvas, Pane requetePane, Canvas requeteCanvas) {
		
		return(super.choisirFichierPlan(planCanvas, requetePane, requeteCanvas));
	}


	public void calculerItineraire() {
		//super.calculerItineraire();
		System.out.println("Charger d'abord un plan");
	}
	
	public void choisirFichierRequetes() {
		//super.choisirFichierRequetes();
	}
	
}
