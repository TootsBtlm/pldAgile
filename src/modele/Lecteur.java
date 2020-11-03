package modele;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;




	/**
	 * 
	 * Cette classe est l'interface de lecture des fichiers xml. 
	 * @author romain
	 *
	 */

public class Lecteur {
	
	/**
	 * Cette méthode lit le plan contenus dans un fichier xml. Elle renvoie un Plan rempli avec toutes les intersections.
	 * 
	 * @param nomDeFichier
	 * @return Plan
	 */
	
	public Plan LirePlan(String nomDeFichier) {
		Plan nouveauPlan = new Plan();
		
		try {
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser parser = factory.newSAXParser();
	         
	         GestionnairePlanXml nouveauGestionnaireDePlan = new GestionnairePlanXml();
	         
	         parser.parse(nomDeFichier, nouveauGestionnaireDePlan );
	         Plan PlanLu = new Plan(nouveauGestionnaireDePlan.getListeIntersectionId(),nouveauGestionnaireDePlan.getListeIntersection(),nouveauGestionnaireDePlan.getListeSegment());
	         nouveauPlan = PlanLu;
	         
	    } catch (DOMException e) {
	       e.printStackTrace();
	    } catch (ParserConfigurationException e) {
	       e.printStackTrace();
	    } catch (TransformerFactoryConfigurationError e) {
	       e.printStackTrace();
	    } catch (SAXException e) {
	       e.printStackTrace();
	    } catch (IOException e) {
	       // TODO Auto-generated catch block
	       e.printStackTrace();
	    }
		return nouveauPlan;
	}

	
	/**
	 * Cette méthode lit les requetes contnues dans un fichier et 
	 * renvoie l'ensemble des ces requetes ainsi que le point de départ/arrivée
	 * 
	 * @param nomDeFichier
	 * @param planCourant
	 * @return EnsembleRequete
	 */
	public EnsembleRequete LireRequete(String nomDeFichier, Plan planCourant) {
		
		EnsembleRequete RecapDemande = new EnsembleRequete();
		
		try {
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser parser = factory.newSAXParser();
	         
	         GestionnaireRequeteXml nouveauGestionnaireDeRequetes = new GestionnaireRequeteXml();
	         nouveauGestionnaireDeRequetes.setPlanCourant(planCourant);
	         parser.parse(nomDeFichier, nouveauGestionnaireDeRequetes );
	         
	         EnsembleRequete NouveauRecapDemande = new EnsembleRequete(planCourant.getIntersectionIdRetourne(), nouveauGestionnaireDeRequetes.getListeRequest(), nouveauGestionnaireDeRequetes.getPointDepart());
	         RecapDemande = NouveauRecapDemande;
	         
	    } catch (DOMException e) {
	       e.printStackTrace();
	    } catch (ParserConfigurationException e) {
	       e.printStackTrace();
	    } catch (TransformerFactoryConfigurationError e) {
	       e.printStackTrace();
	    } catch (SAXException e) {
	       e.printStackTrace();
	    } catch (IOException e) {
	       // TODO Auto-generated catch block
	       e.printStackTrace();
	    }
		return RecapDemande;
	}
	
	
	
	
	
	
}
