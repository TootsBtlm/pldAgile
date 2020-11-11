package controleur;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import modele.EnsembleRequete;
import modele.Intersection;
import modele.Itineraire;
import modele.Lecteur;
import modele.Livraison;
import modele.Plan;
import modele.TSP;
import modele.TSP1;
import vue.VueGraphique;
import vue.VueTextuelle;

/**
 * 
 * @author Aurélien, Mario et Jean-Jacques
 * Représente 
 *
 */
public class InterfaceController {


	@FXML
	private Canvas planCanvas;
	
	@FXML
	private Canvas itineraireCanvas;

	@FXML
	private Canvas requeteCanvas;

	@FXML
	private Text textChargerFichierRequete;

	@FXML
	private Pane intersectionPane;


	@FXML
	private Button btnOuvrirPlan;

	@FXML
	private ListView<String> listViewRequest;

	private Stage stage;
	private Stage ajouterStage;
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
	
	private Intersection nouveauPointRecuperation;
	private Intersection nouveauPointLivraison;

	@FXML
	public void initialize() {
		tsp = new TSP1();
		etat = new EtatInitial(this);
		ajouterStage = new Stage();
		mouseEvents = new MouseEvents(requeteNodeListView, this.listViewRequest, this);
	}

	@FXML
	public void actionChargerFichierPlan() {
		System.out.println("called actionChargerFichierPlan");
		System.out.println("ETAT au call : " + this.etat);
		etat.chargerFichierPlan();

	}
	
	public Etat getEtat() {
		return this.etat;
	}
	
	public void chargerFichierPlan() {
		this.plan = null;
		this.vueGraphique = null;
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(this.stage);
		if(file != null) {
			String path = file.getPath();
			System.out.println(path);
			Lecteur lecteur = new Lecteur();
			this.plan = lecteur.LirePlan(path);
			System.out.println(intersectionPane);
			this.vueGraphique = new VueGraphique(this.plan, this.planCanvas, this.intersectionPane, this.itineraireCanvas, mouseEvents);
			this.vueGraphique.drawPlan();
			for(int i = 0; i < this.vueGraphique.getIntersectionPane().getChildren().size(); i++) {
				mouseEvents.setIntersectionCliquable(this.vueGraphique.getIntersectionPane().getChildren().get(i));
			}

			this.listViewRequest.getItems().clear();
			this.textChargerFichierRequete.setVisible(true);;
		} else {
			System.out.println("Fichier incorrect");
		}
		etat = new EtatPlanCharge(this);

	}

