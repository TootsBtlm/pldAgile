package vue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import modele.EnsembleRequete;


public class VueTextuelle {
	
	public VueTextuelle() {
		
	}
	
	public void drawText(EnsembleRequete ense, ListView<String> listViewRequest) {
		ObservableList<String> items = FXCollections.observableArrayList();
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

}
