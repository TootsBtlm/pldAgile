package vue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import controleur.MouseEvents;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import modele.Depot;
import modele.EnsembleRequete;
import modele.Intersection;
import modele.Itineraire;
import modele.Livraison;
import modele.Plan;
import modele.Requete;
import modele.Segment;

public class VueGraphique {

	Plan plan;
	Canvas planCanvas;

	Pane intersectionPane;

	List<Node> requetes = new ArrayList<>();
	BiMap<Node, Intersection> nodeLinkedToIntersection = HashBiMap.create();
	private MouseEvents mouseEvents;

	public VueGraphique(Plan plan, Canvas planCanvas, Pane intersectionPane, MouseEvents mouseEvents) {
		this.plan = plan;
		this.planCanvas = planCanvas;
		this.intersectionPane = intersectionPane;
		this.mouseEvents = mouseEvents;
	}

	public Plan getPlan() {
		return(this.plan);
	}

	public void drawPlan() {
		requetes.clear();
		intersectionPane.getChildren().clear();
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

			Circle c1 = new Circle(8.0);
			c1.setCenterX(x1);
			c1.setCenterY(y1);
			c1.setFill(Color.rgb(0, 0, 0, 0));

			if(!nodeLinkedToIntersection.containsValue(i1)) {
				nodeLinkedToIntersection.put(c1, i1);
				this.intersectionPane.getChildren().add(c1);
			}


			Circle c2 = new Circle(8.0);
			c2.setCenterX(x2);
			c2.setCenterY(y2);
			c2.setFill(Color.rgb(0, 0, 0, 0));

			if(!nodeLinkedToIntersection.containsValue(i2)) {
				nodeLinkedToIntersection.put(c2, i2);
				this.intersectionPane.getChildren().add(c2);
			}
			mouseEvents.setNodeLinkedToIntersection(nodeLinkedToIntersection);

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

		if(requetes.size() > 0) {
			for(int i = 0; i < requetes.size(); i++) {

				Circle node = (Circle)(requetes.get(i));
				node.setFill(Color.rgb(0,0,0,0));
				//intersectionPane.getChildren().remove(requetes.get(i));
			}
			requetes.clear();
		}
		//		requetePane.getChildren().clear();
		//		nodeLinkedToIntersection.clear();

		double latitudeMin = this.plan.latitudeMin();
		double latitudeMax = this.plan.latitudeMax();

		double longitudeMin = this.plan.longitudeMin();
		double longitudeMax = this.plan.longitudeMax();

		double rayonCercle = 8.0;

		//		drawPlan();
		Depot depot = er.getLieuDepart();

		double depotX = this.intersectionPane.getWidth() * (depot.getPointDeDepart().getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
		double depotY = this.intersectionPane.getHeight() - (this.intersectionPane.getHeight() * (depot.getPointDeDepart().getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));
		Circle depotC = (Circle)(nodeLinkedToIntersection.inverse().get(depot.getPointDeDepart()));
		//		File imgDepot = new File("ressources/img/warehouse.png");
		//		ImageView warehouse = new ImageView();
		//		warehouse.setImage(new Image(imgDepot.toURI().toString()));
		//		
		//		warehouse.setFitWidth(32);
		//		warehouse.setX(depotX - 16);
		//		warehouse.setY(depotY - 16);
		//		warehouse.setPreserveRatio(true);
		//		depotC.setCenterX(depotX);
		//		depotC.setCenterY(depotY);
		depotC.setFill(Color.ORANGE);
		depotC.toFront();
		this.requetes.add(depotC);

		for(int i = 0; i < er.getListeRequete().size(); i++) {
			Requete req = er.getListeRequete().get(i);
			Intersection pRecup = req.getPointDeRecuperation();
			Intersection pLiv = req.getPointDeLivraison();

			System.out.println(pLiv);

			double recupX = this.intersectionPane.getWidth() * (pRecup.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double recupY = this.intersectionPane.getHeight() - (this.intersectionPane.getHeight() * (pRecup.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));

			Circle recupC = (Circle)(nodeLinkedToIntersection.inverse().get(pRecup));
			//			recupC.setCenterX(recupX);
			//			recupC.setCenterY(recupY);
			recupC.setFill(Color.YELLOW);
			recupC.toFront();
			this.requetes.add(recupC);

			double livX = this.intersectionPane.getWidth() * (pLiv.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double livY = this.intersectionPane.getHeight() - (this.intersectionPane.getHeight() * (pLiv.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));

			Circle livC = (Circle)(nodeLinkedToIntersection.inverse().get(pLiv));
			//			livC.setCenterX(livX);
			//			livC.setCenterY(livY);
			livC.setFill(Color.BLUE);
			livC.toFront();
			this.requetes.add(livC);
		}
		//intersectionPane.getChildren().addAll(requetes);
		//		requetePane.getChildren().add(warehouse);
		for(int i = 0; i < this.requetes.size(); i++) {
			mouseEvents.requeteCliquable(requetes.get(i));
		}
	}

	public void drawItineraire(Livraison livraison) {
		var gc = this.planCanvas.getGraphicsContext2D();
//		gc.setFill(Color.RED);
		

		double latitudeMin = this.plan.latitudeMin();
		double latitudeMax = this.plan.latitudeMax();

		double longitudeMin = this.plan.longitudeMin();
		double longitudeMax = this.plan.longitudeMax();
		
		int sizeItineraire = livraison.getListeItineraires().size();
		

		for(int i = 0; i < sizeItineraire; i++) {
			
			double luminosite = (double)i / (double)sizeItineraire;
			double color = (double)i / (double)sizeItineraire;
			gc.setFill(Color.hsb(240, 1.0, luminosite));
			Itineraire itineraire = livraison.getListeItineraires().get(i);
			for(int j = 0; j < itineraire.getListeIntersections().size() - 1; j++) {
				Intersection i1 = itineraire.getListeIntersections().get(j);
				Intersection i2 = itineraire.getListeIntersections().get(j + 1);

				double x1 = this.planCanvas.getWidth() * (i1.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
				double y1 = this.planCanvas.getHeight() - (this.planCanvas.getHeight() * (i1.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin)); 

				double x2 = this.planCanvas.getWidth() * (i2.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
				double y2 = this.planCanvas.getHeight() - (this.planCanvas.getHeight() * (i2.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin)); 


				gc.beginPath();
				gc.moveTo(x1, y1);
				gc.lineTo(x2, y2);
				gc.setStroke(Color.hsb(0, 1.0, luminosite));
				gc.setLineWidth(4.0);
				gc.stroke();
			}
		}
	}

	public Pane getIntersectionPane() {
		return intersectionPane;
	}

	public List<Node> getRequetes() {
		return requetes;
	}
}
