package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.Intersection;
import modele.Segment;

class SegmentTest {

	Segment segment = null;
	Intersection origine = null;
	Intersection fin = null;
	
	@BeforeEach
	void setUp() throws Exception {
		origine = new Intersection(1l,10.,10.);
		fin = new Intersection(2l,20.,20.);
		segment = new Segment(origine, fin, 10., "Nom");
	}

	@Test
	void testIsSegment() {
		assertTrue(this.segment.isSegment(origine, fin), "La fonction doit retourner vrai");
		assertFalse(this.segment.isSegment(new Intersection(3l,10.,10.), fin), "La fonction doit retourner faux");
	}

}
