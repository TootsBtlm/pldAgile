package controleur;

/**
 * 
 * @author Mario
 * Repr�sente l'�tat de l'application dans lequel l'utilisateur doit ajouter une �tape, qui h�rite de l'�tat g�n�ral
 * 
 */

public class EtatAjouterPointLivraison extends Etat{

	public EtatAjouterPointLivraison(InterfaceController interfaceController) {
		super(interfaceController);
		// TODO Auto-generated constructor stub
	}
	
	public void validerAjouterEtape() {
		interfaceController.validerAjouterEtape();
	}
	
}
