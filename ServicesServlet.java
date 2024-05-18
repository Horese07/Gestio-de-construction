package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.JDBC;
import models.Service;
@WebServlet("/services")
public class ServicesServlet extends HttpServlet {
  
	private static final Logger LOGGER = Logger.getLogger(HomeServlet.class.getName());

	private static final long serialVersionUID = -4655570794634428233L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Service> services = JDBC.selectAllServices();
            LOGGER.log(Level.INFO, "Number of services retrieved: {0}", services.size());

            request.setAttribute("services", services);
            HttpSession session = request.getSession();
            session.setAttribute("services", services);
            request.getRequestDispatcher("services.jsp").forward(request, response);
        } catch (Exception e) {
        	 LOGGER.log(Level.SEVERE, "Error retrieving services", e);
            throw new ServletException("Unable to retrieve services", e);
        }
    }
}
