package fr.benocode.appli.devinerNombre;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name = "ServletPropositionNombre",
		urlPatterns = "/applications/DevinerNombre/ServletPropositionNombre",
		initParams =
			{
				@WebInitParam(description="Valeur minimale à rechercher",
						name="MINI",
						value="0"),
				@WebInitParam(description="Valeur maximale à rechercher",
						name="MAXI",
						value="10")
			}
)

/**
 * Servlet implementation class ServletPropositionNombre
 */
public class ServletPropositionNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int min;
	private int max;
	private int nbADeviner;
	private boolean estTrouve = true;
	
	@Override
	public void init() throws ServletException {
		if(this.getInitParameter("MINI")!=null &&
    			!this.getInitParameter("MINI").equals(""))
    	{
    		String valeurLue=this.getInitParameter("MINI");
			try {
				this.min=Integer.parseInt(valeurLue);
			} catch (NumberFormatException e) {
				//Valeur par défaut si la valeur lue n'est pas numérique
				this.min=0;
			}
    	}
    	
    	if(this.getInitParameter("MAXI")!=null &&
    			!this.getInitParameter("MAXI").equals(""))
    	{
    		String valeurLue=this.getInitParameter("MAXI");
    		try {
				this.max=Integer.parseInt(valeurLue);
			} catch (NumberFormatException e) {
				//Valeur par défaut si la valeur lue n'est pas numérique
				this.max=10;
			}
    	}
		super.init();
	}

	/**
	 * Méthode pour réinitialiser la partie à l'instanciation de la servlet
	 */
	public void reinitPartie() {
		nombreAleatoire();
		estTrouve = false;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reinit = request.getParameter("reinit");
		if (reinit.equals("true")) {
			if (estTrouve)
				reinitPartie();
		}
		String unNombre = request.getParameter("unNombre");
		System.out.println("Nombre proposé : " + unNombre);
		if (unNombre.equals(String.valueOf(this.nbADeviner)) && !this.estTrouve) {
			response.sendRedirect("/MesApplisDemoJavaEE/applications/DevinerNombre/succes.html");
			this.estTrouve = true;
		} else {
			response.sendRedirect("/MesApplisDemoJavaEE/applications/DevinerNombre/echec.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * Méthode pour tirer un nombre aléatoire
	 */
	protected void nombreAleatoire() {
		nbADeviner = new Random().nextInt(max - min + 1) + min;
		System.out.println("Nombre à deviner : " + nbADeviner);
	}

}
