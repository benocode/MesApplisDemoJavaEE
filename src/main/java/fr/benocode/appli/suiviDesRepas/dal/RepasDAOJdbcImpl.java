package fr.benocode.appli.suiviDesRepas.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import fr.benocode.appli.suiviDesRepas.BusinessException;
import fr.benocode.appli.suiviDesRepas.bo.Repas;

public class RepasDAOJdbcImpl implements RepasDAO {

	private static final String INSERT="INSERT INTO suivi_des_repas(date, repas) VALUES(?,?);";
	private static final String SELECT_ALL="SELECT * FROM suivi_des_repas;";
	private Date dateFormatDateSQL;
	private LocalDateTime dateFormatLocalDateTime;
	
	@Override
	public void insert(Repas repas) throws BusinessException {
		if(repas==null)
		{
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
			throw businessException;
		}
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(INSERT);
			pstmt.setDate(1, new Date(repas.getDate()));
			pstmt.setString(2, repas.getDetailRepas());
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			if(e.getMessage().contains("CH_avis_note"))
			{
				businessException.ajouterErreur(CodesResultatDAL.INSERT_AVIS_NOTE_ECHEC);
			}
			else
			{
				businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			}
			throw businessException;
		}	
	}

	@Override
	public void selectAll() throws BusinessException {
		// TODO Auto-generated method stub
		
	}
	
	// Méthodes pour modifier le format de la date
	public LocalDateTime convertToLocalDateTime(Date dateToConvert) {
		dateFormatLocalDateTime = dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		// Affichage console
		DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		System.out.println(dateFormatLocalDateTime.format(dateTimePattern));
		return dateFormatLocalDateTime;
	}
	
	public Date convertToDateSQL(LocalDateTime dateToConvert) {
		dateFormatDateSQL = (Date) Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
		// Affichage console
		System.out.println(dateFormatDateSQL);
		return dateFormatDateSQL;
	}	
}
