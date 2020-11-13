package controleur;

import java.util.Map;

import com.google.common.collect.BiMap;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import modele.Intersection;

/**
 * 
 * @author Hexanome4103
 * Réprésente la classe contenant toutes les intéractions entre la vue graphique, la vue textuelle et l'utilisateur
 *
 */
public class MouseEvents {

	private BiMap<Node, String> requeteNodeListView;
	private ListView<String> listViewRequest;
	private Map<Node, Intersection> nodeLinkedToIntersection;
	private InterfaceController interfaceController;
	
	/**
	 * Constructeur de la classe MouseEvents
	 * @param requeteNodeListView, listViewRequest, interfaceController
	 * 
	 */
	public MouseEvents(BiMap<Node, String> requeteNodeListView, ListView<String> listViewRequest, InterfaceController interfaceController) {
		this.interfaceController = interfaceController;
		this.requeteNodeListView = requeteNodeListView;
		this.listViewRequest = listViewRequest;
	}
	
	/**
	 * Evenement déclenché lorsque l'utilisateur clique sur une requête sur la vue graphique
	 */
	EventHandler<MouseEvent> clickRequeteNode = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			if(event.getSource() instanceof Circle) {
				Circle p = ((Circle)(event.getSource()));
				listViewRequest.getSelectionModel().select(requeteNodeListView.get(p));
				for(Node key : requeteNodeListView.keySet()) {
					Circle nodeC = (Circle)(key);
					nodeC.setRadius(8.0);
				}
				p.setRadius(12.0);
				
				Intersection inter = nodeLinkedToIntersection.get(p);
				
				if (interfaceController.getEtat() instanceof EtatSupprimerEtape) {
					interfaceController.supprimerEtape(inter);
				}
				else if (interfaceController.getEtat() instanceof EtatAjouterPointPrecedentRecuperation) {
					interfaceController.ajouterPointPrecedentRecuperation(inter);
				}
				else if (interfaceController.getEtat() instanceof EtatAjouterPointPrecedentLivraison) {
					interfaceController.ajouterPointPrecedentLivraison(inter);
				}
			}

		}
	};

	/**
	 * Evènement déclenché lorsque l'utilisateur clique sur un élément de la vue textuelle
	 */
	EventHandler<MouseEvent> clickRequeteListeTextuelle = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			for(Node key : requeteNodeListView.keySet()) {
				Circle nodeC = (Circle)(key);
				nodeC.setRadius(8.0);
			}
			String clickedString = listViewRequest.getSelectionModel().getSelectedItem();
			Node n = requeteNodeListView.inverse().get(clickedString);
			Circle p = (Circle)(n);
			p.setRadius(12.0);
			Intersection inter = nodeLinkedToIntersection.get(p);
			if (interfaceController.getEtat() instanceof EtatSupprimerEtape) {
				interfaceController.supprimerEtape(inter);
			}
			else if (interfaceController.getEtat() instanceof EtatAjouterPointPrecedentRecuperation) {
				interfaceController.ajouterPointPrecedentRecuperation(inter);
			}
			else if (interfaceController.getEtat() instanceof EtatAjouterPointPrecedentLivraison) {
				interfaceController.ajouterPointPrecedentLivraison(inter);
			}
		}
	};
	
	/**
	 * Evènement déclenché lorsque l'utilisateur clique sur une intersection de la vue graphique
	 */
	EventHandler<MouseEvent> clickIntersection = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			if(event.getSource() instanceof Circle) {
				Circle p = ((Circle)(event.getSource()));
				Intersection inter = nodeLinkedToIntersection.get(p);
				if (interfaceController.getEtat() instanceof EtatSupprimerEtape) {
					interfaceController.supprimerEtape(inter);
				} else if(interfaceController.getEtat() instanceof EtatAjouterPointRecuperation) {
					interfaceController.ajouterNouveauPointRecuperation(inter);
				} else if(interfaceController.getEtat() instanceof EtatAjouterPointLivraison) {
					interfaceController.ajouterNouveauPointLivraison(inter);
				}
			}

		}
	};

	public void requeteCliquable(Node node) {
		node.setOnMousePressed(this.clickRequeteNode);
	}
	
	public void setListeCliquable() {
		listViewRequest.setOnMouseClicked(clickRequeteListeTextuelle);
	}
	
	public void setIntersectionCliquable(Node node) {
		node.setOnMousePressed(this.clickIntersection);
	}

	public void setNodeLinkedToIntersection(Map<Node, Intersection> nodeLinkedToIntersection) {
		this.nodeLinkedToIntersection = nodeLinkedToIntersection;
	}
	
	public void setListViewRequest(ListView<String> listViewRequest) {
		this.listViewRequest = listViewRequest;
	}
}
