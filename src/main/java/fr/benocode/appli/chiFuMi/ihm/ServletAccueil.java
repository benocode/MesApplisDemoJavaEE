package fr.benocode.appli.chiFuMi.ihm;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/applications/ChiFuMi/ServletAccueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<Integer, String> signes;
	private int choixOrdinateur;
	private String choixUtilisateur;

	/**
	 * Initialisation du dictionnaire comprenant les signes du jeu
	 */
	@Override
	public void init() throws ServletException {
		signes = new HashMap<Integer, String>();
		signes.put(0, "chi"); // Pierre
		signes.put(1, "fou"); // Feuille
		signes.put(2, "mi"); // Ciseaux
		super.init();
	}
	
	/**
	 * Initialise le choix du signe pour l'ordinateur
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		choixOrdinateur = new Random().nextInt(3);

		System.out.println("Choix ordinateur : " + signes.get(choixOrdinateur));
		request.getRequestDispatcher("/WEB-INF/jsp/ChiFuMi/tentative.jsp").forward(request, response);
	}

	/**
	 * Vérifie le choix de l'utilisateur et retourne la page de résultat
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		choixUtilisateur = request.getParameter("choix");
		System.out.println("Choix utilisateur : " + choixUtilisateur);
		
		if (choixUtilisateur.equals(signes.get(choixOrdinateur))) {
			System.out.println("Egalité");
		} else if (choixUtilisateur.equals("chi") && signes.get(choixOrdinateur).equals("mi") || 
				choixUtilisateur.equals("fou") && signes.get(choixOrdinateur).equals("chi") || 
				choixUtilisateur.equals("mi") && signes.get(choixOrdinateur).equals("fou")) {
			System.out.println("Vous avez gagné [Vous : " + choixUtilisateur + " VS Ordi : " + signes.get(choixOrdinateur) + "]");
		} else {
			System.out.println("Vous avez perdu [Vous : " + choixUtilisateur + " VS Ordi : " + signes.get(choixOrdinateur) + "]");
		}
		
	}

}
