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
		   
		   //Pour lisre un plan il faut invoquer la m�thode LirePlan avec comme attribut le chemin vers le fichier
		   Plan nouveauPlan = nouveauLecteur.LirePlan("ressources/smallMap.xml");
		   
		   
		   System.out.println(nouveauPlan.toString());
		   System.out.println(nouveauPlan.getSegment().get(3).toString());
		   
		   //Pour lire un fichier de requ�tes, il faut invoquer la m�thode LireRequete avec comme attribut le chemin vers le fichier xml et le Plan courant
		   EnsembleRequete recap = nouveauLecteur.LireRequete("ressources/requestsSmall1.xml", nouveauPlan);
		   System.out.println(recap.toString());
	   }
		   

}
