package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.Intersection;
import modele.Requete;

class RequeteTest {

	Requete requete = null;
	
	@BeforeEach
	void setUp() throws Exception {
		Intersection recup = new Intersection(1l,5.,5.);
		Intersection livraison = new Intersection(2l,10.,10.);
		this.requete = new Requete(recup,livraison,10l,10l);
	}

	@Test
	void testToString() {
		
		assertEquals(this.requete.toString(), "Requete [pointDeRecuperation=" + new Intersection(1l,5.,5.) + 
				", pointDeLivraison=" + new Intersection(2l,10.,10.)
				+ ", dureeRecuperation=" + 10l + 
				", dureeLivraison=" + 10l + "]");
	}

}
