package controleur;

import vue.VueGraphique;

/**
 * 
 * @author Hexanome4103
 * Repr�sente la classe m�re de tous les �tats
 * 
 */

public abstract class Etat {


	protected VueGraphique vue;

	protected InterfaceController interfaceController;


	/**
	 * 
	 * @param interfaceController
	 * Prend l'objet interface controleur de la classe InterfaceControleur pour modifier les attributs de l'objet interface controleur existant
	 * 
	 */

	public Etat(InterfaceController interfaceController) {
		this.interfaceController = interfaceController;
	}

	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void chargerFichierPlan() {

	}

	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void chargerFichierRequetes() {

	}

	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void calculerItineraire() {

	}

	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void ajouterEtape() {

	}

	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void supprimerEtape() {
	}

	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void validerAjouterEtape() {

	}

	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void construireFeuilleDeRoute() {

	}

	/**
	 * 
	 * M�thode surcharg�e sur chacune des classes filles de Etat
	 * 
	 */
	public void ajouterPointRecuperation() {

	}

	public void ajouterPointLivraison() {

	}

	public void ajouterPointPrecedentRecuperation() {

	}

	public void ajouterPointPrecedentLivraison() {

	}

}
