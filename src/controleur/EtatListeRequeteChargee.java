package controleur;

/**
 * 
 * @author Hexanome4103
 * Repr�sente l'�tat de l'application dans lequel la liste des requ�tes vient d'�tre charg�e, qui h�rite de la classe Etat
 * 
 */

public class EtatListeRequeteChargee extends Etat{
	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatListeRequeteChargee(InterfaceController interfaceController) {
		super(interfaceController);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Fait appel � la m�thode chargerFichierPlan de l'objet interface controleur 
	 * 
	 */
	@Override
	public void chargerFichierPlan() {
		
		this.interfaceController.chargerFichierPlan();
		
	}

	/**
	 * 
	 * Fait appel � la m�thode chargerFichierRequete de l'objet interface controleur 
	 * 
	 */
	@Override
	public void chargerFichierRequetes() {
		
		this.interfaceController.chargerFichierRequete();
		
	}

	/**
	 * 
	 * Fait appel � la m�thode calculerItineraire de l'objet interface controleur 
	 * 
	 */
	@Override
	public void calculerItineraire() {
		
		this.interfaceController.calculerItineraire();
	
	}

	/**
	 * 
	 * Dans l'�tat liste requ�te charg�e, la m�thode ajouterEtape ne fait aucune action car aucun itin�raire n'est calcul�
	 * 
	 */
	@Override
	public void ajouterEtape() {
		interfaceController.afficherPopupErreur("Calculer d'abord l'itin�raire");
	}
	
	/**
	 * 
	 * Dans l'�tat liste requ�te charg�e, la m�thode supprimerEtape ne fait aucune action car aucun itin�raire n'est calcul�
	 * 
	 */

		

	@Override
	public void supprimerEtape() {
		interfaceController.afficherPopupErreur("Calculer d'abord l'itin�raire");
		System.out.println("Calculer d'abord l'itin�raire");
	}
	
	/**
	 * Dans l'�tat liste requ�te charg�e, la m�thode construireFeuilleDeRoute ne fait aucune action car aucun itin�raire n'est calcul�
	 * 
	 */
	@Override
	public void construireFeuilleDeRoute() {
		interfaceController.afficherPopupErreur("Calculer d'abord l'itin�raire");

	}
	
}
