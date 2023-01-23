package fr.benocode.appli.suiviDesRepas;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import fr.benocode.appli.suiviDesRepas.bo.Repas;
import fr.benocode.appli.suiviDesRepas.dal.DAOFactory;
import fr.benocode.appli.suiviDesRepas.dal.RepasDAO;

public class TestsSuiviDesRepas {

	public static void main(String[] args) {

		RepasDAO repasDAO = DAOFactory.getRepasDAO();
		List<Repas> listeRepas = new ArrayList<>();
		
		Repas repas = new Repas(LocalDateTime.of(2022, Month.SEPTEMBER, 1, 16, 30), "graines de courgettes, flan");
		System.out.println(repas);
		
		try {
			repasDAO.insert(repas);
			listeRepas = repasDAO.selectAll();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		for (Repas current : listeRepas) {
			System.out.println(current);
		}
		
		
		
//		System.out.println();
//		System.out.println("******************************");
//		System.out.println();
		  
		
//		LocalDateTime localDateTime = LocalDateTime.of(2016,8,19,21,46,31);
//		System.out.println("LocaleDateTime : " + affichageDate(localDateTime));
//		Date date = localTimeToDate(localDateTime);
//		System.out.println("TRANSFORMATION > Date : " + date);
//		
//		//Converting Date to Timestamp
//		Timestamp timestamp = new Timestamp(date.getTime());
//		
//		System.out.println("LocaleDateTime 2 : " + affichageDate(timestamp.toLocalDateTime()));
		
	}
	
	// Méthodes pour afficher la LocalDateTime
//	public static String affichageDate(LocalDateTime dateAAfficher) {
//		DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//		return String.format(dateAAfficher.format(dateTimePattern));
//	}
//	
//	 public static java.sql.Date localTimeToDate(LocalDateTime lt) {
//		    return new java.sql.Date(lt.atZone(ZoneId.systemDefault()).toInstant()
//		        .toEpochMilli());
//		  }
}
