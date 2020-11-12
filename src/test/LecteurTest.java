package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.EnsembleRequete;
import modele.Lecteur;
import modele.Plan;

class LecteurTest {

	private Lecteur lecteur ;
	
	@BeforeEach
	void initialisation() {
		lecteur = new Lecteur(); 
	}
	/**
	 * Test de la m�thode lirePlan
	 */
	@Test
	void testLirePlan() {
		Plan plan = lecteur.LirePlan("ressources/testMap.xml");
		
		assertEquals(plan.getIntersection().size(), 4);
		
		assertTrue(plan.getIntersection().get(0).getId().equals(Integer.toUnsignedLong(1)));
		assertTrue(plan.getIntersection().get(1).getId().equals(Integer.toUnsignedLong(2)));
		assertTrue(plan.getIntersection().get(2).getId().equals(Integer.toUnsignedLong(3)));
		assertTrue(plan.getIntersection().get(3).getId().equals(Integer.toUnsignedLong(4)));
		
		
		assertEquals(plan.getSegment().size(), 6);
		
		assertTrue(plan.getSegment().get(0).getOrigine().getId().equals(Integer.toUnsignedLong(1)));
		assertTrue(plan.getSegment().get(0).getFin().getId().equals(Integer.toUnsignedLong(2)));
		
		assertTrue(plan.getSegment().get(1).getOrigine().getId().equals(Integer.toUnsignedLong(2)));
		assertTrue(plan.getSegment().get(1).getFin().getId().equals(Integer.toUnsignedLong(3)));
		
		assertTrue(plan.getSegment().get(2).getOrigine().getId().equals(Integer.toUnsignedLong(1)));
		assertTrue(plan.getSegment().get(2).getFin().getId().equals(Integer.toUnsignedLong(4)));
		
		assertTrue(plan.getSegment().get(3).getOrigine().getId().equals(Integer.toUnsignedLong(3)));
		assertTrue(plan.getSegment().get(3).getFin().getId().equals(Integer.toUnsignedLong(4)));
		
		assertTrue(plan.getSegment().get(4).getOrigine().getId().equals(Integer.toUnsignedLong(4)));
		assertTrue(plan.getSegment().get(4).getFin().getId().equals(Integer.toUnsignedLong(3)));
		
		assertTrue(plan.getSegment().get(5).getOrigine().getId().equals(Integer.toUnsignedLong(4)));
		assertTrue(plan.getSegment().get(5).getFin().getId().equals(Integer.toUnsignedLong(1)));
	}

	@Test
	void testLireRequete() {
		Plan plan = lecteur.LirePlan("ressources/testMap.xml");
		EnsembleRequete ensembleRequete = lecteur.LireRequete("ressources/requestsTest.xml", plan);
		
		assertTrue(ensembleRequete.getLieuDepart().getPointDeDepart().getId().equals(Integer.toUnsignedLong(1)));
		assertTrue(ensembleRequete.getListeRequete().get(0).getPointDeRecuperation().getId().equals(Integer.toUnsignedLong(3)));
		assertTrue(ensembleRequete.getListeRequete().get(0).getPointDeLivraison().getId().equals(Integer.toUnsignedLong(4)));
		
		
		
	}

}
