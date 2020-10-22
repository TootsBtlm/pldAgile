package modele;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;



public class EnsembleRequete {

	
	public HashMap<Long,Integer> intersectionIdRetourne = new HashMap<Long, Integer>();
	
	ArrayList<Requete> listeRequete ;
	Depot LieuDepart;

	public HashMap<Long, Integer> getIntersectionIdRetourne() {
		return intersectionIdRetourne;
	}
	public void setIntersectionIdRetourne(HashMap<Long, Integer> intersectionIdRetourne) {
		this.intersectionIdRetourne = intersectionIdRetourne;
	}	
	public ArrayList<Requete> getListeRequete() {
		return listeRequete;
	}
	public void setListeRequete(ArrayList<Requete> listeRequete) {
		this.listeRequete = listeRequete;
	}
	public Depot getLieuDepart() {
		return LieuDepart;
	}
	public void setLieuDepart(Depot lieuDepart) {
		LieuDepart = lieuDepart;
	}
	public EnsembleRequete(ArrayList<Requete> listeRequete, Depot lieuDepart) {
		super();
		this.listeRequete = listeRequete;
		LieuDepart = lieuDepart;
	}
	
	
	public EnsembleRequete(HashMap<Long, Integer> intersectionIdRetourne, ArrayList<Requete> listeRequete,
			Depot lieuDepart) {
		super();
		this.intersectionIdRetourne = intersectionIdRetourne;
		this.listeRequete = listeRequete;
		LieuDepart = lieuDepart;
	}
	public EnsembleRequete() {
		super();
	}
	@Override
	public String toString() {
		return "RecapDemande [listeRequete=" + listeRequete + ", LieuDepart=" + LieuDepart + "]";
	}
	
	public ArrayList<Pair<Integer, Integer>> listePairesIntersections() {
		ArrayList<Pair<Integer, Integer>> liste = new ArrayList<Pair<Integer, Integer>>();
		for(int i  = 0 ; i<this.listeRequete.size(); i++) {	
			Intersection pointDeRecuperation = this.listeRequete.get(i).getPointDeRecuperation();
			Intersection pointDeLivraison = this.listeRequete.get(i).getPointDeLivraison();			
			
			Pair<Integer,Integer> nouvellePaire = new Pair<Integer,Integer>(intersectionIdRetourne.get(pointDeRecuperation.getId()),intersectionIdRetourne.get(pointDeLivraison.getId()));
			liste.add(nouvellePaire);
		}
		return liste;
		
	}
	
	public int indexLieuDepart() {
		
		return intersectionIdRetourne.get(this.getLieuDepart().getPointDeDepart().getId());
	}
	
	
	public Double[][] matriceCout() {
		
		int nbIntersection = this.listeRequete.size()*2 + 1;
		ArrayList<Intersection> listeIntersections = new ArrayList<Intersection>() ;
		for(int i = 0 ; i < this.listeRequete.size(); i++) {
			listeIntersections.add(listeRequete.get(i).getPointDeRecuperation());
			listeIntersections.add(listeRequete.get(i).getPointDeRecuperation());
		}
		Double[][] matriceCouts = new Double[nbIntersection][nbIntersection];
		
		for(int i = 0 ; i < nbIntersection ; i++) {
			for(int j = 0 ; j < nbIntersection ; j++) {
				Double longi = listeIntersections.get(i).getLongitude();
				Double longj = listeIntersections.get(j).getLongitude();
				Double lati = listeIntersections.get(i).getLatitude();
				Double latj = listeIntersections.get(j).getLatitude();
				matriceCouts[i][j] = (longi-longj)*(longi-longj) +(latj-lati)*(latj-lati) ;
			}
			
		}
		
		return matriceCouts;		
		
	}
	
	
}
