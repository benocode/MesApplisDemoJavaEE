package fr.benocode.appli.suiviDesRepas.bo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Repas {

	private LocalDateTime date;
	private String detailRepas;
	
	// Constructeur tous paramètres
	public Repas(LocalDateTime date, String detailRepas) {
		this.date = date;
		this.detailRepas = detailRepas;
	}

	// Getters & setters
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDetailRepas() {
		return detailRepas;
	}

	public void setDetailRepas(String detailRepas) {
		this.detailRepas = detailRepas;
	}
	
	// Méthode toString()
	@Override
	public String toString() {
		DateTimeFormatter dateTimePattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		return this.date.format(dateTimePattern) + " : " + this.detailRepas;
	}
}
