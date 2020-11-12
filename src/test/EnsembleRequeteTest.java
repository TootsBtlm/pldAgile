package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.Depot;
import modele.EnsembleRequete;
import modele.Intersection;
import modele.Requete;

class EnsembleRequeteTest {

	EnsembleRequete ensembleRequete = null;
	ArrayList<Requete> listeRequete = null;
	Depot depot = null;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.depot = new Depot(new Intersection(1l,10.,10.), new Time(1000));
		this.listeRequete = new ArrayList<Requete>();
		Requete requete1 = new Requete();
		Requete requete2 = new Requete();
		Requete requete3 = new Requete();
		
		this.listeRequete.add(requete1);
		this.listeRequete.add(requete2);
		this.listeRequete.add(requete3);
		
		this.ensembleRequete = new EnsembleRequete(this.listeRequete, this.depot);
	}

	@Test
	void testModifierIntersection() {
		this.ensembleRequete.modifierIntersections();
		int nombreRequete = this.ensembleRequete.getListeRequete().size();
		for(int i=0;i<nombreRequete;i++) {
			for(int j=1;j<nombreRequete;j++) {
				if(i!=j) {
					assertFalse(this.ensembleRequete.getListeRequete().get(i).getPointDeRecuperation().getIdVisible() 
							== this.ensembleRequete.getListeRequete().get(j).getPointDeRecuperation().getIdVisible(), 
							"Les points de récupération ne doivent pas avoir le même ID visible");
					assertFalse(this.ensembleRequete.getListeRequete().get(i).getPointDeLivraison().getIdVisible() 
							== this.ensembleRequete.getListeRequete().get(j).getPointDeLivraison().getIdVisible(),
							"Les points de livraison ne doivent pas avoir le même ID visible");
					assertFalse(this.ensembleRequete.getListeRequete().get(i).getPointDeRecuperation().getIdVisible() 
							== this.ensembleRequete.getListeRequete().get(j).getPointDeLivraison().getIdVisible(),
							"Les points de récupération et les points de livraison ne doivent pas avoir le même ID visible");
					
				}
			}
		}
	}

}
