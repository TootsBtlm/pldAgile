package modele;



public class Testeur {

	   public static void main(String[] args) {
/** Cette classe est destinée à tester les lecteurs de xml
* et à donner des exemples de leurs utilisations 
* (je la supprimerai sous peu)
* 
*/
		   //Pour lire un fichier xml, il faut tout d'abord créer une instance de Lecteur
		   Lecteur nouveauLecteur =  new Lecteur();
		   
		   //Pour lire un plan il faut invoquer la méthode LirePlan avec comme attribut le chemin vers le fichier
		   Plan nouveauPlan = nouveauLecteur.LirePlan("ressources/smallMap.xml");
		   
		   //Méthode pour récupérer la matrice
		   Double[][] matrice = nouveauPlan.getMatrice();

		   System.out.println(nouveauPlan.toString());
		   System.out.println(nouveauPlan.getSegment().get(3).toString());

		   
		   System.out.println("\n Latitude max :"+nouveauPlan.latitudeMax()+"\n");
		   System.out.println("\n Longitude max :"+nouveauPlan.longitudeMax()+"\n");		   
		   System.out.println("\n Latitude min :"+nouveauPlan.latitudeMin()+"\n");
		   System.out.println("\n Longitude min :"+nouveauPlan.longitudeMin()+"\n");
		   
		   //Pour lire un fichier de requêtes, il faut invoquer la méthode LireRequete avec comme attribut le chemin vers le fichier xml et le Plan courant
		   EnsembleRequete recap = nouveauLecteur.LireRequete("ressources/requestsSmall1.xml", nouveauPlan);
		   System.out.println(recap.listePairesIntersections().toString());
		      

		   Intersection fin = nouveauPlan.getIntersectionById(Long.parseLong("26576953"));
		   Intersection depart = nouveauPlan.getIntersectionById(Long.parseLong("26576955"));
		   		   
		   System.out.println(nouveauPlan.calcDijsktra(depart, fin));

		   System.out.println(recap.listePairesIntersections().toString());
		   
		   nouveauPlan.getMatriceCout(recap);
	   }
		   
}
