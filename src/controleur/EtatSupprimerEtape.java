package controleur;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

/**
 * 
 * @author Mario
 * Repr�sente l'�tat de l'application dans lequel l'utilisateur doit supprimer une etape, qui h�rite de l'�tat g�n�ral
 * 
 */

public class EtatSupprimerEtape extends Etat{

	public void selectionFichierPlan(Canvas planCanvas, Pane requetePane, Canvas requeteCanvas) {
		super.selectionFichierPlan(planCanvas, requetePane, requeteCanvas);
	}
	
	public void calculerItineraire() {
		//super.calculerItineraire();
		System.out.println("Charger d'abord un plan");
	}
	
	public void choisirFichierRequetes() {
		//super.choisirFichierRequetes();
	}
}
