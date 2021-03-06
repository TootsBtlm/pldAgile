// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package modele;

import java.util.ArrayList;

/************************************************************/
/**
 * 
 * Cette classe repr�sente un itin�raire.
 * @author romain
 */
public class Itineraire {
	
	/**   
	 * Liste des intersections composant l'itineraire
	 */
	private ArrayList<Intersection> listeIntersections = new ArrayList<Intersection>();
	
	/**   
	 * Liste des noms de rue composant l'itin�raire
	 */
	private ArrayList<String> listeNomsRue = new ArrayList<String>();
	
	/**   
	 * Cout de l'itin�raire (distance en m�tres)
	 */
	private Double cout = 0. ;
	
	/**
	 * Temps n�cessaire au livreur pour aller de la premi�re � la deni�re intersection (vitesse de 15km/h)
	 */
	private Double temps;
	
	/**
	 * Vitesse du livreur en m�tres par seconde
	 */
	final private Double VITESSE = 4.17; 
	
	/**
	 * 
	 * @param listeIntersections composant l'itin�raire
	 * @param cout total de l'itin�raire
	 */
	public Itineraire(ArrayList<Intersection> listeIntersections, Double cout) {
		super();
		this.listeIntersections = listeIntersections;
		this.cout = cout;
		this.temps = cout / VITESSE;
	}
	
	
	/**
	 * 
	 * @param listeIntersections
	 * @param listeNomsRue
	 * @param cout
	 */
	public Itineraire(ArrayList<Intersection> listeIntersections, ArrayList<String> listeNomsRue, Double cout) {
		super();
		this.listeIntersections = listeIntersections;
		this.listeNomsRue = listeNomsRue;
		this.cout = cout;
		this.temps = cout / VITESSE;
	}



	public ArrayList<Intersection> getListeIntersections() {
		return listeIntersections;
	}

	public Double getCout() {
		return cout;
	}

	public void setCout(Double cout) {
		this.cout = cout;
	}
	

	public Double getTemps() {
		return temps;
	}

	public void setTemps(Double temps) {
		this.temps = temps;
	}

	public void setListeIntersections(ArrayList<Intersection> listeIntersections) {
		this.listeIntersections = listeIntersections;
	}

	public Itineraire(ArrayList<Intersection> listeIntersections) {
		super();
		this.listeIntersections = listeIntersections;
	}
	
	public ArrayList<String> getListeNomsRue() {
		return listeNomsRue;
	}

	public void setListeNomsRue(ArrayList<String> listeNomsRue) {
		this.listeNomsRue = listeNomsRue;
	}

	public Itineraire() {
		super();
	}

	/**
	 * Cette méthode ajoute une intersection et les nom de sa rue aux listes
	 * @param intersection
	 * @param nomRue
	 */
	public void addStep(Intersection intersection, String nomRue) {
		this.listeIntersections.add(intersection);
		this.listeNomsRue.add(nomRue);
	}	
	
	/**
	 * Ajoute une intersection � la � l'attribut listeIntersections
	 * @param intersection
	 */
	public void addIntersection(Intersection intersection) {
		this.listeIntersections.add(intersection);
	}
	
	/**
	 * Ajout d'un itinéraire
	 * @param itineraire
	 */
	public void addItineraire(Itineraire itineraire) {
		this.listeIntersections.addAll(itineraire.getListeIntersections());
		this.cout = this.cout + itineraire.getCout();
	}
	
	
};
