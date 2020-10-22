package vue;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modele.EnsembleRequete;
import modele.Lecteur;
import modele.Plan;

public class InterfaceController {


	@FXML
	private Canvas planCanvas;

	@FXML
	private Button btnOuvrirPlan;
	
	private Stage stage;
	private Plan plan;
	private VueGraphique vueGraphique;


	@FXML
	public void initialize() {
	}
	
	@FXML
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
		
	}
	
	@FXML
	public void choisirFichierRequetes() {
		if(this.vueGraphique == null) {
			System.out.println("Charger d'abord un plan");
		} else {
			FileChooser fileChooser = new FileChooser();
			File file = fileChooser.showOpenDialog(this.stage);
			String path = file.getPath();
			System.out.println(path);
			Lecteur lecteur = new Lecteur();
			EnsembleRequete er = lecteur.LireRequete(path, this.plan);
			this.vueGraphique.drawRequests(er, this.plan, this.planCanvas);
		}
	}


	public void drawLine() {
		var gc = this.planCanvas.getGraphicsContext2D();

		gc.beginPath();
		gc.moveTo(this.planCanvas.getWidth(), 0);
		gc.lineTo(30.5, 30.5);
		gc.stroke();
	}

	
	
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
