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
 * @author Hexanome4103
 * Repr�sente 
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
	private Text textPointPrecedentRecuperation;
	
	@FXML
	private Text textPointPrecedentLivraison;
	
	@FXML
	private Text textPointRecuperation;
	
	@FXML
	private Text textPointLivraison;
	
	
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
	private Intersection pointPrecedentRecuperation;
	private Intersection pointPrecedentLivraison;
	
	/**
	 * 
	 * Cr�er une instance de la classe InterfaceController. Initialise les attributs tsp, etat, ajouterStage et mouseEvents de l'instance.
	 * 
	 */
	
	public InterfaceController() {
		tsp = new TSP1();
		etat = new EtatInitial(this);
		ajouterStage = new Stage();
		mouseEvents = new MouseEvents(requeteNodeListView, this.listViewRequest, this);
	}

	/**
	 * 
	 * Fait appel � la fonction polymorphe chargerFichierPlan de la classe Etat 
	 * 
	 */
	
	@FXML
	public void actionChargerFichierPlan() {
		System.out.println("called actionChargerFichierPlan");
		System.out.println("ETAT au call : " + this.etat);
		etat.chargerFichierPlan();

	}
	
	/**
	 * 
	 *  
	 * 
	 */
	
	public Etat getEtat() {
		return this.etat;
	}
	
	/**
	 * 
	 * Permet de charger le plan en faisant appel � la classe Lecteur
	 * 
	 */
	
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

	/**
	 * 
	 * Fait appel � la fonction polymorphe chargerFichierRequetes de la classe Etat 
	 * 
	 */
	
	@FXML
	public void actionChargerFichierRequete() {
		System.out.println("called actionChargerFichierRequete");
		System.out.println("ETAT au call : " + this.etat);
		etat.chargerFichierRequetes();
	}

	/**
	 * 
	 * Permet de charger le fichier de requ�tes en faisant appel � la classe Lecteur
	 * 
	 */
	
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


			// Ajout d'un event handler sur les nodes correspondant aux requ�tes sur la carte

			//			for(int i = 0; i < this.vueGraphique.getRequetes().size(); i++) {
			//				mouseEvents.requeteCliquable(this.vueGraphique.getRequetePane().getChildren().get(i));
			//			}


			this.mouseEvents.setListeCliquable();
			this.textChargerFichierRequete.setVisible(false);;

			//System.out.println("test");
			etat = new EtatListeRequeteChargee(this);
		}
	}

	/**
	 * 
	 * Fait appel � la fonction polymorphe calculerItineraire de la classe Etat 
	 * 
	 */
	
	@FXML
	public void actionCalculerItineraire() {
		System.out.println("called actionCalculerItineraire");
		System.out.println("ETAT au actionCalculerItineraire : " + this.etat);
		etat.calculerItineraire();
	}


	/**
	 * 
	 * Permet de charger l'itin�raire calcul� en faisant appel � la m�thode getMatriceCout de la classe Plan
	 * 
	 */
	
	public void calculerItineraire() {

		this.livraison = plan.getMatriceCout(this.ensembleRequete);
//		for(int i = 0; i < livraison.getListeItineraires().size(); i++) {
//			Itineraire iti = livraison.getListeItineraires().get(i);
//			System.out.println("itineraire " + i);
//			System.out.println(iti.getListeIntersections().get(0));
//			System.out.println(iti.getListeIntersections().get(iti.getListeIntersections().size()-1));
//			System.out.println(" ");
//		}
		
		//System.out.println("Size itineraire : " + this.livraison.getListeItineraires().get(0).getListeIntersections().get(0).getId());

		this.vueGraphique.drawItineraire(this.livraison);
		
		//System.out.println("BEFORE : " + listViewRequest.getItems());
		this.vueTextuelle.drawItineraire(this.livraison, this.requeteNodeListView);
		//System.out.println("AFTER : " + listViewRequest.getItems());
		
		//mouseEvents.setListeCliquable();
		//System.out.println(this.requeteNodeListView);

		etat = new EtatItineraireCalcule(this);

	}

	/**
	 * 
	 * Fait appel � la fonction polymorphe ajouterEtape de la classe Etat ce qui lance une autre fen�tre de gestion de l'ajout d'une �tape
	 * 
	 */
	
	@FXML
	public void actionAjouterEtape() {
		System.out.println("called actionAjouterEtape");
		System.out.println("ETAT au call : " + this.etat);
		etat = new EtatAjouterEtape(this);
		etat.ajouterEtape();
	}
	
	/**
	 * 
	 * D�clench�e lorsque l'utilisateur appuie sur le bouton ajouter un point de r�cup�ration. Permet � l'utilisateur de s�lectionner le point de r�cup�ration � ajouter
	 * 
	 */
	
	@FXML
	public void actionAjouterPointRecuperation() {
		System.out.println("called actionAjouterPointRecuperation");
		System.out.println("ETAT au call : " + this.etat);

		etat = new EtatAjouterPointRecuperation(this);
	}

	/**
	 * 
	 * D�clench�e lorsque l'utilisateur appuie sur le bouton ajouter le point qui pr�c�de le point de r�cup�ration. Permet � l'utilisateur de s�lectionner le point pr�c�dent � ajouter
	 * 
	 */
	
	@FXML
	public void actionAjouterPointPrecedentRecuperation() {
		System.out.println("called actionAjouterPointPrecedentRecuperation");
		System.out.println("ETAT au call : " + this.etat);

		etat = new EtatAjouterPointPrecedentRecuperation(this);
	}
	
	/**
	 * 
	 * D�clench�e lorsque l'utilisateur appuie sur le bouton ajouter le point qui pr�c�de le point de livraison. Permet � l'utilisateur de s�lectionner le point pr�c�dent � ajouter
	 * 
	 */
	
	@FXML
	public void actionAjouterPointPrecedentLivraison() {
		System.out.println("called actionAjouterPointPrecedentLivraison");
		System.out.println("ETAT au call : " + this.etat);

		etat = new EtatAjouterPointPrecedentLivraison(this);
	}
	
	/**
	 * 
	 * D�clench�e lorsque l'utilisateur appuie sur le bouton ajouter le point de livraison. Permet � l'utilisateur de s�lectionner le point de livraison � ajouter
	 * 
	 */
	
	@FXML
	public void actionAjouterPointLivraison() {
		System.out.println("called actionAjouterPointLivraison");
		System.out.println("ETAT au call : " + this.etat);

		etat = new EtatAjouterPointLivraison(this);
	}
	
	/**
	 * 
	 * Lance une nouvelle fen�tre qui permet � l'utilisateur de g�rer l'ajout d'une nouvelle �tape
	 * 
	 */
	
	public void ajouterEtape() {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/ajouterPopup.fxml"));
		loader.setController(this);
		Parent root;
		try {
			root = loader.load();
			this.ajouterStage.setScene(new Scene(root));
			this.ajouterStage.setResizable(false);
			this.ajouterStage.show();
		} catch (IOException e) {
			e.printStackTrace();
			
		}

		
	}
	
	/**
	 * 
	 * Valide l'ajout de l'�tape en calculant le nouvel itin�raire
	 * 
	 */
	
	public void validerAjouterEtape() {
		Long duree = (long) 10;
		this.livraison = plan.ajouterRequete(this.livraison, this.pointPrecedentRecuperation, this.pointPrecedentLivraison, this.nouveauPointRecuperation, this.nouveauPointLivraison, duree, duree);
		this.ensembleRequete = this.livraison.getRequetes();
		this.vueGraphique.drawRequests(this.ensembleRequete);
		this.vueGraphique.drawItineraire(this.livraison);
		this.vueTextuelle.drawItineraire(this.livraison, this.requeteNodeListView);

		etat = new EtatItineraireCalcule(this);
		
	}
	
	/**
	 * 
	 * Permet � l'utilisateur de valider l'ajout d'une �tape en faisant appel � la fonction polymorphe validerAjouterEtape de la classe Etat
	 * 
	 */
	
	@FXML
	public void actionValiderAjouterEtape() {
		etat.validerAjouterEtape();
	}
	
	/**
	 * 
	 * Ajoute le point de r�cup�ration dans la fen�tre de gestion d'ajout d'une �tape
	 * 
	 */
	
	public void ajouterNouveauPointRecuperation(Intersection inter) {
		System.out.println("called ajouterNouveauPointRecuperation");
		System.out.println("ETAT au call : " + this.etat);
		inter.setTypeIntersection(3);
		setNouveauPointRecuperation(inter);
		this.textPointRecuperation.setText(this.plan.getNomRue(inter));
		System.out.println(this.plan.getNomRue(inter));
	}
	
	/**
	 * 
	 * Ajoute le point qui pr�c�de point de r�cup�ration dans la fen�tre de gestion d'ajout d'une �tape
	 * 
	 */
	
	public void ajouterPointPrecedentRecuperation(Intersection inter) {
		System.out.println("called ajouterPointPrecedentRecuperation");
		System.out.println("ETAT au call : " + this.etat);
		setPointPrecedentRecuperation(inter);
		this.textPointPrecedentRecuperation.setText(this.plan.getNomRue(inter));
		System.out.println(this.plan.getNomRue(inter));
	}
	
	/**
	 * 
	 * Ajoute le point qui pr�c�de point de livraison dans la fen�tre de gestion d'ajout d'une �tape
	 * 
	 */
	
	public void ajouterPointPrecedentLivraison(Intersection inter) {
		System.out.println("called ajouterPointPrecedentLivraison");
		System.out.println("ETAT au call : " + this.etat);
		setPointPrecedentLivraison(inter);
		this.textPointPrecedentLivraison.setText(this.plan.getNomRue(inter));
		System.out.println(this.plan.getNomRue(inter));
	}
	
	/**
	 * 
	 * Ajoute le point de livraison dans la fen�tre de gestion d'ajout d'une �tape
	 * 
	 */
	
	public void ajouterNouveauPointLivraison(Intersection inter) {
		System.out.println("called ajouterNouveauPointLivraison");
		System.out.println("ETAT au call : " + this.etat);
		inter.setTypeIntersection(4);
		setNouveauPointLivraison(inter);
		this.textPointLivraison.setText(this.plan.getNomRue(inter));
		System.out.println(this.plan.getNomRue(inter));
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	
	@FXML
	public void actionSupprimerEtape() {
		etat = new EtatSupprimerEtape(this);
	}

	/**
	 * 
	 * 
	 * 
	 */
	
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
		System.out.println("test1");
		this.etat = new EtatFeuilleDeRoute(this);
		etat.feuilleDeRoute();
	}

	public void feuilleDeRoute() {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/feuilleDeRoutePopup.fxml"));
		loader.setController(this);
		Parent root;
		try {
			root = loader.load();
			this.ajouterStage.setScene(new Scene(root));
			this.ajouterStage.setResizable(false);
			this.ajouterStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

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
	
	public Intersection getPointPrecedentRecuperation() {
		return pointPrecedentRecuperation;
	}

	public void setPointPrecedentRecuperation(Intersection pointPrecedentRecuperation) {
		this.pointPrecedentRecuperation = pointPrecedentRecuperation;
	}
	
	public Intersection getPointPrecedentLivraison() {
		return pointPrecedentLivraison;
	}

	public void setPointPrecedentLivraison(Intersection pointPrecedentLivraison) {
		this.pointPrecedentLivraison = pointPrecedentLivraison;
	}
}
