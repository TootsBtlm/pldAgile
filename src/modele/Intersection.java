
package modele;

/************************************************************/
/**
 * @param <String>
 * @param <Long>
 * 
 */

public class Intersection {
	
	

	
	/**   
	 * 
	 */
	private Long id;
	/**   
	 * 
	 */
	private Double longitude;
	/**
	 * 
	 */
	private Double latitude;
	/**
	 * 
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
