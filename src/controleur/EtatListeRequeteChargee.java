package controleur;

import modele.Itineraire;
import modele.Plan;

/**
 * 
 * @author Mario
 * Repr�sente l'�ta de l'application dans lequel la liste des requ�tes vient d'�tre charg�e, qui h�rite de l'�tat g�n�ral
 * 
 */

public class EtatListeRequeteChargee extends Etat{
	
	public EtatListeRequeteChargee(InterfaceController interfaceController) {
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
		System.out.println("Calculer d'abord l'itin�raire");
	}
	
	public void supprimerEtape() {
		System.out.println("Charger d'abord l'itin�raire");
	}
	
	public void feuilleDeRoute() {
		System.out.println("Charger d'abord l'itin�raire");
	}
	
}
