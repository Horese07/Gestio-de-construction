package servlets;

import models.JDBC;
import models.Taches;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/taches")
public class TachesServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7664018433472309485L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String projetName = request.getParameter("projetName");

        if (projetName != null) {
            // Enregistrez le nom du projet dans la session
            session.setAttribute("projetName", projetName);

            try {
                List<Taches> taches = JDBC.selectTachesByProjetId(projetName);
                request.setAttribute("taches", taches);
            } catch (Exception e) {
                e.printStackTrace();
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("taches.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
