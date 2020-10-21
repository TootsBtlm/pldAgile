package vue;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.EnsembleRequete;
import modele.Lecteur;
import modele.Plan;

public class Main extends Application {
	

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/ScenePlan.fxml"));
			Parent root = loader.load();
			Lecteur l = new Lecteur();
			Plan nouveauPlan = l.LirePlan("ressources/largeMap.xml");
			
			UiController ui = loader.getController();
			ui.setStage(primaryStage);
			
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(new Scene(root));
			primaryStage.setResizable(false);
			primaryStage.show();
			
//			ui.drawPlan(nouveauPlan);
//			
//			EnsembleRequete r = l.LireRequete("ressources/requestsLarge7.xml", nouveauPlan);
//			
//			ui.drawRequests(r);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
