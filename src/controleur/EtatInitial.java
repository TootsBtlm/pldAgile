package controleur;


import modele.Intersection;

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
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
		System.out.println("Charger d'abord un plan");
	}

	/**
	 * 
	 * Dans l'�tat initial, la m�thode calculerItineraire ne fait aucune action car aucun plan n'est charg�
	 * 
	 */
	public void calculerItineraire() {
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
		System.out.println("Charger d'abord un plan");
	}
	
	/**
	 * 
	 * Dans l'�tat initial, la m�thode ajouterEtape ne fait aucune action car aucun plan n'est charg�
	 * 
	 */
	public void ajouterEtape() {
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
		System.out.println("Charger d'abord un plan");
	}
	
	/**
	 * 
	 * Dans l'�tat initial, la m�thode supprimerEtape ne fait aucune action car aucun plan n'est charg�
	 * 
	 */
	public void supprimerEtape(Intersection inter) {
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
		System.out.println("Charger d'abord un plan");
	}
	
	/**
	 * 
	 * Dans l'�tat initial, la m�thode feuilleDeRoute ne fait aucune action car aucun plan n'est charg�
	 * 
	 */
	public void feuilleDeRoute() {
		interfaceController.afficherPopupErreur("Charger d'abord un plan");
		System.out.println("Charger d'abord un plan");
	}
	
}
