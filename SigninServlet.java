package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controllers.UserController;

@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserController userController;

    public SigninServlet() {
        super();
        this.userController = new UserController();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String telephone= request.getParameter("telephone");
        String adresse = request.getParameter("adresse");

        boolean userCreated = false;
		try {
			userCreated = userController.createUser(username, password, email, telephone, adresse);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (userCreated) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMessage", "Failed to create user. Username might be already taken.");
            request.getRequestDispatcher("signin.jsp").forward(request, response);
        }
    }
}
