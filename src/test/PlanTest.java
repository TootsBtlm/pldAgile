package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modele.Lecteur;
import modele.Plan;

public class PlanTest {

	private Plan plan ;
	
	@Before
	public void init() {
		Lecteur lecteur = new Lecteur();
		this.plan =  lecteur.LirePlan("ressources/testMap");
	}
	
	@Test
	public void testModifierIntersectionsPertinentes() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMatriceCout() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNomRue() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcDijsktra() {
		fail("Not yet implemented");
	}

	@Test
	public void testAjouterSommet() {
		fail("Not yet implemented");
	}

	@Test
	public void testSupprimerSommet() {
		fail("Not yet implemented");
	}

	@Test
	public void testAEtoile() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIntersectionId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIntersectionId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIntersection() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIntersection() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlanArrayListOfLongArrayListOfIntersectionArrayListOfSegment() {
		fail("Not yet implemented");
	}

	@Test
	public void testPlanArrayListOfLongHashMapOfLongIntegerArrayListOfIntersectionArrayListOfSegment() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIntersectionById() {
		fail("Not yet implemented");
	}

	@Test
	public void testLongitudeMax() {
		fail("Not yet implemented");
	}

	@Test
	public void testLatitudeMax() {
		fail("Not yet implemented");
	}

	@Test
	public void testLongitudeMin() {
		fail("Not yet implemented");
	}

	@Test
	public void testLatitudeMin() {
		fail("Not yet implemented");
	}


}
