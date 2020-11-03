package controleur;

import java.io.File;

import javafx.stage.FileChooser;
import modele.Lecteur;
import vue.VueGraphique;

/**
 * 
 * @author Mario
 * Représente un état général de l'application
 * 
 */

public class Etat {
	/**
	 * @param 
	 * @return ca return le temps qu'il faut pour aller de a a b
	 * 
	 */
	

	public void choisirFichierPlan() {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(this.stage);
		if(file != null) {
			String path = file.getPath();
			System.out.println(path);
			Lecteur lecteur = new Lecteur();
			this.plan = lecteur.LirePlan(path);
			this.vueGraphique = new VueGraphique();
			this.vueGraphique.drawPlan(this.plan, this.planCanvas);
		} else {
			System.out.println("Fichier incorrect");
		}
		
		//appel au constructeur test
		EtatListeRequeteChargee etattrois = new EtatListeRequeteChargee();
	}
	
	
	
	
}
