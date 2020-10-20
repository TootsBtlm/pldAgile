package vue;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import modele.Intersection;
import modele.Plan;
import modele.Segment;

public class UiController {


	@FXML
	private Canvas planCanvas;

	@FXML
	private Button button1;


	@FXML
	public void initialize() {
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
			System.out.println("x:" + x + ", y: " + y);
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
}
