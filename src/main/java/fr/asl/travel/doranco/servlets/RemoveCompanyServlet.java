package fr.asl.travel.doranco.servlets;

import java.io.IOException;

import fr.asl.travel.doranco.service.CompagnieService;
import fr.asl.travel.doranco.service.impl.CompagnieServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AeroportServlet
 */
@WebServlet("/removeCompany")
public class RemoveCompanyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static CompagnieService compagnieService = new CompagnieServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCompanyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        compagnieService.supprimerCompagnie(Long.parseLong(request.getParameter("id")));
        response.sendRedirect("index");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
