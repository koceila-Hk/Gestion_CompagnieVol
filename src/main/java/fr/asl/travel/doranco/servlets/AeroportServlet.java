package fr.asl.travel.doranco.servlets;

import java.io.IOException;

import fr.asl.travel.doranco.business.Aeroport;
import fr.asl.travel.doranco.service.AeroportService;
import fr.asl.travel.doranco.service.impl.AeroportServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AeroportServlet
 */
@WebServlet("/aeroportUpdate")
public class AeroportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static AeroportService aeroportService = new AeroportServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AeroportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Aeroport aeroport = aeroportService.recupererAeroportParId(Long.parseLong(request.getParameter("id")));
        request.setAttribute("aeroport", aeroport);
        request.getRequestDispatcher("WEB-INF/aeroportUpdate.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Creation
        Aeroport aeroport = new Aeroport();
        aeroport.setId(Long.parseLong(request.getParameter("id")));
        aeroport.setNom(request.getParameter("NOM_AEROPORT"));
        aeroportService.modifierAeroport(aeroport);

        response.sendRedirect("index");
    }

}
