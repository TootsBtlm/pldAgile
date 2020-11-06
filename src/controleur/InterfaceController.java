package controleur;

import java.io.File;
import java.util.List;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modele.EnsembleRequete;
import modele.Itineraire;
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
	private Canvas requeteCanvas;
	
	@FXML
	private Pane requetePane;
	

	@FXML
	private Button btnOuvrirPlan;
	
	@FXML
	private ListView<String> listViewRequest;
	
	private Stage stage;
	private Plan plan;
	private EnsembleRequete ensembleRequete = null;
	private List<Node> requeteNodes = null;
	private VueGraphique vueGraphique;
	private BiMap<Node, String> requeteNodeListView = HashBiMap.create();

	private VueTextuelle vueTextuelle;
	
	private TSP tsp;
	
	private MouseEvents mouseEvents;

	private int numéroEtat = 0;

	@FXML
	public void initialize() {
		tsp = new TSP1();
		
	}
	
	@FXML
	public void choisirFichierPlan() {
/*		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(this.stage);
		if(file != null) {
			String path = file.getPath();
			System.out.println(path);
			Lecteur lecteur = new Lecteur();
			this.plan = lecteur.LirePlan(path);
			this.vueGraphique = new VueGraphique(this.plan, this.planCanvas, this.requetePane);
			this.vueGraphique.drawPlan();
		} else {
			System.out.println("Fichier incorrect");
		}
		*/
		//Première version pour étudier la manière dont les données vont aller d'une classe à l'autre
		
		if (this.numéroEtat == 0) {
			EtatInitial etat1 = new EtatInitial();
			this.vueGraphique = etat1.choisirFichierPlan(this.planCanvas, this.requetePane, this.requeteCanvas);
			this.plan = this.vueGraphique.getPlan();
		} else if (this.numéroEtat == 1) {
			EtatListeRequeteChargee etat1 = new EtatListeRequeteChargee();
			this.vueGraphique = etat1.choisirFichierPlan(this.planCanvas, this.requetePane, this.requeteCanvas);
			this.plan = this.vueGraphique.getPlan();
		} else if (this.numéroEtat == 2) {
			EtatItineraireCalcule etat1 = new EtatItineraireCalcule();
			this.vueGraphique = etat1.choisirFichierPlan(this.planCanvas, this.requetePane, this.requeteCanvas);
			this.plan = this.vueGraphique.getPlan();
		} else if (this.numéroEtat == 3) {
			EtatListeRequeteChargee etat1 = new EtatListeRequeteChargee();
			this.vueGraphique = etat1.choisirFichierPlan(this.planCanvas, this.requetePane, this.requeteCanvas);
			this.plan = this.vueGraphique.getPlan();
		} else if (this.numéroEtat == 4) {
			EtatAjouterEtape etat1 = new EtatAjouterEtape();
			this.vueGraphique = etat1.choisirFichierPlan(this.planCanvas, this.requetePane, this.requeteCanvas);
			this.plan = this.vueGraphique.getPlan();
		} else if (this.numéroEtat == 5) {
			EtatSupprimerEtape etat1 = new EtatSupprimerEtape();
			this.vueGraphique = etat1.choisirFichierPlan(this.planCanvas, this.requetePane, this.requeteCanvas);
			this.plan = this.vueGraphique.getPlan();
		} else if (this.numéroEtat == 6) {
			EtatFeuilleDeRoute etat1 = new EtatFeuilleDeRoute();
			this.vueGraphique = etat1.choisirFichierPlan(this.planCanvas, this.requetePane, this.requeteCanvas);
			this.plan = this.vueGraphique.getPlan();
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
			this.ensembleRequete = lecteur.LireRequete(path, this.plan);
			this.vueTextuelle = new VueTextuelle();
			this.vueTextuelle.drawText(this.ensembleRequete, this.listViewRequest);
			this.vueGraphique.drawRequests(this.ensembleRequete);
			this.requeteNodes = this.vueGraphique.getRequetePane().getChildren();
			
			for(int i = 0; i < this.vueGraphique.getRequetes().size(); i++) {
				requeteNodeListView.put(this.requeteNodes.get(i), listViewRequest.getItems().get(i));
			}
			
			mouseEvents = new MouseEvents(requeteNodeListView, this.listViewRequest);
			// Ajout d'un event handler sur les nodes correspondant aux requêtes sur la carte
			for(int i = 0; i < this.vueGraphique.getRequetes().size(); i++) {
				 mouseEvents.requeteCliquable(this.vueGraphique.getRequetePane().getChildren().get(i));
			}
			
			mouseEvents.setListeCliquable();
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
			
			//ici ça va buguer
			//Itineraire itineraire = plan.getMatriceCout(this.ensembleRequete);
			//this.vueGraphique.drawItineraire(itineraire);
		}
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
