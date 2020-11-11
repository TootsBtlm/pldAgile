package vue;

import java.util.List;

import com.google.common.collect.BiMap;

import controleur.MouseEvents;
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
	private MouseEvents mouseEvents;

	public VueTextuelle(Plan plan, ListView<String> listViewRequest, MouseEvents mouseEvents) {
		this.plan = plan;
		this.listViewRequest = listViewRequest;
		this.mouseEvents = mouseEvents;
	}

	public void drawText(EnsembleRequete ense, ListView<String> listViewRequest) {
		ObservableList<String> items = FXCollections.observableArrayList();
		items.add(ense.getLieuDepart().getPointDeDepart().getIdVisible().toString() + " Depot" + 
				", Adresse : " + plan.getNomRue(ense.getLieuDepart().getPointDeDepart()));

		for (int i = 0; i< ense.getListeRequete().size(); i++) {

			items.add(ense.getListeRequete().get(i).getPointDeLivraison().getIdVisible().toString() + " Point de recup" + ", Adresse : " + plan.getNomRue(ense.getListeRequete().get(i).getPointDeRecuperation()).toString());
			items.add(ense.getListeRequete().get(i).getPointDeRecuperation().getIdVisible().toString() + " Point de livraison" + ", Adresse : " + plan.getNomRue(ense.getListeRequete().get(i).getPointDeLivraison()).toString());
		}
		this.listViewRequest.setItems(items);
	}

	public void drawItineraire(Livraison livraison, BiMap<Node, String> requeteNodeListView) {
		ObservableList<String> items = this.listViewRequest.getItems();
		ObservableList<String> newItems = FXCollections.observableArrayList();

		int sizeLivraison = livraison.getListeItineraires().size();

		newItems.add(livraison.getListeItineraires().get(0).getListeIntersections().get(0).getIdVisible().toString() + " Depot"  + 
				", Adresse : " + plan.getNomRue(livraison.getListeItineraires().get(0).getListeIntersections().get(0)));

		for(int i = 1; i < sizeLivraison; i++) {

			Itineraire itineraire = livraison.getListeItineraires().get(i);
			Intersection inter = itineraire.getListeIntersections().get(0);
			System.out.println("intersection : " + inter);
			// TODO remettre le lien 

			if(inter.getTypeIntersection() == 3) {
				for(int j = 0; j < items.size(); j++) {
					String s = items.get(j);
					if(s.equals(inter.getIdVisible().toString() + " Point de recup"  
							+ ", Adresse : " + plan.getNomRue(inter))) {
						newItems.add(items.get(j).toString());
					}
				}
			} else if(inter.getTypeIntersection() == 4) {
				for(int j = 0; j < items.size(); j++) {
					String s = items.get(j);
					if(s.equals(inter.getIdVisible().toString() + " Point de livraison"  
							+ ", Adresse : " + plan.getNomRue(inter))) {
						newItems.add(items.get(j).toString());
					}
				}
			}
		}


		Itineraire itineraire = livraison.getListeItineraires().get(sizeLivraison - 1);
		int itineraireSize = itineraire.getListeIntersections().size();
		newItems.add(itineraire.getListeIntersections().get(itineraireSize-1).getIdVisible().toString() + " Depot" + 
				", Adresse : " + plan.getNomRue(itineraire.getListeIntersections().get(itineraireSize-1)));
		this.listViewRequest.setItems(newItems);
	}
}
