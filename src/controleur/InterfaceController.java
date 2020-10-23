package controleur;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modele.EnsembleRequete;
import modele.Lecteur;
import modele.Plan;
import tsp.TSP;
import tsp.TSP1;
import vue.VueGraphique;
import vue.VueTextuelle;

public class InterfaceController {


	@FXML
	private Canvas planCanvas;

	@FXML
	private Button btnOuvrirPlan;
	
	@FXML
	private ListView<String> listViewRequest;
	
	private Stage stage;
	private Plan plan;
	private EnsembleRequete ensembleRequete = null;
	private VueGraphique vueGraphique;

	private VueTextuelle vueTextuelle;
	
	private TSP tsp;


	@FXML
	public void initialize() {
		tsp = new TSP1();
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
			this.vueTextuelle = new VueTextuelle();
			this.vueTextuelle.drawText(er, this.listViewRequest);
			this.vueGraphique.drawRequests(er, this.plan, this.planCanvas);

			this.ensembleRequete = lecteur.LireRequete(path, this.plan);
			this.vueGraphique.drawRequests(this.ensembleRequete, this.plan, this.planCanvas);
		}
	}


	@FXML
	public void calculerItineraire() {
		if(this.vueGraphique == null) {
			System.out.println("Charger d'abord un plan");
		} 
		else if(this.ensembleRequete == null) {
			System.out.println("Charger d'abord une requête");
		}
		else {
//			int timeLimit = 30;
			/*
			tsp.searchSolution(timeLimit, cout, paires, depart);
			System.out.print("Solution of cost "+tsp.getSolutionCost()+" found in "
	                +(System.currentTimeMillis() - startTime)+"ms : ");
	        for (int i=0; i<nbVertices; i++)
	            System.out.print(tsp.getSolution(i)+" ");
	        System.out.println(depart);*/
			
			this.vueGraphique.drawItineraire(this.plan, this.planCanvas, itineraire);
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
