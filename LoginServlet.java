package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controllers.UserController;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserController userController;

    public LoginServlet() {
        super();
        this.userController = new UserController();
    }
    
  

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isAuthenticated=false;
		try {
			isAuthenticated = userController.authenticate(username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (isAuthenticated) {
            // Crée une session et stocke le nom d'utilisateur
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
         // Dans votre servlet d'authentification (LoginServlet)
            String user = request.getParameter("username");
            session.setAttribute("user", user); // Stockez le nom d'utilisateur dans la session

            response.sendRedirect("home"); // Redirige vers la page d'accueil
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Déconnexion : invalide la session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        response.sendRedirect("login.jsp"); // Redirige vers la page de login après la déconnexion
    }
}
