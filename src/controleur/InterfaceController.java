package controleur;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.EnsembleRequete;
import modele.Intersection;
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
	private Text textPointPrecedentRecuperation;

	@FXML
	private Text textPointPrecedentLivraison;

	@FXML
	private Text textPointRecuperation;

	@FXML
	private Text textPointLivraison;

	@FXML
	private ListView<String> feuilleDeRoute;

	@FXML
	private Pane intersectionPane;


	@FXML
	private Button btnOuvrirPlan;

	@FXML
	private ListView<String> listViewRequest;

	private Stage stage;
	private Stage feuilleDeRouteStage;
	private Stage ajouterStage;
	private Stage messageErreurStage;

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
	 * Créer une instance de la classe InterfaceController. Initialise les attributs tsp, etat, ajouterStage et mouseEvents de l'instance.
	 * 
	 */

	public InterfaceController() {
		tsp = new TSP1();
		etat = new EtatInitial(this);
		ajouterStage = new Stage();
		messageErreurStage = new Stage();
		mouseEvents = new MouseEvents(requeteNodeListView, this.listViewRequest, this);
	}

	/**
	 * 
	 * Fait appel à la fonction polymorphe chargerFichierPlan de la classe Etat 
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
	 * Permet de charger le plan en faisant appel à la classe Lecteur
	 * 
	 */
	public void chargerFichierPlan() {
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(this.stage);
		if(file != null) {
			String path = file.getPath();
			System.out.println(path);
			Lecteur lecteur = new Lecteur();
			this.plan = lecteur.LirePlan(path);
			if(this.plan == null) {
				afficherPopupErreur("Fichier incorrect ! Veuillez réessayer");
				//System.out.println("Fichier incorrect");
			} else {
				System.out.println(intersectionPane);
				this.vueGraphique = new VueGraphique(this.plan, this.planCanvas, this.intersectionPane, this.itineraireCanvas, mouseEvents);
				this.vueGraphique.drawPlan();
				for(int i = 0; i < this.vueGraphique.getIntersectionPane().getChildren().size(); i++) {
					mouseEvents.setIntersectionCliquable(this.vueGraphique.getIntersectionPane().getChildren().get(i));
				}

				this.listViewRequest.getItems().clear();
				this.textChargerFichierRequete.setVisible(true);
				etat = new EtatPlanCharge(this);
			}
		} else {
			System.out.println("Fichier incorrect");
		}
	}

	/**
	 * 
	 * Fait appel à la fonction polymorphe chargerFichierRequetes de la classe Etat 
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
	 * Permet de charger le fichier de requêtes en faisant appel à la classe Lecteur
	 * 
	 */

	public void chargerFichierRequete() {
		if(this.vueGraphique == null) {
			System.out.println("Charger d'abord un plan");
		} else {
			FileChooser fileChooser = new FileChooser();
			File file = fileChooser.showOpenDialog(this.stage);
			if(file != null) {
				String path = file.getPath();
				System.out.println(path);
				Lecteur lecteur = new Lecteur();
				this.ensembleRequete = lecteur.LireRequete(path, this.plan);
				if(this.ensembleRequete == null) {
					afficherPopupErreur("Fichier incorrect ! Veuillez réessayer");
				} else {
					this.vueTextuelle = new VueTextuelle(this.plan, this.listViewRequest, this.mouseEvents);
					this.vueTextuelle.drawText(this.ensembleRequete, this.listViewRequest);
					this.vueGraphique.drawRequests(this.ensembleRequete);

					this.requeteNodes = this.vueGraphique.getIntersectionPane().getChildren();

					this.requeteNodeListView.clear();
					for(int i = 0; i < this.vueGraphique.getRequetes().size(); i++) {
						requeteNodeListView.put(this.vueGraphique.getRequetes().get(i), listViewRequest.getItems().get(i));
						//this.requeteNodes = this.vueGraphique.getIntersectionPane().getChildren();
					}
					System.out.println("creation mouse event : " + this.listViewRequest);
					//					mouseEvents = new MouseEvents(this.requeteNodeListView, this.listViewRequest, this);
					mouseEvents.setListViewRequest(this.listViewRequest);


					// Ajout d'un event handler sur les nodes correspondant aux requêtes sur la carte

					for(int i = 0; i < this.vueGraphique.getRequetes().size(); i++) {
						mouseEvents.requeteCliquable(this.vueGraphique.getRequetes().get(i));
					}

					this.mouseEvents.setListeCliquable();
					this.textChargerFichierRequete.setVisible(false);;

					//System.out.println("test");
					etat = new EtatListeRequeteChargee(this);
				}
			} else {
				System.out.println("fichier incorrect");
			}
		}
	}

	/**
	 * 
	 * Fait appel à la fonction polymorphe calculerItineraire de la classe Etat 
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
	 * Permet de charger l'itinéraire calculé en faisant appel à la méthode getMatriceCout de la classe Plan
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
	 * Fait appel à la fonction polymorphe ajouterEtape de la classe Etat ce qui lance une autre fenêtre de gestion de l'ajout d'une étape
	 * 
	 */

	@FXML
	public void actionAjouterEtape() {
		System.out.println("called actionAjouterEtape");
		System.out.println("ETAT au call : " + this.etat);
		//etat = new EtatAjouterEtape(this);
		etat.ajouterEtape();
	}

	/**
	 * 
	 * Déclenchée lorsque l'utilisateur appuie sur le bouton ajouter un point de récupération. Permet à l'utilisateur de sélectionner le point de récupération à ajouter
	 * 
	 */

	@FXML
	public void actionAjouterPointRecuperation() {
		System.out.println("called actionAjouterPointRecuperation");
		System.out.println("ETAT au call : " + this.etat);
		etat.ajouterPointRecuperation();
	}

	/**
	 * 
	 * Déclenchée lorsque l'utilisateur appuie sur le bouton ajouter le point qui précède le point de récupération. Permet à l'utilisateur de sélectionner le point précédent à ajouter
	 * 
	 */

	@FXML
	public void actionAjouterPointPrecedentRecuperation() {
		System.out.println("called actionAjouterPointPrecedentRecuperation");
		System.out.println("ETAT au call : " + this.etat);

		etat.ajouterPointPrecedentRecuperation();
	}

	/**
	 * 
	 * Déclenchée lorsque l'utilisateur appuie sur le bouton ajouter le point qui précède le point de livraison. Permet à l'utilisateur de sélectionner le point précédent à ajouter
	 * 
	 */

	@FXML
	public void actionAjouterPointPrecedentLivraison() {
		System.out.println("called actionAjouterPointPrecedentLivraison");
		System.out.println("ETAT au call : " + this.etat);

		etat.ajouterPointPrecedentLivraison();
	}

	/**
	 * 
	 * Déclenchée lorsque l'utilisateur appuie sur le bouton ajouter le point de livraison. Permet à l'utilisateur de sélectionner le point de livraison à ajouter
	 * 
	 */

	@FXML
	public void actionAjouterPointLivraison() {
		System.out.println("called actionAjouterPointLivraison");
		System.out.println("ETAT au call : " + this.etat);

		etat.ajouterPointLivraison();
	}

	/**
	 * 
	 * Lance une nouvelle fenêtre qui permet à l'utilisateur de gérer l'ajout d'une nouvelle étape
	 * 
	 */

	public void ajouterEtape() {
		etat = new EtatAjouterEtape(this);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/ajouterPopup.fxml"));
		loader.setController(this);
		Parent root;
		try {
			root = loader.load();
			this.ajouterStage.setScene(new Scene(root));
			this.ajouterStage.setResizable(false);
			this.ajouterStage.show();
			this.ajouterStage.setAlwaysOnTop(true);
			
			// Si l'utilisateur ferme la fenetre on revient dans l'etat itineraire calculé
			ajouterStage.setOnHidden(event -> {
				etat = new EtatItineraireCalcule(this);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Valide l'ajout de l'étape en calculant le nouvel itinéraire
	 * 
	 */

	public void validerAjouterEtape() {
		if(this.pointPrecedentLivraison == null || this.pointPrecedentRecuperation == null || this.pointPrecedentLivraison == null || this.nouveauPointRecuperation == null || this.nouveauPointLivraison == null) {
			this.afficherPopupErreur("Erreur lors de l'ajout d'une requete");
			//etat = new EtatItineraireCalcule(this);
		} else {
			Long duree = (long) 10;
			this.livraison = plan.ajouterRequete(this.livraison, this.pointPrecedentRecuperation, this.pointPrecedentLivraison, this.nouveauPointRecuperation, this.nouveauPointLivraison, duree, duree);
			this.ensembleRequete = this.livraison.getRequetes();
			this.vueGraphique.drawRequests(this.ensembleRequete);
			this.vueGraphique.drawItineraire(this.livraison);
			this.vueTextuelle.drawText(livraison.getRequetes(), listViewRequest);
			this.vueTextuelle.drawItineraire(this.livraison, this.requeteNodeListView);
			this.ajouterStage.close();
			etat = new EtatItineraireCalcule(this);
		}
	}

	/**
	 * 
	 * Permet à l'utilisateur de valider l'ajout d'une étape en faisant appel à la fonction polymorphe validerAjouterEtape de la classe Etat
	 * 
	 */

	@FXML
	public void actionValiderAjouterEtape() {
		etat.validerAjouterEtape();
	}

	/**
	 * 
	 * Ajoute le point de récupération dans la fenêtre de gestion d'ajout d'une étape
	 * 
	 */

	public void ajouterNouveauPointRecuperation(Intersection inter) {
		System.out.println("called ajouterNouveauPointRecuperation");
		System.out.println("ETAT au call : " + this.etat);
		inter.setTypeIntersection(3);
		setNouveauPointRecuperation(inter);
		this.textPointRecuperation.setText(this.plan.getNomRue(inter));
		System.out.println(this.plan.getNomRue(inter));
		etat = new EtatAjouterEtape(this);
	}

	/**
	 * 
	 * Ajoute le point qui précède point de récupération dans la fenêtre de gestion d'ajout d'une étape
	 * 
	 */

	public void ajouterPointPrecedentRecuperation(Intersection inter) {
		System.out.println("called ajouterPointPrecedentRecuperation");
		System.out.println("ETAT au call : " + this.etat);
		setPointPrecedentRecuperation(inter);
		this.textPointPrecedentRecuperation.setText(this.plan.getNomRue(inter));
		System.out.println(this.plan.getNomRue(inter));
		etat = new EtatAjouterEtape(this);
	}

	/**
	 * 
	 * Ajoute le point qui précède point de livraison dans la fenêtre de gestion d'ajout d'une étape
	 * 
	 */

	public void ajouterPointPrecedentLivraison(Intersection inter) {
		System.out.println("called ajouterPointPrecedentLivraison");
		System.out.println("ETAT au call : " + this.etat);
		setPointPrecedentLivraison(inter);
		this.textPointPrecedentLivraison.setText(this.plan.getNomRue(inter));
		System.out.println(this.plan.getNomRue(inter));
		etat = new EtatAjouterEtape(this);
	}

	/**
	 * 
	 * Ajoute le point de livraison dans la fenêtre de gestion d'ajout d'une étape
	 * 
	 */

	public void ajouterNouveauPointLivraison(Intersection inter) {
		System.out.println("called ajouterNouveauPointLivraison");
		System.out.println("ETAT au call : " + this.etat);
		inter.setTypeIntersection(4);
		setNouveauPointLivraison(inter);
		this.textPointLivraison.setText(this.plan.getNomRue(inter));
		System.out.println(this.plan.getNomRue(inter));
		etat = new EtatAjouterEtape(this);
	}

	/**
	 * 
	 * 
	 * 
	 */

	@FXML
	public void actionSupprimerEtape() {
		etat.supprimerEtape();
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

	public void afficherPopupErreur(String message) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/PopupError.fxml"));
		loader.setController(this);
		Parent root;
		try {
			messageErreurStage = new Stage();
			root = loader.load();
			messageErreurStage.setScene(new Scene(root));
			Text messageErreur =  (Text)messageErreurStage.getScene().lookup("#messageErreur");
			messageErreur.setText(message);

			Button boutonErreurFermer = (Button)messageErreurStage.getScene().lookup("#boutonErreurFermer");
			boutonErreurFermer.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent arg0) {
					messageErreurStage.close();
				}
			});
			messageErreurStage.setResizable(false);
			messageErreurStage.initModality(Modality.APPLICATION_MODAL);
			messageErreurStage.showAndWait();
			messageErreurStage.setAlwaysOnTop(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void actionCreerFeuilleDeRoute() {
		System.out.println("test1");
		System.out.println(this.feuilleDeRoute);
		etat.construireFeuilleDeRoute();
	}

	public void construireFeuilleDeRoute() {
		System.out.println(this.feuilleDeRoute);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vue/feuilleDeRoutePopup.fxml"));
		loader.setController(this);
		Parent root;
		try {
			this.feuilleDeRouteStage = new Stage();
			root = loader.load();
			this.feuilleDeRouteStage.setScene(new Scene(root));
			this.feuilleDeRouteStage.setResizable(false);
			this.feuilleDeRouteStage.show();
			ObservableList<String> items = FXCollections.observableArrayList();
			items.add(this.livraison.getRequetes().getLieuDepart().getPointDeDepart().getIdVisible().toString() + " Depot" + 
					", Adresse : " + plan.getNomRue(ensembleRequete.getLieuDepart().getPointDeDepart()));

			for (int i = 1; i< this.livraison.getListeItineraires().size(); i++) {

					
					items.add("Prendre le chemin suivant :" + this.livraison.getListeItineraires().get(i).getListeNomsRue().get(0));
					for (int k = 1; k< this.livraison.getListeItineraires().get(i).getListeNomsRue().size(); k++) {
						if (!(this.livraison.getListeItineraires().get(i).getListeNomsRue().get(k).equals(this.livraison.getListeItineraires().get(i).getListeNomsRue().get(k-1))) && !(this.livraison.getListeItineraires().get(i).getListeNomsRue().get(k).equals(""))){
						items.add("Prendre le chemin suivant : " + this.livraison.getListeItineraires().get(i).getListeNomsRue().get(k));
						}
					}
					if(this.livraison.getListeItineraires().get(i).getListeIntersections().get(0).getTypeIntersection() == 3) {
					items.add("Récupération ici : " + this.plan.getNomRue(this.livraison.getListeItineraires().get(i).getListeIntersections().get(0)) + " à " + this.livraison.getDictionnaireArriveesItineraires().get(this.livraison.getListeItineraires().get(i)) + " heures. ");
					}
					else if(this.livraison.getListeItineraires().get(i).getListeIntersections().get(0).getTypeIntersection() == 4) {
					items.add("Livraison ici : " + this.plan.getNomRue(this.livraison.getListeItineraires().get(i).getListeIntersections().get(0)) + " à " + this.livraison.getDictionnaireArriveesItineraires().get(this.livraison.getListeItineraires().get(i)) + " heures. ");
					}
			}
			this.feuilleDeRoute.setItems(items);
			this.etat = new EtatItineraireCalcule(this);
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

	public Stage getAjouterStage() {
		return ajouterStage;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public void setAjouterStage(Stage ajouterStage) {
		this.ajouterStage = ajouterStage;
	}

	public Stage getMessageErreurStage() {
		return messageErreurStage;
	}

	public void setMessageErreurStage(Stage messageErreurStage) {
		this.messageErreurStage = messageErreurStage;
	}
}
