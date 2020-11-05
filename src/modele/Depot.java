package modele;

import java.sql.Time;
/************************************************************/
/**
 * 
 * Cette classe représente un dépôt.
 * @author romain
 */
public class Depot {
	
	
	/**   
	 * Intersection correspondant au point de départ/ d'arrivée
	 */
	private Intersection pointDeDepart;
	/**   
	 * Heure du départ du liveur
	 */
	private Time heureDepart;
	
	public Intersection getPointDeDepart() {
		return pointDeDepart;
	}
	public void setPointDeDepart(Intersection pointDeDepart) {
		this.pointDeDepart = pointDeDepart;
	}
	public Time getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(Time heureDepart) {
		this.heureDepart = heureDepart;
	}
	public Depot(Intersection pointDeDepart, Time heureDepart) {
		super();
		this.pointDeDepart = pointDeDepart;
		this.heureDepart = heureDepart;
	}
	public Depot() {
		super();
	}
	@Override
	public String toString() {
		return "Depot [pointDeDepart=" + pointDeDepart + ", heureDepart=" + heureDepart + "]";
	}
	
	
	
}
