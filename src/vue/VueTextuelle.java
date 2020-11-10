package vue;

import java.util.List;

import com.google.common.collect.BiMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import modele.EnsembleRequete;
import modele.Intersection;
import modele.Itineraire;
import modele.Livraison;
import modele.Plan;


public class VueTextuelle {

	private Plan plan;
	private ListView<String> listViewRequest;

	public VueTextuelle(Plan plan, ListView<String> listViewRequest) {
		this.plan = plan;
		this.listViewRequest = listViewRequest;
	}

	public void drawText(EnsembleRequete ense, ListView<String> listViewRequest) {
		ObservableList<String> items = FXCollections.observableArrayList();
		items.add("Depot :" + ense.getLieuDepart().getPointDeDepart().getId().toString() + 
				", Adresse : " + plan.getNomRue(ense.getLieuDepart().getPointDeDepart()));

		for (int i = 0; i< ense.getListeRequete().size(); i++) {

			items.add("Point de recup :" + ense.getListeRequete().get(i).getPointDeLivraison().getId().toString() + 
					", Adresse : " + plan.getNomRue(ense.getListeRequete().get(i).getPointDeLivraison()));
			items.add("Point de livraison :" + ense.getListeRequete().get(i).getPointDeRecuperation().getId().toString() + 
					", Adresse : " + plan.getNomRue(ense.getListeRequete().get(i).getPointDeRecuperation()));
		}
		listViewRequest.setItems(items);
	}

	public void drawItineraire(Livraison livraison, BiMap<Node, String> requeteNodeListView) {
		ObservableList<String> items = this.listViewRequest.getItems();
		ObservableList<String> newItems = FXCollections.observableArrayList();
		//		items.add("Depot :" + ense.get(0).getPointDeDepart().getId().toString() + 
		//				"Lat :" + ense.getLieuDepart().getPointDeDepart().getLatitude().toString() + 
		//				"Long :" + ense.getLieuDepart().getPointDeDepart().getLongitude().toString());

		int sizeLivraison = livraison.getListeItineraires().size();
		
		newItems.add("Depot :" + livraison.getListeItineraires().get(0).getListeIntersections().get(0).getId().toString() + 
				", Adresse : " + plan.getNomRue(livraison.getListeItineraires().get(0).getListeIntersections().get(0)));
		
		for(int i = 0; i < livraison.getListeItineraires().size(); i++) {
			Itineraire itineraire = livraison.getListeItineraires().get(i);

			for(String str : items) {
				if(str.equals("Point de recup :" + itineraire.getListeIntersections().get(0).getId().toString() + 
						", Adresse : " + plan.getNomRue(itineraire.getListeIntersections().get(0)))) {
					newItems.add(str);
				} else if(str.equals("Point de livraison :" + itineraire.getListeIntersections().get(0).getId().toString() + 
						", Adresse : " + plan.getNomRue(itineraire.getListeIntersections().get(0)))) {
					newItems.add(str);
				}
			}
			

			//				if(requeteNodeListView.containsValue("Point de recup :" + itineraire.getListeIntersections().get(0).getId().toString() + 
			//						", Adresse : " + plan.getNomRue(itineraire.getListeIntersections().get(0)))) {
			//					newItems.add(requeteNodeListView.get)
			//				}

			//				items.add("Point de recup :" + itineraire.getListeIntersections().get(0).getId().toString() + 
			//						", Adresse : " + plan.getNomRue(itineraire.getListeIntersections().get(0)));
			//				items.add("Point de livraison :" + ense.getListeRequete().get(i).getPointDeRecuperation().getId().toString() + 
			//						"Lat :" + ense.getListeRequete().get(i).getPointDeRecuperation().getLatitude().toString() + 
			//						"Long :" + ense.getListeRequete().get(i).getPointDeRecuperation().getLongitude().toString());

//			newItems.add("ID :" + itineraire.getListeIntersections().get(0).getId().toString() + 
//					", Adresse : " + plan.getNomRue(itineraire.getListeIntersections().get(0)));
//
//			if(i == livraison.getListeItineraires().size()) {
//				newItems.add("ID :" + itineraire.getListeIntersections().get(itineraire.getListeIntersections().size()-1).getId().toString() + 
//						", Adresse : " + plan.getNomRue(itineraire.getListeIntersections().get(itineraire.getListeIntersections().size()-1)));
//			}
		}
		Itineraire itineraire = livraison.getListeItineraires().get(sizeLivraison - 1);
		int itineraireSize = itineraire.getListeIntersections().size();
		newItems.add("Depot :" + itineraire.getListeIntersections().get(itineraireSize-1).getId().toString() + 
						", Adresse : " + plan.getNomRue(itineraire.getListeIntersections().get(itineraireSize-1)));
		listViewRequest.setItems(newItems);
	}
}
