package fr.benocode.appli.devinerNombre;

public class DevinerNombre {

	private static int nbADeviner;
	
	/**
	 * Initialise un nombre aléatoire compris entre 0 et 10
	 */
	public static void nombreAleatoire() {
		nbADeviner = (int) Math.floor(Math.random() * (10 - 0 + 1) + 0);
	}
	
	public String verifNombre(int proposition) {
		String message = "";
		if (proposition == nbADeviner) {
			message = "You win !";
		} else {
			message = "Try again...";
		}
		
		return message;
	}
	
	public static void main(String[] args) {

		nombreAleatoire();
		System.out.println(nbADeviner);
		
		
	}

}
