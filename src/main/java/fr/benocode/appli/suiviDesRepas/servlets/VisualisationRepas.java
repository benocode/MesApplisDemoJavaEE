package fr.benocode.appli.suiviDesRepas.servlets;

import java.io.IOException;
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
import fr.benocode.appli.suiviDesRepas.bo.Repas;

/**
 * Servlet implementation class VisualisationRepas
 */
@WebServlet("/applications/SuiviDesRepas/VisualisationRepas")
public class VisualisationRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Integer> listeCodesErreur=new ArrayList<>();
		if(listeCodesErreur.size()>0)
		{
			request.setAttribute("listeCodesErreur",listeCodesErreur);
		}
		else
		{
			try {
				//Recherche des repas
				RepasManager repasManager = new RepasManager();
				List<Repas> listeRepas=null;
				listeRepas = repasManager.visualiser();
				request.setAttribute("listeRepas", listeRepas);
			} catch (BusinessException e) {
				e.printStackTrace();
				request.setAttribute("listeCodesErreur",e.getListeCodesErreur());
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/SuiviDesRepas/historique.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
