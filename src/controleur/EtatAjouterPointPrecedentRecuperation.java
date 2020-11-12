package controleur;

/**
 * 
 * @author Mario
 * Représente l'état de l'application dans lequel l'utilisateur doit ajouter une étape, qui hérite de l'état général
 * 
 */

public class EtatAjouterPointPrecedentRecuperation extends Etat{

	public EtatAjouterPointPrecedentRecuperation(InterfaceController interfaceController) {
		super(interfaceController);
		// TODO Auto-generated constructor stub
	}
	
	public void validerAjouterEtape() {
		interfaceController.validerAjouterEtape();
	}

	
}
