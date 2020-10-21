package vue;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modele.Depot;
import modele.EnsembleRequete;
import modele.Intersection;
import modele.Lecteur;
import modele.Plan;
import modele.Requete;
import modele.Segment;

public class UiController {


	@FXML
	private Canvas planCanvas;

	@FXML
	private Button btnOuvrirPlan;
	
	private Stage stage;


	@FXML
	public void initialize() {
	}
	
	@FXML
	public void choisirFichierPlan() {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(this.stage);
		String path = file.getPath();
		System.out.println(path);
		Lecteur lecteur = new Lecteur();
		Plan p = lecteur.LirePlan(path);
		this.drawPlan(p);
	}


	public void drawLine() {
		var gc = this.planCanvas.getGraphicsContext2D();

		gc.beginPath();
		gc.moveTo(this.planCanvas.getWidth(), 0);
		gc.lineTo(30.5, 30.5);
		gc.stroke();
	}

	public void drawPlan(Plan plan) {
		var gc = this.planCanvas.getGraphicsContext2D();
		gc.clearRect(0, 0, this.planCanvas.getWidth(), this.planCanvas.getHeight());
		//		gc.beginPath();
		//		gc.moveTo(this.planCanvas.getWidth(), 0);
		//		gc.lineTo(30.5, 30.5);
		//		gc.stroke();

		double latitudeMin = 45.727352;
		double latitudeMax = 45.780518;

		double longitudeMin = 4.8314367;
		double longitudeMax = 4.9075384;


		for(int i = 0; i < plan.getIntersection().size(); i++) {
			double x = this.planCanvas.getWidth() * (plan.getIntersection().get(i).getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double y = this.planCanvas.getHeight() - (this.planCanvas.getHeight() * (plan.getIntersection().get(i).getLatitude() - latitudeMin) / (latitudeMax - latitudeMin)); 
			gc.setFill(Color.RED);
			gc.fillRect(x-2, y-2, 2, 2);
		}
		
		for(int i = 0; i < plan.getSegment().size(); i++) {
			Segment s = plan.getSegment().get(i);
			Intersection i1 = s.getOrigine();
			Intersection i2 = s.getFin();
			
			double x1 = this.planCanvas.getWidth() * (i1.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double y1 = this.planCanvas.getHeight() - (this.planCanvas.getHeight() * (i1.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin)); 
			
			double x2 = this.planCanvas.getWidth() * (i2.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double y2 = this.planCanvas.getHeight() - (this.planCanvas.getHeight() * (i2.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin)); 
			
			gc.beginPath();
			gc.moveTo(x1, y1);
			gc.lineTo(x2, y2);
			gc.stroke();

		}
	}
	
	public void drawRequests(EnsembleRequete er) {
		
		double latitudeMin = 45.727352;
		double latitudeMax = 45.780518;

		double longitudeMin = 4.8314367;
		double longitudeMax = 4.9075384;
		
		double rayonCercle = 20.0;
		
		var gc = this.planCanvas.getGraphicsContext2D();
		Depot depot = er.getLieuDepart();
		
		double depotX = this.planCanvas.getWidth() * (depot.getPointDeDepart().getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
		double depotY = this.planCanvas.getHeight() - (this.planCanvas.getHeight() * (depot.getPointDeDepart().getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));
		gc.setFill(Color.ORANGE);
		gc.fillOval(depotX - rayonCercle/2, depotY - rayonCercle/2, rayonCercle, rayonCercle);
		
		for(int i = 0; i < er.getListeRequete().size(); i++) {
			Requete req = er.getListeRequete().get(i);
			Intersection pRecup = req.getPointDeRecuperation();
			Intersection pLiv = req.getPointDeLivraison();
			
			System.out.println(pLiv);
			
			double recupX = this.planCanvas.getWidth() * (pRecup.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double recupY = this.planCanvas.getHeight() - (this.planCanvas.getHeight() * (pRecup.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));
			
			double livX = this.planCanvas.getWidth() * (pLiv.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double livY = this.planCanvas.getHeight() - (this.planCanvas.getHeight() * (pLiv.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));
			
			
			
			gc.setFill(Color.BLUE);
			gc.fillOval(recupX - rayonCercle/2, recupY - rayonCercle/2, rayonCercle, rayonCercle);
			
			gc.setFill(Color.YELLOW);
			gc.fillOval(livX - rayonCercle/2, livY - rayonCercle/2, rayonCercle, rayonCercle);
		}
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
