package controleur;


import modele.Intersection;
import modele.Plan;

/**
 * 
 * @author Mario
 * Repr�sente l'�tat de l'application dans lequel l'utilisateur doit ajouter une �tape, qui h�rite de l'�tat g�n�ral
 * 
 */


public class EtatAjouterPointRecuperation extends Etat{

	public EtatAjouterPointRecuperation(InterfaceController interfaceController) {
		super(interfaceController);
		// TODO Auto-generated constructor stub
	}

	public void chargerFichierPlan() {
		
		this.interfaceController.chargerFichierPlan();
		
	}

	
	public void chargerFichierRequetes() {
		
		this.interfaceController.chargerFichierRequete();
		
	}

	public void calculerItineraire() {
		
		this.interfaceController.calculerItineraire();
	
	}
	
	public void ajouterEtape() {
	}
	
	public void supprimerEtape(Intersection inter) {
	}
	
	public void feuilleDeRoute() {
		
	}
	
	public void validerAjouterEtape() {
		interfaceController.validerAjouterEtape();
	}
	
	public void ajouterPointRecuperation() {
	}
	
}
