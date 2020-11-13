package modele;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.util.Pair;



public class EnsembleRequete {


	private HashMap<Long,Integer> intersectionIdRetourne = new HashMap<Long, Integer>();
	/**
	 * Cet attribut liste toutes les requetes que le livreur doit effectuer.
	 */
	private ArrayList<Requete> listeRequete ;
	/**
	 * Lieu de départ de la livraison.
	 */
	private Depot LieuDepart;

	
	
	
	/* Method */
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
		this.modifierIntersections();
	}
	/**
	 * Cette fonction attribut un identifiant aux intersections mentionnées dans une liste de requête 
	 * et leur donne un type (1 : non renseigné, 2 : depot, 3 : point de recuperation, 4 point de livraison)
	 */
	
	public void modifierIntersections(){
		Long compteur = new Long(1);
		this.LieuDepart.getPointDeDepart().setIdVisible(compteur);
		this.LieuDepart.getPointDeDepart().setTypeIntersection(2);
		compteur ++;
		for(int i = 0; i< this.listeRequete.size();i++) {
			this.listeRequete.get(i).getPointDeRecuperation().setIdVisible(compteur);
			this.listeRequete.get(i).getPointDeRecuperation().setTypeIntersection(3);
			this.listeRequete.get(i).getPointDeLivraison().setIdVisible(compteur);
			this.listeRequete.get(i).getPointDeLivraison().setTypeIntersection(4);
			compteur ++;
		}
	}
	public EnsembleRequete() {
		super();
	}
	@Override
	public String toString() {
		return "RecapDemande [listeRequete=" + listeRequete + ", LieuDepart=" + LieuDepart + "]";
	}
	


	
	
}
