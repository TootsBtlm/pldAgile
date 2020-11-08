package modele;



public class Testeur {

	   public static void main(String[] args) {
/** Cette classe est destin�e � tester les lecteurs de xml
* et � donner des exemples de leurs utilisations 
* (je la supprimerai sous peu)
* 
*/
		   //Pour lire un fichier xml, il faut tout d'abord cr�er une instance de Lecteur
		   Lecteur nouveauLecteur =  new Lecteur();
		   
		   //Pour lire un plan il faut invoquer la m�thode LirePlan avec comme attribut le chemin vers le fichier
		   Plan nouveauPlan = nouveauLecteur.LirePlan("ressources/smallMap.xml");
		   EnsembleRequete recap = nouveauLecteur.LireRequete("ressources/requestsSmall2.xml", nouveauPlan);

		   Livraison liv = nouveauPlan.getMatriceCout(recap);
		   
		   
		  
		   System.out.println(liv.getListeItineraires().get(0).getListeIntersections().get(0));
		   System.out.println(liv.getListeItineraires().get(1).getListeIntersections().get(0));
		   System.out.println(liv.getListeItineraires().get(4).getListeIntersections().get(0));
		   System.out.println(liv.getListeItineraires().get(liv.getListeItineraires().size()-1).getListeIntersections().get(liv.getListeItineraires().get(liv.getListeItineraires().size()-1).getListeIntersections().size()-1));		   
		   /**
		   //M�thode pour r�cup�rer la matrice
		   Double[][] matrice = nouveauPlan.getMatrice();

		   System.out.println(nouveauPlan.toString());
		   System.out.println(nouveauPlan.getSegment().get(3).toString());

		   
		   System.out.println("\n Latitude max :"+nouveauPlan.latitudeMax()+"\n");
		   System.out.println("\n Longitude max :"+nouveauPlan.longitudeMax()+"\n");		   
		   System.out.println("\n Latitude min :"+nouveauPlan.latitudeMin()+"\n");
		   System.out.println("\n Longitude min :"+nouveauPlan.longitudeMin()+"\n");
		   
		   //Pour lire un fichier de requ�tes, il faut invoquer la m�thode LireRequete avec comme attribut le chemin vers le fichier xml et le Plan courant
		   EnsembleRequete recap = nouveauLecteur.LireRequete("ressources/requestsSmall1.xml", nouveauPlan);
		   System.out.println(recap.listePairesIntersections().toString());
		      

		   Intersection fin = nouveauPlan.getIntersectionById(Long.parseLong("26576953"));
		   Intersection depart = nouveauPlan.getIntersectionById(Long.parseLong("26576955"));
		   		   
		   System.out.println(nouveauPlan.calcDijsktra(depart, fin));

		   System.out.println(recap.listePairesIntersections().toString());
		   
		   nouveauPlan.getMatriceCout(recap);*/
	   }

}
