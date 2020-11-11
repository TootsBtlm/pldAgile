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
	 * @author Romain
	 *
	 */

public class Lecteur {

	
	
	/**
	 * Cette m�thode lit le plan contenus dans un fichier xml. Elle renvoie un Plan rempli avec toutes les intersections.
	 * 
	 * @param nomDeFichier
	 * @return Plan
	 */
	
	public Plan LirePlan(String nomDeFichier) {
		Plan nouveauPlan = null;
		
		try {
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser parser = factory.newSAXParser();
	         
	         GestionnairePlanXml nouveauGestionnaireDePlan = new GestionnairePlanXml();
	         
	         parser.parse(nomDeFichier, nouveauGestionnaireDePlan );
	         
	         ArrayList<Intersection> ListeIntersections = nouveauGestionnaireDePlan.getListeIntersection();
	         ArrayList<Long> ListeIntersectionsid = nouveauGestionnaireDePlan.getListeIntersectionId();
	         ArrayList<Segment> ListeSegments = nouveauGestionnaireDePlan.getListeSegment();

	         Plan PlanLu = new Plan(ListeIntersectionsid, ListeIntersections, ListeSegments);
	         nouveauPlan = PlanLu;
	         
	         if(ListeIntersections.size() <= 0) {
	        	 nouveauPlan = null;
	         }
	         
	         
	         
	    } catch (DOMException e) {
	       e.printStackTrace();
	    } catch (ParserConfigurationException e) {
	       e.printStackTrace();
	    } catch (TransformerFactoryConfigurationError e) {
	       e.printStackTrace();
	    } catch (SAXException e) {
	       e.printStackTrace();
	    } catch (IOException e) {
	       e.printStackTrace();
	    }
		return nouveauPlan;
	}

	
	/**
	 * Cette m�thode lit les requetes contnues dans un fichier et 
	 * renvoie l'ensemble des ces requetes ainsi que le point de d�part/arriv�e
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
	         
	         if(nouveauGestionnaireDeRequetes.getListeRequest().size() <= 0) {
	        	 return null;
	         }
	         
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
	       e.printStackTrace();
	    }
		return RecapDemande;
	}
	
	
	
	
	
	
}
