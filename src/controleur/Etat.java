package controleur;

import vue.VueGraphique;

/**
 * 
 * @author Hexanome4103
 * Classe m�re repr�sentant l'impl�mentation du design pattern Etat
 * 
 */

public abstract class Etat {

	protected VueGraphique vue;

	protected InterfaceController interfaceController;

	/**
	 * Constructeur
	 * @param interfaceController Objet InterfaceController
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
