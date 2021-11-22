package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Perfil;

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
			//accede a base de datos y carga perfil de usuario
			Perfil perfil=new Perfil(user,"prueba@gmail.com",33);
			request.setAttribute("perfil", perfil);
			//transferimos petición a la página de buscador
			RequestDispatcher dispatcher=request.getRequestDispatcher("bienvenida.jsp");
			dispatcher.forward(request, response);
		}else {
			//transferimos petición a servlet de error
			RequestDispatcher dispatcher=request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
