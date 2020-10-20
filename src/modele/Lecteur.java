package modele;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;




	/**
	 * 
	 * Cette classe est l'interface de lecture des fichiers xml.
	 * @author rfonc
	 *
	 */

public class Lecteur {
	
	/**
	 * Cette méthode lit les plans contenus dans un fichier xml.
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
	 * Cette méthode lit les requetes contneues dans un fichier et 
	 * renvoie l'ensemble des ces requetes ainsi que le point de départ/arrivée
	 * 
	 * @param nomDeFichier
	 * @param planCourant
	 * @return EnsembleRequete
	 */
	public EnsembleRequete LireRequete(String nomDeFichier, Plan planCourant) {
		
		EnsembleRequete NouveauRecapDemande = new EnsembleRequete();
		
		try {
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser parser = factory.newSAXParser();
	         
	         GestionnaireRequeteXml nouveauGestionnaireDeRequetes = new GestionnaireRequeteXml();
	         nouveauGestionnaireDeRequetes.setPlanCourant(planCourant);
	         parser.parse(nomDeFichier, nouveauGestionnaireDeRequetes );
	         
	         NouveauRecapDemande.setLieuDepart(nouveauGestionnaireDeRequetes.getPointDepart());
	         NouveauRecapDemande.setListeRequete(nouveauGestionnaireDeRequetes.getListeRequest());
	         
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
		return NouveauRecapDemande;
	}
	
	
	
	
	
	
}
