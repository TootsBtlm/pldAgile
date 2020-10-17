package modele;

import java.util.ArrayList;

public class EnsembleRequete {

	ArrayList<Requete> listeRequete ;
	Depot LieuDepart;
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
	public EnsembleRequete() {
		super();
	}
	@Override
	public String toString() {
		return "RecapDemande [listeRequete=" + listeRequete + ", LieuDepart=" + LieuDepart + "]";
	}
	
	
	
}
