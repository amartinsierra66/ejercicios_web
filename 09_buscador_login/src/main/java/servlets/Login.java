package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		if(user.equals("admin")&&pwd.equals("admin")) {
			//transferimos petici?n a la p?gina de buscador
			RequestDispatcher dispatcher=request.getRequestDispatcher("buscador.html");
			dispatcher.forward(request, response);
		}else {
			//transferimos petici?n a servlet de error
			RequestDispatcher dispatcher=request.getRequestDispatcher("Error");
			dispatcher.forward(request, response);
		}
	}

}
