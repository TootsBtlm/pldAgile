package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import controleur.EtatAjouterEtape;
import controleur.EtatItineraireCalcule;
import controleur.EtatListeRequeteChargee;
import controleur.EtatPlanCharge;
import controleur.InterfaceController;
import javafx.scene.Node;
import modele.EnsembleRequete;
import modele.Plan;

class InterfaceControllerTest {

	InterfaceController interfaceController = null;
	
	@BeforeEach
	void setUp() throws Exception {	
		this.interfaceController = new InterfaceController();
	}
	
	/*@Test
	void testChargerFichierPlan() {
		this.interfaceController.chargerFichierPlan();
		assertFalse(this.interfaceController.getPlanCanvas() == null, "Le canvas du plan ne doit pas être nul");
	}

	@Test
	void testChargerFichierRequete() {
		EtatPlanCharge etat = new EtatPlanCharge(this.interfaceController);
		this.interfaceController.setEtat(etat);
		this.interfaceController.chargerFichierRequete();
		assertFalse(this.interfaceController.getRequeteCanvas() == null, "Le canvas des requêtes ne doit pas être nul");
	}*/

	@Test
	void testCalculerItineraire() {
		Plan plan = new Plan();
		this.interfaceController.setPlan(plan);
		
		EnsembleRequete ensembleRequete = new EnsembleRequete();
		this.interfaceController.setEnsembleRequete(ensembleRequete);
		
		BiMap<Node,String> requeteNodeListView = HashBiMap.create();
		this.interfaceController.setRequeteNodeListView(requeteNodeListView);
		
		this.interfaceController.calculerItineraire();
		assertFalse(this.interfaceController.getLivraison() == null, "Le canvas de l'itinéraire ne doit pas être nul");
	}
/*
	@Test
	void testAjouterEtape() {
		EtatItineraireCalcule etat = new EtatItineraireCalcule(this.interfaceController);
		this.interfaceController.setEtat(etat);
		this.interfaceController.ajouterEtape();
		assertFalse(this.interfaceController.getItineraireCanvas() == null, "Le canvas de l'itinéraire ne doit pas être nul");
	}

	@Test
	void testValiderAjouterEtape() {
		EtatAjouterEtape etat = new EtatAjouterEtape(this.interfaceController);
		this.interfaceController.setEtat(etat);
		this.interfaceController.validerAjouterEtape();
		assertFalse(this.interfaceController.getItineraireCanvas() == null, "Le canvas de l'itinéraire ne doit pas être nul");
	}
	
	@Test
	void testAjouterPointRecuperation() {
		fail("Not yet implemented");
	}

	@Test
	void testAjouterNouveauPointRecuperation() {
		fail("Not yet implemented");
	}

	@Test
	void testSupprimerEtape() {
		fail("Not yet implemented");
	}

	@Test
	void testFeuilleDeRoute() {
		fail("Not yet implemented");
	}
*/
}
