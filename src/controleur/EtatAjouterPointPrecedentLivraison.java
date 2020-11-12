package controleur;

/**
 * 
 * @author Mario
 * Repr�sente l'�tat de l'application dans lequel l'utilisateur doit ajouter une �tape, qui h�rite de l'�tat g�n�ral
 * 
 */

public class EtatAjouterPointPrecedentLivraison extends Etat{

	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */
	public EtatAjouterPointPrecedentLivraison(InterfaceController interfaceController) {
		super(interfaceController);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * Fait appel � la m�thode validerAjouterEtape de l'objet interface controleur 
	 * 
	 */
	@Override
	public void validerAjouterEtape() {
		interfaceController.validerAjouterEtape();
	}
	
}