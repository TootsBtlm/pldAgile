package controleur;

import java.util.HashMap;
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
 * Représente la classe controleur de l'application, qui fait appel aux classes états pour gérer les différentes actions possibles
 *
 */

public class MouseEvents {

	private BiMap<Node, String> requeteNodeListView;
	private ListView<String> listViewRequest;
	private Map<Node, Intersection> nodeLinkedToIntersection;
	private InterfaceController interfaceController;
	
	/**
	 * @param requeteNodeListView, listViewRequest, interfaceController
	 * Crée une instance de la classe MouseEvents, et initialise les attributs interfaceController, requeteNodeListView et listViewRequest de l'instance
	 * 
	 */
	
	public MouseEvents(BiMap<Node, String> requeteNodeListView, ListView<String> listViewRequest, InterfaceController interfaceController) {
		this.interfaceController = interfaceController;
		this.requeteNodeListView = requeteNodeListView;
		this.listViewRequest = listViewRequest;
	}

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
