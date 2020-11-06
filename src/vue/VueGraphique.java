package vue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import modele.Depot;
import modele.EnsembleRequete;
import modele.Intersection;
import modele.Itineraire;
import modele.Plan;
import modele.Requete;
import modele.Segment;

public class VueGraphique {

	Plan plan;
	Canvas planCanvas;
	
	Pane requetePane;
	
	List<Node> requetes = new ArrayList<>();
	Map<Node, Intersection> nodeLinkedToIntersection = new HashMap<>();
	
	public VueGraphique(Plan plan, Canvas planCanvas, Pane requetePane) {
		this.plan = plan;
		this.planCanvas = planCanvas;
		this.requetePane = requetePane;
	}

	public Plan getPlan() {
		return(this.plan);
	}
	
	public void drawPlan() {
		requetes.clear();
		requetePane.getChildren().clear();
		nodeLinkedToIntersection.clear();
		var gc = this.planCanvas.getGraphicsContext2D();
		gc.clearRect(0, 0, this.planCanvas.getWidth(), this.planCanvas.getHeight());
		//		gc.beginPath();
		//		gc.moveTo(this.this.planCanvas.getWidth(), 0);
		//		gc.lineTo(30.5, 30.5);
		//		gc.stroke();

		double latitudeMin = this.plan.latitudeMin();
		double latitudeMax = this.plan.latitudeMax();

		double longitudeMin = this.plan.longitudeMin();
		double longitudeMax = this.plan.longitudeMax();

		System.out.println(latitudeMax + " " + latitudeMin);
		System.out.println(longitudeMax + " " + longitudeMin);


		for(int i = 0; i < this.plan.getIntersection().size(); i++) {
			double x =  this.planCanvas.getWidth() * (this.plan.getIntersection().get(i).getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double y = this.planCanvas.getHeight() - (this.planCanvas.getHeight() * (this.plan.getIntersection().get(i).getLatitude() - latitudeMin) / (latitudeMax - latitudeMin)); 
			gc.setFill(Color.RED);
			gc.fillRect(x-2, y-2, 2, 2);
		}

		for(int i = 0; i < this.plan.getSegment().size(); i++) {
			Segment s = this.plan.getSegment().get(i);
			Intersection i1 = s.getOrigine();
			Intersection i2 = s.getFin();

			double x1 = this.planCanvas.getWidth() * (i1.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double y1 = this.planCanvas.getHeight() - (this.planCanvas.getHeight() * (i1.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin)); 

			double x2 = this.planCanvas.getWidth() * (i2.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double y2 = this.planCanvas.getHeight() - (this.planCanvas.getHeight() * (i2.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin)); 

			gc.beginPath();
			gc.moveTo(x1, y1);
			gc.setLineWidth(1.0);
			gc.setFill(Color.BLACK);
			gc.setStroke(Color.BLACK);
			gc.lineTo(x2, y2);
			gc.stroke();

		}
	}

	public void drawRequests(EnsembleRequete er) {
		requetes.clear();
		requetePane.getChildren().clear();
		nodeLinkedToIntersection.clear();
		
		double latitudeMin = this.plan.latitudeMin();
		double latitudeMax = this.plan.latitudeMax();

		double longitudeMin = this.plan.longitudeMin();
		double longitudeMax = this.plan.longitudeMax();

		double rayonCercle = 8.0;

//		drawPlan();
		Depot depot = er.getLieuDepart();

		double depotX = this.requetePane.getWidth() * (depot.getPointDeDepart().getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
		double depotY = this.requetePane.getHeight() - (this.requetePane.getHeight() * (depot.getPointDeDepart().getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));
		Circle depotC = new Circle(rayonCercle);
		depotC.setCenterX(depotX);
		depotC.setCenterY(depotY);
		depotC.setFill(Color.ORANGE);
		this.requetes.add(depotC);
		
		for(int i = 0; i < er.getListeRequete().size(); i++) {
			Requete req = er.getListeRequete().get(i);
			Intersection pRecup = req.getPointDeRecuperation();
			Intersection pLiv = req.getPointDeLivraison();

			System.out.println(pLiv);

			double recupX = this.requetePane.getWidth() * (pRecup.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double recupY = this.requetePane.getHeight() - (this.requetePane.getHeight() * (pRecup.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));

			Circle recupC = new Circle(rayonCercle);
			recupC.setCenterX(recupX);
			recupC.setCenterY(recupY);
			recupC.setFill(Color.YELLOW);
			this.requetes.add(recupC);
			
			double livX = this.requetePane.getWidth() * (pLiv.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double livY = this.requetePane.getHeight() - (this.requetePane.getHeight() * (pLiv.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));
			
			Circle livC = new Circle(rayonCercle);
			livC.setCenterX(livX);
			livC.setCenterY(livY);
			livC.setFill(Color.BLUE);
			this.requetes.add(livC);
		}
		requetePane.getChildren().addAll(requetes);
	}
	
	public void drawItineraire(Itineraire itineraire) {
		var gc = this.planCanvas.getGraphicsContext2D();
		gc.setFill(Color.RED);
		
		double latitudeMin = this.plan.latitudeMin();
		double latitudeMax = this.plan.latitudeMax();

		double longitudeMin = this.plan.longitudeMin();
		double longitudeMax = this.plan.longitudeMax();
		
		for(int i = 0; i < itineraire.getListeIntersections().size() - 1; i++) {
			
			Intersection i1 = itineraire.getListeIntersections().get(i);
			Intersection i2 = itineraire.getListeIntersections().get(i + 1);
			
			double x1 = this.planCanvas.getWidth() * (i1.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double y1 = this.planCanvas.getHeight() - (this.planCanvas.getHeight() * (i1.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin)); 

			double x2 = this.planCanvas.getWidth() * (i2.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double y2 = this.planCanvas.getHeight() - (this.planCanvas.getHeight() * (i2.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin)); 
			
			
			gc.beginPath();
			gc.moveTo(x1, y1);
			gc.lineTo(x2, y2);
			gc.setStroke(Color.RED);
			gc.setLineWidth(4.0);
			gc.stroke();
		}
	}
	
	public Pane getRequetePane() {
		return requetePane;
	}
	
	public List<Node> getRequetes() {
		return requetes;
	}
}
