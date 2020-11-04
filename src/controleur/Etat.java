package controleur;

import java.io.File;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modele.EnsembleRequete;
import modele.Lecteur;
import modele.Plan;
import vue.VueGraphique;
import vue.VueTextuelle;

/**
 * 
 * @author Mario
 * Représente un état général de l'application
 * 
 */

public class Etat {
	
	private Stage stage;
	private Plan plan;
	private EnsembleRequete ensembleRequete = null;
	private VueGraphique vueGraphique;

	private VueTextuelle vueTextuelle;
	
	/**
	 * @param 
	 * @return ca return le temps qu'il faut pour aller de a a b
	 * 
	 */
	

	public void choisirFichierPlan(Canvas planCanvas, Pane requetePane, Canvas requeteCanvas) {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(this.stage);
		Circle c1 = new Circle();
		c1.setCenterX(1000);
		c1.setCenterY(1000);
		c1.setRadius(20);
		requetePane.getChildren().add(c1);
		if(file != null) {
			String path = file.getPath();
			System.out.println(path);
			Lecteur lecteur = new Lecteur();
			this.plan = lecteur.LirePlan(path);
			this.vueGraphique = new VueGraphique(this.plan, planCanvas, requeteCanvas);
			this.vueGraphique.drawPlan();
		} else {
			System.out.println("Fichier incorrect");
		}
		
	}
	
	
	
	
}
