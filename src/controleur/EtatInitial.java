package controleur;


import modele.Intersection;
import modele.Itineraire;
import modele.Plan;
import vue.VueGraphique;

/**
 * 
 * @author Mario et Jean-Jacques
 * Repr�sente l'�tat initial de l'application, qui h�rite de la classe Etat
 * 
 */

public class EtatInitial extends Etat {

	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatInitial(InterfaceController interfaceController) {
		super(interfaceController);
	}
	
	/**
	 * 
	 * Fait appel � la m�thode chargerFichierPlan de l'objet interface controleur 
	 * 
	 */
	public void chargerFichierPlan() {
		
		this.interfaceController.chargerFichierPlan();
		
	}

	/**
	 * 
	 * Dans l'�tat initial, la m�thode chargerFichierRequetes ne fait aucune action car aucun plan n'est charg�
	 * 
	 */
	public void chargerFichierRequetes() {
		System.out.println("Charger d'abord un plan");
	}

	/**
	 * 
	 * Dans l'�tat initial, la m�thode calculerItineraire ne fait aucune action car aucun plan n'est charg�
	 * 
	 */
	public void calculerItineraire() {
		System.out.println("Charger d'abord un plan");
	}
	
	/**
	 * 
	 * Dans l'�tat initial, la m�thode ajouterEtape ne fait aucune action car aucun plan n'est charg�
	 * 
	 */
	public void ajouterEtape() {
		System.out.println("Charger d'abord un plan");
	}
	
	/**
	 * 
	 * Dans l'�tat initial, la m�thode supprimerEtape ne fait aucune action car aucun plan n'est charg�
	 * 
	 */
	public void supprimerEtape(Intersection inter) {
		System.out.println("Charger d'abord un plan");
	}
	
	/**
	 * 
	 * Dans l'�tat initial, la m�thode feuilleDeRoute ne fait aucune action car aucun plan n'est charg�
	 * 
	 */
	public void feuilleDeRoute() {
		System.out.println("Charger d'abord un plan");
	}
	
}
