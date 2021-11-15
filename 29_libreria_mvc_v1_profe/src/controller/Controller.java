package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option=request.getParameter("option");
		String url="login.html";
		switch(option) {
			case "doRegistrar":
				request.getRequestDispatcher("RegistrarAction").include(request, response);
				url="login.html";
				break;
			case "doLogin":
				request.getRequestDispatcher("LoginAction").include(request, response);
				url=(Boolean)request.getAttribute("resultado")?"bienvenida.html":"error.html";
				break;
			case "toRegistro":
				url="registro.html";
				break;
			case "toSalir":
				url="login.html";
				break;
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
