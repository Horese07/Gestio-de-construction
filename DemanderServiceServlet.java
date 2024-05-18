package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/demande")
public class DemanderServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Boolean inwser = false;
      
        String nom = request.getParameter("name");
        String email = request.getParameter("email");
        String service = request.getParameter("service");
        String message = request.getParameter("message");
        try {
        	inwser=	new models.Service().InserService(nom, email, service, message);
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (inwser) {
          
        	 response.sendRedirect("confirmation.jsp"); 
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("demande.jsp").forward(request, response);
        }
        HttpSession session = request.getSession();
        session.setAttribute("requestedService", nom);
        
       // Rediriger vers une page de confirmation ou une autre page appropriée
    }
}

