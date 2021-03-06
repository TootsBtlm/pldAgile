package modele;

import java.sql.Time;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestionnaireRequeteXml extends DefaultHandler{

	private Depot pointDepart;
	private ArrayList<Requete> listeRequest = new ArrayList<Requete>();
	private Plan planCourant;
	
	/**
	 * M�thode h�rit�e de SAX qui se d�clenche � la lecture de chaque nouvel �l�ment xml
	 * Elle remplit la liste des requetes et le d�pot
	 */
	   
   	public void startElement(String namespaceURI, String lname, String qname, Attributes attrs) throws SAXException {
	   if(qname.equals("depot")) {
		   Depot nouveauDepot = new Depot();
		   if (attrs != null) {
			   for (int i = 0; i < attrs.getLength(); i++) {
				   //nous r�cup�rons le nom de l'attribut
				   String aname = attrs.getLocalName(i);
				   //Et nous affichons sa valeur
				   if(aname.equals("address")) {
					   if(planCourant.getIntersectionId().contains(Long.parseLong(attrs.getValue(i)))) {
						   nouveauDepot.setPointDeDepart(planCourant.getIntersectionById(Long.parseLong(attrs.getValue(i))));	
					   }
					   else {
						   throw new SAXException("requ�te non int�gre");
					   }
						

			       }	
				   else if (aname.equals("departureTime")) {
					   String moment = attrs.getValue(i);
					   Integer seconde =  Integer.parseInt(moment.split("[:]")[2]);
					   Integer minute = Integer.parseInt(moment.split("[:]")[1]);
					   Integer heure = Integer.parseInt(moment.split("[:]")[0]);
					   
					   //Cette m�thode est plus simple, malgr� le warning ...
					   Time heureDepart = new Time(heure, minute, seconde);
					   nouveauDepot.setHeureDepart(heureDepart);
				   }
			         
			   }
			   setPointDepart(nouveauDepot);
		   }
		   
			   
	   }
	   if(qname.equals("request")) {
		   Requete nouvelleRequete = new Requete();

		   if (attrs != null) {
			   for (int i = 0; i < attrs.getLength(); i++) {

				   String aname = attrs.getLocalName(i);

				   if(aname.equals("pickupAddress")) {

					   Long idOrigine = Long.parseLong((attrs.getValue(i)));
					   if(this.planCourant.getIntersectionId().contains(idOrigine)) {
						   Intersection lieuRecuperation = this.planCourant.getIntersectionById(idOrigine); 
						   nouvelleRequete.setPointDeRecuperation(lieuRecuperation);
					   }
					   else {
						   throw new SAXException("requ�te non int�gre");						   
					   }

					   
				   }
				   else if(aname.equals("deliveryAddress")) {

					   
					   Long idDestination = Long.parseLong((attrs.getValue(i)));
					   if(this.planCourant.getIntersectionId().contains(idDestination)) {
						   Intersection lieuLivraison = this.planCourant.getIntersectionById(idDestination);
						   nouvelleRequete.setPointDeLivraison(lieuLivraison);
					   }
					   else {
						   throw new SAXException("requ�te non int�gre");						   
					   }
					   

				   }
				   else if(aname.equals("pickupDuration")) {
					   nouvelleRequete.setDureeRecuperation(Long.parseLong(attrs.getValue(i)));
				   }
				   else if(aname.equals("deliveryDuration")) {
					   nouvelleRequete.setDureeLivraison(Long.parseLong(attrs.getValue(i)));
				   }   
			   }
			   listeRequest.add(nouvelleRequete);
		   }
		   
	   }
	}   
   
   	public void endElement(String uri, String localName, String qName) throws SAXException{     
			}

	public Depot getPointDepart() {
		return pointDepart;
	}

	public void setPointDepart(Depot pointDepart) {
		this.pointDepart = pointDepart;
	}

	public ArrayList<Requete> getListeRequest() {
		return listeRequest;
	}

	public void setListeRequest(ArrayList<Requete> listeRequest) {
		this.listeRequest = listeRequest;
	}

	public Plan getPlanCourant() {
		return planCourant;
	}

	public void setPlanCourant(Plan planCourant) {
		this.planCourant = planCourant;
	}
	
	

}
