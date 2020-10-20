// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package modele;

import java.util.ArrayList;



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
	public ArrayList<Intersection> intersection;
	/**
	 * 
	 */
	public ArrayList<Segment> segment;
	
	
	
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
	public Plan(ArrayList<Long> intersectionId, ArrayList<Intersection> intersection, ArrayList<Segment> segment) {
		super();
		this.intersectionId = intersectionId;
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
		return this.intersection.get(2);
	}
	
	
	
	
};
