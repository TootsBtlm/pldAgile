package controleur;

/**
 * 
 * @author Mario
 * Représente l'état de l'application dans lequel l'utilisateur doit ajouter une étape, qui hérite de l'état général
 * 
 */

public class EtatAjouterPointPrecedentLivraison extends Etat{

	public EtatAjouterPointPrecedentLivraison(InterfaceController interfaceController) {
		super(interfaceController);
		// TODO Auto-generated constructor stub
	}
	
	public void validerAjouterEtape() {
		interfaceController.validerAjouterEtape();
	}
	
}