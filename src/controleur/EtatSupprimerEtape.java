package controleur;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

/**
 * 
 * @author Mario
 * Représente l'état de l'application dans lequel l'utilisateur doit supprimer une etape, qui hérite de l'état général
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
