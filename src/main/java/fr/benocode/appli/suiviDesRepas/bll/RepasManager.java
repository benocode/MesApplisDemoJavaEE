package fr.benocode.appli.suiviDesRepas.bll;

import java.time.LocalDateTime;
import java.util.List;

import fr.benocode.appli.suiviDesRepas.BusinessException;
import fr.benocode.appli.suiviDesRepas.bo.Repas;
import fr.benocode.appli.suiviDesRepas.dal.DAOFactory;
import fr.benocode.appli.suiviDesRepas.dal.RepasDAO;

/**
 * Cette classe permet d'effectuer les traitements attendus sur la classe Repas
 */
public class RepasManager {
	
	private RepasDAO repasDAO;
	
	/**
	 * Le constructeur permet d'initialiser la variable membre repasDAO pour 
	 * permettre une communication avec la base de données. 
	 */
	public RepasManager() {
		this.repasDAO=DAOFactory.getRepasDAO();
	}
	/**
	 * @param description
	 * @param note
	 * @return un objet Avis en cas de succcès
	 * @throws BusinessException 
	 */
	public Repas ajouter(LocalDateTime date, String menu) throws BusinessException
	{
		BusinessException exception = new BusinessException();
		
		Repas repas = new Repas(date, menu);
		
		this.validerDate(repas,exception);
		this.validerMenu(repas,exception);

		if(!exception.hasErreurs())
		{
			this.repasDAO.insert(repas);
		}
		
		if(exception.hasErreurs())
		{
			throw exception;
		}
		return repas;
	}
	
	public List<Repas> visualiser() throws BusinessException {
		return this.repasDAO.selectAll();
	}
	
	/**
	 * Cette méthode permet de vérifier les règles à respecter sur la variable membre date.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param repas
	 * @param businessException 
	 */
	private void validerDate(Repas repas, BusinessException businessException)
	{
		if(repas.getDate() == null)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_REPAS_DATE_ERREUR);
		}
	}
	
	/**
	 * Cette méthode permet de vérifier les règles à respecter sur la variable membre menu.
	 * En cas d'erreur, le code d'erreur est enregistré dans l'objet businessException.
	 * @param repas
	 * @param businessException
	 */
	private void validerMenu(Repas repas, BusinessException businessException)
	{
		if(repas.getMenu() == null || repas.getMenu().isBlank() || repas.getMenu().length()>200)
		{
			businessException.ajouterErreur(CodesResultatBLL.REGLE_REPAS_MENU_ERREUR);
		}
	}
}