	@FXML
	public void actionChargerFichierRequete() {
		System.out.println("called actionChargerFichierRequete");
		System.out.println("ETAT au call : " + this.etat);
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
			this.vueTextuelle = new VueTextuelle(this.plan, this.listViewRequest, this.mouseEvents);
			this.vueTextuelle.drawText(this.ensembleRequete, this.listViewRequest);
			this.vueGraphique.drawRequests(this.ensembleRequete);
			
			this.requeteNodes = this.vueGraphique.getIntersectionPane().getChildren();

			this.requeteNodeListView.clear();
			for(int i = 0; i < this.vueGraphique.getRequetes().size(); i++) {
				requeteNodeListView.put(this.vueGraphique.getRequetes().get(i), listViewRequest.getItems().get(i));
				//this.requeteNodes = this.vueGraphique.getIntersectionPane().getChildren();
			}




			mouseEvents = new MouseEvents(this.requeteNodeListView, this.listViewRequest, this);


			// Ajout d'un event handler sur les nodes correspondant aux requêtes sur la carte

			//			for(int i = 0; i < this.vueGraphique.getRequetes().size(); i++) {
			//				mouseEvents.requeteCliquable(this.vueGraphique.getRequetePane().getChildren().get(i));
			//			}


			this.mouseEvents.setListeCliquable();
			this.textChargerFichierRequete.setVisible(false);;

			System.out.println("test");
			etat = new EtatListeRequeteChargee(this);
		}
	}

	@FXML
	public void actionCalculerItineraire() {
		System.out.println("called actionCalculerItineraire");
		System.out.println("ETAT au actionCalculerItineraire : " + this.etat);
		etat.calculerItineraire();
	}


	public void calculerItineraire() {

		this.livraison = plan.getMatriceCout(this.ensembleRequete);
//		for(int i = 0; i < livraison.getListeItineraires().size(); i++) {
//			Itineraire iti = livraison.getListeItineraires().get(i);
//			System.out.println("itineraire " + i);
//			System.out.println(iti.getListeIntersections().get(0));
//			System.out.println(iti.getListeIntersections().get(iti.getListeIntersections().size()-1));
//			System.out.println(" ");
//		}
		
		System.out.println("Size itineraire : " + this.livraison.getListeItineraires().get(0).getListeIntersections().get(0).getId());

		this.vueGraphique.drawItineraire(this.livraison);
		
		System.out.println("BEFORE : " + listViewRequest.getItems());
		this.vueTextuelle.drawItineraire(this.livraison, this.requeteNodeListView);
		System.out.println("AFTER : " + listViewRequest.getItems());
		
		//mouseEvents.setListeCliquable();
		//System.out.println(this.requeteNodeListView);

		etat = new EtatItineraireCalcule(this);

	}

	@FXML
	public void actionAjouterEtape() {
		System.out.println("called actionAjouterEtape");
		System.out.println("ETAT au call : " + this.etat);
		etat.ajouterEtape();
	}
	
	@FXML
	public void actionAjouterPointRecuperation() {
		System.out.println("called actionAjouterPointRecuperation");
		System.out.println("ETAT au call : " + this.etat);
		etat.ajouterPointRecuperation();
	}

	public void ajouterEtape() {
		etat = new EtatAjouterEtape(this);
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/ajouterPopup.fxml"));
//		Parent root;
//		try {
//			root = loader.load();
//			this.ajouterStage.setScene(new Scene(root));
//			this.ajouterStage.setResizable(false);
//			this.ajouterStage.show();
//		} catch (IOException e) {
//			e.printStackTrace();
//			
//		}

//		Long duree = (long) 10;
//		Intersection intersection = this.livraison.getListeItineraires().get(0).getListeIntersections().get(1);
//
//		this.livraison = plan.ajouterSommet(this.livraison, intersection, this.livraison.getListeItineraires().get(0).getListeIntersections().get(0) , duree); 
//		this.livraison = plan.ajouterSommet(this.livraison,  intersection , intersection , duree); 


		
	}
	
	public void ajouterPointRecuperation() {
		System.out.println("AJOUTER ETAPE 2");

		etat = new EtatAjouterPointRecuperation(this);
		System.out.println(this.etat);
	}
	
	public void ajouterNouveauPointRecuperation(Intersection inter) {
		inter.setTypeIntersection(3);
		System.out.println(this.plan.getNomRue(inter));
	}

	@FXML
	public void actionSupprimerEtape() {
		etat = new EtatSupprimerEtape(this);
	}

	public void supprimerEtape(Intersection inter) {

		
		this.livraison = plan.supprimerRequete(this.livraison,  inter);
		
		this.ensembleRequete = this.livraison.getRequetes();
		this.vueGraphique.drawRequests(this.ensembleRequete);
		this.vueGraphique.drawItineraire(this.livraison);
		this.vueTextuelle.drawItineraire(this.livraison, this.requeteNodeListView);

		etat = new EtatItineraireCalcule(this);

	}

	@FXML
	public void actionCreerFeuilleDeRoute() {
		etat.feuilleDeRoute();
	}

	public void feuilleDeRoute() {
		
		etat = new EtatFeuilleDeRoute(this);

	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Intersection getNouveauPointRecuperation() {
		return nouveauPointRecuperation;
	}

	public void setNouveauPointRecuperation(Intersection nouveauPointRecuperation) {
		this.nouveauPointRecuperation = nouveauPointRecuperation;
	}

	public Intersection getNouveauPointLivraison() {
		return nouveauPointLivraison;
	}

	public void setNouveauPointLivraison(Intersection nouveauPointLivraison) {
		this.nouveauPointLivraison = nouveauPointLivraison;
	}
	
	
}
