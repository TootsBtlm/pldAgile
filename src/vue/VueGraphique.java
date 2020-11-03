package vue;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
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
	Canvas requeteCanvas;
	
	public VueGraphique(Plan plan, Canvas planCanvas, Canvas requeteCanvas) {
		this.plan = plan;
		this.planCanvas = planCanvas;
		this.requeteCanvas = requeteCanvas;
	}

	public void drawPlan() {
		var gc = this.planCanvas.getGraphicsContext2D();
		var gc2 = this.requeteCanvas.getGraphicsContext2D();
		gc.clearRect(0, 0, this.planCanvas.getWidth(), this.planCanvas.getHeight());
		gc2.clearRect(0, 0, this.requeteCanvas.getWidth(), this.requeteCanvas.getHeight());
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
			gc.lineTo(x2, y2);
			gc.stroke();

		}
	}

	public void drawRequests(EnsembleRequete er) {

		double latitudeMin = this.plan.latitudeMin();
		double latitudeMax = this.plan.latitudeMax();

		double longitudeMin = this.plan.longitudeMin();
		double longitudeMax = this.plan.longitudeMax();

		double rayonCercle = 20.0;

		var gc = this.requeteCanvas.getGraphicsContext2D();
		gc.clearRect(0, 0, this.requeteCanvas.getWidth(), this.requeteCanvas.getHeight());
//		drawPlan();
		Depot depot = er.getLieuDepart();

		double depotX = this.requeteCanvas.getWidth() * (depot.getPointDeDepart().getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
		double depotY = this.requeteCanvas.getHeight() - (this.requeteCanvas.getHeight() * (depot.getPointDeDepart().getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));
		gc.setFill(Color.ORANGE);
		gc.fillOval(depotX - rayonCercle/2, depotY - rayonCercle/2, rayonCercle, rayonCercle);

		for(int i = 0; i < er.getListeRequete().size(); i++) {
			Requete req = er.getListeRequete().get(i);
			Intersection pRecup = req.getPointDeRecuperation();
			Intersection pLiv = req.getPointDeLivraison();

			System.out.println(pLiv);

			double recupX = this.requeteCanvas.getWidth() * (pRecup.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double recupY = this.requeteCanvas.getHeight() - (this.requeteCanvas.getHeight() * (pRecup.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));

			double livX = this.requeteCanvas.getWidth() * (pLiv.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double livY = this.requeteCanvas.getHeight() - (this.requeteCanvas.getHeight() * (pLiv.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));



			gc.setFill(Color.BLUE);
			gc.fillOval(recupX - rayonCercle/2, recupY - rayonCercle/2, rayonCercle, rayonCercle);

			gc.setFill(Color.YELLOW);
			gc.fillOval(livX - rayonCercle/2, livY - rayonCercle/2, rayonCercle, rayonCercle);
		}
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
			gc.stroke();
		}
	}

}
