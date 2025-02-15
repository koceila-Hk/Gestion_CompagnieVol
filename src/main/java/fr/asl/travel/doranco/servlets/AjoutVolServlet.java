package fr.asl.travel.doranco.servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import fr.asl.travel.doranco.service.VolService;
import fr.asl.travel.doranco.service.impl.VolServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AeroportServlet
 */
@WebServlet("/ajoutVol")
public class AjoutVolServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static VolService volService = new VolServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutVolServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        volService.ajouterVol(LocalDateTime.parse(request.getParameter("dateArrivee")),LocalDateTime.parse(request.getParameter("dateDepart")),
                            Float.parseFloat(request.getParameter("prix")), Long.parseLong(request.getParameter("idAeroportArrivee")),
                            Long.parseLong(request.getParameter("idAeroportDepart")), Long.parseLong(request.getParameter("idCompagnie")));
        response.sendRedirect("index");
    }

}
