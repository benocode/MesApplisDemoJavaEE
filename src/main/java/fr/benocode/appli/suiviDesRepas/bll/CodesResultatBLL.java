package fr.benocode.appli.suiviDesRepas.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	
	/**
	 * Echec quand la date du repas n'est pas renseignée
	 */
	public static final int REGLE_REPAS_DATE_ERREUR=20000;
	/**
	 * Echec quand la description du repas n'est pas renseignée
	 */
	public static final int REGLE_REPAS_MENU_ERREUR=20001;
	
	
}
