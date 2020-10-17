
package modele;

/************************************************************/
/**
 * @param <String>
 * @param <Long>
 * 
 */

public class Intersection<String, Long> {
	
	
	
	/**   
	 * 
	 */
	private Long longitude;
	/**
	 * 
	 */
	private Long latitude;
	/**
	 * 
	 */
	
	
	
	private String nom;
	public Long getLongitude() {
		return longitude;
	}
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	public Long getLatitude() {
		return latitude;
	}
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Intersection(Long longitude, Long latitude, String nom) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.nom = nom;
	}
	public Intersection() {
		super();
	}
	

	
	
	
};
