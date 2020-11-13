package vue;

import controleur.InterfaceController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	/**
	 * Méthode permettant de créer la fenêtre principale
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			InterfaceController ui = new InterfaceController();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/ScenePlan.fxml"));
			loader.setController(ui);
			Parent root = loader.load();
			
			ui.setStage(primaryStage);

			primaryStage.setScene(new Scene(root));
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Méthode permettant de lancer JavaFX
	 * @param args Tableau de chaine de caractères
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
