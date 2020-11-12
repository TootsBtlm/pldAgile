package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.Depot;
import modele.EnsembleRequete;
import modele.Intersection;
import modele.Itineraire;
import modele.Livraison;
import modele.Requete;

class LivraisonTest {

	Livraison livraison = null;
	ArrayList<Itineraire> listeItineraires = null;
	Time heureDepart = null;
	HashMap<Itineraire, Time> dictionnaireArriveesItineraires = null;
	EnsembleRequete requetes = null;
	Itineraire itineraire1 = null;
	Itineraire itineraire2 = null;
	Itineraire itineraire3 = null;
	
	@BeforeEach
	void setUp() throws Exception {
		
		ArrayList<Intersection> listeIntersections = new ArrayList<Intersection>();
		Intersection intersection1 = new Intersection(1l,0.,0.);
		Intersection intersection2 = new Intersection(1l,0.,5.);
		Intersection intersection3 = new Intersection(1l,0.,10.);
		listeIntersections.add(intersection1);
		listeIntersections.add(intersection2);
		listeIntersections.add(intersection3);
		itineraire1 = new Itineraire(listeIntersections,10.);
		
		ArrayList<Intersection> listeIntersections2 = new ArrayList<Intersection>();
		Intersection intersection4 = new Intersection(1l,0.,15.);
		Intersection intersection5 = new Intersection(1l,0.,20.);
		listeIntersections2.add(intersection4);
		listeIntersections2.add(intersection5);
		listeIntersections2.add(new Intersection(1l,0.,25.));
		itineraire2 = new Itineraire(listeIntersections2,10.);
		
		this.listeItineraires = new ArrayList<Itineraire>();
		this.listeItineraires.add(itineraire1);
		this.listeItineraires.add(itineraire2);
		
		
		Requete requete1 = new Requete(intersection1,intersection2, 1l,1l);
		Requete requete2 = new Requete(intersection2,intersection3, 1l,1l);
		Requete requete3 = new Requete(intersection4,intersection5, 1l,1l);
		ArrayList<Requete>listeRequete = new ArrayList<Requete>();
		listeRequete.add(requete1);
		listeRequete.add(requete2);
		listeRequete.add(requete3);
		Depot depot = new Depot(new Intersection(1l,10.,10.), new Time(1000));
		this.requetes = new EnsembleRequete(listeRequete,depot);
		
		this.livraison = new Livraison(this.listeItineraires,this.requetes);
	}

	@Test
	void testCalculArrivees() {
		this.livraison.calculArrivees();
		assertEquals(this.livraison.getDictionnaireArriveesItineraires().get(this.itineraire1).getSeconds(),
				new Time(1000).getSeconds());
	}

}
