package vue;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import modele.Plan;

public class UiController {


	@FXML
	private Canvas planCanvas;

	@FXML
	private Button button1;


	@FXML
	public void initialize() {
		System.out.println("test init");
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

		double latitudeMin = 45.727;
		double latitudeMax = 45.780;

		double longitudeMin = 4.831;
		double longitudeMax = 4.907;

		double ratioLatitude = this.planCanvas.getWidth() / (latitudeMax - latitudeMin + 1);
		double ratioLongitude = this.planCanvas.getHeight() / (longitudeMax - longitudeMin + 1);

		for(int i = 0; i < plan.getIntersection().size(); i++) {
			double x = (plan.getIntersection().get(i).getLatitude() - latitudeMin) * ratioLatitude;
			double y = (plan.getIntersection().get(i).getLongitude() - longitudeMin) * ratioLongitude;
			gc.setFill(Color.RED);
			gc.fillRect(x, y, 2, 2);
			System.out.println("x:" + x + ", y: " + y);
		}
	}



}
