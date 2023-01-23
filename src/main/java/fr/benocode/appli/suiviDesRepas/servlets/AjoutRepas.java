package fr.benocode.appli.suiviDesRepas.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.benocode.appli.suiviDesRepas.BusinessException;
import fr.benocode.appli.suiviDesRepas.bll.RepasManager;

/**
 * Servlet implementation class AjoutRepas
 */
@WebServlet("/applications/SuiviDesRepas/AjoutRepas")
public class AjoutRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/SuiviDesRepas/ajout.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LocalDateTime date = null;
		String menu;
		List<Integer> listeCodesErreur=new ArrayList<>();
		
		// Vérification des données avant intégration
		try {
			date = LocalDateTime.parse(request.getParameter("date_form") + "T" + request.getParameter("heure_form"));
		} catch (DateTimeParseException e){
			e.printStackTrace();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_DATE_HEURE_ERREUR);
		}
		
		menu = request.getParameter("menu_form");
		if (menu == null || menu.isBlank()) {
			listeCodesErreur.add(CodesResultatServlets.FORMAT_REPAS_ERREUR);
		}
		
		// Traitement des données
		if (listeCodesErreur.size()>0) {
			request.setAttribute("listeCodesErreur",listeCodesErreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/SuiviDesRepas/ajout.jsp");
			rd.forward(request, response);
		} else {			
			RepasManager repasManager = new RepasManager();
			try {
				repasManager.ajouter(date, menu);
				RequestDispatcher rd = request.getRequestDispatcher("/applications/SuiviDesRepas/VisualisationRepas");
				rd.forward(request, response);
			} catch (BusinessException e) {
				e.printStackTrace();
				request.setAttribute("listeCodesErreur",listeCodesErreur);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/SuiviDesRepas/ajout.jsp");
				rd.forward(request, response);
			}
		}
	}
}
