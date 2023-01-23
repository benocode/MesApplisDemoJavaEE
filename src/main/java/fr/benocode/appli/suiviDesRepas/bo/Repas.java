package fr.benocode.appli.suiviDesRepas.bo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Repas {

	private LocalDateTime date;
	private String menu;
	
	// Constructeur tous paramètres
	public Repas(LocalDateTime date, String menu) {
		this.date = date;
		this.menu = menu;
	}

	// Getters & setters
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	// Méthode toString()
	@Override
	public String toString() {
		DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return this.date.format(dateTimePattern) + " : " + this.menu;
	}
}
