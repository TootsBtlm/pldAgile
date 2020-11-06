package vue;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import modele.EnsembleRequete;
import modele.Intersection;


public class VueTextuelle {

	public VueTextuelle() {

	}

	public void drawText(EnsembleRequete ense, ListView<String> listViewRequest) {
		ObservableList<String> items = FXCollections.observableArrayList();
		items.add("Depot :" + ense.getLieuDepart().getPointDeDepart().getId().toString() + 
				"Lat :" + ense.getLieuDepart().getPointDeDepart().getLatitude().toString() + 
				"Long :" + ense.getLieuDepart().getPointDeDepart().getLongitude().toString());

		for (int i = 0; i< ense.getListeRequete().size(); i++) {

			items.add("Point de recup :" + ense.getListeRequete().get(i).getPointDeLivraison().getId().toString() + 
					"Lat :" + ense.getListeRequete().get(i).getPointDeLivraison().getLatitude().toString() + 
					"Long :" + ense.getListeRequete().get(i).getPointDeLivraison().getLongitude().toString());
			items.add("Point de livraison :" + ense.getListeRequete().get(i).getPointDeRecuperation().getId().toString() + 
					"Lat :" + ense.getListeRequete().get(i).getPointDeRecuperation().getLatitude().toString() + 
					"Long :" + ense.getListeRequete().get(i).getPointDeRecuperation().getLongitude().toString());
		}
		listViewRequest.setItems(items);
	}
	
//	public void drawItineraire(List<Intersection> ense, ListView<String> listViewRequest) {
//		ObservableList<String> items = FXCollections.observableArrayList();
//		items.add("Depot :" + ense.get(0).getPointDeDepart().getId().toString() + 
//				"Lat :" + ense.getLieuDepart().getPointDeDepart().getLatitude().toString() + 
//				"Long :" + ense.getLieuDepart().getPointDeDepart().getLongitude().toString());
//
//		for (int i = 0; i < ense.size(); i++) {
//
//			items.add("Point de recup :" + ense.get(i).getId().toString() + 
//					"Lat :" + ense.get(i).getLatitude().toString() + 
//					"Long :" + ense.get(i).getLongitude().toString());
//			items.add("Point de livraison :" + ense.getListeRequete().get(i).getPointDeRecuperation().getId().toString() + 
//					"Lat :" + ense.getListeRequete().get(i).getPointDeRecuperation().getLatitude().toString() + 
//					"Long :" + ense.getListeRequete().get(i).getPointDeRecuperation().getLongitude().toString());
//		}
//		listViewRequest.setItems(items);
//	}

}
