package modele;

import java.sql.Time;

public class Depot {
	
	private Intersection pointDeDepart;
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
