package modele;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class GestionnairePlanXml extends DefaultHandler{

	private ArrayList<Long> listeIntersectionId = new ArrayList<Long>();
	private ArrayList<Intersection> listeIntersection = new ArrayList<Intersection>();
	private ArrayList<Segment> listeSegment = new ArrayList<Segment>();
	
	public GestionnairePlanXml() {
		super();
	}
	public GestionnairePlanXml(ArrayList<Intersection> listeIntersection, ArrayList<Segment> listeSegment,
			long nbSegments) {
		super();
		this.listeIntersection = listeIntersection;
		this.listeSegment = listeSegment;
	}
	public ArrayList<Intersection> getListeIntersection() {
		return listeIntersection;
	}
	public void setListeIntersection(ArrayList<Intersection> listeIntersection) {
		this.listeIntersection = listeIntersection;
	}
	public ArrayList<Segment> getListeSegment() {
		return listeSegment;
	}
	public void setListeSegment(ArrayList<Segment> listeSegment) {
		this.listeSegment = listeSegment;
	}
	public ArrayList<Long> getListeIntersectionId() {
		return listeIntersectionId;
	}
	public void setListeIntersectionId(ArrayList<Long> listeIntersectionId) {
		this.listeIntersectionId = listeIntersectionId;
	}
	
	
	/**
	 * Méthode héritée de SAX qui se déclenche à la lecture de chaque nouvel élément xml
	 * Elle remplit les attributs qui listent les intersections et les segments
	 */
   
   	public void startElement(String namespaceURI, String lname, String qname, Attributes attrs) throws SAXException  {
	   if(qname.equals("intersection")) {

		   Intersection nouvelleIntersection = new Intersection();
		   if (attrs != null) {
			   for (int i = 0; i < attrs.getLength(); i++) {
				   //nous récupérons le nom de l'attribut
				   String aname = attrs.getLocalName(i);
				   //Et nous affichons sa valeur
				   if(aname.equals("latitude")) {
					   nouvelleIntersection.setLatitude(Double.parseDouble(attrs.getValue(i)));
			       }	
				   else if (aname.equals("longitude")) {
					   nouvelleIntersection.setLongitude(Double.parseDouble(attrs.getValue(i)));
				   }
				   else if(aname.equals("id")) {
					   nouvelleIntersection.setId(Long.parseLong((attrs.getValue(i))));
				   }
				   
			         
			   }
			   listeIntersection.add(nouvelleIntersection);
			   listeIntersectionId.add((Long) nouvelleIntersection.getId());
		   }			   
			   
	   }
	   if(qname.equals("segment")) {
		   Segment nouveauSegment = new Segment();

		   if (attrs != null) {
			   for (int i = 0; i < attrs.getLength(); i++) {

				   String aname = attrs.getLocalName(i);
				   Boolean integre = true ;
				   if(aname.equals("destination")) {
					   Long idDestination = Long.parseLong((attrs.getValue(i)));
					   
					   if(listeIntersectionId.contains(idDestination)) {
						   nouveauSegment.setFin(listeIntersection.get(listeIntersectionId.indexOf(idDestination)));
					   }
					   else {
						   throw new SAXException("plan non intègre");
					   }
					   
					   
				   }
				   else if(aname.equals("origin")) {
					   Long idOrigine = Long.parseLong((attrs.getValue(i)));
					   if(listeIntersectionId.contains(idOrigine)) {
						   nouveauSegment.setOrigine(listeIntersection.get(listeIntersectionId.indexOf(idOrigine)));
					   }
					   else {
						   throw new SAXException("plan non intègre");

					   }
					   
				   }
				   else if(aname.equals("length")) {
					   nouveauSegment.setLongueur(Double.parseDouble((attrs.getValue(i))));
				   }
				   else if(aname.equals("name")) {
					   nouveauSegment.setNom(attrs.getValue(i));
				   }

				   
				         
			   }
			   listeSegment.add(nouveauSegment);
		   }
	   }
	}   
   
   	public void endElement(String uri, String localName, String qName) throws SAXException{     
			}

	
}
