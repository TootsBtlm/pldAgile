package vue;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modele.Depot;
import modele.EnsembleRequete;
import modele.Intersection;
import modele.Plan;
import modele.Requete;
import modele.Segment;

public class VueGraphique {

	public VueGraphique() {
		
	}

	public void drawPlan(Plan plan, Canvas planCanvas) {
		var gc = planCanvas.getGraphicsContext2D();
		gc.clearRect(0, 0, planCanvas.getWidth(), planCanvas.getHeight());
		//		gc.beginPath();
		//		gc.moveTo(this.planCanvas.getWidth(), 0);
		//		gc.lineTo(30.5, 30.5);
		//		gc.stroke();

		double latitudeMin = plan.latitudeMin();
		double latitudeMax = plan.latitudeMax();

		double longitudeMin = plan.longitudeMin();
		double longitudeMax = plan.longitudeMax();

		System.out.println(latitudeMax + " " + latitudeMin);
		System.out.println(longitudeMax + " " + longitudeMin);


		for(int i = 0; i < plan.getIntersection().size(); i++) {
			double x =  planCanvas.getWidth() * (plan.getIntersection().get(i).getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double y = planCanvas.getHeight() - (planCanvas.getHeight() * (plan.getIntersection().get(i).getLatitude() - latitudeMin) / (latitudeMax - latitudeMin)); 
			gc.setFill(Color.RED);
			gc.fillRect(x-2, y-2, 2, 2);
		}

		for(int i = 0; i < plan.getSegment().size(); i++) {
			Segment s = plan.getSegment().get(i);
			Intersection i1 = s.getOrigine();
			Intersection i2 = s.getFin();

			double x1 = planCanvas.getWidth() * (i1.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double y1 = planCanvas.getHeight() - (planCanvas.getHeight() * (i1.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin)); 

			double x2 = planCanvas.getWidth() * (i2.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double y2 = planCanvas.getHeight() - (planCanvas.getHeight() * (i2.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin)); 

			gc.beginPath();
			gc.moveTo(x1, y1);
			gc.lineTo(x2, y2);
			gc.stroke();

		}
	}

	public void drawRequests(EnsembleRequete er, Plan plan, Canvas planCanvas) {

		double latitudeMin = plan.latitudeMin();
		double latitudeMax = plan.latitudeMax();

		double longitudeMin = plan.longitudeMin();
		double longitudeMax = plan.longitudeMax();

		double rayonCercle = 20.0;

		var gc = planCanvas.getGraphicsContext2D();
//		gc.clearRect(0, 0, planCanvas.getWidth(), planCanvas.getHeight());
//		drawPlan();
		Depot depot = er.getLieuDepart();

		double depotX = planCanvas.getWidth() * (depot.getPointDeDepart().getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
		double depotY = planCanvas.getHeight() - (planCanvas.getHeight() * (depot.getPointDeDepart().getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));
		gc.setFill(Color.ORANGE);
		gc.fillOval(depotX - rayonCercle/2, depotY - rayonCercle/2, rayonCercle, rayonCercle);

		for(int i = 0; i < er.getListeRequete().size(); i++) {
			Requete req = er.getListeRequete().get(i);
			Intersection pRecup = req.getPointDeRecuperation();
			Intersection pLiv = req.getPointDeLivraison();

			System.out.println(pLiv);

			double recupX = planCanvas.getWidth() * (pRecup.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double recupY = planCanvas.getHeight() - (planCanvas.getHeight() * (pRecup.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));

			double livX = planCanvas.getWidth() * (pLiv.getLongitude() - longitudeMin) / (longitudeMax - longitudeMin); 
			double livY = planCanvas.getHeight() - (planCanvas.getHeight() * (pLiv.getLatitude() - latitudeMin) / (latitudeMax - latitudeMin));



			gc.setFill(Color.BLUE);
			gc.fillOval(recupX - rayonCercle/2, recupY - rayonCercle/2, rayonCercle, rayonCercle);

			gc.setFill(Color.YELLOW);
			gc.fillOval(livX - rayonCercle/2, livY - rayonCercle/2, rayonCercle, rayonCercle);
		}
	}

}
