package fr.asl.travel.doranco.servlets;

import java.io.IOException;
import java.util.List;

import fr.asl.travel.doranco.business.Aeroport;
import fr.asl.travel.doranco.business.Compagnie;
import fr.asl.travel.doranco.business.Vol;
import fr.asl.travel.doranco.service.AeroportService;
import fr.asl.travel.doranco.service.CompagnieService;
import fr.asl.travel.doranco.service.VolService;
import fr.asl.travel.doranco.service.impl.AeroportServiceImpl;
import fr.asl.travel.doranco.service.impl.CompagnieServiceImpl;
import fr.asl.travel.doranco.service.impl.VolServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns = { "/index", "/" }, loadOnStartup = 1)
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static AeroportService aeroportService = new AeroportServiceImpl();
	private static CompagnieService compagnieService = new CompagnieServiceImpl();
	private static VolService volService = new VolServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Aeroport> aeroports = aeroportService.recupererTousLesAeroports();
		request.setAttribute("aeroports", aeroports);
		
		List<Compagnie> compagnies = compagnieService.recupererToutesCompagnies();
		request.setAttribute("compagnies", compagnies);

		List<Vol> vols = volService.recupererVolsTrieParPrix();
		request.setAttribute("vols", vols);

		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
