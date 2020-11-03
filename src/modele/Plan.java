// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package modele;

import java.util.ArrayList;
import java.util.HashMap;



/************************************************************/
/**
 * 
 */
public class Plan {
	/**
	 * 
	 */
	public ArrayList<Long> intersectionId;	
	/**
	 * 
	 */
	public HashMap<Long,Integer> intersectionIdRetourne = new HashMap<Long, Integer>();
	/**
	 * 
	 */
	public ArrayList<Intersection> intersection;
	/**
	 * 
	 */
	public ArrayList<Segment> segment;
	
	public HashMap<Intersection, ArrayList<Segment>> listeAdjacence = new HashMap<Intersection, ArrayList<Segment>>();
	
	public HashMap<Intersection, ArrayList<Segment>> listeAdjacenceInverse = new HashMap<Intersection, ArrayList<Segment>>();
	 
	public HashMap<Intersection, Integer> indexIdInteger = new HashMap<Intersection, Integer>();
	
	public HashMap<Intersection, ArrayList<Segment>> getListeAdjacence() {
		return listeAdjacence;
	}
	public void setListeAdjacence(HashMap<Intersection, ArrayList<Segment>> listeAdjacence) {
		this.listeAdjacence = listeAdjacence;
	}
	/* Method */
	
	
	public ArrayList<Long> getIntersectionId() {
		return intersectionId;
	}
	public void setIntersectionId(ArrayList<Long> intersectionId) {
		this.intersectionId = intersectionId;
	}
	public ArrayList<Intersection> getIntersection() {
		return intersection;
	}
	public void setIntersection(ArrayList<Intersection> intersection) {
		this.intersection = intersection;
	}
	public ArrayList<Segment> getSegment() {
		return segment;
	}
	public void setSegment(ArrayList<Segment> segment) {
		this.segment = segment;
	}

	
	public HashMap<Long, Integer> getIntersectionIdRetourne() {
		return intersectionIdRetourne;
	}
	public void setIntersectionIdRetourne(HashMap<Long, Integer> intersectionIdRetourne) {
		this.intersectionIdRetourne = intersectionIdRetourne;
	}
	public Plan(ArrayList<Long> intersectionId, ArrayList<Intersection> intersection, ArrayList<Segment> segment) {
		super();

		this.intersectionId = intersectionId;
		this.intersection = intersection;
		this.segment = segment;
		for(int i = 0; i < this.intersectionId.size(); i++) {
			this.intersectionIdRetourne.put(intersectionId.get(i), i);	
		}
		
		for(int i = 0; i < this.intersectionId.size(); i++) {
			ArrayList<Segment> vide = new ArrayList<Segment>();
			this.listeAdjacence.put(this.intersection.get(i), vide);
		}
		
		for(int j = 0 ; j < this.segment.size(); j ++)
		{
			ArrayList<Segment> listeSegmentsAssocies = this.listeAdjacence.get(this.segment.get(j).getOrigine());
			listeSegmentsAssocies.add(this.segment.get(j));
			this.listeAdjacence.put(this.segment.get(j).getOrigine(), listeSegmentsAssocies );
		}
		
		
		for(int i = 0; i < this.intersectionId.size(); i++) {
			ArrayList<Segment> videDeux = new ArrayList<Segment>();
			this.listeAdjacenceInverse.put(this.intersection.get(i), videDeux);
		}
		
		for(int j = 0 ; j < this.segment.size(); j ++)
		{
			ArrayList<Segment> listeSegmentsAssocies = this.listeAdjacenceInverse.get(this.segment.get(j).getFin());
			listeSegmentsAssocies.add(this.segment.get(j));
			this.listeAdjacenceInverse.put(this.segment.get(j).getFin(), listeSegmentsAssocies );
		}
	} 
	
	public Plan(ArrayList<Long> intersectionId, HashMap<Long, Integer> intersectionIdRetourne,
			ArrayList<Intersection> intersection, ArrayList<Segment> segment) {
		super();
		this.intersectionId = intersectionId;
		this.intersectionIdRetourne = intersectionIdRetourne;
		this.intersection = intersection;
		this.segment = segment;
	}
	public Plan() {
		super();
	}

	@Override
	public String toString() {
		return "Plan [intersectionId=" + intersectionId + ", intersection=" + intersection + " ]";
	}
	
	
	
	public Intersection getIntersectionById(Long id){

		return this.intersection.get(this.intersectionIdRetourne.get(id));
	}
	
	public Double[][] getMatrice(){
		int nbIntersection = this.intersectionId.size();
		int nbSegment = this.segment.size();
		Double[][] matriceCouts = new Double[nbIntersection+1][nbIntersection+1];
		
		for(int i = 0 ; i < nbIntersection ; i++) {
			for(int j = 0 ; j < nbIntersection ; j++) {
				matriceCouts[i][j] = 1000000.;
			}
			
		}
		
		for(int i = 0 ; i < nbSegment ; i++) {
			Segment segmentCourant = this.segment.get(i);
			matriceCouts[intersectionIdRetourne.get(segmentCourant.getOrigine().getId())][intersectionIdRetourne.get(segmentCourant.getFin().getId())] = segmentCourant.getLongueur();
		}
		return matriceCouts;
	}
	
	public Double longitudeMax(){
		Double max = this.intersection.get(0).getLongitude();
		for(int i = 0; i < this.intersectionId.size(); i++) {
			if(max < this.intersection.get(i).getLongitude()) {
				max = this.intersection.get(i).getLongitude();
			}
		}
		return max;
	}
	
	public Double latitudeMax(){
		Double max = this.intersection.get(0).getLatitude();
		for(int i = 0; i < this.intersectionId.size(); i++) {
			if(max < this.intersection.get(i).getLatitude()) {
				max = this.intersection.get(i).getLatitude();
			}
		}
		return max;
	}
	
	
	public Double longitudeMin(){
		Double min = this.intersection.get(0).getLongitude();
		for(int i = 0; i < this.intersectionId.size(); i++) {
			if(min > this.intersection.get(i).getLongitude()) {
				min = this.intersection.get(i).getLongitude();
			}
		}
		return min;
	}
	
	public Double latitudeMin(){
		Double min = this.intersection.get(0).getLatitude();
		for(int i = 0; i < this.intersectionId.size(); i++) {
			if(min > this.intersection.get(i).getLatitude()) {
				min = this.intersection.get(i).getLatitude();
			}
		}
		return min;
	}
	
	public Itineraire getItineraire(ArrayList<Integer> listeSommets){
		Itineraire itineraire = new Itineraire();
		
		for (int i= 0; i < listeSommets.size() ; i++) {
			itineraire.addIntersection(this.intersection.get(listeSommets.get(i)));
		}
		
		
		return itineraire;
	}
	
	public void remplirIndex(ArrayList<Intersection> requetes, Intersection depart) {
		this.indexIdInteger.put(depart, 0);
		Integer entier = 1;
		for(Intersection i : requetes) {
			this.indexIdInteger.put(i, entier++);
		}
	}
	
};




