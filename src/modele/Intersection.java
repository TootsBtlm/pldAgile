
package modele;

public class Intersection {

	/**   
	 * Id unique de l'intersection
	 */
	private Long id;
	
	/**   
	 * Longitude de l'intersection 
	 */
	private Double longitude;
	
	/**
	 * Latitude de l'intersection
	 */
	private Double latitude;
	
	/**
	 * @return Retourne l'id unique de l'intersection
	 */	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Intersection(Long id, Double longitude, Double latitude, String nom) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public Intersection() {
		super();
	}
	
	
	@Override
	public java.lang.String toString() {
		return "Intersection [id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}

	
	
	
	

	
	
	
};
