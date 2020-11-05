package controleur;

import java.util.Iterator;

import com.google.common.collect.BiMap;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class MouseEvents {

	private BiMap<Node, String> requeteNodeListView;
	private ListView<String> listViewRequest;

	public MouseEvents(BiMap<Node, String> requeteNodeListView, ListView<String> listViewRequest) {
		this.requeteNodeListView = requeteNodeListView;
		this.listViewRequest = listViewRequest;
	}

	EventHandler<MouseEvent> clickRequeteNode = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			if(event.getSource() instanceof Circle) {
				Circle p = ((Circle)(event.getSource()));

				for(Node key : requeteNodeListView.keySet()) {
					Circle nodeC = (Circle)(key);
					nodeC.setRadius(6.0);
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
			for(Node key : requeteNodeListView.keySet()) {
				Circle nodeC = (Circle)(key);
				nodeC.setRadius(8.0);
			}
			String clickedString = listViewRequest.getSelectionModel().getSelectedItem();
			Node n = requeteNodeListView.inverse().get(clickedString);
			Circle p = (Circle)(n);
			p.setRadius(12.0);
		}
	};



	public void requeteCliquable(Node node) {
		node.setOnMousePressed(this.clickRequeteNode);
	}
	
	public void setListeCliquable() {
		listViewRequest.setOnMouseClicked(clickRequeteListeTextuelle);
	}
}
