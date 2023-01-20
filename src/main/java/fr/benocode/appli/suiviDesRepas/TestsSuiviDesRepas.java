package fr.benocode.appli.suiviDesRepas;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import fr.benocode.appli.suiviDesRepas.bo.Repas;

public class TestsSuiviDesRepas {

	public static void main(String[] args) {

//		Repas repas = new Repas(LocalDateTime.of(2010, Month.SEPTEMBER, 1, 16, 30), "bon repas");
//		System.out.println(repas);
//		
//		System.out.println();
//		System.out.println("******************************");
//		System.out.println();
//		  
		
		LocalDateTime localDateTime = LocalDateTime.of(2016,8,19,21,46,31);
		long nombre = localDateTime.toEpochSecond(ZoneOffset.of("Z"))*1000;
		System.out.println(nombre);
		Date date = new Date(nombre);
		System.out.println("LocaleDateTime : " + affichageDate(localDateTime));
//		date = convertToDateSQL(localDateTime);
		System.out.println("TRANSFORMATION > Date : " + date);
		
		
		System.out.println();
		System.out.println("******************************");
		System.out.println();
		
		//Converting Date to Timestamp
		Timestamp timestamp = new Timestamp(date.getTime());
		;
		
		
//		LocalDateTime localDateTime2 = date.getTimestamp("value").toLocalDateTime();
//		LocalDateTime localDateTime1 = (LocalDateTime) localDate;
		System.out.println("LocaleDateTime 2 : " + affichageDate(timestamp.toLocalDateTime()));
		
//		LocalDateTime localDateTime1 = LocalDateTime.of(2016,8,19,21,46,31);
//		
//		String str = "2015-03-31";  
//	    Date date = Date.valueOf(str);
//		System.out.println("Date : " + date);
//		localDateTime1 = convertToLocalDateTime(date);
//		System.out.println("TRANSFORMATION > Date : " + localDateTime1);
	}
	
	// Méthodes pour afficher la LocalDateTime
	public static String affichageDate(LocalDateTime dateAAfficher) {
		DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return String.format(dateAAfficher.format(dateTimePattern));
	}
//	
//	public static Date convertToDateSQL(LocalDateTime dateToConvert) {
//		Date dateFormatDateSQL = (Date) Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
//		// Affichage console
//		System.out.println(dateFormatDateSQL);
//		return dateFormatDateSQL;
//	}
}
