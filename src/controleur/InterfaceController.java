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
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modele.EnsembleRequete;
import modele.Itineraire;
import modele.Lecteur;
import modele.Livraison;
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
	private Text textChargerFichierRequete;
	
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

	private Etat etat;
	
	private Livraison livraison;

	@FXML
	public void initialize() {
		tsp = new TSP1();
		etat = new EtatInitial(this);

	}

	@FXML
	public void actionChargerFichierPlan() {
		etat.chargerFichierPlan();

	}

	public void chargerFichierPlan() {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(this.stage);
		if(file != null) {
			String path = file.getPath();
			System.out.println(path);
			Lecteur lecteur = new Lecteur();
			this.plan = lecteur.LirePlan(path);
			System.out.println(requetePane);
			this.vueGraphique = new VueGraphique(this.plan, this.planCanvas, this.requetePane);
			this.vueGraphique.drawPlan();
			this.listViewRequest.getItems().clear();
			this.textChargerFichierRequete.setVisible(true);;
		} else {
			System.out.println("Fichier incorrect");
		}
		etat = new EtatPlanCharge(this);

	}

	@FXML
	public void actionChargerFichierRequete() {
		etat.chargerFichierRequetes();
	}

	public void chargerFichierRequete() {
		if(this.vueGraphique == null) {
			System.out.println("Charger d'abord un plan");
		} else {
			FileChooser fileChooser = new FileChooser();
			File file = fileChooser.showOpenDialog(this.stage);
			String path = file.getPath();
			System.out.println(path);
			Lecteur lecteur = new Lecteur();
			this.ensembleRequete = lecteur.LireRequete(path, this.plan);
			this.vueTextuelle = new VueTextuelle(this.plan, this.listViewRequest);
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
			this.textChargerFichierRequete.setVisible(false);;
		}
		etat = new EtatListeRequeteChargee(this);
	}

	@FXML
	public void actionCalculerItineraire() {
		etat.calculerItineraire();
	}


	public void calculerItineraire() {


	
		this.livraison = plan.getMatriceCout(this.ensembleRequete);
		System.out.println("Size itineraire : " + this.livraison.getListeItineraires().get(0).getListeIntersections().get(0).getId());
		this.vueGraphique.drawItineraire(this.livraison);
		this.vueTextuelle.drawItineraire(this.livraison, this.requeteNodeListView);

		etat = new EtatItineraireCalcule(this);

	}
	
	@FXML
	public void actionAjouterEtape() {
		etat.ajouterEtape();
	}
	
	public void ajouterEtape() {
		System.out.println("tout marche");
		
		//this.intersection = mouseEvents.clickIntersection
		// a faire mario et jj
		// this.livraison = plan.ajouterSommet(this.livraison, "nouvelle intersection", "intersection precedente", LONG "demander la durée")
		// this.livraison = plan.ajouterSommet(this.livraison, "nouvelle intersection", "intersection precedente", LONG "demander la durée")
		// mettre le code pour ajouter une etape (appel a une fonction dans plan)	
	}
	
	@FXML
	public void actionSupprimerEtape() {
		etat.supprimerEtape();
	}
	
	public void supprimerEtape() {
		System.out.println("tout marche");
		// à faire mario et jj
		// this.livraison = plan.supprimerSommet(this.livraison, "intersection à supprimer")
		// mettre le code pour supprimer une etape (appel a une fonction dans plan)	
	}
	
	@FXML
	public void actionCreerFeuilleDeRoute() {
		etat.feuilleDeRoute();
	}
	
	public void feuilleDeRoute() {
		System.out.println("tout marche");
		// creer feuille de route au bon format
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
