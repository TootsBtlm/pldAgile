// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package modele;


import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Bastien
 * Repr�sente l'itin�raire de livraison final
 *
 */
public class Livraison {
	
	/**
	 * Liste d'itin�raires
	 */
	private ArrayList<Itineraire>listeItineraires;
	
	/**
	 * Heure de d�part de la livraison
	 */
	private Time heureDepart;
	
	/**
	 * Dictionnaire des heures d'arriv�e (valeur) pour chaque itin�raire (cl�)
	 */
	HashMap<Itineraire,Time>dictionnaireArriveesItineraires = new HashMap<Itineraire,Time>();

	/**
	 * Ensemble des requ�tes de la livraison
	 */
	EnsembleRequete requetes;
	
	/**
	 * Constructeur de livraison
	 * @param listeItineraires
	 * @param requetes
	 * @param heureDepart
	 */
	public Livraison(ArrayList<Itineraire> listeItineraires, EnsembleRequete requetes) {
		super();
		this.listeItineraires = listeItineraires;
		this.requetes = requetes;
		this.heureDepart = requetes.LieuDepart.getHeureDepart();
		
	}
	
	/**
	 * Cette fonction calcule les temps associ�s aux intersections principales du parcours.
	 */
	
	private void calculArrivees() {
		HashMap<Intersection,Long>tempsAssocieIntersection = new HashMap<Intersection,Long>();
		for(int i=0;i<this.requetes.getListeRequete().size();i++) {
			tempsAssocieIntersection.put(this.requetes.listeRequete.get(i).getPointDeRecuperation(), this.requetes.listeRequete.get(i).getDureeRecuperation());
			tempsAssocieIntersection.put(this.requetes.listeRequete.get(i).getPointDeLivraison(), this.requetes.listeRequete.get(i).getDureeLivraison());
		}
		this.dictionnaireArriveesItineraires.put(this.listeItineraires.get(0), new Time(this.heureDepart.getTime()+this.listeItineraires.get(0).getTemps().longValue()));
		
		if(this.listeItineraires.size() > 0) {
			

			for(int i=1;i<this.listeItineraires.size();i++) {
				Time temps = new Time(
						this.dictionnaireArriveesItineraires.get(this.listeItineraires.get(i-1)).getTime()+
						this.listeItineraires.get(i).getTemps().longValue() + 
						tempsAssocieIntersection.get(listeItineraires.get(i).getListeIntersections().get(0))				
						);
				
				this.dictionnaireArriveesItineraires.put(this.listeItineraires.get(i),temps );
			}
		}
		
	}
};
