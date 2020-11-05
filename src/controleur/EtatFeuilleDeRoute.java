package controleur;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import modele.Plan;
import vue.VueGraphique;

/**
 * 
 * @author Mario
 * Représente l'état de l'application dans lequel la feuille de route vient d'être générée, qui hérite de l'état général
 * 
 */

public class EtatFeuilleDeRoute extends Etat{

	public VueGraphique choisirFichierPlan(Canvas planCanvas, Pane requetePane, Canvas requeteCanvas) {
		super.choisirFichierPlan(planCanvas, requetePane, requeteCanvas);
		return(super.vue);
	}

	
	public void calculerItineraire() {
		//super.calculerItineraire();
		System.out.println("Charger d'abord un plan");
	}
	
	public void choisirFichierRequetes() {
		//super.choisirFichierRequetes();
	}
}
