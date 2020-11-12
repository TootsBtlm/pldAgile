/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.Intersection;

/**
 * @author Bastien
 *
 */
class IntersectionTest {
	
	Intersection intersection = null;

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		Long id = 1l;
		Double longitude = 10.;
		Double latitude = 10.;
		this.intersection = new Intersection(id, longitude, latitude);
	}
	
	@Test
	void testConstructor() {
		assertEquals(1l, this.intersection.getId(),"L'ID doit être égal à 1");
		assertEquals(10., this.intersection.getLongitude(),"La longitude doit être égale à 10");
		assertEquals(10., this.intersection.getLatitude(),"La latitude doit être égale à 10");
	}

	@Test
	void testSetId() {
		Long newId = 2l;
		this.intersection.setId(newId);
		assertEquals(this.intersection.getId(),newId, "L'ID doit être égal à newId");
	}

	@Test
	void testToString() {
		this.intersection.setIdVisible(2l);
		assertEquals(this.intersection.toString(), "Intersection [id=" + 1l + ", idVisible=" + 2l + ", typeIntersection=" + 1
				+ ", longitude=" + 10. + ", latitude=" + 10. + "]");
	}
}
