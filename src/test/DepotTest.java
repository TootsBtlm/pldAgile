package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.Depot;
import modele.Intersection;

class DepotTest {
	
	Depot depot = null;
	Intersection intersection = null;
	Time time = null;
	
	
	@BeforeEach
	void setUp() {
		intersection = new Intersection(1l,10.,10.);
		time = new Time(1000);
		this.depot = new Depot(intersection, time);
	}
	
	@Test
	void testToString() {
		assertEquals(this.depot.toString(),"Depot [pointDeDepart=" + this.intersection + ", heureDepart=" + this.time + "]");
	}
}
