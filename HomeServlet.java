package servlets;

import models.JDBC;
import models.Projet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
   
	private static final long serialVersionUID = -1420276788473997957L;
	private static final Logger LOGGER = Logger.getLogger(HomeServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String clientName = (String) request.getSession().getAttribute("username");
            List<Projet> projets = JDBC.selectAllProjets(clientName);
            LOGGER.log(Level.INFO, "Number of projects retrieved: {0}", projets.size());

            HttpSession session = request.getSession();
            session.setAttribute("projets", projets);
            request.setAttribute("projets", projets);

            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error retrieving projects", e);
            throw new ServletException("Unable to retrieve projects", e);
        }
    }
}
