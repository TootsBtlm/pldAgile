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

public class MouseEvents {

	private BiMap<Node, String> requeteNodeListView;
	private ListView<String> listViewRequest;
	private Map<Node, Intersection> nodeLinkedToIntersection;
	private InterfaceController interfaceController;
	
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
				
				Intersection inter = nodeLinkedToIntersection.get(p);
				
				if (interfaceController.getEtat() instanceof EtatSupprimerEtape) {
					interfaceController.supprimerEtape(inter);
				}
				
				for(Node key : requeteNodeListView.keySet()) {
					Circle nodeC = (Circle)(key);
					nodeC.setRadius(8.0);
				}
				p.setRadius(12.0);
				listViewRequest.getSelectionModel().select(requeteNodeListView.get(p));
				System.out.println(p);
			}

		}
	};

	EventHandler<MouseEvent> clickRequeteListeTextuelle = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
//			System.out.println(requeteNodeListView);
			for(Node key : requeteNodeListView.keySet()) {
				Circle nodeC = (Circle)(key);
				nodeC.setRadius(8.0);
			}
			String clickedString = listViewRequest.getSelectionModel().getSelectedItem();
			System.out.println("Clicked string : " + clickedString);
			Node n = requeteNodeListView.inverse().get(clickedString);
			Circle p = (Circle)(n);
			p.setRadius(12.0);
		}
	};
	
	EventHandler<MouseEvent> clickIntersection = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			if(event.getSource() instanceof Circle) {
				Circle p = ((Circle)(event.getSource()));
				Intersection inter = nodeLinkedToIntersection.get(p);
				System.out.println("MOUSE EVENTS : " + interfaceController.getEtat());
				if(interfaceController.getEtat() instanceof EtatAjouterEtape) {
					//interfaceController.ajouterEtape(inter);
				}
				else if (interfaceController.getEtat() instanceof EtatSupprimerEtape) {
					interfaceController.supprimerEtape(inter);
				} else if(interfaceController.getEtat() instanceof EtatAjouterPointRecuperation) {
					System.out.println("clique pendant etat point recuperation");
					interfaceController.ajouterNouveauPointRecuperation(inter);
				}
				System.out.println(inter);
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
