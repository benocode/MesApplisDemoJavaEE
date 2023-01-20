package fr.benocode.appli.suiviDesRepas.dal;

import fr.benocode.appli.suiviDesRepas.bo.Repas;
import fr.benocode.appli.suiviDesRepas.BusinessException;

public interface RepasDAO {
	
	public void insert(Repas repas) throws BusinessException;
	public void selectAll() throws BusinessException;
}
