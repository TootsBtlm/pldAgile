
package modele;

/************************************************************/
/**
 * 
 * Cette classe représente l'intersection de deux voie (rue, avenue..)
 * @author romain
 */

public class Intersection {

	/**   
	 * Id unique de l'intersection
	 */
	private Long id;
	
	/**   
	 * Id qui s'affiche sur le plan
	 */
	private Long idVisible;
	/**   
	 * Type de l'intersection:
	 * 1 : Non défni
	 * 2 : Dépôt
	 * 3 : Pickup
	 * 4 : Delivery 
	 */	
	private Integer typeIntersection = 1;
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
	public Long getIdVisible() {
		return idVisible;
	}
	public void setIdVisible(Long idVisible) {
		this.idVisible = idVisible;
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
	public Integer getTypeIntersection() {
		return typeIntersection;
	}
	public void setTypeIntersection(Integer typeIntersection) {
		this.typeIntersection = typeIntersection;
	}
	public Intersection(Long id, Double longitude, Double latitude) {
		super();
		this.id = id;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public Intersection() {
		super();
	}
	@Override
	public String toString() {
		return "Intersection [id=" + id + ", idVisible=" + idVisible + ", typeIntersection=" + typeIntersection
				+ ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}

	
	
	


	
	
	
	

	
	
	
};
